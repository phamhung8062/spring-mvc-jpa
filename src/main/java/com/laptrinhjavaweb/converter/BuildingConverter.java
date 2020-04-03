package com.laptrinhjavaweb.converter;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.entity.BuildingEntity;
@Component
public class BuildingConverter {
	public BuildingDTO convertToDTO(BuildingEntity entity) {
		ModelMapper modelMapper = new ModelMapper();
		BuildingDTO dto = modelMapper.map(entity, BuildingDTO.class);
		dto.setAddress(dto.getStreet()+","+ dto.getWard() +","+ dto.getDistrict());
		return dto;
	}
	public BuildingEntity convertToEntity(BuildingDTO dto) {
		ModelMapper modelMapper = new ModelMapper();
		BuildingEntity entity = modelMapper.map(dto, BuildingEntity.class);
		return entity;
	}
}
