package com.heymom.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.heymom.backend.common.LoginRequired;
import com.heymom.backend.dto.incentive.CouponDto;
import com.heymom.backend.service.CouponService;

@Controller
@RequestMapping("/api/coupon/")
public class CouponAPIController {
	@Autowired
	private CouponService couponService;

	@RequestMapping(value = "listreceived", method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	@ResponseBody
	public List<CouponDto> listAllReceivedCoupons() {
		// type = 1 means list available
		// type = 0 means list not begin

		return null;
	}

	@RequestMapping(value = "listpage", method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	@ResponseBody
	public List<CouponDto> listCoupons(@RequestParam(defaultValue = "0") int currentPage,
			@RequestParam(defaultValue = "10") int pageSize,
			@RequestParam(defaultValue = "startTime") String sortProperty,
			@RequestParam(defaultValue = "DESC") String sortDirection, @RequestParam(defaultValue = "1") Integer type) {
		// type = 1 means list available
		// type = 0 means list not begin

		return null;
	}

	@RequestMapping(value = "{userid}", method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.OK)
	@ResponseBody
	@LoginRequired
	public Boolean receiveCoupon(@PathVariable Integer couponId, @RequestHeader("token") String userToken) {
		// TODO
		return true;
	}
}
