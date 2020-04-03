package com.laptrinhjavaweb.dto;

public class BuildingDTO extends AbstractDTO<BuildingDTO> {

	private String name;
	private String numberOfBasement;
	private String buildingArea;
	private String district;
	private String ward;
	private String street;
	private String structure;
	private Integer costRent;
	private String serviceCost;
	private String carCost;
	private String motorbikeCost;
	private String overtimeCost;
	private String electricityCost;
	private String deposit;
	private String costdescription;
	private String payment;
	private String timeRent;
	private String areaRent;
	private String address;
	private String timedeCorator;
	private String managerName;
	private String managerPhone;
	private String staffId;
	private Long[] staffss= new Long[]{};
	private String type;
	private String[] buildingTypes= new String[]{};
	private String costRentFrom;
	private String costRentTo;
	private String areaRentFrom;
	private String areaRentTo;
	private String staffName;
	
	public String getStaffName() {
		return staffName;
	}
	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}
	public String getAreaRent() {
		return areaRent;
	}
	public void setAreaRent(String areaRent) {
		this.areaRent = areaRent;
	}
	public String getCostdescription() {
		return costdescription;
	}
	public void setCostdescription(String costdescription) {
		this.costdescription = costdescription;
	}
	
	public Long[] getStaffss() {
		return staffss;
	}
	public void setStaffss(Long[] staffss) {
		this.staffss = staffss;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNumberOfBasement() {
		return numberOfBasement;
	}
	public void setNumberOfBasement(String numberOfBasement) {
		this.numberOfBasement = numberOfBasement;
	}
	public String getBuildingArea() {
		return buildingArea;
	}
	public void setBuildingArea(String buildingArea) {
		this.buildingArea = buildingArea;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getWard() {
		return ward;
	}
	public void setWard(String ward) {
		this.ward = ward;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getStructure() {
		return structure;
	}
	public void setStructure(String structure) {
		this.structure = structure;
	}
	public Integer getCostRent() {
		return costRent;
	}
	public void setCostRent(Integer costRent) {
		this.costRent = costRent;
	}
	public String getServiceCost() {
		return serviceCost;
	}
	public void setServiceCost(String serviceCost) {
		this.serviceCost = serviceCost;
	}
	public String getCarCost() {
		return carCost;
	}
	public void setCarCost(String carCost) {
		this.carCost = carCost;
	}
	public String getMotorbikeCost() {
		return motorbikeCost;
	}
	public void setMotorbikeCost(String motorbikeCost) {
		this.motorbikeCost = motorbikeCost;
	}
	public String getOvertimeCost() {
		return overtimeCost;
	}
	public void setOvertimeCost(String overtimeCost) {
		this.overtimeCost = overtimeCost;
	}
	public String getElectricityCost() {
		return electricityCost;
	}
	public void setElectricityCost(String electricityCost) {
		this.electricityCost = electricityCost;
	}
	public String getDeposit() {
		return deposit;
	}
	public void setDeposit(String deposit) {
		this.deposit = deposit;
	}
	public String getPayment() {
		return payment;
	}
	public void setPayment(String payment) {
		this.payment = payment;
	}
	public String getTimeRent() {
		return timeRent;
	}
	public void setTimeRent(String timeRent) {
		this.timeRent = timeRent;
	}
	public String getTimedeCorator() {
		return timedeCorator;
	}
	public void setTimedeCorator(String timedeCorator) {
		this.timedeCorator = timedeCorator;
	}
	public String getManagerName() {
		return managerName;
	}
	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}
	public String getManagerPhone() {
		return managerPhone;
	}
	public void setManagerPhone(String managerPhone) {
		this.managerPhone = managerPhone;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String[] getBuildingTypes() {
		return buildingTypes;
	}
	public void setBuildingTypes(String[] buildingTypes) {
		this.buildingTypes = buildingTypes;
	}
	public String getCostRentFrom() {
		return costRentFrom;
	}
	public void setCostRentFrom(String costRentFrom) {
		this.costRentFrom = costRentFrom;
	}
	public String getCostRentTo() {
		return costRentTo;
	}
	public void setCostRentTo(String costRentTo) {
		this.costRentTo = costRentTo;
	}
	public String getAreaRentFrom() {
		return areaRentFrom;
	}
	public void setAreaRentFrom(String areaRentFrom) {
		this.areaRentFrom = areaRentFrom;
	}
	public String getAreaRentTo() {
		return areaRentTo;
	}
	public void setAreaRentTo(String areaRentTo) {
		this.areaRentTo = areaRentTo;
	}
	public String getStaffId() {
		return staffId;
	}
	public void setStaffId(String staffId) {
		this.staffId = staffId;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
}
