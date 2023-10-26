package com.fonyou.exams.services.exams.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.fonyou.exams.persistence.repository.exam.ICollectAnswerRepository;
import com.fonyou.exams.persistence.repository.exam.IExamRepository;
import com.fonyou.exams.persistence.repository.student.IStudentRepository;
import com.fonyou.exams.util.UtilMocksExam;

/**
 * 
 * @author Julian Velasquez
 *
 */
@ExtendWith(MockitoExtension.class)
class CollectAnswerServiceImplTest {

	@Mock
	ICollectAnswerRepository collectAnswerRepository;

	@Mock
	IStudentRepository studentRepository;

	@Mock
	IExamRepository examRepository;

	@InjectMocks
	CollectAnswerServiceImpl collectAnswerServiceImpl;

	@Test
	void getQualificationTest() {
		
		when(studentRepository.existsById(anyLong())).thenReturn(true);
		
		when(examRepository.existsById(anyLong())).thenReturn(true);
		
		when(collectAnswerRepository.getStudentAndQualification(anyLong(), anyLong()))
			.thenReturn(UtilMocksExam.buildQualificationProjection());
		
		var result = collectAnswerServiceImpl.getQualification(1L, 1L);
		
		assertNotNull(result);
		assertEquals("Tokyo", result.getCity());
		
	}
}
