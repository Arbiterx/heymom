package com.heymom.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.heymom.backend.dto.activity.ActivityDto;
import com.heymom.backend.service.ActivityService;

@Controller
@RequestMapping("/api/question/")
public class DictionaryAPIController {
	@Autowired
	private ActivityService activityService;

	@RequestMapping(value = "list", method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	@ResponseBody
	public List<ActivityDto> listAll() {
		return null;
	}
}
