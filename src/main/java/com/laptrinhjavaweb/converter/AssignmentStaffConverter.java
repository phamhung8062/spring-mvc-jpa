//package com.laptrinhjavaweb.converter;
//
//import org.modelmapper.ModelMapper;
//
//import com.laptrinhjavaweb.dto.AssignmentsStaffDTO;
//import com.laptrinhjavaweb.entity.AssignmentStaffEntity;
//
//public class AssignmentStaffConverter {
//	public AssignmentsStaffDTO convertToDTO(AssignmentStaffEntity entity) {
//		ModelMapper modelMapper = new ModelMapper();
//		AssignmentsStaffDTO dto = modelMapper.map(entity, AssignmentsStaffDTO.class);
//		return dto;
//	}
//	public AssignmentStaffEntity convertToEntity(AssignmentsStaffDTO dto) {
//		ModelMapper modelMapper = new ModelMapper();
//		AssignmentStaffEntity entity = modelMapper.map(dto, AssignmentStaffEntity.class);
//		return entity;
//	}
//}
