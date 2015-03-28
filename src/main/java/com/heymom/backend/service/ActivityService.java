package com.heymom.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.heymom.backend.dao.ActivityDao;
import com.heymom.backend.dto.activity.ActivityDto;
import com.heymom.backend.entity.activity.Activity;
import com.heymom.backend.utils.DtoUtils;

@Service
public class ActivityService {
	@Autowired
	private ActivityDao activityDao;

	@Transactional
	public void createActivity(ActivityDto activityDto) {
		// TODO
		activityDao.save(activityDto.toEntity());
	}

	@Transactional
	public void deleteActivity(Integer activityId) {
		// TODO
		activityDao.delete(activityId);
	}

	@Transactional(readOnly = true)
	public ActivityDto findOneActivity(Integer activityId) {
		return new ActivityDto(activityDao.findOne(activityId));
	}

	@Transactional(readOnly = true)
	public Page<ActivityDto> listAvaliableActivities(int currentPage, int pageSize, String sortProperty,
			String sortDirection, List<Integer> citiyIds, Integer startAge, Integer endAge, Integer type,
			String nameContent) {
		// TODO
		Pageable pageRequest = new PageRequest(currentPage, pageSize, Direction.fromString(sortDirection), sortProperty);
		Page<Activity> activties = activityDao.listAvaliableActivities(pageRequest);
		return DtoUtils.activityDtoUtil.toDTO(activties);
	}

	@Transactional
	public void updateActivity(ActivityDto activityDto) {
		activityDao.save(activityDto.toEntity());
	}
}
