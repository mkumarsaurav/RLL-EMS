package com.ems.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "MANAGER")

public class Manager extends Employee {

	private int totalLeaveApproved;
	private int totalLeaveRejected;
	private String queriesByEmployee;

	public Manager() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Manager(int eid, String fname, String lname, int age, String gender, String email, String address,
			String password, String role) {
		super(eid, fname, lname, age, gender, email, address, password, role);
		// TODO Auto-generated constructor stub
	}

	public int getTotalLeaveApproved() {
		return totalLeaveApproved;
	}

	public void setTotalLeaveApproved(int totalLeaveApproved) {
		this.totalLeaveApproved = totalLeaveApproved;
	}

	public int getTotalLeaveRejected() {
		return totalLeaveRejected;
	}

	public void setTotalLeaveRejected(int totalLeaveRejected) {
		this.totalLeaveRejected = totalLeaveRejected;
	}

	public String getQueriesByEmployee() {
		return queriesByEmployee;
	}

	public void setQueriesByEmployee(String queriesByEmployee) {
		this.queriesByEmployee = queriesByEmployee;
	}

	@Override
	public String toString() {
		return "Manager [totalLeaveApproved=" + totalLeaveApproved + ", totalLeaveRejected=" + totalLeaveRejected
				+ ", queriesByEmployee=" + queriesByEmployee + "]";
	}

}