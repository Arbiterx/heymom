package com.heymom.backend.dto.customized;

import java.util.List;

import com.heymom.backend.entity.BaseEntity;

public class QuestionDto extends BaseEntity {
	private String decription;
	private Integer id;
	private List<OptionDto> options;
	private Integer type;

	public String getDecription() {
		return decription;
	}

	public Integer getId() {
		return id;
	}

	public List<OptionDto> getOptions() {
		return options;
	}

	public Integer getType() {
		return type;
	}

	public void setDecription(String decription) {
		this.decription = decription;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setOptions(List<OptionDto> options) {
		this.options = options;
	}

	public void setType(Integer type) {
		this.type = type;
	}

}
