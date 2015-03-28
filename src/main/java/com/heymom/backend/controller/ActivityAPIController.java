package com.heymom.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.heymom.backend.common.LoginRequired;
import com.heymom.backend.dto.APIResult;
import com.heymom.backend.dto.activity.ActivityAttendeeRecordDto;
import com.heymom.backend.dto.activity.ActivityDto;
import com.heymom.backend.service.ActivityService;

@Controller
@RequestMapping("/api/activity/")
public class ActivityAPIController {
	@Autowired
	private ActivityService activityService;

	@RequestMapping(value = "attend/{activityId}", method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.OK)
	@ResponseBody
	@LoginRequired
	public List<ActivityDto> attend(@PathVariable Integer activityId, @RequestHeader("token") String userToken) {
		// TODO
		return null;
	}

	@RequestMapping(value = "cancel", method = RequestMethod.PUT)
	@ResponseStatus(value = HttpStatus.OK)
	@ResponseBody
	public APIResult<Integer> cancel(@PathVariable Integer activityId) {
		// TODO
		return new APIResult<Integer>(0);
	}

	@RequestMapping(value = "cancelFollow", method = RequestMethod.PUT)
	@ResponseStatus(value = HttpStatus.OK)
	@ResponseBody
	public APIResult<Integer> cancelFollow(@PathVariable Integer activityId) {
		// TODO
		return new APIResult<Integer>(0);
	}

	@RequestMapping(value = "deleteMyAttended", method = RequestMethod.DELETE)
	@ResponseStatus(value = HttpStatus.OK)
	@ResponseBody
	public APIResult<Integer> deleteMyAttended() {
		// TODO
		return new APIResult<Integer>(0);
	}

	@RequestMapping(value = "deleteMyFollowed", method = RequestMethod.DELETE)
	@ResponseStatus(value = HttpStatus.OK)
	@ResponseBody
	public APIResult<Integer> deleteMyFollowed() {
		// TODO
		return new APIResult<Integer>(0);
	}

	@RequestMapping(value = "feedback", method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.OK)
	@ResponseBody
	public APIResult<Integer> feedback(ActivityAttendeeRecordDto dto) {
		// TODO
		return new APIResult<Integer>(0);
	}

	@RequestMapping(value = "follow", method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.OK)
	@ResponseBody
	public APIResult<Integer> follow(@PathVariable Integer activityId) {
		// TODO
		return new APIResult<Integer>(0);
	}

	@RequestMapping(value = "listAllAvailableActivities", method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	@ResponseBody
	public List<ActivityDto> listAllAvailableActivities() {
		// TODO 1
		return null;
	}

	@RequestMapping(value = "listByIds", method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	@ResponseBody
	public List<ActivityDto> listByIds(@PathVariable List<Integer> ids) {
		return activityService.listByIds(ids);
	}

	@RequestMapping(value = "listFeedBack", method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	@ResponseBody
	public List<ActivityDto> listFeedBack(@PathVariable Integer activityId) {
		// TODO
		return null;
	}

	@RequestMapping(value = "listMyActivity", method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	@ResponseBody
	public List<ActivityDto> listMyActivity() {
		// TODO
		return null;
	}

	@RequestMapping(value = "listMyFeedback", method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	@ResponseBody
	public List<ActivityDto> listMyFeedback() {
		// TODO
		return null;
	}

	@RequestMapping(value = "listMyFollowed", method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	@ResponseBody
	public List<ActivityDto> listMyFollowed() {
		// TODO
		return null;
	}

}
