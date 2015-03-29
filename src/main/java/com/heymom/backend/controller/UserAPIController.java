package com.heymom.backend.controller;

import java.util.HashMap;
import java.util.Map;

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
import com.heymom.backend.dto.user.UserInfoDto;
import com.heymom.backend.service.UserService;

@Controller
@RequestMapping("/api/user/")
public class UserAPIController {
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/{mobile}/{verificationCode}/{password}", method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.OK)
	@ResponseBody
	public APIResult<Map<String, String>> createUser(@PathVariable String mobile,
			@PathVariable String verificationCode, @PathVariable String password) {
		String userToken = userService.createUser(mobile, verificationCode, password);
		return generateTokenResult(userToken);
	}

	@RequestMapping(value = "/userinfo", method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	@ResponseBody
	public APIResult<UserInfoDto> findUserInfo() {
		// TODO
		return null;
	}

	private APIResult<Map<String, String>> generateTokenResult(String userToken) {
		Map<String, String> result = new HashMap<String, String>();
		result.put("userToken", userToken);
		return new APIResult<Map<String, String>>(result);
	}

	@RequestMapping(value = "/login/{mobile}/{password}", method = RequestMethod.PUT)
	@ResponseStatus(value = HttpStatus.OK)
	@ResponseBody
	public APIResult<Map<String, String>> login(@PathVariable String mobile, @PathVariable String password) {
		return generateTokenResult(userService.login(mobile, password));
	}

	@RequestMapping(value = "/refreshToken", method = RequestMethod.PUT)
	@ResponseStatus(value = HttpStatus.OK)
	@ResponseBody
	@LoginRequired
	public APIResult<Map<String, String>> refreshToken(@RequestHeader("token") String userToken) {
		return generateTokenResult(userService.reLogin(userToken));
	}

	@RequestMapping(value = "sendMobileVerification/{mobile}", method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.OK)
	@ResponseBody
	public APIResult<Integer> sendMobileVerification(@PathVariable String mobile) {
		userService.sendMobileVerification(mobile);
		return new APIResult<Integer>(0);
	}

	@RequestMapping(value = "/{mobile}/{verificationCode}/{password}", method = RequestMethod.PUT)
	@ResponseStatus(value = HttpStatus.OK)
	@ResponseBody
	public APIResult<Integer> updatePasword(@PathVariable String mobile, @PathVariable String verificationCode,
			@PathVariable String password) {
		userService.changeUserPassword(mobile, verificationCode, password);
		return new APIResult<Integer>(0);
	}

	@RequestMapping(value = "/userinfo", method = RequestMethod.PUT)
	@ResponseStatus(value = HttpStatus.OK)
	@ResponseBody
	@LoginRequired
	public APIResult<Integer> updateUserInfo(@RequestHeader("token") String userToken) {
		// TODO
		return new APIResult<Integer>(0);
	}

}
