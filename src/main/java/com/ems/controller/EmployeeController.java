package com.ems.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ems.entity.Employee;
import com.ems.service.EmployeeService;

@Controller
public class EmployeeController {
	@Autowired
	EmployeeService employeeService;

	Employee employee;

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView register() {
		return new ModelAndView("register");
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ModelAndView signup(@RequestParam("txtfname") String fname, @RequestParam("txtlname") String lname,
			@RequestParam("txtage") int age, @RequestParam("txtgender") String gender,
			@RequestParam("txtemail") String email, @RequestParam("txtaddress") String address,
			@RequestParam("txtpwd") String password, @RequestParam("txtrole") String role) {
		System.out.println(fname + lname + age + gender + email + address + password + role);

		employee = new Employee();
		employee.setFname(fname);
		employee.setLname(lname);
		employee.setAge(age);
		employee.setGender(gender);
		employee.setEmail(email);
		employee.setAddress(address);
		employee.setPassword(password);
		employee.setRole(role);
		System.out.println("passed " + employee.getFname() + "details to empservice.");
		return new ModelAndView("login");
	}

	public ModelAndView getEmployee(List<Employee> li) {

		ModelAndView mv = new ModelAndView("home");
		mv.addObject("emplist", li);
		return mv;
	}

	public ModelAndView allEmployee() {

		List<Employee> li = employeeService.getEmployeeList();
		ModelAndView mv = new ModelAndView("home");
		mv.addObject("emplist", li);
		return mv;
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public ModelAndView deleteEmployee(Employee emp) {
		List<Employee> li = employeeService.deleteEmployee(emp.getEid());
		ModelAndView mv = new ModelAndView("home");
		mv.addObject("msg", "Employee Deleted Successfully");
		mv.addObject("emplist", li);

		return mv;
	}

	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public ModelAndView editEmployee(@RequestParam("eid") int eid, @RequestParam("fname") String fname,
			@RequestParam("lname") String lname, @RequestParam("age") int age) {

		ModelAndView mv = new ModelAndView("employee-update");
		return mv;
	}

	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public ModelAndView updateEmployee(@RequestParam("txteid") int eid, @RequestParam("txtfname") String fname,
			@RequestParam("txtlname") String lname, @RequestParam("txtage") int age) {
		Employee emp = new Employee();
		emp.setEid(eid);
		emp.setFname(fname);
		emp.setLname(lname);
		emp.setAge(age);
		List<Employee> li = employeeService.updateEmployee(emp);
		ModelAndView mv = new ModelAndView("home");
		mv.addObject("msg", "Employee Updated Successfully");
		mv.addObject("emplist", li);
		return mv;
	}

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public List<Employee> getEmployeeListDetails() {
		List<Employee> empList = new ArrayList<Employee>();
		Employee employee = new Employee();
		Date tempdate = new Date(1403685556000L);
		employee.setEid(101);
		employee.setFname("alex");
		employee.setLname("a");
		employee.setAge(20);
		employee.setAddress("hyd");
		employee.setAvailableLeave(24);
		employee.setEmail("a@gmail.com");
		employee.setGender("male");
		employee.setPassword("alex");
		employee.setPhoneNumber(909090);
		employee.setRole("Employee");
		employee.setLoginTime(tempdate);

		empList.add(employee);
		return empList;
	}

}