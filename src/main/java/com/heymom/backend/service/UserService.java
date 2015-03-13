package com.heymom.backend.service;

import java.util.Date;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.heymom.backend.common.HeymomException;
import com.heymom.backend.dao.MobileVerificationRecordDao;
import com.heymom.backend.dao.UserDao;
import com.heymom.backend.dto.UserDto;
import com.heymom.backend.entity.user.MobileVerificationRecord;
import com.heymom.backend.entity.user.User;
import com.heymom.backend.utils.RandomUtil;

@Service
public class UserService {
	@Value("max.send.mobile.verification.code.count")
	private static int maxSendMobileVerificationCodeCount;
	@Autowired
	private MobileVerificationRecordDao mobileVerificationRecordDao;
	@Autowired
	private UserDao userDao;

	@Transactional
	public long createUser(UserDto dto, String mobileCode) {
		if (StringUtils.isEmpty(mobileCode) && StringUtils.isEmpty(dto.getMobile())) {
			throw new HeymomException(100004);
		}
		isMobileExist(dto.getMobile());

		hasSentMaxTimes(dto.getMobile());
		if (!mobileVerificationRecordDao.findByMobileandCode(dto.getMobile(), mobileCode)) {
			throw new HeymomException(100003);
		}
		User entity = dto.toEntity();
		userDao.save(entity);

		return entity.getId();
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
	public void sendMobileVerification(String mobile) {
		if (StringUtils.isEmpty(mobile)) {
			throw new HeymomException(100004);
		}
		isMobileExist(mobile);
		hasSentMaxTimes(mobile);
		mobileVerificationRecordDao.save(new MobileVerificationRecord(RandomUtil.generate6Int(), mobile));
	}
}
