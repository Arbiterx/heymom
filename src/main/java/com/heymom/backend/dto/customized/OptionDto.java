package com.heymom.backend.dto.customized;

import com.heymom.backend.entity.BaseEntity;

public class OptionDto extends BaseEntity {
	private String decription;
	private Integer id;
	private QuestionDto question;

	public String getDecription() {
		return decription;
	}

	public Integer getId() {
		return id;
	}

	public QuestionDto getQuestion() {
		return question;
	}

	public void setDecription(String decription) {
		this.decription = decription;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setQuestion(QuestionDto question) {
		this.question = question;
	}

}
