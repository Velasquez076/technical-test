package com.fonyou.exams.persistence.dto.student;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @author Julian Velasquez
 *
 */
@Setter
@Getter
public class StudentDto {

	private Long idStudent;

	@JsonProperty(value = "name")
	private String nameStudent;

	@JsonProperty(value = "age")
	private String ageStudent;

	private String city;

	private String timeZone;

	@JsonInclude(value = Include.NON_NULL)
	private Double qualification;
}
