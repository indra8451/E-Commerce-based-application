package com.UserLogin;

public class User {
	
	private int Uid;
	private String FirstName;
	private String LastName;
	private String UserName;
	private String Password;
	private String City;
	private String Email;
	private String Phone;
	private String Role;
	public User() {
		
		
	}
	
	public User(int uid,String firstName, String lastName, String userName, String password, String city, String email,
			String phone,String role) {
		Uid = uid;
		FirstName = firstName;
		LastName = lastName;
		UserName = userName;
		Password = password;
		City = city;
		Email = email;
		Phone = phone;
		Role = role;
	}
	
	


	public int getUid() {
		return Uid;
	}

	public void setUid(int uid) {
		Uid = uid;
	}

	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String firstName) {
		FirstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public String getUserName() {
		return UserName;
	}

	public void setUserName(String userName) {
		UserName = userName;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public String getCity() {
		return City;
	}

	public void setCity(String city) {
		City = city;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getPhone() {
		return Phone;
	}

	public void setPhone(String phone) {
		Phone = phone;
	}

	
	
	public String getRole() {
		return Role;
	}

	public void setRole(String role) {
		Role = role;
	}

	@Override
	public String toString() {
		return "User [Uid=" + Uid + ", FirstName=" + FirstName + ", LastName=" + LastName + ", UserName=" + UserName
				+ ", Password=" + Password + ", City=" + City + ", Email=" + Email + ", Phone=" + Phone + "]";
	}

	
	
	
	
	

}
