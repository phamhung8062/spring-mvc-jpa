package com.laptrinhjavaweb.converter;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.laptrinhjavaweb.dto.CustomerDTO;
import com.laptrinhjavaweb.entity.CustomerEntity;
@Component
public class CustomerConverter {
	public CustomerDTO convertToDTO(CustomerEntity item) {
		ModelMapper modelMapper = new ModelMapper();
		CustomerDTO dto=modelMapper.map(item, CustomerDTO.class);
		return dto;
	}
	public CustomerEntity convertToEntity(CustomerDTO dto) {
		ModelMapper modelMapper = new ModelMapper();
		CustomerEntity entity=modelMapper.map(dto, CustomerEntity.class);
		return entity;
	}
}
