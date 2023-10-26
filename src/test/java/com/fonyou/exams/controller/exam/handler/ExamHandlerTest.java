package com.fonyou.exams.controller.exam.handler;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

import com.fonyou.exams.exceptions.GlobalException;
import com.fonyou.exams.persistence.dto.exam.CollectAnswerDto;
import com.fonyou.exams.persistence.dto.request.RequestExam;
import com.fonyou.exams.services.exams.IAssignService;
import com.fonyou.exams.services.exams.ICollectAnswerService;
import com.fonyou.exams.services.exams.IQuestionsService;
import com.fonyou.exams.util.UtilMocksExam;
import com.fonyou.exams.util.messages.MessagesEnum;

/**
 * 
 * @author Julian Velasquez
 *
 */
@ExtendWith(MockitoExtension.class)
class ExamHandlerTest {

	@Mock
	IQuestionsService examService;

	@Mock
	IAssignService assignService;

	@Mock
	ICollectAnswerService answerService;

	@InjectMocks
	ExamHandler examHandler;

	@Test
	void createExamSuccessTest() {
		
		when(examService.saveExam(any(RequestExam.class)))
				.thenReturn(UtilMocksExam.buildListQuestionDtos());
		
		var result = examHandler.createExam(UtilMocksExam.buildRequestExam());
		
		assertFalse(result.getResponse().isEmpty());
		assertNotNull(result.getStatusCode());
		verify(examService, times(1)).saveExam(any(RequestExam.class));
	}

	@Test
	void createExamFailTest() {

		var req = UtilMocksExam.buildRequestExam();

		var lstQ = req.getQuestions();
		lstQ.remove(2);

		var ex = assertThrows(GlobalException.class, () -> examHandler.createExam(req));

		assertEquals(HttpStatus.BAD_REQUEST.value(), ex.getCode());
		verify(examService, never()).saveExam(any(RequestExam.class));
	}

	@Test
	void assignExamSuccessTest() {
		
		when(assignService.createAssignExam(any(LocalDateTime.class), anyLong()))
				.thenReturn(UtilMocksExam.GENERIC_MESSAGE);
		
		var result = examHandler.assignExam(LocalDateTime.now(), 1L);
		
		assertNotNull(result.getMessage());
		verify(assignService, times(1)).createAssignExam(any(LocalDateTime.class), anyLong());
	}

	@Test
	void createAnswersSuccessTest() {
		
		when(answerService.saveAnswers(any(CollectAnswerDto.class)))
				.thenReturn(UtilMocksExam.buildCollectAnswerDto());
		
		var result = examHandler.createAnswers(UtilMocksExam.buildCollectAnswerDto());
		
		assertNotNull(result.getResponse());
		verify(answerService, times(1)).saveAnswers(any(CollectAnswerDto.class));
	}

	@Test
	void createAnswersFailTest() {

		var req = UtilMocksExam.buildCollectAnswerDto();
		req.setIdFkExam(null);

		var ex = assertThrows(GlobalException.class, () -> examHandler.createAnswers(req));

		assertEquals(String.format(MessagesEnum.FIELD_NOT_NULL.getMessage(), "idExam"), ex.getMessage());
		verify(answerService, never()).saveAnswers(any(CollectAnswerDto.class));
	}

	@Test
	void qualificationsTest() {
		
		when(answerService.getQualification(anyLong(), anyLong()))
			.thenReturn(UtilMocksExam.buildQualificationDto());
		
		var result = examHandler.qualifications(1L, 1L);
		
		assertNotNull(result.getResponse());
		assertEquals("ingles",result.getResponse().getArea());
	}
}
