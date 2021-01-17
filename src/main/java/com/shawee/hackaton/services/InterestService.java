package com.shawee.hackaton.services;

import java.util.List;
import java.util.Optional;

import com.shawee.hackaton.dtos.request.InterestRequestDTO;
import com.shawee.hackaton.entities.Interest;
import com.shawee.hackaton.entities.User;
import com.shawee.hackaton.exceptions.EntityNotFoundException;

public interface InterestService {

	/**
	 * Receives an id and returns a Interest instance if exists
	 * 
	 * @param id
	 * @return Optional<Interest>
	 */
	Optional<Interest> findById(Long id);
	
	/**
	 * Receives an id and returns a Interest instance if exists, otherwise throw exception
	 * 
	 * @param id
	 * @return Interest
	 * @throws EntityNotFoundException
	 */
	Interest findByIdAndValidated(Long id) throws EntityNotFoundException;

	/**
	 * Return all Interest registers of the database
	 * 
	 * @return List<Interest>
	 */
	List<Interest> findAll();

	/**
	 * Return all Interest registers of the database for the logged user
	 * 
	 * @return List<Interest>
	 */
	List<Interest> findByUser(User user);

	/**
	 * Receives a InterestRequestDTO and save in the database
	 * 
	 * @param interestRequestDTO
	 * @return Interest
	 */
	Interest save(InterestRequestDTO interestRequestDTO);

	/**
	 * Receives a Interest id and remove of the database if exists
	 * 
	 * @param id
	 * @throws EntityNotFoundException
	 */
	void deleteById(Long id) throws EntityNotFoundException;

}