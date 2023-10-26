package com.fonyou.exams.services.exams.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.fonyou.exams.exceptions.GlobalException;
import com.fonyou.exams.persistence.repository.exam.IAssignRepository;
import com.fonyou.exams.persistence.repository.exam.IExamRepository;
import com.fonyou.exams.persistence.repository.student.IStudentRepository;
import com.fonyou.exams.util.UtilMockStudent;
import com.fonyou.exams.util.messages.MessagesEnum;

/**
 * 
 * @author Julian Velasquez
 *
 */
@ExtendWith(MockitoExtension.class)
class AssignServiceImplTest {

	@Mock
	IStudentRepository studentRepository;

	@Mock
	IAssignRepository assignRepository;

	@Mock
	IExamRepository examRepository;

	@InjectMocks
	AssignServiceImpl assignImpl;

	@Test
	void createAssignExamSuccessTest() {
		
		when(studentRepository.findByStudents())
				.thenReturn(UtilMockStudent.buildSetAssignProjections());
		
		when(examRepository.existsById(anyLong())).thenReturn(true);
		
		when(assignRepository.saveAll(anyList()))
				.thenReturn(UtilMockStudent.buildListAssignExamEntities());
		
		var result = assignImpl.createAssignExam(LocalDateTime.now(), 1L);
		
		assertNotNull(result);
		assertEquals(result, MessagesEnum.ASSIGN_SUCCESS.getMessage());
	}

	@Test
	void createAssignFailTest() {

		when(examRepository.existsById(anyLong())).thenReturn(false);
		
		var date = LocalDateTime.now();
		
		var ex = assertThrows(GlobalException.class, () -> assignImpl.createAssignExam(date, 1L));
		
		assertEquals(ex.getMessage(), MessagesEnum.EXAM_NOT_FOUND.getMessage());
		verify(assignRepository, never()).saveAll(anyList());
	}
}
