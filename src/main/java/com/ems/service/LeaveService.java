package com.ems.service;

import java.util.List;

import com.ems.entity.Leave;

public interface LeaveService {

	List<Leave> getEmployeeLeave();

	void createLeave(Leave leave);

	List<Leave> getLeaveForSpecficEmployee(int eid);

	List<Leave> cancelLeave(int eid);

	List<Leave> approveLeave(Leave leave);
	String getAction(int leaveId);
}
