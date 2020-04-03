package com.laptrinhjavaweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.laptrinhjavaweb.entity.RentAreaEntity;
import com.laptrinhjavaweb.repository.custom.RentAreaRepositoryCustom;

public interface RentAreaRepository extends JpaRepository<RentAreaEntity, Long> ,RentAreaRepositoryCustom{

}
