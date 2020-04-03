package com.laptrinhjavaweb.dto;

public class CustomerDTO  extends AbstractDTO<CustomerDTO>{
	private String customerName;
	private String email;
	private Long staffId;
	private Long buildingId;
	private Integer phone;
	private String address;
	
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getPhone() {
		return phone;
	}
	public void setPhone(Integer phone) {
		this.phone = phone;
	}
	

}
