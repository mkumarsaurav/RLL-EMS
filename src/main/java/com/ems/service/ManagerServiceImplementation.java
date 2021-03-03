package com.ems.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ems.dao.ManagerDao;
import com.ems.entity.Leave;

@Service
@Transactional
public class ManagerServiceImplementation implements ManagerService {

	@Autowired
	private ManagerDao managerDao;

	@Override
	public List<Leave> totalLeaveApproved(Leave leave) {
		return managerDao.totalLeaveApproved(leave);
	}

	@Override
	public List<Leave> totalLeaveRejected(Leave leave) {
		return managerDao.totalLeaveRejected(leave);
	}
}
