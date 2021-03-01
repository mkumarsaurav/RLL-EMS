package com.ems.dao;

import java.util.List;
//import org.springframework.transaction.annotation.EnableTransactionManagement;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ems.entity.Employee;

@Repository
//@EnableTransactionManagement
public class EmployeeDaoImplementation implements EmployeeDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public void createEmployee(Employee employee) {
		getSession().saveOrUpdate(employee);
		System.out.println("employee " + employee.getFname()+employee.getLname() +" stored in the DB !!!");
	}

	@Override
	public List<Employee> getEmployeeList() {
		Query query = getSession().createQuery("select me from Employee me");
		@SuppressWarnings("unchecked")
		List<Employee> empList=query.list();
		return empList;
	}

	@Override
	public Employee getEmployee(Employee employee) {
		Criteria c = getSession().createCriteria(Employee.class);
		c.add(Restrictions.eq("email",employee.getEmail()));
		Employee e =(Employee) c.uniqueResult();
		return e;
	}
	
	@Override
	public Employee getEmployeeById(int eid) {
		Query query = getSession().createQuery("from Employee me where eid="+eid);
        Employee e=(Employee) query.uniqueResult();
		return e;
	}
	
	@Override
	public List<Employee> updateEmployee(Employee employee) {
		int eid=employee.getEid();
		int age=employee.getAge();
		String fname=employee.getFname();
		String lname=employee.getLname();
		
		Query query = getSession().createQuery("update Employee em set fname=:fname, lname=:lname, age=:age where eid=:eid");
		query.setParameter("eid", eid);
		query.setParameter("fname", fname);
		query.setParameter("lname", lname);
		query.setParameter("age", age);
		query.executeUpdate();
		return getEmployeeList();
	}

	@Override
	public List<Employee> deleteEmployee(int eid) {
		Query query = getSession().createQuery("delete from Employee em where eid=:eid");
		query.setParameter("eid", eid);
		query.executeUpdate();
		return getEmployeeList();
	}

	
	

}