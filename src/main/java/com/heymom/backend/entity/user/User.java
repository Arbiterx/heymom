package com.heymom.backend.entity.user;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.heymom.backend.entity.BaseEntity;
import com.heymom.backend.entity.activity.ActivityAttendeeRecord;
import com.heymom.backend.entity.incentive.CouponReceiveRecord;

@Entity
@Table(name = "user")
public class User extends BaseEntity {
	private List<ActivityAttendeeRecord> attendRecords;
	private List<CouponReceiveRecord> couponReceiveRecords;
	private String email;
	private Integer gender;
	private Long id;
	private List<Kid> kids;
	private String mobile;
	private String name;
	private String password;
	private UserInfo userInfo;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
	public List<ActivityAttendeeRecord> getAttendRecords() {
		return attendRecords;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
	public List<CouponReceiveRecord> getCouponReceiveRecords() {
		return couponReceiveRecords;
	}

	@Column(name = "email", unique = true, length = 50)
	public String getEmail() {
		return email;
	}

	@Column(name = "gender", precision = 1, scale = 0)
	public Integer getGender() {
		return gender;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false, precision = 20, scale = 0)
	public Long getId() {
		return id;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "parent")
	public List<Kid> getKids() {
		return kids;
	}

	@Column(name = "mobile", unique = true, length = 20)
	public String getMobile() {
		return mobile;
	}

	@Column(name = "name", unique = true, length = 50)
	public String getName() {
		return name;
	}

	@Column(name = "password", length = 50)
	public String getPassword() {
		return password;
	}

	@OneToOne
	@PrimaryKeyJoinColumn
	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setAttendRecords(List<ActivityAttendeeRecord> attendRecords) {
		this.attendRecords = attendRecords;
	}

	public void setCouponReceiveRecords(List<CouponReceiveRecord> couponReceiveRecords) {
		this.couponReceiveRecords = couponReceiveRecords;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setKids(List<Kid> kids) {
		this.kids = kids;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

}
