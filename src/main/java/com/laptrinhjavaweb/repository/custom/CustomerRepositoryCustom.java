package com.laptrinhjavaweb.repository.custom;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Pageable;

import com.laptrinhjavaweb.buider.CustomerSearchBuilder;
import com.laptrinhjavaweb.entity.CustomerEntity;

public interface CustomerRepositoryCustom {
	List<CustomerEntity> findAll(Map<String,Object> params,Pageable pageable,CustomerSearchBuilder customerSearchBuilder);

}
