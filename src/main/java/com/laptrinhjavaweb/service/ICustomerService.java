package com.laptrinhjavaweb.service;
import java.util.List;
import org.springframework.data.domain.Pageable;

import com.laptrinhjavaweb.buider.CustomerSearchBuilder;
import com.laptrinhjavaweb.buider.UserSearchBuilder;
import com.laptrinhjavaweb.dto.CustomerDTO;
import com.laptrinhjavaweb.dto.UserDTO;

public interface ICustomerService {
	List<CustomerDTO> findAll(CustomerSearchBuilder filedSearch,Pageable pageable);
	CustomerDTO findbyId(Long id);
	CustomerDTO save(CustomerDTO customerDTO);
	CustomerDTO update(CustomerDTO customerDTO);
	void deleteMany(CustomerDTO customerDTO);
	int getTotalItem();
}
