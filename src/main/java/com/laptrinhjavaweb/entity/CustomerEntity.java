package com.laptrinhjavaweb.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "customer")
public class CustomerEntity extends BaseEntity {

	@Column(name = "customername")
	private String customerName;

	@Column(name = "staffid")
	private Long staffId;
	
	@Column(name = "buildingid")
	private Long buildingId;

	@Column(name = "phone")
	private String phone;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "email")
	private String email;

	@OneToMany(
	        mappedBy = "customerid",
	        fetch = FetchType.LAZY
	    )
	private List<AssignmentCustomerEntity> assignmentCustomerEntities = new ArrayList<>();
	
	
	public void setAssignmentCustomerEntities(List<AssignmentCustomerEntity> assignmentCustomerEntities) {
		this.assignmentCustomerEntities = assignmentCustomerEntities;
	}


	public List<AssignmentCustomerEntity> getAssignmentCustomerEntities() {
		return assignmentCustomerEntities;
	}


	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public Long getStaffId() {
		return staffId;
	}

	public void setStaffId(Long staffId) {
		this.staffId = staffId;
	}

	public Long getBuildingId() {
		return buildingId;
	}

	public void setBuildingId(Long buildingId) {
		this.buildingId = buildingId;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


}
