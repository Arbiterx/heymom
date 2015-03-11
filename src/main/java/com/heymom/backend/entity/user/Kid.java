package com.heymom.backend.entity.user;

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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.heymom.backend.entity.BaseEntity;
import com.heymom.backend.entity.activity.Activity;

@Entity
@Table(name = "kid")
public class Kid extends BaseEntity {
	private List<Activity> attendActivities;
	private Date birthday;
	private Integer gender;
	private Long id;
	private String name;
	private User parent;

	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "attendees")
	public List<Activity> getAttendActivities() {
		return attendActivities;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "birthday")
	public Date getBirthday() {
		return birthday;
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

	@Column(name = "name", length = 50)
	public String getName() {
		return name;
	}

	@ManyToOne
	@JoinColumn(name = "parent_id")
	public User getParent() {
		return parent;
	}

	public void setAttendActivities(List<Activity> attendActivities) {
		this.attendActivities = attendActivities;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setParent(User parent) {
		this.parent = parent;
	}

}
