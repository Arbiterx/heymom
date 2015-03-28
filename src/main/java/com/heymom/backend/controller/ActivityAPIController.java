package com.heymom.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.heymom.backend.dto.activity.ActivityDto;
import com.heymom.backend.service.ActivityService;

@Controller
@RequestMapping("/api/activity/")
public class ActivityAPIController {
	@Autowired
	private ActivityService activityService;

	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	@ResponseBody
	public ActivityDto findOne(@PathVariable Integer id) {
		return activityService.findOneActivity(id);
	}

	@RequestMapping(value = "listpage", method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	@ResponseBody
	public List<ActivityDto> listActivities(@RequestParam(defaultValue = "0") int currentPage,
			@RequestParam(defaultValue = "10") int pageSize,
			@RequestParam(defaultValue = "createTime") String sortProperty,
			@RequestParam(defaultValue = "DESC") String sortDirection) {
		Page<ActivityDto> page = activityService.listAvaliableActivities(currentPage, pageSize, sortProperty,
				sortDirection, null, null, null, null, null);
		return page.getContent();
	}
}
