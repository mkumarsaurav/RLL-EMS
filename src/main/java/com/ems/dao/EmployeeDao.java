package com.ems.dao;

import java.util.List;

import com.ems.entity.Employee;
import com.ems.entity.Manager;

public interface EmployeeDao {
	public void createEmployee(Manager manager);

	public List<Employee> getEmployeeList();

	List<Employee> updateEmployee(Employee employee);

	List<Employee> deleteEmployee(int eid);

	Employee getEmployeeById(int eid);

	public List<String> employeeLogin(String email, String password);

	public void updateLoginTime(String email);
}
