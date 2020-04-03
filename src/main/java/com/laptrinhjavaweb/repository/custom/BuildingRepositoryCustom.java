package com.laptrinhjavaweb.repository.custom;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Pageable;

import com.laptrinhjavaweb.buider.BuildingSeachBuilder;
import com.laptrinhjavaweb.entity.BuildingEntity;

public interface BuildingRepositoryCustom{
	List<BuildingEntity> findAll(Map<String, Object> params,Pageable pageable,BuildingSeachBuilder fieldSearch);
	
}
