package com.fonyou.exams.persistence.dto.exam;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 
 * @author Julián Velásquez
 *
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class QuestionDto {

	private Long idQuestions;

	private String questionExam;

	private String firstOption;

	private String secondOption;

	private String thirdOption;

	private String fourthOption;

	@JsonInclude(value = Include.NON_NULL)
	private String correctAnswer;

	@JsonIgnore
	private Long idExam;
}
