package com.ems.service;

import java.util.List;
import com.ems.entity.Employee;

public interface EmployeeService {
	public void createEmployee(Employee employee);

	public List<Employee> getEmployeeList();

	public Employee getEmployee(Employee employee);

	public List<Employee> updateEmployee(Employee employee);

	public List<Employee> deleteEmployee(int eid);

	public Employee getEmployeeById(int eid);

}