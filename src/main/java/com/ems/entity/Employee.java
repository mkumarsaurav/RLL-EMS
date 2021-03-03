package com.ems.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name = "Employee")
@Inheritance(strategy = InheritanceType.JOINED)
public class Employee {
	
	@Id
	private int eid;

	@Column(name = "FirstName")
	private String fname;
	@Column(name = "LastName")
	private String lname;
	@Column
	private int age;
	@Column
	private String gender;
	@Column
	private String email;
	@Column
	private String password;
	@Column
	private String address;
	@Column
	private String role;
	@Column
	private int availableLeave;
	@Column
	private long phoneNumber;

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(int eid, String fname, String lname, int age, String gender, String email, String password,
			String address, String role, int availableLeave, long phoneNumber) {
		super();
		this.eid = eid;
		this.fname = fname;
		this.lname = lname;
		this.age = age;
		this.gender = gender;
		this.email = email;
		this.password = password;
		this.address = address;
		this.role = role;
		this.availableLeave = availableLeave;
		this.phoneNumber = phoneNumber;
	}

	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public int getAvailableLeave() {
		return availableLeave;
	}

	public void setAvailableLeave(int availableLeave) {
		this.availableLeave = availableLeave;
	}

	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", fname=" + fname + ", lname=" + lname + ", age=" + age + ", gender=" + gender
				+ ", email=" + email + ", password=" + password + ", address=" + address + ", role=" + role
				+ ", availableLeave=" + availableLeave + ", phoneNumber=" + phoneNumber + "]";
	}

}