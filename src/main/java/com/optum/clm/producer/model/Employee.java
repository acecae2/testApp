package com.optum.clm.producer.model;


//import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;

@Data
public class Employee {

	private Long id;
	private String firstname;
	private String lastname;
	private String title;
	private String location;

	//@JsonManagedReference
	private Organization organization;
}