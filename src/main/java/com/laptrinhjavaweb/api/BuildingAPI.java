package com.laptrinhjavaweb.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.service.IBuildingService;

@RestController
@RequestMapping("/api/building")
public class BuildingAPI {
	@Autowired
	private IBuildingService buildingService;
	
	@PostMapping
	public BuildingDTO createdBuilding(@RequestBody BuildingDTO newBuilding){
		return buildingService.save(newBuilding);
	}
	@PutMapping
	public BuildingDTO updateBuilding(@RequestBody BuildingDTO newBuilding){
		return buildingService.update(newBuilding);
	}
	@DeleteMapping
	public void deleteBuilding(@RequestBody BuildingDTO newBuilding){
		buildingService.deleteMany(newBuilding);
	}
}
