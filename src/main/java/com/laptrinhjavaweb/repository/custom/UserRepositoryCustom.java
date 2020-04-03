package com.laptrinhjavaweb.repository.custom;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Pageable;

import com.laptrinhjavaweb.buider.UserSearchBuilder;
import com.laptrinhjavaweb.entity.UserEntity;

public interface UserRepositoryCustom {
	List<UserEntity> findStaff();
	List<UserEntity> findAll(Map<String,Object> params,Pageable pageable,UserSearchBuilder userSearchBuilder);

}
