package com.ems.dao;

import java.util.List;

import com.ems.entity.Leave;

public interface ManagerDao {

	List<Leave> totalLeaveApproved(Leave leave);

	List<Leave> totalLeaveRejected(Leave leave);

}
