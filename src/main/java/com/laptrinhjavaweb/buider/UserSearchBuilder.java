package com.laptrinhjavaweb.buider;

public class UserSearchBuilder {
	private String userName;
	private String checked;
	private String phone;
	private String email;
	private String fullName;
	public String getPhone() {
		return phone;
	}
	public String getChecked() {
		return checked;
	}

	public String getEmail() {
		return email;
	}
	public String getUsername() {
		return userName;
	}
	
	public String getUserName() {
		return userName;
	}


	public String getFullName() {
		return fullName;
	}
	private UserSearchBuilder(Builder builder) {
		this.userName=builder.userName;
		this.email=builder.email;
		this.phone=builder.phone;
		this.checked=builder.checked;
		this.fullName=builder.fullName;
	}


	public static class Builder{
		private String userName;
		private String checked;
		private String phone;
		private String email;
		private String fullName;
		
		
		public Builder setPhone(String phone) {
			this.phone = phone;
			return this;
		}

		public Builder setChecked(String checked) {
			this.checked = checked;
			return this;
		}


		public Builder setEmail(String email) {
			this.email = email;
			return this;
		}


		public Builder setUserName(String userName) {
			this.userName = userName;
			return this;
		}


		public Builder setFullName(String fullName) {
			this.fullName = fullName;
			return this;
		}


		public UserSearchBuilder build() {
			return new UserSearchBuilder(this);
		}
	}
}
