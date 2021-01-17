package com.shawee.hackaton.dtos.response;

import com.shawee.hackaton.enumerations.InterestType;

public class InterestResponseDTO {

	private InterestType type;
	private String category;
	private String description;
	
	public InterestType getType() {
		return type;
	}

	public String getCategory() {
		return category;
	}
	
	public String getDescription() {
		return description;
	}


	public InterestResponseDTO setType(InterestType type) {
		this.type = type;
		return this;
	}

	public InterestResponseDTO setCategory(String category) {
		this.category = category;
		return this;
	}
	
	public InterestResponseDTO setDescription(String description) {
		this.description = description;
		return this;
	}

}
