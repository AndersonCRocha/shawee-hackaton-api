package com.shawee.hackaton.controllers;

import java.util.Date;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.shawee.hackaton.dtos.request.AuthenticationRequestDTO;
import com.shawee.hackaton.dtos.response.TokenResponseDTO;
import com.shawee.hackaton.entities.User;
import com.shawee.hackaton.security.JwtUtil;

@RestController
public class AuthenticationController {

	private AuthenticationManager authenticationManager;
	private JwtUtil jwtUtil;

	public AuthenticationController(AuthenticationManager authenticationManager, JwtUtil jwtUtil) {
		this.authenticationManager = authenticationManager;
		this.jwtUtil = jwtUtil;
	}

	@PostMapping("auth")
	public ResponseEntity<TokenResponseDTO> authenticate(
			@RequestBody @Valid AuthenticationRequestDTO authenticationRequestDTO) {
		String email = authenticationRequestDTO.getEmail();
		UsernamePasswordAuthenticationToken usernamPasswordToken = new UsernamePasswordAuthenticationToken(email,
				authenticationRequestDTO.getPassword());

		Authentication authentication = authenticationManager.authenticate(usernamPasswordToken);
		SecurityContextHolder.getContext().setAuthentication(authentication);

		User user = (User) authentication.getPrincipal();
		String token = jwtUtil.generateToken(email, user.getRoleNames());
		Date expiration = jwtUtil.getExpirationFromToken(token);

		return ResponseEntity.ok(new TokenResponseDTO(token, expiration));
	}

}