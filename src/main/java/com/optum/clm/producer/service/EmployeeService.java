package com.optum.clm.producer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.optum.clm.producer.model.Employee;
import com.optum.clm.producer.model.Organization;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class EmployeeService {

	@Autowired
	private KafkaTemplate<String, String> template;

	@Async
	public void saveEmployeeToKafka(Employee employee) {

		log.info("Employee successfully saved: {}", employee);

		template.send("employee", "Employee Created id:" + employee.getId());
		System.out.println("sent "+ employee.getId() + " to kafka" );
	}



	@Async
	public Organization hire(Organization organization, Employee employee) {

		employee.setOrganization(organization);

		template.send("employee", "Employee hired, id: " + employee.getId());

		return organization;
	}

	@Async
	public Organization fire(Organization organization, Employee employee) {

		employee.setOrganization(null);

		template.send("employee", "Employee fired, id: " + employee.getId());

		return organization;
	}
}
