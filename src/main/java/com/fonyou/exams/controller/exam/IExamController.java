package com.fonyou.exams.controller.exam;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.ResponseEntity;

import com.fonyou.exams.persistence.dto.exam.CollectAnswerDto;
import com.fonyou.exams.persistence.dto.exam.QualificationDto;
import com.fonyou.exams.persistence.dto.exam.QuestionDto;
import com.fonyou.exams.persistence.dto.request.RequestExam;
import com.fonyou.exams.persistence.dto.response.BuildResponse;

/**
 * 
 * @author Julian Velasquez
 *
 */
public interface IExamController {

	ResponseEntity<BuildResponse<List<QuestionDto>>> createExam(RequestExam requestExam);

	ResponseEntity<BuildResponse<String>> assignExam(LocalDateTime dateAssign, Long idExam);

	ResponseEntity<BuildResponse<CollectAnswerDto>> createAnswers(CollectAnswerDto answerDto);

	ResponseEntity<BuildResponse<QualificationDto>> getQualifications(Long idStudent, Long idExam);
}
