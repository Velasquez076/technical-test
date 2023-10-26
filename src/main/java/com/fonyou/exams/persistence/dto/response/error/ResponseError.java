package com.fonyou.exams.persistence.dto.response.error;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 
 * @author Julian Velasquez
 *
 */
@Getter
@AllArgsConstructor
public class ResponseError {

	private HttpStatus status;
	
	private String message;
}
