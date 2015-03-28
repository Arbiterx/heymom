package com.heymom.backend.service;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.heymom.backend.dto.incentive.CouponDto;

@Service
public class CouponService {
	public void createCoupon() {
	}

	public void deleteCoupon() {

	}

	public List<CouponDto> listAllCoupon(int currentPage, int pageSize, String sortProperty, String sortDirection,
			Date startDate, Date endDate, String nameContent) {
		return null;
	}

	public void updateCoupon() {

	}
}
