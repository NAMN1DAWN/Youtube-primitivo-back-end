package com.youpri.rest.security.jwt.model;

import java.util.Set;

import com.youpri.rest.dto.GetUserDTO;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class JwtUserResponse extends GetUserDTO{
	
	private String token;

	@Builder(builderMethodName = "jwtUserResponseBuilder")
	public JwtUserResponse(String username, String avatar, String fullName, String correo, Set<String> roles, String token) {
		super(username, avatar, fullName, correo, roles);
		this.token = token;
	}
	
}
