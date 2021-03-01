package com.ems.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ems.dao.EmployeeDao;
import com.ems.entity.Employee;

@Service
@Transactional
public class EmployeeServiceImplementation implements EmployeeService {
	@Autowired
	private EmployeeDao employeeDao;

	@Override
	public void createEmployee(Employee employee) {
		employeeDao.createEmployee(employee);

	}

	@Override
	public List<Employee> getEmployeeList() {

		return employeeDao.getEmployeeList();
	}

	@Override
	public Employee getEmployee(Employee employee) {

		return employeeDao.getEmployee(employee);
	}

	@Override
	public List<Employee> updateEmployee(Employee employee) {

		return employeeDao.updateEmployee(employee);
	}

	@Override
	public List<Employee> deleteEmployee(int eid) {

		return employeeDao.deleteEmployee(eid);
	}

	@Override
	public Employee getEmployeeById(int eid) {
		return employeeDao.getEmployeeById(eid);

	}

}