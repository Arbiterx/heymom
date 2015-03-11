package com.heymom.backend.entity.activity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.heymom.backend.entity.BaseEntity;

@Entity
@Table(name = "activity_provider")
public class ActivityProvider extends BaseEntity {
	private List<Activity> activities;
	private Location city;
	private Location country;
	private Integer id;
	private String name;
	private Location province;

	@OneToMany(mappedBy = "provider")
	public List<Activity> getActivities() {
		return activities;
	}

	@ManyToOne
	@JoinColumn(name = "city_id")
	public Location getCity() {
		return city;
	}

	@ManyToOne
	@JoinColumn(name = "country_id")
	public Location getCountry() {
		return country;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false, precision = 10, scale = 0)
	public Integer getId() {
		return id;
	}

	@Column(name = "name", unique = true, length = 50)
	public String getName() {
		return name;
	}

	@ManyToOne
	@JoinColumn(name = "province_id")
	public Location getProvince() {
		return province;
	}

	public void setActivities(List<Activity> activities) {
		this.activities = activities;
	}

	public void setCity(Location city) {
		this.city = city;
	}

	public void setCountry(Location country) {
		this.country = country;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setProvince(Location province) {
		this.province = province;
	}

}
