package com.shawee.hackaton.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.shawee.hackaton.dtos.request.InterestRequestDTO;
import com.shawee.hackaton.entities.Interest;
import com.shawee.hackaton.entities.User;
import com.shawee.hackaton.exceptions.EntityNotFoundException;
import com.shawee.hackaton.repositories.InterestRepository;
import com.shawee.hackaton.services.InterestService;
import com.shawee.hackaton.utilities.converters.InterestConverter;

@Service
public class InterestServiceImpl implements InterestService {

	private InterestRepository interestRepository;
	
	public InterestServiceImpl(InterestRepository interestRepository) {
		this.interestRepository = interestRepository;
	}
	
	@Override
	public Optional<Interest> findById(Long id) {
		return interestRepository.findById(id);
	}

	@Override
	public Interest findByIdAndValidated(Long id) throws EntityNotFoundException {
		return this.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Interest not found for id: %d", id));
	}

	@Override
	public List<Interest> findAll() {
		return interestRepository.findAll();
	}

	@Override
	public Interest save(InterestRequestDTO interestRequestDTO) {
		Interest interest = InterestConverter.dtoToEntity(interestRequestDTO);
		
		return interestRepository.save(interest);
	}

	@Override
	public void deleteById(Long id) throws EntityNotFoundException {
		Interest interest = this.findByIdAndValidated(id);
		interestRepository.delete(interest);
	}

	@Override
	public List<Interest> findByUser(User user) {
		return interestRepository.findByUser(user);
	}

}