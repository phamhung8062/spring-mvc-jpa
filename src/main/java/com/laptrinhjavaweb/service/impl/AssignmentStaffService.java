package com.laptrinhjavaweb.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.laptrinhjavaweb.converter.BuildingConverter;
import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.entity.BuildingEntity;
import com.laptrinhjavaweb.entity.UserEntity;
import com.laptrinhjavaweb.repository.BuildingRepository;
import com.laptrinhjavaweb.service.IAssignmentStaffService;

@Service
public class AssignmentStaffService implements IAssignmentStaffService {
	@Autowired
	private BuildingConverter buildingConverter;
	@Autowired
	private BuildingRepository buildingRepository;
	@Transactional
	@Override
	public BuildingDTO AssignStaff(BuildingDTO buildingDTO) {
		BuildingEntity buildingEntity=buildingConverter.convertToEntity(buildingDTO);
		BuildingEntity buildingEntity1=buildingRepository.findOne(buildingEntity.getId());
		Long[] staffids=buildingDTO.getStaffss();
		List<UserEntity> user= new ArrayList<>();
		if(staffids.length>0) {
			for(int i=0;i<staffids.length;i++) {
				UserEntity a= new UserEntity();
				a.setId(staffids[i]);
				user.add(a);
			}	
		}
		buildingEntity1.setStaffs(user);
		buildingRepository.save(buildingEntity1);
		return null;
	}

}