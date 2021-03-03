package com.ems.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ems.entity.Leave;

@SuppressWarnings("unchecked")
@Repository
public class ManagerDaoImplementation implements ManagerDao {

	@Autowired
	private SessionFactory sessionFactory;

	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public List<Leave> totalLeaveApproved(Leave leave) {
		Query query = getSession().createQuery("select COUNT(*) from Leave le where leaveStatus='Approved'");
		List<Leave> leaveApprovedList = query.list();

		return leaveApprovedList;
	}

	@Override
	public List<Leave> totalLeaveRejected(Leave leave) {
		Query query = getSession().createQuery("select COUNT(*) from Leave le where leaveStatus='Rejected'");
		List<Leave> leaveRejectedList = query.list();
		return leaveRejectedList;
	}

}