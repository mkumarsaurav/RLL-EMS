package com.ems.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ems.entity.Employee;
import com.ems.entity.Manager;

@Repository
public class EmployeeDaoImplementation implements EmployeeDao {

	@Autowired
	private SessionFactory sessionFactory;

	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void createEmployee(Manager manager) {

		manager.setAvailableLeave(24);

		if (manager.getRole().equals("Manager")) {

			getSession().saveOrUpdate(manager);

		} else {
			Employee employee = new Employee();
			employee.setAddress(manager.getAddress());
			employee.setAge(manager.getAge());
			employee.setEid(manager.getEid());
			employee.setEmail(manager.getEmail());
			employee.setFname(manager.getFname());
			employee.setGender(manager.getGender());
			employee.setLname(manager.getLname());
			employee.setPassword(manager.getPassword());
			employee.setRole(manager.getRole());
			employee.setPhoneNumber(manager.getPhoneNumber());
			employee.setAvailableLeave(24);
			getSession().saveOrUpdate(employee);
		}

	}

	@Override
	public List<Employee> getEmployeeList() {
		Query query = getSession().createQuery("select me from Employee me");
		@SuppressWarnings("unchecked")
		List<Employee> empList = query.list();
		return empList;
	}

	@Override
	public Employee getEmployeeById(int eid) {
		Query query = getSession().createQuery("from Employee me where eid=" + eid);

		return (Employee) query.uniqueResult();
	}

	@Override
	public List<Employee> updateEmployee(Employee employee) {
		int eid = employee.getEid();
		int age = employee.getAge();
		String fname = employee.getFname();
		String lname = employee.getLname();
		String gender = employee.getGender();
		String email = employee.getEmail();
		long phoneNumber = employee.getPhoneNumber();
		String address = employee.getAddress();

		Query query = getSession()
				.createQuery("update Employee em set fname=:fname, lname=:lname, age=:age,gender=:gender,"
						+ "email=:email,phoneNumber=:phoneNumber,address=:address where eid=:eid");
		query.setParameter("eid", eid);
		query.setParameter("fname", fname);
		query.setParameter("lname", lname);
		query.setParameter("age", age);
		query.setParameter("gender", gender);
		query.setParameter("email", email);
		query.setParameter("phoneNumber", phoneNumber);
		query.setParameter("address", address);

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

	@Override
	public String login(String email, String password) {
		Query query = getSession().createQuery(
				"select me.role from Employee me where email='" + email + "'and password='" + password + "'");

		return (String) query.uniqueResult();
	}

}