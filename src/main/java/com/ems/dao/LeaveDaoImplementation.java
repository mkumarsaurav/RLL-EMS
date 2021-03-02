package com.ems.dao;

import java.time.Duration;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ems.entity.Leave;

@Repository
public class LeaveDaoImplementation implements LeaveDao {

	@Autowired
	private SessionFactory sessionFactory;

	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public List<Leave> getLeave() {
		Query query = getSession().createQuery("select me from Leave me");
		@SuppressWarnings("unchecked")
		List<Leave> empList = query.list();
		return empList;
	}

	@Override
	public void createLeave(Leave leave) {
		getSession().saveOrUpdate(leave);
		System.out.println(
				"leave id " + leave.getLeaveId() + " with employee  " + leave.getEid() + "stored in the DB !!!");
	}

	@Override
	public Leave getLeaveForSpecficEmployee(int eid) {
		Query query = getSession().createQuery("from Leave me where eid=" + eid);
		Leave e = (Leave) query.uniqueResult();
		return e;
	}

	@Override
	public List<Leave> cancelLeave(int eid) {
		Query query = getSession().createQuery("delete from Leave em where eid=:eid");
		query.setParameter("eid", eid);
		query.executeUpdate();
		System.out.print("Deleted Leave" + eid);
		return getLeave();
	}

	@Override
	public List<Leave> approveLeave(Leave leave) {

		int leaveId = leave.getLeaveId();
		String leaveStatus = leave.getLeaveStatus();
		Query query = getSession().createQuery("from Leave me where leaveId=" + leaveId);
		Leave e = (Leave) query.uniqueResult();
		int eid = e.getEid();

		int availableLeave = e.getAvailableLeave();
		Date toDate = e.getToDate();
		Date fromDate = e.getFromDate();
		LocalDate d1 = fromDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		LocalDate d2 = toDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		Duration diff = Duration.between(d1.atStartOfDay(), d2.atStartOfDay());
		int diffDays = (int) diff.toDays();
		if (leaveStatus.equals("Approved")) {
			availableLeave = availableLeave - diffDays;
			Query query1 = getSession().createQuery(
					"update Leave em set leaveStatus=:leaveStatus,availableLeave=:availableLeave where leaveId=:leaveId");
			query1.setParameter("leaveId", leaveId);
			query1.setParameter("leaveStatus", leaveStatus);
			query1.setParameter("availableLeave", availableLeave);
			query1.executeUpdate();
		} else {

			Query query1 = getSession().createQuery(
					"update Leave em set leaveStatus=:leaveStatus,availableLeave=:availableLeave where leaveId=:leaveId");
			query1.setParameter("leaveId", leaveId);
			query1.setParameter("leaveStatus", leaveStatus);
			query1.setParameter("availableLeave", availableLeave);
			query1.executeUpdate();

		}
		return getLeave();

	}

}
