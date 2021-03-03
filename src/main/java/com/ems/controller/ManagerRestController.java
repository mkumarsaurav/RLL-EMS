package com.ems.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ems.entity.Leave;
import com.ems.service.ManagerService;

@RestController()
public class ManagerRestController {

	@Autowired
	ManagerService managerService;
	Leave leave;

	@GetMapping("/getApprovedLeaves")
	private ResponseEntity<List<Leave>> approvedLeave() {

		List<Leave> li = managerService.totalLeaveApproved(leave);
		if (li.isEmpty()) {
			return new ResponseEntity<List<Leave>>(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<List<Leave>>(li, HttpStatus.OK);
	}

	@GetMapping("/getRejectedLeaves")
	private ResponseEntity<List<Leave>> rejectedLeave() {

		List<Leave> li = managerService.totalLeaveRejected(leave);
		if (li.isEmpty()) {
			return new ResponseEntity<List<Leave>>(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<List<Leave>>(li, HttpStatus.OK);
	}

}