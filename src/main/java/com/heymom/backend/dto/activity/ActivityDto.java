package com.heymom.backend.dto.activity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.heymom.backend.dto.incentive.CouponDto;
import com.heymom.backend.entity.activity.Activity;
import com.heymom.backend.entity.activity.ActivityAttendeeRecord;

public class ActivityDto {
	private Integer attendeeMaxAge;
	private Integer attendeeMinAge;
	private List<ActivityAttendeeRecordDto> attendRecords;
	private LocationDto city;
	private LocationDto country;
	private List<CouponDto> coupons;
	private Date endTime;
	private Boolean hasCoupon;
	private Integer id;
	private Integer InitialAttendeeCount;
	private double latitude;
	private double longitude;
	private Integer maxAttedneeCount;
	private String name;
	private float price;
	private ActivityProviderDto provider;
	private LocationDto province;
	private Date startTime;
	private Integer type;

	public ActivityDto() {
		super();
	}

	public ActivityDto(Activity entity) {
		BeanUtils.copyProperties(entity, this);
		if (entity.getCity() != null)
			city = new LocationDto(entity.getCity());
		if (entity.getCountry() != null)
			country = new LocationDto(entity.getCountry());
		if (entity.getProvince() != null)
			province = new LocationDto(entity.getProvince());
		if (entity.getProvider() != null)
			provider = new ActivityProviderDto(entity.getProvider());
		if (entity.getAttendRecords() != null) {
			attendRecords = new ArrayList<ActivityAttendeeRecordDto>();
			for (ActivityAttendeeRecord activityAttendeeRecord : entity.getAttendRecords())
				attendRecords.add(new ActivityAttendeeRecordDto(activityAttendeeRecord));
		}

	}

	public Integer getAttendeeMaxAge() {
		return attendeeMaxAge;
	}

	public Integer getAttendeeMinAge() {
		return attendeeMinAge;
	}

	public List<ActivityAttendeeRecordDto> getAttendRecords() {
		return attendRecords;
	}

	public LocationDto getCity() {
		return city;
	}

	public LocationDto getCountry() {
		return country;
	}

	public List<CouponDto> getCoupons() {
		return coupons;
	}

	public Date getEndTime() {
		return endTime;
	}

	public Boolean getHasCoupon() {
		return hasCoupon;
	}

	public Integer getId() {
		return id;
	}

	public Integer getInitialAttendeeCount() {
		return InitialAttendeeCount;
	}

	public double getLatitude() {
		return latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public Integer getMaxAttedneeCount() {
		return maxAttedneeCount;
	}

	public String getName() {
		return name;
	}

	public float getPrice() {
		return price;
	}

	public ActivityProviderDto getProvider() {
		return provider;
	}

	public LocationDto getProvince() {
		return province;
	}

	public Date getStartTime() {
		return startTime;
	}

	public Integer getType() {
		return type;
	}

	public void setAttendeeMaxAge(Integer attendeeMaxAge) {
		this.attendeeMaxAge = attendeeMaxAge;
	}

	public void setAttendeeMinAge(Integer attendeeMinAge) {
		this.attendeeMinAge = attendeeMinAge;
	}

	public void setAttendRecords(List<ActivityAttendeeRecordDto> attendRecords) {
		this.attendRecords = attendRecords;
	}

	public void setCity(LocationDto city) {
		this.city = city;
	}

	public void setCountry(LocationDto country) {
		this.country = country;
	}

	public void setCoupons(List<CouponDto> coupons) {
		this.coupons = coupons;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public void setHasCoupon(Boolean hasCoupon) {
		this.hasCoupon = hasCoupon;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setInitialAttendeeCount(Integer initialAttendeeCount) {
		InitialAttendeeCount = initialAttendeeCount;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public void setMaxAttedneeCount(Integer maxAttedneeCount) {
		this.maxAttedneeCount = maxAttedneeCount;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public void setProvider(ActivityProviderDto provider) {
		this.provider = provider;
	}

	public void setProvince(LocationDto province) {
		this.province = province;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Activity toEntity() {
		Activity entity = new Activity();
		BeanUtils.copyProperties(this, entity);
		if (city != null)
			entity.setCity(city.toEntity());
		if (country != null)
			entity.setCountry(country.toEntity());
		if (province != null)
			entity.setProvince(province.toEntity());
		if (provider != null)
			entity.setProvider(provider.toEntity());
		return entity;
	}
}
