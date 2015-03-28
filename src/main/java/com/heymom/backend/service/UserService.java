package com.heymom.backend.service;

import java.util.Date;
import java.util.UUID;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.heymom.backend.common.HeymomException;
import com.heymom.backend.dao.MobileVerificationRecordDao;
import com.heymom.backend.dao.UserDao;
import com.heymom.backend.dto.user.UserDto;
import com.heymom.backend.entity.user.MobileVerificationRecord;
import com.heymom.backend.entity.user.User;
import com.heymom.backend.utils.RandomUtil;

@Service
public class UserService {
	private ThreadLocal<User> currentUser = new ThreadLocal<User>();
	@Value("${max.send.mobile.verification.code.count}")
	private int maxSendMobileVerificationCodeCount;
	@Autowired
	private MobileVerificationRecordDao mobileVerificationRecordDao;
	@Autowired
	private UserDao userDao;

	@Transactional
	public String changeUserPassword(String mobile, String verificationCode, String password) {
		if (mobileVerificationRecordDao.countByMobileandCode(mobile, verificationCode) == 0) {
			throw new HeymomException(100003);
		}
		User user = userDao.findByMobile(mobile);
		user.setPassword(password);
		user.setUserToken(UUID.randomUUID().toString());
		userDao.save(user);
		return user.getUserToken();
	}

	@Transactional
	public String createUser(String mobile, String verificationCode, String password) {
		UserDto dto = new UserDto();
		dto.setMobile(mobile);
		dto.setPassword(password);
		return createUser(dto, verificationCode).getUserToken();
	}

	@Transactional
	public User createUser(UserDto dto, String verificationCode) {
		if (StringUtils.isEmpty(verificationCode) && StringUtils.isEmpty(dto.getMobile())) {
			throw new HeymomException(100004);
		}
		isMobileExist(dto.getMobile());

		hasSentMaxTimes(dto.getMobile());
		if (mobileVerificationRecordDao.countByMobileandCode(dto.getMobile(), verificationCode) == 0) {
			throw new HeymomException(100003);
		}
		User entity = dto.toEntity();
		entity.setUserToken(UUID.randomUUID().toString());
		userDao.save(entity);

		return entity;
	}

	@Transactional(readOnly = true)
	public User getCurrentUser(String userToken) {
		if (currentUser.get() == null) {
			User user = userDao.findByToken(userToken);
			if (user == null) {
				throw new HeymomException(100005);
			} else {
				currentUser.set(user);
			}
		}
		return currentUser.get();
	}

	private void hasSentMaxTimes(String mobile) {
		Date startTime = new DateTime().toLocalDate().toDate();
		Date endTime = new DateTime().toLocalDate().plusDays(1).toDate();
		int count = mobileVerificationRecordDao.countByMobileandCreateTime(mobile, startTime, endTime);
		if (count > maxSendMobileVerificationCodeCount) {
			throw new HeymomException(100002);
		}
	}

	private void isMobileExist(String mobile) {
		if (userDao.findByMobile(mobile) != null) {
			throw new HeymomException(100001);
		}
	}

	@Transactional
	public String login(String mobile, String password) {
		User user = userDao.findByMobileAndPassword(mobile, password);
		return refreshToken(user);
	}

	private String refreshToken(User user) {
		if (user != null) {
			user.setUserToken(UUID.randomUUID().toString());
			userDao.save(user);
			currentUser.set(user);
			return user.getUserToken();
		}
		return null;
	}

	@Transactional
	public String reLogin(String userToken) {
		User user = userDao.findByToken(userToken);
		return refreshToken(user);
	}

	@Transactional
	public void sendMobileVerification(String mobile) {
		if (StringUtils.isEmpty(mobile)) {
			throw new HeymomException(100004);
		}
		isMobileExist(mobile);
		hasSentMaxTimes(mobile);
		mobileVerificationRecordDao.save(new MobileVerificationRecord(RandomUtil.generate6Int(), mobile));
	}

	public void setCurrentUser(ThreadLocal<User> currentUser) {
		this.currentUser = currentUser;
	}

}
