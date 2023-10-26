package com.fonyou.exams.controller.student.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

import com.fonyou.exams.controller.student.handler.StudentHandler;
import com.fonyou.exams.persistence.dto.student.StudentDto;
import com.fonyou.exams.util.UtilMockStudent;

/**
 * 
 * @author Julian Velasquez
 *
 */
@ExtendWith(MockitoExtension.class)
class StudentControllerImplTest {

	@Mock
	StudentHandler studentHandler;

	@InjectMocks
	StudentControllerImpl studentControllerImpl;

	@Test
	void saveStudentTest() {
		
		when(studentHandler.createStudent(any(StudentDto.class)))
				.thenReturn(UtilMockStudent.buildResponseStudentDto());
		
		var result = studentControllerImpl.saveStudent(UtilMockStudent.buildStudentDto());
				
		assertNotNull(result.getBody());
		assertEquals(HttpStatus.CREATED, result.getStatusCode());
	}

	@Test
	void getAllStudentsTest() {
		
		when(studentHandler.getAllStudents())
				.thenReturn(UtilMockStudent.buildResponsebuildListStudentProjection());
		
		var result = studentControllerImpl.getAllStudents();
		
		assertNotNull(result.getBody());
		assertEquals(HttpStatus.OK, result.getStatusCode());
	}
}
