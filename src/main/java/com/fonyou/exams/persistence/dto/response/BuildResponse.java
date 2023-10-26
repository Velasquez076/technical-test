package com.fonyou.exams.persistence.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 
 * @author Julián Velásquez
 *
 * @param <T>
 */
@Getter
@AllArgsConstructor
public class BuildResponse<T> {

	private Integer statusCode;

	private String statusName;

	private String uuid;

	private String message;
	
	@JsonInclude(value = Include.NON_NULL)
	private Long idExam;

	@JsonInclude(value = Include.NON_NULL)
	private T response;
}
