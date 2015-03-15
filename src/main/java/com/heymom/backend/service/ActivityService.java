package com.heymom.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.heymom.backend.dao.ActivityDao;
import com.heymom.backend.dto.activity.ActivityDto;
import com.heymom.backend.entity.activity.Activity;
import com.heymom.backend.utils.DtoUtils;

@Service
public class ActivityService {
	@Autowired
	private ActivityDao activityDao;

	public Page<ActivityDto> listAvaliableActivities(int currentPage, int pageSize, String sortProperty,
			String sortDirection) {
		Pageable pageRequest = new PageRequest(currentPage, pageSize, Direction.fromString(sortDirection), sortProperty);
		Page<Activity> activties = activityDao.listAvaliableActivities(pageRequest);
		return DtoUtils.activityDtoUtil.toDTO(activties);
	}
}
