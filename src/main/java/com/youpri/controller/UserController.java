package com.youpri.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.youpri.rest.dto.CreateUserDTO;
import com.youpri.rest.dto.GetUserDTO;
import com.youpri.rest.dto.converter.UserDTOConverter;
import com.youpri.rest.service.UserEntityService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

	private final UserEntityService userEntityService = null;
	private final UserDTOConverter userDTOConverter = null;
	
	@PostMapping("/")
	private ResponseEntity<GetUserDTO> nuevoUsuario(@RequestBody CreateUserDTO newUser) {
		return ResponseEntity.status(HttpStatus.CREATED).body(
				userDTOConverter.convertUserEntityToGetUserDTO
				(userEntityService.nuevoUsuario(newUser)));
	}
}
