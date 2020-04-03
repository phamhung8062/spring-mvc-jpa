package com.laptrinhjavaweb.buider;

public class CustomerSearchBuilder {
	private String customerName;
	private String email;
	private String staffId;
	private String buildingId;
	private Integer phone;
	public String getCustomerName() {
		return customerName;
	}
	public String getEmail() {
		return email;
	}
	public String getStaffId() {
		return staffId;
	}
	public String getBuildingId() {
		return buildingId;
	}
	public Integer getPhone() {
		return phone;
	}
	private CustomerSearchBuilder(Builder builder) {
		this.customerName=builder.customerName;
		this.email=builder.email;
		this.buildingId=builder.buildingId;
		this.phone=builder.phone;
		this.staffId=builder.staffId;
		
		
	}

	public static class Builder {
		private String customerName;
		private String email;
		private String staffId;
		private String buildingId;
		private Integer phone;
		
		public Builder setCustomerName(String customerName) {
			this.customerName = customerName;
			return this;
		}

		public Builder setEmail(String email) {
			this.email = email;
			return this;
		}

		public Builder setStaffId(String staffId) {
			this.staffId = staffId;
			return this;
		}

		public Builder setBuildingId(String buildingId) {
			this.buildingId = buildingId;
			return this;
		}

		public Builder setPhone(Integer phone) {
			this.phone = phone;
			return this;
		}

		public CustomerSearchBuilder build() {
			return new CustomerSearchBuilder(this);
		}
	}
	
}
