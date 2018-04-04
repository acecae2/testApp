package com.optum.clm.producer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.optum.clm.producer.model.Employee;
import com.optum.clm.producer.service.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void createEmployee(@RequestBody Employee employee) {
		employeeService.saveEmployeeToKafka(employee);
	}

}
