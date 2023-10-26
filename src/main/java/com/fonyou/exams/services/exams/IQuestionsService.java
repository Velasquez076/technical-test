package com.fonyou.exams.services.exams;

import java.util.List;

import com.fonyou.exams.persistence.dto.exam.QuestionDto;
import com.fonyou.exams.persistence.dto.request.RequestExam;

/**
 * 
 * @author Julián Velásquez
 *
 */
public interface IQuestionsService {

	List<QuestionDto> saveExam(RequestExam requestExam);
}
