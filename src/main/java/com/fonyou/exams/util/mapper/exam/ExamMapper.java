package com.fonyou.exams.util.mapper.exam;

import java.util.List;
import java.util.stream.Collectors;

import com.fonyou.exams.persistence.dto.exam.QuestionDto;
import com.fonyou.exams.persistence.model.exam.QuestionEntity;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * 
 * @author Julian Velasquez
 *
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ExamMapper {

	public static List<QuestionEntity> dtoToEntity(
			List<QuestionDto> questionsDto, Long idExam) {

		return questionsDto.stream()
				.map(exam -> new QuestionEntity(exam.getIdQuestions(),
						exam.getQuestionExam(), exam.getFirstOption(),
						exam.getSecondOption(), exam.getThirdOption(),
						exam.getFourthOption(), exam.getCorrectAnswer(),
						idExam))
				.collect(Collectors.toList());
	}

	public static List<QuestionDto> entityToDto(
			List<QuestionEntity> examEntity, Long idExam) {
		return examEntity.stream()
				.map(exam -> QuestionDto.builder()
						.idQuestions(exam.getIdQuestion())
						.questionExam(exam.getQuestionExam())
						.firstOption(exam.getFirstOption())
						.secondOption(exam.getSecondOption())
						.thirdOption(exam.getThirdOption())
						.fourthOption(exam.getFourthOption())
						.idExam(idExam)
						.build())
				.collect(Collectors.toList());
	}

}
