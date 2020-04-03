package com.laptrinhjavaweb.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "assignmentcustomer")
public class AssignmentCustomerEntity extends BaseEntity {
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "staffid")
	private UserEntity staffid;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customerid")
    private CustomerEntity customerid;

	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "buildingid")
    private BuildingEntity buildingid;


	public BuildingEntity getBuildingid() {
		return buildingid;
	}

	public void setBuildingid(BuildingEntity buildingid) {
		this.buildingid = buildingid;
	}

	public UserEntity getStaffid() {
		return staffid;
	}

	public void setStaffid(UserEntity staffid) {
		this.staffid = staffid;
	}

	public CustomerEntity getCustomerid() {
		return customerid;
	}

	public void setCustomerid(CustomerEntity customerid) {
		this.customerid = customerid;
	}

	
}

	
