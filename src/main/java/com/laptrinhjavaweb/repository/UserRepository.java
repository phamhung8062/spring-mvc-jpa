package com.laptrinhjavaweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.laptrinhjavaweb.entity.UserEntity;
import com.laptrinhjavaweb.repository.custom.UserRepositoryCustom;

public interface UserRepository extends JpaRepository<UserEntity, Long>, UserRepositoryCustom{
	UserEntity findOneByUserNameAndStatus(String name, int status);
}
