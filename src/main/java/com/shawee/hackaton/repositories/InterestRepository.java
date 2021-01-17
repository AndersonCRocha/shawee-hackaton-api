package com.shawee.hackaton.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shawee.hackaton.entities.Interest;
import com.shawee.hackaton.entities.User;

public interface InterestRepository extends JpaRepository<Interest, Long> {

	List<Interest> findByUser(User user);

}