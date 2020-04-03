package com.laptrinhjavaweb.buider;

public class BuildingSeachBuilder {
	private String name;
	private String district;
	private String buildingArea;
	private String numberOfBasement;
	private String street;
	private String ward;
	private String[] buildingTypes= new String[]{};
	private String costRentFrom;
	private String costRentTo;
	private String areaRentFrom;
	private String areaRentTo;
	private String staffId;
	private String staffName;
	private Long id;
	private Integer page;
	private Integer limit;
	
	public String getStaffName() {
		return staffName;
	}

	public Integer getPage() {
		return page;
	}

	public Integer getLimit() {
		return limit;
	}

	public Long getId() {
		return id;
	}

	public String getStaffId() {
		return staffId;
	}

	public String getCostRentFrom() {
		return costRentFrom;
	}

	public String getCostRentTo() {
		return costRentTo;
	}

	public String getAreaRentFrom() {
		return areaRentFrom;
	}

	public String getAreaRentTo() {
		return areaRentTo;
	}

	public String[] getBuildingTypes() {
		return buildingTypes;
	}

	public String getStreet() {
		return street;
	}

	public String getWard() {
		return ward;
	}

	public String getBuildingArea() {
		return buildingArea;
	}

	public String getNumberOfBasement() {
		return numberOfBasement;
	}

	public String getName() {
		return name;
	}

	public String getDistrict() {
		return district;
	}

	private BuildingSeachBuilder(Builder builder) {
		this.name=builder.name;
		this.district=builder.district;
		this.buildingArea=builder.buildingArea;
		this.numberOfBasement=builder.numberOfBasement;
		this.street=builder.street;
		this.ward=builder.ward;
		this.buildingTypes=builder.buildingTypes;
		this.costRentFrom=builder.costRentFrom;
		this.areaRentFrom=builder.areaRentFrom;
		this.areaRentTo=builder.areaRentTo;
		this.costRentTo=builder.costRentTo;
		this.staffId=builder.staffId;
		this.id=builder.id;
		this.limit=builder.limit;
		this.page=builder.page;
		this.staffName=builder.staffName;
	}

	public static class Builder {
		private Long id;
		public Builder setId(Long id) {
			this.id = id;
			return this;
		}

		private String name;
		private String district;
		private String buildingArea;
		private String numberOfBasement;
		private String street;
		private String ward;
		private String[] buildingTypes= new String[]{};
		private String costRentFrom;
		private String costRentTo;
		private String areaRentFrom;
		private String areaRentTo;
		private String staffId;
		private Integer page;
		private Integer limit;
		private String staffName;
		public Builder setStaffName(String staffName) {
			this.staffName = staffName;
			return this;
		}

		public Builder setPage(Integer page) {
			this.page = page;
			return this;
		}

		public Builder setLimit(Integer limit) {
			this.limit = limit;
			return this;
		}

		public Builder setStaffId(String staffId) {
			this.staffId = staffId;
			return this;
		}

		public Builder setCostRentFrom(String costRentFrom) {
			this.costRentFrom = costRentFrom;
			return this;
		}

		public Builder setCostRentTo(String costRentTo) {
			this.costRentTo = costRentTo;
			return this;
		}

		public Builder setAreaRentFrom(String areaRentFrom) {
			this.areaRentFrom = areaRentFrom;
			return this;
		}

		public Builder setAreaRentTo(String areaRentTo) {
			this.areaRentTo = areaRentTo;
			return this;
		}

		

		public Builder setBuildingTypes(String[] buildingTypes) {
			this.buildingTypes = buildingTypes;
			return this;
		}

		public Builder setStreet(String street) {
			this.street = street;
			return this;
		}

		public Builder setWard(String ward) {
			this.ward = ward;
			return this;
		}

		public Builder setName(String name) {
			this.name = name;
			return this;
		}

		public Builder setBuildingArea(String buildingArea) {
			this.buildingArea = buildingArea;
			return this;
		}

		public Builder setNumberOfBasement(String numberOfBasement) {
			this.numberOfBasement = numberOfBasement;
			return this;
		}

		public Builder setDistrict(String district) {
			this.district = district;
			return this;
		}

		public BuildingSeachBuilder build() {
			return new BuildingSeachBuilder(this);
		}
	}
}
