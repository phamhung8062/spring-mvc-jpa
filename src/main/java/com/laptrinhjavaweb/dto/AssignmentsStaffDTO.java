package com.laptrinhjavaweb.dto;

public class AssignmentsStaffDTO extends AbstractDTO<AssignmentsStaffDTO> {
	private Long buildingId;
	private Long[] staffIds= new Long[]{};
	public Long[] getStaffIds() {
		return staffIds;
	}
	public void setStaffIds(Long[] staffIds) {
		this.staffIds = staffIds;
	}
	public Long getBuildingId() {
		return buildingId;
	}
	public void setBuildingId(Long buildingId) {
		this.buildingId = buildingId;
	}
	

}
