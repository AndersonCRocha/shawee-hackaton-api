package com.shawee.hackaton.entities;

import java.time.LocalDate;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name = "users")
@SequenceGenerator(name = "sq_users", sequenceName = "sq_users", allocationSize = 1)
public class User implements UserDetails {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String fullName;
	private String username;
	private LocalDate birth;
	private String document;
	private String password;
	private String email;
	private String city;
	private String state;
	private Set<Role> roles;
	private List<Interest> interests;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_users")
	public Long getId() {
		return id;
	}
	
	public String getFullName() {
		return fullName;
	}

	@Override
	public String getUsername() {
		return username;
	}
	
	public LocalDate getBirth() {
		return birth;
	}

	public String getDocument() {
		return document;
	}
	
	@Column(unique = true)
	public String getEmail() {
		return email;
	}
	
	public String getCity() {
		return city;
	}
	
	public String getState() {
		return state;
	}

	public String getPassword() {
		return password;
	}

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	@JoinTable(
		name = "users_roles", 
		joinColumns = @JoinColumn(name = "user_id"), 
		inverseJoinColumns = @JoinColumn(name = "role_id")
	)
	public Set<Role> getRoles() {
		return roles;
	}
	
	@OneToMany(mappedBy = "user", orphanRemoval = true)
	public List<Interest> getInterests() {
		return interests;
	}

	public User addRole(Role role) {
		if(Objects.isNull(this.roles)) {
			this.roles = new HashSet<Role>();
		}
		roles.add(role);
		return this;
	}
	
	public User setId(Long id) {
		this.id = id;
		return this;
	}
	
	public User setFullName(String fullName) {
		this.fullName = fullName;
		return this;
	}

	public User setUsername(String username) {
		this.username = username;
		return this;
	}
	
	public User setBirth(LocalDate birth) {
		this.birth = birth;
		return this;
	}
	
	public User setDocument(String document) {
		this.document = document;
		return this;
	}
		
	public User setEmail(String email) {
		this.email = email;
		return this;
	}

	public User setPassword(String password) {
		this.password = password;
		return this;
	}

	public User setCity(String city) {
		this.city = city;
		return this;
	}
	
	public User setState(String state) {
		this.state = state;
		return this;
	}
	
	public User setRoles(Set<Role> roles) {
		this.roles = roles;
		return this;
	}	

	public void setInterests(List<Interest> interests) {
		this.interests = interests;
	}
	
	@Transient
	public Set<String> getRoleNames() {
		return roles.stream().map(Role::getName).collect(Collectors.toSet());
	}
	
	@Transient
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return roles.stream()
				.map(role -> new SimpleGrantedAuthority(role.getName()))
				.collect(Collectors.toList());
	}

	@Transient
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Transient
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Transient
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Transient
	@Override
	public boolean isEnabled() {
		return true;
	}

}