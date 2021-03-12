package com.youpri.controller;

import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.youpri.modelo.UserEntity;
import com.youpri.modelo.UserRole;
import com.youpri.rest.dto.GetUserDTO;
import com.youpri.rest.dto.converter.UserDTOConverter;
import com.youpri.rest.security.jwt.JwtTokenProvider;
import com.youpri.rest.security.jwt.model.JwtUserResponse;
import com.youpri.rest.security.jwt.model.LoginRequest;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class AuthenticationController {

	private final AuthenticationManager authenticationManager;
	private final JwtTokenProvider tokenProvider;
	private final UserDTOConverter converter;
	
	@PostMapping("/login")
	public ResponseEntity<JwtUserResponse> login(@Valid @RequestBody LoginRequest loginRequest){
		
		Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(),loginRequest.getPassword()));
		
		SecurityContextHolder.getContext().setAuthentication(authentication);
		
		UserEntity user = (UserEntity) authentication.getPrincipal();
		String jwtToken = tokenProvider.generateToken(authentication);
		
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(convertUserEntityAndTokenToJwtUserResponse(user , jwtToken));
	}

	public GetUserDTO me(@AuthenticationPrincipal UserEntity user) {
		return converter.convertUserEntityToGetUserDTO(user);
	}
	private JwtUserResponse convertUserEntityAndTokenToJwtUserResponse(UserEntity user, String jwtToken) {
		return JwtUserResponse
				.jwtUserResponseBuilder()
				.fullName(user.getFullName())
				.correo(user.getCorreo())
				.username(user.getUsername())
				.avatar(user.getAvatar())
				.roles(user.getRoles().stream().map(UserRole::name).collect(Collectors.toSet()))
				.token(jwtToken)
				.build();
	}
}
