package com.fonyou.exams.util.mapper.exam;

import com.fonyou.exams.persistence.dto.exam.CollectAnswerDto;
import com.fonyou.exams.persistence.model.exam.CollectAnswerEntity;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * 
 * @author Julian velasquez
 *
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class AnswersMapper {

	public static CollectAnswerEntity dtoToEntity(CollectAnswerDto answerDto) {
		CollectAnswerEntity model = new CollectAnswerEntity();
		model.setFirstAnswer(answerDto.getFirstAnswer());
		model.setSecondAnswer(answerDto.getSecondAnswer());
		model.setThirdAnswer(answerDto.getThirdAnswer());
		model.setIdFkExam(answerDto.getIdFkExam());
		model.setIdFkStudent(answerDto.getIdSFkStudent());
		return model;
	}

	public static CollectAnswerDto entityToDto(CollectAnswerEntity model, Double points) {
		CollectAnswerDto answerDto = new CollectAnswerDto();
		answerDto.setFirstAnswer(model.getFirstAnswer());
		answerDto.setSecondAnswer(model.getSecondAnswer());
		answerDto.setThirdAnswer(model.getThirdAnswer());
		answerDto.setIdFkExam(model.getIdFkExam());
		answerDto.setIdSFkStudent(model.getIdFkStudent());
		answerDto.setQualification(points);
		return answerDto;
	}
}
