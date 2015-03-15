package com.heymom.backend.dto.incentive;

import java.util.Date;
import java.util.List;

import com.heymom.backend.dto.activity.ActivityDto;
import com.heymom.backend.dto.activity.ActivityProviderDto;

public class CouponDto {
	private List<ActivityDto> activities;
	private String description;
	private Date expireDate;
	private Integer id;
	private String imageUrl;
	private Integer maxCount;
	private String name;
	private ActivityProviderDto provider;

	public List<ActivityDto> getActivities() {
		return activities;
	}

	public String getDescription() {
		return description;
	}

	public Date getExpireDate() {
		return expireDate;
	}

	public Integer getId() {
		return id;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public Integer getMaxCount() {
		return maxCount;
	}

	public String getName() {
		return name;
	}

	public ActivityProviderDto getProvider() {
		return provider;
	}

	public void setActivities(List<ActivityDto> activities) {
		this.activities = activities;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setExpireDate(Date expireDate) {
		this.expireDate = expireDate;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public void setMaxCount(Integer maxCount) {
		this.maxCount = maxCount;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setProvider(ActivityProviderDto provider) {
		this.provider = provider;
	}
}
