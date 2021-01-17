package com.shawee.hackaton.dtos.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.shawee.hackaton.entities.User;
import com.shawee.hackaton.enumerations.InterestType;

public class InterestRequestDTO {

	private InterestType type;
	private String category;
	private String description;
	@JsonIgnore
	private User user;
	
	@NotNull(message = "type cannot be null or empty")
	public InterestType getType() {
		return type;
	}
	
	@NotNull
	@NotBlank(message = "category cannot be null or empty")
	public String getCategory() {
		return category;
	}

	@NotNull
	@NotBlank(message = "description cannot be null or empty")
	public String getDescription() {
		return description;
	}
	
	public User getUser() {
		return user;
	}

	public InterestRequestDTO setType(InterestType type) {
		this.type = type;
		return this;
	}
	
	public InterestRequestDTO setCategory(String category) {
		this.category = category;
		return this;
	}
	
	public InterestRequestDTO setDescription(String description) {
		this.description = description;
		return this;
	}
	
	public InterestRequestDTO setUser(User user) {
		this.user = user;
		return this;
	}

}
