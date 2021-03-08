package com.ems.service;

import java.util.List;
import com.ems.entity.Employee;
import com.ems.entity.Manager;

public interface EmployeeService {
	public void createEmployee(Manager manager);

	public List<Employee> getEmployeeList();

	public List<Employee> updateEmployee(Employee employee);

	public List<Employee> deleteEmployee(int eid);

	public Employee getEmployeeById(int eid);

	public List<String> employeeLogin(String email, String password);

	public void updateLoginTime(String email);
	

}