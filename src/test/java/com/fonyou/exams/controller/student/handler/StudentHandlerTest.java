package com.fonyou.exams.controller.student.handler;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.fonyou.exams.exceptions.GlobalException;
import com.fonyou.exams.persistence.dto.student.StudentDto;
import com.fonyou.exams.services.student.IStudentService;
import com.fonyou.exams.util.UtilMockStudent;
import com.fonyou.exams.util.messages.MessagesEnum;

/**
 * 
 * @author Julian Velasquez
 *
 */
@ExtendWith(MockitoExtension.class)
class StudentHandlerTest {

	@Mock
	IStudentService studentService;

	@InjectMocks
	StudentHandler studentHandler;

	@Test
	void createStudentSuccessTest() {
		
		when(studentService.saveStudent(any(StudentDto.class)))
				.thenReturn(UtilMockStudent.buildStudentDto());
		
		var result = studentHandler.createStudent(UtilMockStudent.buildStudentDto());
		
		assertNotNull(result.getResponse().getTimeZone());
		verify(studentService, times(1)).saveStudent(any(StudentDto.class));
	}

	@Test
	void createStudentFailTest() {

		var request = UtilMockStudent.buildStudentDto();
		request.setNameStudent(null);

		var ex = assertThrows(GlobalException.class, () -> studentHandler.createStudent(request));

		assertEquals(ex.getMessage(), String.format(MessagesEnum.FIELD_NOT_NULL.getMessage(), "name"));
		verify(studentService, never()).saveStudent(any(StudentDto.class));
	}

	@Test
	void getAllStudentsTest() {
		
		when(studentService.findAllStudents())
				.thenReturn(UtilMockStudent.buildListStudentProjection());
		
		var result = studentHandler.getAllStudents();
		
		assertNotNull(result.getStatusCode());
		assertFalse(result.getResponse().isEmpty());
		assertEquals("Tokyo", result.getResponse().get(0).getCity());
		
		verify(studentService, times(1)).findAllStudents();
	}
}
