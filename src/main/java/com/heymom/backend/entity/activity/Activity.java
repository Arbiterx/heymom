package com.heymom.backend.entity.activity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.heymom.backend.entity.BaseEntity;
import com.heymom.backend.entity.incentive.Coupon;

@Entity
@Table(name = "activity")
public class Activity extends BaseEntity {
	private Integer attendeeMaxAge;
	private Integer attendeeMinAge;
	private List<ActivityAttendeeRecord> attendRecords;
	private Location city;
	private Location country;
	private List<Coupon> coupons;
	private Date endTime;
	private Integer id;
	private Integer InitialAttendeeCount;
	private double latitude;
	private double longitude;
	private Integer maxAttedneeCount;
	private String name;
	private float price;
	private ActivityProvider provider;
	private Location province;
	private Date startTime;
	private Integer type;

	@Column(name = "attendee_max_age", precision = 3, scale = 0)
	public Integer getAttendeeMaxAge() {
		return attendeeMaxAge;
	}

	@Column(name = "attendee_min_age", precision = 3, scale = 0)
	public Integer getAttendeeMinAge() {
		return attendeeMinAge;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "activity")
	public List<ActivityAttendeeRecord> getAttendRecords() {
		return attendRecords;
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

	@ManyToMany(mappedBy = "activities")
	public List<Coupon> getCoupons() {
		return coupons;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "end_time")
	public Date getEndTime() {
		return endTime;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false, precision = 10, scale = 0)
	public Integer getId() {
		return id;
	}

	@Column(name = "initial_attendee_count", precision = 4, scale = 0)
	public Integer getInitialAttendeeCount() {
		return InitialAttendeeCount;
	}

	@Column(name = "latitude", precision = 10, scale = 6)
	public double getLatitude() {
		return latitude;
	}

	@Column(name = "longitude", precision = 10, scale = 6)
	public double getLongitude() {
		return longitude;
	}

	@Column(name = "max_attendee_count", precision = 5, scale = 0)
	public Integer getMaxAttedneeCount() {
		return maxAttedneeCount;
	}

	@Column(name = "name", length = 50, nullable = false)
	public String getName() {
		return name;
	}

	@Column(name = "price", precision = 10, scale = 2)
	public float getPrice() {
		return price;
	}

	@ManyToOne
	@JoinColumn(name = "provider_id")
	public ActivityProvider getProvider() {
		return provider;
	}

	@ManyToOne
	@JoinColumn(name = "province_id")
	public Location getProvince() {
		return province;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "start_time")
	public Date getStartTime() {
		return startTime;
	}

	@Column(name = "type", precision = 1, nullable = false)
	public Integer getType() {
		return type;
	}

	public void setAttendeeMaxAge(Integer attendeeMaxAge) {
		this.attendeeMaxAge = attendeeMaxAge;
	}

	public void setAttendeeMinAge(Integer attendeeMinAge) {
		this.attendeeMinAge = attendeeMinAge;
	}

	public void setAttendRecords(List<ActivityAttendeeRecord> attendRecords) {
		this.attendRecords = attendRecords;
	}

	public void setCity(Location city) {
		this.city = city;
	}

	public void setCountry(Location country) {
		this.country = country;
	}

	public void setCoupons(List<Coupon> coupons) {
		this.coupons = coupons;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
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

	public void setProvider(ActivityProvider provider) {
		this.provider = provider;
	}

	public void setProvince(Location province) {
		this.province = province;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public void setType(Integer type) {
		this.type = type;
	}

}
