package com.laptrinhjavaweb.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.laptrinhjavaweb.api.output.StaffOutput;
import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.dto.UserDTO;
import com.laptrinhjavaweb.service.IAssignmentStaffService;
import com.laptrinhjavaweb.service.IUserService;

@RestController

public class UserAPI {
	@Autowired
	private IUserService userservice;
	@Autowired
	private IAssignmentStaffService assignmentStaffService;
	

	@RequestMapping(value = "/api/user", method = RequestMethod.GET)
	public List<StaffOutput> Stff(@RequestParam(value="id",required = false) Long id){
		List<UserDTO> user = userservice.findStaff();
		List<StaffOutput> users= new ArrayList<>();
		for(UserDTO a :user) {
			StaffOutput StaffOutput=new StaffOutput();
			StaffOutput.setId(a.getId());
			StaffOutput.setFullName(a.getFullName());
			if(userservice.AssignmentStaf(id, a.getId())){
			StaffOutput.setChecked("checked");
		}else if(!userservice.AssignmentStaf(id, a.getId())){
			StaffOutput.setChecked("");
		}
			users.add(StaffOutput);
		}
		return users;
	}
	@RequestMapping(value = "/api/user/assignment", method = RequestMethod.POST)
	public BuildingDTO Building(@RequestBody BuildingDTO newBuilding){
		return assignmentStaffService.AssignStaff(newBuilding);
	}
	@RequestMapping(value = "/api/user/insert", method = RequestMethod.POST)
	public UserDTO createdUser(@RequestBody UserDTO userDTO){
		return userservice.save(userDTO);
	}
	@RequestMapping(value = "/api/user/edit", method = RequestMethod.PUT)
	public UserDTO updateUser(@RequestBody UserDTO userDTO){
		return userservice.update(userDTO);
	}
	@RequestMapping(value = "/api/user/delete", method = RequestMethod.DELETE)
	public void deleteUser(@RequestBody UserDTO userDTO){
		userservice.deleteMany(userDTO);
	}

}
