package com.shawee.hackaton.dtos.request;

import java.time.LocalDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.shawee.hackaton.utilities.validators.ValuesMatch;

@ValuesMatch(
	field = "password", 
	fieldMatch = "passwordConfirmation", 
	message = "password and passwordConfirmation doesn't match!"
)
public class UserRequestDTO {

	private String fullName;
	private String username;
	private LocalDate birth;
	private String document;
	private String password;
	private String passwordConfirmation;
	private String email;
	private String city;
	private String state;

	@NotNull
	@NotBlank(message = "fullName cannot be null or empty")
	public String getFullName() {
		return fullName;
	}

	@NotNull
	@NotBlank(message = "username cannot be null or empty")
	public String getUsername() {
		return username;
	}
	
	@NotNull(message = "birth cannot be null or empty")
	public LocalDate getBirth() {
		return birth;
	}
	
	@NotNull
	@NotBlank(message = "document cannot be null or empty")
	public String getDocument() {
		return document;
	}

	@NotNull
	@NotBlank(message = "password cannot be null or empty")
	public String getPassword() {
		return password;
	}
	
	@NotNull
	@NotBlank(message = "password confirmation cannot be null or empty")
	public String getPasswordConfirmation() {
		return passwordConfirmation;
	}

	@NotNull
	@Email(message = "invalid email")
	@NotBlank(message = "email cannot be null or empty")
	public String getEmail() {
		return email;
	}
	
	@NotNull
	@NotBlank(message = "city cannot be null or empty")
	public String getCity() {
		return city;
	}
	
	@NotNull
	@NotBlank(message = "state cannot be null or empty")
	public String getState() {
		return state;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public void setBirth(LocalDate birth) {
		this.birth = birth;
	}
	
	public void setDocument(String document) {
		this.document = document;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setPasswordConfirmation(String passwordConfirmation) {
		this.passwordConfirmation = passwordConfirmation;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public void setState(String state) {
		this.state = state;
	}

}