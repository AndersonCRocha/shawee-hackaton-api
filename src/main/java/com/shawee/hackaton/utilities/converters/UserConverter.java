package com.shawee.hackaton.utilities.converters;

import com.shawee.hackaton.dtos.request.UserRequestDTO;
import com.shawee.hackaton.dtos.response.UserResponseDTO;
import com.shawee.hackaton.entities.User;

public class UserConverter {

	public static User dtoToEntity(UserRequestDTO userRegisterDTO) {
		return new User()
				.setFullName(userRegisterDTO.getFullName())
				.setUsername(userRegisterDTO.getUsername())
				.setBirth(userRegisterDTO.getBirth())
				.setDocument(userRegisterDTO.getDocument())
				.setPassword(userRegisterDTO.getPassword())
				.setEmail(userRegisterDTO.getEmail())
				.setCity(userRegisterDTO.getCity())
				.setState(userRegisterDTO.getState());
	}
	
	public static UserResponseDTO entityToDTO(User user) {
		return new UserResponseDTO()
				.setId(user.getId())
				.setFullName(user.getFullName())
				.setUsername(user.getUsername())
				.setBirth(user.getBirth())
				.setDocument(user.getDocument())
				.setEmail(user.getEmail())
				.setCity(user.getCity())
				.setState(user.getState())
				.setInterests(user.getInterests());
	}
	
}