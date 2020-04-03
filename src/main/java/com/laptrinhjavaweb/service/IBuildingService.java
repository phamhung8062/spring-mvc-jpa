package com.laptrinhjavaweb.service;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Pageable;

import com.laptrinhjavaweb.buider.BuildingSeachBuilder;
import com.laptrinhjavaweb.dto.BuildingDTO;

public interface IBuildingService {
	List<BuildingDTO> findAll(BuildingSeachBuilder filedSearch,Pageable pageable);
	Map<String, String> getDistricts();
	Map<String, String> getBuildingTypes();
	BuildingDTO save(BuildingDTO newBuilding);
	BuildingDTO findbyId(Long id);
	BuildingDTO update(BuildingDTO newBuilding);
	List<BuildingDTO> findAllUser();
	int getTotalItem();
	void deleteMany(BuildingDTO buildingDTO);
	List<BuildingDTO> findAll();
}
