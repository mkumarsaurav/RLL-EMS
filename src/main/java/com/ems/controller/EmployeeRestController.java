package com.ems.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ems.entity.Employee;
import com.ems.service.EmployeeService;

@RestController
public class EmployeeRestController {
	@Autowired
	EmployeeService employeeService;
	Employee employee;

	@GetMapping("/allemp")
	private ResponseEntity<List<Employee>> allEmployee() {

		List<Employee> li = employeeService.getEmployeeList();
		if (li.isEmpty()) {
			return new ResponseEntity<List<Employee>>(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<List<Employee>>(li, HttpStatus.OK);
	}
	
	@PostMapping("/create")
	public Employee createEmployee(@RequestBody Employee employee) {
		employeeService.createEmployee(employee);
		return employee;
	}

	@GetMapping("/search/{empid}")
	public List<Employee> searchEmployee(@PathVariable("empid") int eid) {
		List<Employee> li= new ArrayList<Employee>();
		Employee emp=new Employee();
		emp=employeeService.getEmployeeById(eid);
		li.add(emp);
		return li;
	}
}
