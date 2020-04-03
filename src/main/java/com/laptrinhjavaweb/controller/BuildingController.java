package com.laptrinhjavaweb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.laptrinhjavaweb.buider.BuildingSeachBuilder;
import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.dto.UserDTO;
import com.laptrinhjavaweb.service.IBuildingService;
import com.laptrinhjavaweb.service.IUserService;

@Controller(value = "buildingControllerOfAdmin")
public class BuildingController {
	@Autowired
	private IBuildingService buildingservice;
	@Autowired
	private IUserService userservice;
	@RequestMapping(value = "/admin/building/list", method = RequestMethod.GET)
	public ModelAndView showBuilding(@ModelAttribute("model") BuildingDTO model ,@RequestParam("page") int page,
			@RequestParam("limit") int limit) {
		model.setPage(page);
		model.setLimit(limit);
		ModelAndView mav = new ModelAndView("admin/building/list");
		BuildingSeachBuilder buildingSeachBuilder = new BuildingSeachBuilder.Builder().setName(model.getName())
				.setDistrict(model.getDistrict()).setStreet(model.getStreet()).setWard(model.getWard())
				.setBuildingArea(model.getBuildingArea()).setNumberOfBasement(model.getNumberOfBasement())
				.setBuildingTypes(model.getBuildingTypes()).setAreaRentFrom(model.getAreaRentFrom())
				.setAreaRentTo(model.getAreaRentTo()).setCostRentFrom(model.getCostRentFrom())
				.setCostRentTo(model.getCostRentTo()).setStaffId(model.getStaffId())
				.setId(model.getId()).setStaffName(model.getStaffName())
				.build();
		//Pageable pageable = new PageRequest(1,3);
		Pageable pageable = new PageRequest(model.getPage()-1, model.getLimit());
		model.setTotalItem(buildingservice.getTotalItem());
		model.setTotalPage((int) Math.ceil((double) model.getTotalItem() / model.getLimit()));
		List<BuildingDTO> buildings = buildingservice.findAll(buildingSeachBuilder, pageable);
		mav.addObject("buildingTypes",buildingservice.getBuildingTypes());
		mav.addObject("districts",buildingservice.getDistricts());
		mav.addObject("buildings",buildings);
		mav.addObject("model",model);
		return mav;
	}
	@RequestMapping(value = "/user/building/list", method = RequestMethod.GET)
	public ModelAndView showBuildingUser(@ModelAttribute("model") BuildingDTO model ,@RequestParam("page") int page,
			@RequestParam("limit") int limit) {
		model.setPage(page);
		model.setLimit(limit);
		ModelAndView mav = new ModelAndView("user/building/list");
		BuildingSeachBuilder buildingSeachBuilder = new BuildingSeachBuilder.Builder().setName(model.getName())
				.setDistrict(model.getDistrict()).setStreet(model.getStreet()).setWard(model.getWard())
				.setBuildingArea(model.getBuildingArea()).setNumberOfBasement(model.getNumberOfBasement())
				.setBuildingTypes(model.getBuildingTypes()).setAreaRentFrom(model.getAreaRentFrom())
				.setAreaRentTo(model.getAreaRentTo()).setCostRentFrom(model.getCostRentFrom())
				.setCostRentTo(model.getCostRentTo()).setStaffId(model.getStaffId())
				.setId(model.getId()).setStaffName(model.getStaffName())
				.build();
		//Pageable pageable = new PageRequest(1,3);
		Pageable pageable = new PageRequest(model.getPage()-1, model.getLimit());
		model.setTotalItem(buildingservice.getTotalItem());
		model.setTotalPage((int) Math.ceil((double) model.getTotalItem() / model.getLimit()));
		List<BuildingDTO> buildings = buildingservice.findAll(buildingSeachBuilder, pageable);
		mav.addObject("buildingTypes",buildingservice.getBuildingTypes());
		mav.addObject("districts",buildingservice.getDistricts());
		mav.addObject("buildings",buildings);
		mav.addObject("model",model);
		return mav;
	}
	@RequestMapping(value = "/admin/building/insert", method = RequestMethod.GET)
	
	public ModelAndView insertBuilding() {
		ModelAndView mav = new ModelAndView("admin/building/insert");
		 BuildingDTO model=new BuildingDTO();
		mav.addObject("buildingTypes",buildingservice.getBuildingTypes());
		mav.addObject("districts",buildingservice.getDistricts());
		mav.addObject("model", model);
		return mav;
	}
@RequestMapping(value = "/admin/building/edit", method = RequestMethod.GET)
	
	public ModelAndView editBuilding(@RequestParam(value="id",required = false) Long id) {
		ModelAndView mav = new ModelAndView("admin/building/edit");
		 BuildingDTO model=new BuildingDTO();
		if(id != null) {
			model=buildingservice.findbyId(id);
		}
		mav.addObject("buildingTypes",buildingservice.getBuildingTypes());
		mav.addObject("model", model);
		return mav;
	}

}
