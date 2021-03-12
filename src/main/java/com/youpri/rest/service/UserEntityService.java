package com.youpri.rest.service;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.youpri.modelo.UserEntity;
import com.youpri.modelo.UserRepositorio;
import com.youpri.modelo.UserRole;
import com.youpri.rest.dto.CreateUserDTO;
import com.youpri.rest.error.exceptions.NewUserWithDifferentPasswordsException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserEntityService extends BaseService<UserEntity, Long, UserRepositorio>{
	
	private final PasswordEncoder passwordEncoder = null;
	
	public Optional<UserEntity> findByUsername(String username)
	{
		return this.repositorio.findByUsername(username);
	}

	public UserEntity nuevoUsuario(CreateUserDTO newUser) 
	{
		//userEntity.setPassword(passwordEncoder.encode(userEntity.getPassword()));
		//userEntity.setRoles(Stream.of(UserRole.USER).collect(Collectors.toSet()));
		//return save(userEntity);
		
		if(newUser.getPassword().contentEquals(newUser.getPassword2())) 
		{
			UserEntity userEntity = UserEntity.builder()
											.username(newUser.getUsername())
											.password(passwordEncoder.encode(newUser.getPassword()))
											.correo(newUser.getCorreo())
											.fullName(newUser.getFullName())
											.avatar(newUser.getAvatar())
											.roles(Stream.of(UserRole.USER).collect(Collectors.toSet()))
											.build();
			try {
				return save(userEntity);
			} catch(DataIntegrityViolationException ex) {
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El nombre de usuario ya existe");
			}
		}else 
		{
			throw new NewUserWithDifferentPasswordsException();
		}
	}
}
