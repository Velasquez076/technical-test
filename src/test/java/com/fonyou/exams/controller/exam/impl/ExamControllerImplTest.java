package com.fonyou.exams.controller.exam.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
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

import com.fonyou.exams.controller.exam.handler.ExamHandler;
import com.fonyou.exams.persistence.dto.exam.CollectAnswerDto;
import com.fonyou.exams.persistence.dto.request.RequestExam;
import com.fonyou.exams.util.UtilMocksExam;

/**
 * 
 * @author Julian Velasquez
 *
 */
@ExtendWith(MockitoExtension.class)
class ExamControllerImplTest {

	@Mock
	ExamHandler handler;

	@InjectMocks
	ExamControllerImpl examControllerImpl;

	@Test
	void createExamTest() {
		
		when(handler.createExam(any(RequestExam.class)))
				.thenReturn(UtilMocksExam.buildResponseListQuestion());	
		
		var result = examControllerImpl.createExam(UtilMocksExam.buildRequestExam());
		
		assertEquals(HttpStatus.CREATED, result.getStatusCode());
		assertNotNull(result.getBody());
		verify(handler, times(1)).createExam(any(RequestExam.class));
		
	}

	@Test
	void assignExamTest() {
		
		when(handler.assignExam(any(LocalDateTime.class), anyLong()))
				.thenReturn(UtilMocksExam.buildResponseAssign());
		
		var result = examControllerImpl.assignExam(LocalDateTime.now(), 1L);
		
		assertEquals(HttpStatus.CREATED, result.getStatusCode());
		assertNotNull(result.getBody());
		verify(handler, times(1)).assignExam(any(LocalDateTime.class), anyLong());
	}

	@Test
	void createAnswersTest() {
		
		when(handler.createAnswers(any(CollectAnswerDto.class)))
				.thenReturn(UtilMocksExam.buildResponseAnswers());
		
		var result = examControllerImpl.createAnswers(UtilMocksExam.buildCollectAnswerDto());
		
		assertEquals(HttpStatus.CREATED, result.getStatusCode());
		assertNotNull(result.getBody());
		verify(handler, times(1)).createAnswers(any(CollectAnswerDto.class));
		
	}

	@Test
	void getQualificationsTest() {
		
		when(handler.qualifications(anyLong(), anyLong()))
			.thenReturn(UtilMocksExam.buildResponseQualificationDto());
		
		var result = examControllerImpl.getQualifications(1L, 1L);
		
		assertNotNull(result.getBody());
		assertEquals(HttpStatus.OK, result.getStatusCode());
	}
}
