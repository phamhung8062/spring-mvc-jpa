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
import com.laptrinhjavaweb.buider.UserSearchBuilder;
import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.dto.UserDTO;
import com.laptrinhjavaweb.service.IBuildingService;
import com.laptrinhjavaweb.service.IUserService;

@Controller(value = "userControllerOfAdmin")
public class UserController {
	@Autowired
	private IUserService userservice;
	@Autowired
	private IBuildingService buildingservice;
	
	@RequestMapping(value = "admin/user/list", method = RequestMethod.GET)
	public ModelAndView showBuilding(@ModelAttribute("model") UserDTO model ,@RequestParam("page") int page,
			@RequestParam("limit") int limit) {
		model.setPage(page);
		model.setLimit(limit);
		ModelAndView mav = new ModelAndView("admin/user/list");
		UserSearchBuilder userSeachBuilder = new UserSearchBuilder.Builder()
				.setUserName(model.getUserName()).setFullName(model.getFullName())
				.setPhone(model.getPhone()).setEmail(model.getEmail())
				.build();
		Pageable pageable = new PageRequest(model.getPage()-1, model.getLimit());
		model.setTotalItem(userservice.getTotalItem());
		model.setTotalPage((int) Math.ceil((double) model.getTotalItem() / model.getLimit()));
		List<UserDTO> users = userservice.findAll(userSeachBuilder, pageable);
		mav.addObject("users",users);
		mav.addObject("model",model);
		return mav;
	}
	@RequestMapping(value = "/admin/user/insert", method = RequestMethod.GET)
	
	public ModelAndView insertBuilding() {
		ModelAndView mav = new ModelAndView("admin/user/insert");
		UserDTO model=new UserDTO();
		mav.addObject("model", model);
		return mav;
	}
	@RequestMapping(value = "/admin/user/edit", method = RequestMethod.GET)
	
	public ModelAndView editBuilding(@RequestParam(value="id",required = false) Long id) {
		ModelAndView mav = new ModelAndView("admin/user/edit");
		UserDTO model=new UserDTO();
		if(id != null) {
			model=userservice.findbyId(id);
		}
		mav.addObject("model", model);
		return mav;
	}
@RequestMapping(value = "/user/user/edit", method = RequestMethod.GET)
	
	public ModelAndView editStaff(@RequestParam(value="id",required = false) Long id) {
		ModelAndView mav = new ModelAndView("user/user/staff-edit");
		UserDTO model=new UserDTO();
		if(id != null) {
			model=userservice.findbyId(id);
		}
		mav.addObject("model", model);
		return mav;
	}
@RequestMapping(value = "/admin/user/user/edit", method = RequestMethod.GET)

public ModelAndView editStaff1(@RequestParam(value="id",required = false) Long id) {
	ModelAndView mav = new ModelAndView("admin/user/admin-edit");
	UserDTO model=new UserDTO();
	if(id != null) {
		model=userservice.findbyId(id);
	}
	mav.addObject("model", model);
	return mav;
}
	
}
