package com.laptrinhjavaweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.laptrinhjavaweb.entity.AssignmentCustomerEntity;
import com.laptrinhjavaweb.repository.custom.AssignmentCustomerRepositoryCustom;

public interface AssignmentCustomerRepository extends JpaRepository<AssignmentCustomerEntity, Long>, AssignmentCustomerRepositoryCustom {


}
