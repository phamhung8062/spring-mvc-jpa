package com.laptrinhjavaweb.enums;

public enum BuildingTypesEnum {
	TANG_TRIET("Tầng Trệt"),
	NGUYEN_CAN("Nguyên Căn"), 
	NOI_THAT("Nội Thất");
	
	private final String buildingTypeValue;

	BuildingTypesEnum(String buildingTypeValue) {
		this.buildingTypeValue = buildingTypeValue;
	}

	public String getBuildingTypeValue() {
		return buildingTypeValue;
	}

	

}
