package com.youpri.controller;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.youpri.modelo.UserEntity;
import com.youpri.modelo.UserRepositorio;
import com.youpri.rest.dto.CreateUserDTO;
import com.youpri.rest.dto.GetUserDTO;
import com.youpri.rest.dto.converter.UserDTOConverter;
import com.youpri.rest.service.UserEntityService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class UserController {

	private final UserEntityService userEntityService = null;
	private final UserRepositorio userRepositorio = null;
	private final UserDTOConverter userDTOConverter = null;
	
	@PostMapping("/register")
	private ResponseEntity<GetUserDTO> nuevoUsuario(@RequestBody CreateUserDTO newUser) {
		return ResponseEntity.status(HttpStatus.CREATED).body(
				userDTOConverter.convertUserEntityToGetUserDTO
				(userEntityService.nuevoUsuario(newUser)));
	}
	
	@GetMapping("/me")
	public GetUserDTO yo(@AuthenticationPrincipal UserEntity user)
	{
		return userDTOConverter.convertUserEntityToGetUserDTO(user);
	}
	
	@GetMapping("/")
	public ResponseEntity<?> obtenerTodos(){
		List<UserEntity> result = userRepositorio.findAll();
		
		if(result.isEmpty()) 
		{
			return ResponseEntity.notFound().build();
		}
		else 
		{
			List<GetUserDTO> dtoList = result.stream().map(userDTOConverter::convertUserEntityToGetUserDTO).collect(Collectors.toList());
			return ResponseEntity.ok(dtoList);
		}
	}
}
