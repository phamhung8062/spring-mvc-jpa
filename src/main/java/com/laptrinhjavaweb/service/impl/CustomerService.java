package com.laptrinhjavaweb.service.impl;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.laptrinhjavaweb.buider.CustomerSearchBuilder;
import com.laptrinhjavaweb.buider.UserSearchBuilder;
import com.laptrinhjavaweb.converter.CustomerConverter;
import com.laptrinhjavaweb.dto.CustomerDTO;
import com.laptrinhjavaweb.entity.AssignmentCustomerEntity;
import com.laptrinhjavaweb.entity.BuildingEntity;
import com.laptrinhjavaweb.entity.CustomerEntity;
import com.laptrinhjavaweb.entity.UserEntity;
import com.laptrinhjavaweb.repository.AssignmentCustomerRepository;
import com.laptrinhjavaweb.repository.CustomerRepository;
import com.laptrinhjavaweb.service.ICustomerService;
import com.laptrinhjavaweb.util.MD5;
@Service
public class CustomerService implements ICustomerService {
	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private AssignmentCustomerRepository assignmentCustomerRepository;
	@Autowired
	private CustomerConverter customerConverter;
	@Autowired
	private MD5 md5;
	
	
	@Override
	public List<CustomerDTO> findAll(CustomerSearchBuilder filedSearch, Pageable pageable) {
		Map<String, Object> properties = convertToMapProperties(filedSearch);
		List<CustomerEntity> customerEntities=customerRepository.findAll(properties, pageable, filedSearch);
		return customerEntities.stream().map(item -> customerConverter.convertToDTO(item)).collect(Collectors.toList());
	}
	private Map<String, Object> convertToMapProperties(CustomerSearchBuilder filedSearch) {
		Map<String, Object> properties = new HashMap<>();
		try {
			Field[] fields = UserSearchBuilder.class.getDeclaredFields();
			for (Field field : fields) {
					field.setAccessible(true);// cap quyen truy cap cho private
					properties.put(field.getName().toLowerCase(), field.get(filedSearch));
				}
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		return properties;
	}
	@Override
	public CustomerDTO findbyId(Long id) {
		CustomerEntity customerEntities=customerRepository.findOne(id);
		CustomerDTO customerDTO= customerConverter.convertToDTO(customerEntities);
		return customerDTO;
	}
	@Override
	public CustomerDTO save(CustomerDTO customerDTO) {
		CustomerEntity customerEntities=customerConverter.convertToEntity(customerDTO);
		BuildingEntity buildingEntity=new BuildingEntity();
		buildingEntity.setId(customerDTO.getBuildingId());
		UserEntity userEntity =new UserEntity();
		userEntity.setId(customerDTO.getStaffId());
		customerEntities=customerRepository.save(customerEntities);
		AssignmentCustomerEntity assignmentCustomerEntity=new AssignmentCustomerEntity();
		assignmentCustomerEntity.setBuildingid(buildingEntity);
		assignmentCustomerEntity.setStaffid(userEntity);
		assignmentCustomerEntity.setCustomerid(customerEntities);
		assignmentCustomerRepository.save(assignmentCustomerEntity);
		return customerConverter.convertToDTO(customerEntities);
	}
	@Override
	public CustomerDTO update(CustomerDTO customerDTO) {
		CustomerEntity customerEntities=customerConverter.convertToEntity(customerDTO);
		return customerConverter.convertToDTO(customerRepository.save(customerEntities));
		
	}
	@Override
	public void deleteMany(CustomerDTO customerDTO) {
		Long[] id= customerDTO.getIds();
		for(int i=0;i<id.length;i++) {
			assignmentCustomerRepository.deleteCustomer(id[i]);
			customerRepository.delete(id[i]);
			
		}
		
	}
	@Override
	public int getTotalItem() {
		return (int) customerRepository.count();
	}
}
