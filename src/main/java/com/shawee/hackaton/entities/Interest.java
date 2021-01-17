package com.shawee.hackaton.entities;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.shawee.hackaton.enumerations.InterestType;

@Entity
@Table(name = "interests")
@SequenceGenerator(name = "sq_interests", sequenceName = "sq_interests", allocationSize = 1)
public class Interest {

	private Long id;
	private InterestType type;
	private String category;
	private String description;
	private User user;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_interests")
	public Long getId() {
		return id;
	}

	@Enumerated(EnumType.STRING)
	public InterestType getType() {
		return type;
	}
	
	public String getCategory() {
		return category;
	}

	public String getDescription() {
		return description;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	public User getUser() {
		return user;
	}

	public Interest setId(Long id) {
		this.id = id;
		return this;
	}
	
	public Interest setType(InterestType type) {
		this.type = type;
		return this;
	}

	public Interest setCategory(String category) {
		this.category = category;
		return this;
	}

	public Interest setDescription(String description) {
		this.description = description;
		return this;
	}

	public Interest setUser(User user) {
		this.user = user;
		return this;
	}

}