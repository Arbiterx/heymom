package com.heymom.backend.dto.activity;

import org.springframework.beans.BeanUtils;

import com.heymom.backend.entity.activity.ActivityProvider;

public class ActivityProviderDto {
	private LocationDto city;
	private LocationDto country;
	private Integer id;
	private String name;
	private LocationDto province;

	public ActivityProviderDto() {
		super();
	}

	public ActivityProviderDto(ActivityProvider entity) {
		BeanUtils.copyProperties(entity, this);
		if (entity.getCity() != null) {
			city = new LocationDto(entity.getCity());
		}
		if (entity.getCountry() != null) {
			country = new LocationDto(entity.getCountry());
		}
		if (entity.getProvince() != null) {
			province = new LocationDto(entity.getProvince());
		}
	}

	public LocationDto getCity() {
		return city;
	}

	public LocationDto getCountry() {
		return country;
	}

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public LocationDto getProvince() {
		return province;
	}

	public void setCity(LocationDto city) {
		this.city = city;
	}

	public void setCountry(LocationDto country) {
		this.country = country;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setProvince(LocationDto province) {
		this.province = province;
	}

	public ActivityProvider toEntity() {
		ActivityProvider entity = new ActivityProvider();
		BeanUtils.copyProperties(this, entity);
		if (city != null) {
			entity.setCity(city.toEntity());
		}
		if (country != null) {
			entity.setCity(country.toEntity());
		}
		if (province != null) {
			entity.setCity(province.toEntity());
		}
		return entity;
	}
}
