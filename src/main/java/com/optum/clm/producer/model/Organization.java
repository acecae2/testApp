package com.optum.clm.producer.model;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;

@Data

public class Organization {


	private Long id;

	private String organizationName;

	private String location;
	private LocalDateTime createDate;
	private LocalDateTime updateDate;


}
