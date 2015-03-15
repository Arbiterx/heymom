package com.heymom.backend.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

import com.heymom.backend.entity.activity.Activity;

public interface ActivityDao extends BaseDao<Activity, Integer> {
	@Query("from Activity a where a.status>=0")
	public Page<Activity> listAvaliableActivities(Pageable pageRequest);
}
