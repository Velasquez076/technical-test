package com.fonyou.exams.services.exams;

import com.fonyou.exams.persistence.dto.exam.CollectAnswerDto;
import com.fonyou.exams.persistence.dto.exam.QualificationDto;

/**
 * 
 * @author Julian Velasquez
 *
 */
public interface ICollectAnswerService {

	CollectAnswerDto saveAnswers(CollectAnswerDto answerEntity);
	
	QualificationDto getQualification(Long idStudent, Long idExam);
}
