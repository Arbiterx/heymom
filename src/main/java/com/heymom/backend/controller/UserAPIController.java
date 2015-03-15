package com.heymom.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.heymom.backend.dto.APIResult;
import com.heymom.backend.service.UserService;

@Controller
@RequestMapping("/api/user/")
public class UserAPIController {
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/{mobile}/{verificationCode}", method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.OK)
	@ResponseBody
	public APIResult<Integer> createUser(@PathVariable String mobile, @PathVariable String verificationCode) {
		userService.createUser(mobile, verificationCode);
		return new APIResult<Integer>(0);
	}

	@RequestMapping(value = "sendMobileVerification/{mobile}", method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.OK)
	@ResponseBody
	public APIResult<Integer> sendMobileVerification(@PathVariable String mobile) {
		userService.sendMobileVerification(mobile);
		return new APIResult<Integer>(0);
	}

}
