package com.shawee.hackaton.controllers;

import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shawee.hackaton.dtos.request.ChangePasswordRequestDTO;
import com.shawee.hackaton.dtos.request.UserRequestDTO;
import com.shawee.hackaton.dtos.response.UserResponseDTO;
import com.shawee.hackaton.entities.User;
import com.shawee.hackaton.exceptions.EntityNotFoundException;
import com.shawee.hackaton.services.UserService;
import com.shawee.hackaton.utilities.converters.UserConverter;

@RestController
@RequestMapping("users")
public class UserController {

	private UserService userService;
	
	public UserController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping
	public ResponseEntity<List<UserResponseDTO>> list() {
		return ResponseEntity.ok(userService.findAll().stream().map(UserConverter::entityToDTO)
				.filter(dto -> !dto.getId().equals(1L))
				.collect(Collectors.toList()));
	}

	@PostMapping
	public ResponseEntity<UserResponseDTO> create(@Valid @RequestBody UserRequestDTO userRequestDTO)
			throws EntityNotFoundException {
		User user = userService.save(userRequestDTO);

		return new ResponseEntity<UserResponseDTO>(UserConverter.entityToDTO(user), HttpStatus.CREATED);
	}

	@PutMapping("change-password")
	public ResponseEntity<UserResponseDTO> changePassword(HttpServletRequest request,
			@Valid @RequestBody ChangePasswordRequestDTO changePasswordRequestDTO) {
		User user = userService.changePassword(changePasswordRequestDTO, request.getHeader(HttpHeaders.AUTHORIZATION));

		return ResponseEntity.ok(UserConverter.entityToDTO(user));
	}
	
}
