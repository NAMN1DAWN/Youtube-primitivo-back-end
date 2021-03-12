package com.youpri.rest.security.jwt;

import java.util.Date;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import com.youpri.modelo.UserEntity;
import com.youpri.modelo.UserRole;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SignatureException;
import lombok.extern.java.Log;

@Log
@Component
public class JwtTokenProvider {
	
	public static final String TOKEN_HEADER = "Authorization";
	public static final String TOKEN_PREFIX = "Bearer "; 
	public static final String TOKEN_TYPE = "JWT";
	
	@Value("${jwt.secret:SoyDealicanteconmuchoartevoyaimpresionarteporquesoyelmasterelquelaparte}")
	private String jwtSecreto;
	
	@Value("${jwt.token-expiration:864000}")
	private int jwtDurationTokenEnSegundos;
	
	public String generateToken(Authentication authentication) {
		
		UserEntity user = (UserEntity) authentication.getPrincipal();
		
		Date tokenExpirationDate = new Date(System.currentTimeMillis() + (jwtDurationTokenEnSegundos * 1000));
		
		return Jwts.builder()
				.signWith(SignatureAlgorithm.HS256, Keys.hmacShaKeyFor(jwtSecreto.getBytes()))
				.setHeaderParam("typ", TOKEN_TYPE)
				.setSubject(Long.toString(user.getId()))
				.setIssuedAt(new Date())
				.setExpiration(tokenExpirationDate)
				.claim("fullname", user.getFullName())
				.claim("roles", 
							user.getRoles().stream()
							.map(UserRole::name)
							.collect(Collectors.joining(", "))
						)
				.compact();
	}
	
	public Long GetUserIdFromJWT(String token) {
		Claims claims = Jwts.parser()
							.setSigningKey(Keys.hmacShaKeyFor(jwtSecreto.getBytes()))
							.parseClaimsJws(token)
							.getBody();
		
		return Long.parseLong(claims.getSubject());
	}
	
public boolean validateToken(String authToken) {
		
		try {
			Jwts.parser().setSigningKey(jwtSecreto.getBytes()).parseClaimsJws(authToken);
			return true;
		} catch (SignatureException ex) {
			log.info("Error en la firma del token JWT: " + ex.getMessage());
		} catch (MalformedJwtException ex) {
			log.info("Token malformado: " + ex.getMessage());
		} catch (ExpiredJwtException ex) {
			log.info("El token ha expirado: " + ex.getMessage());
		} catch (UnsupportedJwtException ex) {
			log.info("Token JWT no soportado: " + ex.getMessage());
		} catch (IllegalArgumentException ex) {
			log.info("JWT claims vacío");
		}
        return false;
		
		
		
	}
}
