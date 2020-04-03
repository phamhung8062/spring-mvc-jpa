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

import com.laptrinhjavaweb.buider.CustomerSearchBuilder;
import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.dto.CustomerDTO;
import com.laptrinhjavaweb.service.IBuildingService;
import com.laptrinhjavaweb.service.ICustomerService;

@Controller(value = "CustomerControllerOfAdmin")
public class CustomerControllerOfAdmin {
	@Autowired
	private ICustomerService customerservice;
	@Autowired
	private IBuildingService buildingservice;
	
	@RequestMapping(value = "admin/customer/list", method = RequestMethod.GET)
	public ModelAndView showBuilding(@ModelAttribute("model") CustomerDTO model ,@RequestParam("page") int page,
			@RequestParam("limit") int limit) {
		model.setPage(page);
		model.setLimit(limit);
		ModelAndView mav = new ModelAndView("admin/customer/list");
		CustomerSearchBuilder customerSeachBuilder = new CustomerSearchBuilder.Builder()
				.setCustomerName(model.getCustomerName()).setEmail(model.getEmail())
				.setPhone(model.getPhone())
				.build();
		Pageable pageable = new PageRequest(model.getPage()-1, model.getLimit());
		model.setTotalItem(customerservice.getTotalItem());
		model.setTotalPage((int) Math.ceil((double) model.getTotalItem() / model.getLimit()));
		List<CustomerDTO> customers = customerservice.findAll(customerSeachBuilder, pageable);
		
		mav.addObject("customers",customers);
		mav.addObject("model",model);
		return mav;
	}
	@RequestMapping(value = "/admin/customer/insert", method = RequestMethod.GET)
	
	public ModelAndView insertCustomer() {
		ModelAndView mav = new ModelAndView("admin/customer/insert");
		CustomerDTO model=new CustomerDTO();
		List<BuildingDTO> buildings= buildingservice.findAll();
		mav.addObject("buildings",buildings);
		mav.addObject("model", model);
		return mav;
	}
	@RequestMapping(value = "/admin/customer/edit", method = RequestMethod.GET)
	
	public ModelAndView editBuilding(@RequestParam(value="id",required = false) Long id) {
		ModelAndView mav = new ModelAndView("admin/customer/edit");
		CustomerDTO model=new CustomerDTO();
		if(id != null) {
			model=customerservice.findbyId(id);
		}
		mav.addObject("model", model);
		return mav;
	}
	
}
