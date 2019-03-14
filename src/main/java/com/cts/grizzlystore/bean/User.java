package com.cts.grizzlystore.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="User")
@Table(name="User")
public class User {
	private String userId;
	private String name;
	private String password;
	private String userType;
	private int userStatus;
	private String contactNumber;
	private String designation;
	private String address;
	private float rating;
	
	public User() {
		super();
	}

	@Id
	@Column
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Column
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column
	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	@Column
	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	@Column
	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	@Column
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column
	public int getUserStatus() {
		return userStatus;
	}

	@Column
	public float getRating() {
		return rating;
	}

	public void setRating(float rating) {
		this.rating = rating;
	}

	public void setUserStatus(int userStatus) {
		this.userStatus = userStatus;
	}

	public User(String userId, String name, String password, String userType, int userStatus, String contactNumber,
			String designation, String address, float rating) {
		super();
		this.userId = userId;
		this.name = name;
		this.password = password;
		this.userType = userType;
		this.userStatus = userStatus;
		this.contactNumber = contactNumber;
		this.designation = designation;
		this.address = address;
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", name=" + name + ", password=" + password + ", userType=" + userType
				+ ", userStatus=" + userStatus + ", contactNumber=" + contactNumber + ", designation=" + designation
				+ ", address=" + address + ", rating=" + rating + "]";
	}

	
	

	
	
	
	
	
}
