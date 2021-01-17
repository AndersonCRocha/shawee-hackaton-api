package com.shawee.hackaton.controllers;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shawee.hackaton.dtos.request.InterestRequestDTO;
import com.shawee.hackaton.dtos.response.InterestResponseDTO;
import com.shawee.hackaton.entities.Interest;
import com.shawee.hackaton.entities.User;
import com.shawee.hackaton.services.InterestService;
import com.shawee.hackaton.utilities.converters.InterestConverter;

import springfox.documentation.annotations.ApiIgnore;

@RestController
@RequestMapping("interests")
public class InterestController {

	private InterestService interestService;
	
	public InterestController(InterestService interestService) {
		this.interestService = interestService;
	}
	
	@GetMapping
	public ResponseEntity<List<InterestResponseDTO>> list(@AuthenticationPrincipal @ApiIgnore User user) {
		return ResponseEntity.ok(interestService.findByUser(user).stream().map(InterestConverter::entityToDto)
				.collect(Collectors.toList()));
	}

	@GetMapping("{id}")
	public ResponseEntity<InterestResponseDTO> get(@PathVariable Long id) {
		Interest interest = interestService.findByIdAndValidated(id);
		return ResponseEntity.ok(InterestConverter.entityToDto(interest));
	}
	
	@PostMapping
	public ResponseEntity<InterestResponseDTO> create(@Valid @RequestBody InterestRequestDTO interestRequestDTO,
			@AuthenticationPrincipal @ApiIgnore User user) {
		interestRequestDTO.setUser(user);
		Interest interest = interestService.save(interestRequestDTO);
		
		return new ResponseEntity<InterestResponseDTO>(InterestConverter.entityToDto(interest), HttpStatus.CREATED);
	}
	
}