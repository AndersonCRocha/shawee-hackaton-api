package com.shawee.hackaton.utilities.converters;

import com.shawee.hackaton.dtos.request.InterestRequestDTO;
import com.shawee.hackaton.dtos.response.InterestResponseDTO;
import com.shawee.hackaton.entities.Interest;

public class InterestConverter {

	public static Interest dtoToEntity(InterestRequestDTO interestRequestDTO) {
		return new Interest()
				.setType(interestRequestDTO.getType())
				.setCategory(interestRequestDTO.getCategory())
				.setDescription(interestRequestDTO.getDescription())
				.setUser(interestRequestDTO.getUser());
	}

	public static InterestResponseDTO entityToDto(Interest interest) {
		return new InterestResponseDTO()
				.setType(interest.getType())
				.setCategory(interest.getCategory())
				.setDescription(interest.getDescription());
	}

}