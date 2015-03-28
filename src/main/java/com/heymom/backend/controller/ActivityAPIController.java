package com.heymom.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.heymom.backend.dto.APIResult;
import com.heymom.backend.dto.activity.ActivityAttendeeRecordDto;
import com.heymom.backend.dto.activity.ActivityDto;
import com.heymom.backend.service.ActivityService;

@Controller
@RequestMapping("/api/question/")
public class ActivityAPIController {
	@Autowired
	private ActivityService activityService;

	@RequestMapping(value = "addfavour", method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.OK)
	@ResponseBody
	public APIResult<Integer> addfavour(@PathVariable Integer activityId) {
		// TODO
		return new APIResult<Integer>(0);
	}

	@RequestMapping(value = "attend", method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.OK)
	@ResponseBody
	public List<ActivityDto> attend(@PathVariable Integer activityId) {
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

	@RequestMapping(value = "cancelfavour", method = RequestMethod.PUT)
	@ResponseStatus(value = HttpStatus.OK)
	@ResponseBody
	public APIResult<Integer> cancelFavour(@PathVariable Integer activityId) {
		// TODO
		return new APIResult<Integer>(0);
	}

	@RequestMapping(value = "deletemyattended", method = RequestMethod.DELETE)
	@ResponseStatus(value = HttpStatus.OK)
	@ResponseBody
	public APIResult<Integer> deleteMyAttended() {
		// TODO
		return new APIResult<Integer>(0);
	}

	@RequestMapping(value = "deletemyfavour", method = RequestMethod.DELETE)
	@ResponseStatus(value = HttpStatus.OK)
	@ResponseBody
	public APIResult<Integer> deleteMyFavour() {
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

	@RequestMapping(value = "listallavailableactivities", method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	@ResponseBody
	public List<ActivityDto> listAllAvailableActivities() {
		// TODO 1
		return null;
	}

	@RequestMapping(value = "listbyids", method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	@ResponseBody
	public List<ActivityDto> listByIds(@PathVariable List<Integer> ids) {
		return activityService.listByIds(ids);
	}

	@RequestMapping(value = "listfeedback", method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	@ResponseBody
	public List<ActivityDto> listfeedback(@PathVariable Integer activityId) {
		// TODO
		return null;
	}

	@RequestMapping(value = "listmyactivity", method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	@ResponseBody
	public List<ActivityDto> listMyActivity() {
		// TODO
		return null;
	}

	@RequestMapping(value = "listmyfavour", method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	@ResponseBody
	public List<ActivityDto> listMyFavour() {
		// TODO
		return null;
	}

	@RequestMapping(value = "listmyfeedback", method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	@ResponseBody
	public List<ActivityDto> listMyFeedback() {
		// TODO
		return null;
	}

}
