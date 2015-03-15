package com.heymom.backend.utils;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import com.heymom.backend.dto.activity.ActivityDto;
import com.heymom.backend.dto.user.UserDto;
import com.heymom.backend.entity.activity.Activity;
import com.heymom.backend.entity.user.User;

public class DtoUtils<CDTO, CEntity> {
	public static DtoUtils<ActivityDto, Activity> activityDtoUtil = new DtoUtils<ActivityDto, Activity>(
			ActivityDto.class, Activity.class);
	private static final Logger logger = LoggerFactory.getLogger(DtoUtils.class);
	public static DtoUtils<UserDto, User> userDtoUtil = new DtoUtils<UserDto, User>(UserDto.class, User.class);
	private Class<?> dtoClass;
	private Class<?> entityClass;

	public DtoUtils(Class<?> dtoClass, Class<?> entityClass) {
		super();
		this.entityClass = entityClass;
		this.dtoClass = dtoClass;
	}

	@SuppressWarnings("unchecked")
	private CDTO newDtoInstance(CEntity entity) {
		try {
			return (CDTO) dtoClass.getConstructor(entityClass).newInstance(entity);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return null;
		}
	}

	public List<CDTO> toDTO(List<CEntity> listSource) {
		List<CDTO> result = new ArrayList<CDTO>();
		for (CEntity entity : listSource) {
			result.add(newDtoInstance(entity));
		}
		return result;
	}

	public Page<CDTO> toDTO(Page<CEntity> pageSource) {
		return new PageImpl<CDTO>(toDTO(pageSource.getContent()));
	}

	@SuppressWarnings("unchecked")
	public List<CEntity> toEntity(List<CDTO> listSource) {
		List<CEntity> result = new ArrayList<CEntity>();
		for (CDTO dto : listSource) {
			try {
				Method method = dto.getClass().getMethod("toEntity");
				result.add((CEntity) method.invoke(dto));
			} catch (Exception e) {
				logger.error(e.getMessage(), e);
			}
		}
		return result;
	}

}
