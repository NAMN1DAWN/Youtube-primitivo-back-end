package com.youpri.rest.dto.converter;

import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.youpri.modelo.UserEntity;
import com.youpri.modelo.UserRole;
import com.youpri.rest.dto.GetUserDTO;

import lombok.Builder;

@Builder
@Component
public class UserDTOConverter {

	public GetUserDTO convertUserEntityToGetUserDTO(UserEntity user) 
	{
		return GetUserDTO.builder()
				.username(user.getUsername())
				.avatar(user.getAvatar())
				.roles(user.getRoles().stream()
						.map(UserRole::name)
						.collect(Collectors.toSet()))
						.build();
	}
}
