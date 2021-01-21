package com.youpri.modelo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepositorio extends JpaRepository<UserEntity, Long>{
	
	Optional<UserEntity> findByUsername(String username);

}
