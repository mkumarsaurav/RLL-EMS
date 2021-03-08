package com.ems.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import static org.mockito.Mockito.when;
import com.ems.controller.EmployeeController;
import com.ems.dao.EmployeeDaoImplementation;
import com.ems.dao.LeaveDaoImplementation;
import com.ems.dao.ManagerDaoImplementation;
import com.ems.entity.Employee;
import com.ems.entity.Leave;

public class TestCases {
	@Autowired
	EmployeeController employeeController = new EmployeeController();

	Date tempdate = new Date(1403685556000L);

	@Mock
	EmployeeDaoImplementation employeeDaoImplementation;
	Employee employee = new Employee();
	List<Employee> elist = new ArrayList<Employee>();
	@Mock
	LeaveDaoImplementation leaveDaoImplementation;
	Leave leave = new Leave();
	List<Leave> leavelist = new ArrayList<Leave>();

	ManagerDaoImplementation managerDaoImplementation;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {

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

		elist.add(employee);

		leave.setEid(101);
		leave.setLeaveComment("feaver");
		leave.setLeaveId(1);
		leave.setLeaveStatus("applyed");
		leave.setLeaveType("sick");
		leavelist.add(leave);
	}

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testForFirstName() {
		System.out.println("Testing for getters and setters");
		Employee employee = new Employee();
		employee.setFname("ALEX");
		assertTrue(employee.getFname() == "ALEX");
	}

	@Test
	public void testForAge() {
		System.out.println("Testing for getters and setters");
		Employee employee = new Employee();
		employee.setAge(33);
		assertTrue(employee.getAge() == 33);
	}


	@Test
	public void testEmployeeDetails() {
		System.out.println("Testing to get Employee Details");
		assertEquals(101, employee.getEid());
		List<Employee> list = employeeController.getEmployeeListDetails();
		assertEquals(elist.get(0).getFname(), list.get(0).getFname());
	}

	@Test
	public void getEmployeeByIdTest() {
		System.out.println("Testing to get Employee by their id");
		when(employeeDaoImplementation.getEmployeeById(100)).thenReturn(new Employee(100, "zayn", "a", 30, "male",
				"zayn@gmail.com", "zayn", "chi", "Manager", 24, 909090, tempdate));

		Employee emp = employeeDaoImplementation.getEmployeeById(100);

		assertEquals("zayn", emp.getFname());
		assertEquals("a", emp.getLname());
		assertEquals("zayn@gmail.com", emp.getEmail());
	}

	@Test
	public void testDeleteEmployee() {
		System.out.println("Testing for Delete Employee");
		when(employeeDaoImplementation.deleteEmployee(101)).thenReturn(null);
		List<Employee> emp = employeeDaoImplementation.deleteEmployee(101);
		assertNull(emp);

	}

	@Test
	public void testCancleLeave() {
		System.out.println("Testing for Cancle Leave");
		when(leaveDaoImplementation.cancelLeave(1)).thenReturn(null);
		List<Leave> leav = leaveDaoImplementation.cancelLeave(1);
		assertNull(leav);
	}

	@Test
	public void getAllEmployeesTest() {
		System.out.println("Testing to get All Employees");
		List<Employee> list = new ArrayList<Employee>();
		Employee empOne = new Employee(100, "zayn", "a", 30, "male", "zayn@gmail.com", "zayn", "chi", "Manager", 24,
				909090, null);

		Employee empTwo = new Employee(101, "alex", "a", 20, "male", "a@gmail.com", "alex", "hyd", "Employee", 24,
				909090, null);

		list.add(empOne);
		list.add(empTwo);

		when(employeeDaoImplementation.getEmployeeList()).thenReturn(list);

		List<Employee> empList = employeeDaoImplementation.getEmployeeList();
		assertEquals(2, empList.size());
		assertEquals(empList.get(0).getFname(), list.get(0).getFname());
		assertEquals(empList.toString(), list.toString());
	}

	@Test
	public void getAllLeaveTest() {
		System.out.println("Testing to get All Leves");
		List<Leave> list = new ArrayList<Leave>();
		Leave leave1 = new Leave(1, "sick", "app", "feaver", null, null, "No", 101);
		Leave leave2 = new Leave(2, "pl", "app", "personal", null, null, "No", 102);

		list.add(leave1);
		list.add(leave2);

		when(leaveDaoImplementation.getLeave()).thenReturn(list);

		List<Leave> leaveList = leaveDaoImplementation.getLeave();

		assertEquals(2, leaveList.size());
		assertEquals(leaveList.get(0).getLeaveType(), list.get(0).getLeaveType());
		assertEquals(leaveList.toString(), list.toString());
	}

}