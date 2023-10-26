package com.fonyou.exams.persistence.dto.request;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fonyou.exams.persistence.dto.exam.QuestionDto;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @author Julian Velasquez
 *
 */
@Setter
@Getter
public class RequestExam {

	@JsonProperty(value = "type")
	private String examTopic;

	private List<QuestionDto> questions;
}
