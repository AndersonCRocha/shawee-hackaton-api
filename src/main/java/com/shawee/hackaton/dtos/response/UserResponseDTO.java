package com.shawee.hackaton.dtos.response;

import java.time.LocalDate;
import java.util.Set;

public class UserResponseDTO {

	private Long id;
	private String username;
	private String email;
	private String fullName;
	private LocalDate birth;
	private String document;
	private String password;
	private String city;
	private String state;
	private Set<String> roles;

	public Long getId() {
		return id;
	}

	public String getUsername() {
		return username;
	}

	public String getEmail() {
		return email;
	}

	public String getFullName() {
		return fullName;
	}
	
	public LocalDate getBirth() {
		return birth;
	}
	
	public String getDocument() {
		return document;
	}

	public String getPassword() {
		return password;
	}
	
	public String getCity() {
		return city;
	}
	
	public String getState() {
		return state;
	}
	
	public Set<String> getRoles() {
		return roles;
	}

	public UserResponseDTO setId(Long id) {
		this.id = id;
		return this;
	}

	public UserResponseDTO setUsername(String username) {
		this.username = username;
		return this;
	}

	public UserResponseDTO setEmail(String email) {
		this.email = email;
		return this;
	}

	public UserResponseDTO setFullName(String fullName) {
		this.fullName = fullName;
		return this;
	}
	
	public UserResponseDTO setBirth(LocalDate birth) {
		this.birth = birth;
		return this;
	}
	
	public UserResponseDTO setDocument(String document) {
		this.document = document;
		return this;
	}

	public UserResponseDTO setPassword(String password) {
		this.password = password;
		return this;
	}
	
	public UserResponseDTO setCity(String city) {
		this.city = city;
		return this;
	}
	
	public UserResponseDTO setState(String state) {
		this.state = state;
		return this;
	}
	
	public UserResponseDTO setRoles(Set<String> roles) {
		this.roles = roles;
		return this;
	}

}