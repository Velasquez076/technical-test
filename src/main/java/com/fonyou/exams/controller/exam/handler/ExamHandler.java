package com.fonyou.exams.controller.exam.handler;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.fonyou.exams.persistence.dto.exam.CollectAnswerDto;
import com.fonyou.exams.persistence.dto.exam.QualificationDto;
import com.fonyou.exams.persistence.dto.exam.QuestionDto;
import com.fonyou.exams.persistence.dto.request.RequestExam;
import com.fonyou.exams.persistence.dto.response.BuildResponse;
import com.fonyou.exams.services.exams.IAssignService;
import com.fonyou.exams.services.exams.ICollectAnswerService;
import com.fonyou.exams.services.exams.IQuestionsService;
import com.fonyou.exams.util.messages.MessagesEnum;
import com.fonyou.exams.util.validate.ValidateFields;

import lombok.RequiredArgsConstructor;

/**
 * 
 * @author Julián Velásquez
 *
 */
@Component
@RequiredArgsConstructor
public class ExamHandler {

	private final IQuestionsService examService;

	private final IAssignService assignService;

	private final ICollectAnswerService answerService;

	public BuildResponse<List<QuestionDto>> createExam(RequestExam requestExam) {

		ValidateFields.validNumberOfQuestions(requestExam.getQuestions());

		ValidateFields.validRequestExam(requestExam);

		var result = examService.saveExam(requestExam);

		var status = HttpStatus.CREATED;

		return new BuildResponse<>(status.value(), status.name(), UUID.randomUUID().toString(),
				MessagesEnum.CREATED_SUCCESS.getMessage(), result.get(0).getIdExam(), result);
	}

	public BuildResponse<String> assignExam(LocalDateTime dateAssign, Long idExam) {
		var status = HttpStatus.CREATED;
		return new BuildResponse<>(status.value(), status.name(), UUID.randomUUID().toString(),
				assignService.createAssignExam(dateAssign, idExam), null, null);
	}

	public BuildResponse<CollectAnswerDto> createAnswers(CollectAnswerDto answerDto) {

		ValidateFields.validAnswers(answerDto);

		var status = HttpStatus.CREATED;

		return new BuildResponse<>(status.value(), status.name(), UUID.randomUUID().toString(),
				MessagesEnum.RESPONSE_SUCCESS.getMessage(), null, answerService.saveAnswers(answerDto));
	}

	public BuildResponse<QualificationDto> qualifications(Long idStudent, Long idExam) {

		var status = HttpStatus.OK;

		return new BuildResponse<>(status.value(), status.name(), UUID.randomUUID().toString(),
				MessagesEnum.SUCCESS.getMessage(), null, answerService.getQualification(idStudent, idExam));
	}
}
