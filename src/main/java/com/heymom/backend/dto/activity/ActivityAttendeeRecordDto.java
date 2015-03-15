package com.heymom.backend.dto.activity;

import com.heymom.backend.dto.user.UserDto;
import com.heymom.backend.entity.user.Kid;

public class ActivityAttendeeRecordDto {
	private ActivityDto activity;
	private String comments;
	private Long id;
	private Kid kid;
	private Integer score;
	private UserDto user;

	public ActivityDto getActivity() {
		return activity;
	}

	public String getComments() {
		return comments;
	}

	public Long getId() {
		return id;
	}

	public Kid getKid() {
		return kid;
	}

	public Integer getScore() {
		return score;
	}

	public UserDto getUser() {
		return user;
	}

	public void setActivity(ActivityDto activity) {
		this.activity = activity;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setKid(Kid kid) {
		this.kid = kid;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public void setUser(UserDto user) {
		this.user = user;
	}
}
