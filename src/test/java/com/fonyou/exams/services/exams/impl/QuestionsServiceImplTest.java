package com.fonyou.exams.services.exams.impl;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.fonyou.exams.persistence.model.exam.ExamEntity;
import com.fonyou.exams.persistence.repository.exam.IExamRepository;
import com.fonyou.exams.persistence.repository.exam.IQuestionRepository;
import com.fonyou.exams.util.UtilMocksExam;

/**
 * 
 * @author Julian Velasquez
 *
 */
@ExtendWith(MockitoExtension.class)
class QuestionsServiceImplTest {

	@Mock
	IQuestionRepository questionRepository;

	@Mock
	IExamRepository examRepository;

	@InjectMocks
	QuestionsServiceImpl serviceImpl;

	@Test
	void saveExamTest() {
		
		when(examRepository.save(any(ExamEntity.class)))
				.thenReturn(UtilMocksExam.buildExamEntity());
		
		when(questionRepository.saveAll(anyList()))
				.thenReturn(UtilMocksExam.buildListQuestionEntities());
		
		var result = serviceImpl.saveExam(UtilMocksExam.buildRequestExam());
		
		assertFalse(result.isEmpty());
		verify(questionRepository).saveAll(anyList());
		verify(examRepository).save(any(ExamEntity.class));
	}
}
