package com.ems.dao;

import java.util.List;

import com.ems.entity.Leave;

public interface LeaveDao {

	List<Leave> getLeave();

	void createLeave(Leave leave);

	Leave getLeaveForSpecficEmployee(int eid);

	List<Leave> cancelLeave(int eid);

	List<Leave> approveLeave(Leave leave);

}
