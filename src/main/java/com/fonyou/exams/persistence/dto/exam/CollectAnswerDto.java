package com.fonyou.exams.persistence.dto.exam;

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
public class CollectAnswerDto {

	private String firstAnswer;

	private String secondAnswer;

	private String thirdAnswer;

	@JsonProperty(value = "idExam")
	private Long idFkExam;
	
	@JsonProperty(value = "idStudent")
	private Long idSFkStudent;
	
	private Double qualification;
}
