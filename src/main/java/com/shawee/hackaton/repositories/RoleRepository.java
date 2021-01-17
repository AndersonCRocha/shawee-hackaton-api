package com.shawee.hackaton.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shawee.hackaton.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

	Optional<Role> findByName(String name);

}
