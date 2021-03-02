package com.ems.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "LEAVE")

public class Leave {

	@Id
	@GeneratedValue
	private int leaveId;
	private String leaveType;
	private String leaveStatus;
	private int availableLeave;
	private Date toDate;
	private Date fromDate;
	private int eid;

	public Leave() {
		super();

		// TODO Auto-generated constructor stub
	}

	public Leave(int leaveId, String leaveType, String leaveStatus, int availableLeave, Date toDate, Date fromDate,
			int eid) {
		super();
		this.leaveId = leaveId;
		this.leaveType = leaveType;
		this.leaveStatus = leaveStatus;
		this.availableLeave = availableLeave;
		this.toDate = toDate;
		this.fromDate = fromDate;
		this.eid = eid;
	}

	public int getLeaveId() {
		return leaveId;
	}

	public void setLeaveId(int leaveId) {
		this.leaveId = leaveId;
	}

	public String getLeaveType() {
		return leaveType;
	}

	public void setLeaveType(String leaveType) {
		this.leaveType = leaveType;
	}

	public String getLeaveStatus() {
		return leaveStatus;
	}

	public void setLeaveStatus(String leaveStatus) {
		this.leaveStatus = leaveStatus;
	}

	public int getAvailableLeave() {
		return availableLeave;
	}

	public void setAvailableLeave(int availableLeave) {
		this.availableLeave = availableLeave;
	}

	public Date getToDate() {
		return toDate;
	}

	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}

	public Date getFromDate() {
		return fromDate;
	}

	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	@Override
	public String toString() {
		return "Leave [leaveId=" + leaveId + ", leaveType=" + leaveType + ", leaveStatus=" + leaveStatus
				+ ", availableLeave=" + availableLeave + ", toDate=" + toDate + ", fromDate=" + fromDate + ", eid="
				+ eid + "]";
	}

}