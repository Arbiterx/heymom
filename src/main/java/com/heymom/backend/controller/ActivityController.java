package com.heymom.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.heymom.backend.dto.activity.ActivityDto;
import com.heymom.backend.service.ActivityService;

@Controller
@RequestMapping(value = "/backend/activity")
public class ActivityController {
	@Autowired
	private ActivityService activityService;

	@RequestMapping(value = "list", method = RequestMethod.GET)
	public ModelAndView listActivities(@RequestParam(defaultValue = "0") int currentPage,
			@RequestParam(defaultValue = "10") int pageSize,
			@RequestParam(defaultValue = "createTime") String sortProperty,
			@RequestParam(defaultValue = "DESC") String sortDirection) {
		Page<ActivityDto> page = activityService.listAvaliableActivities(currentPage, pageSize, sortProperty,
				sortDirection);
		return new ModelAndView("backend/list-activities", "page", page);
	}
}
