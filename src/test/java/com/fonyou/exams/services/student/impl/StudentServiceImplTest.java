package com.fonyou.exams.services.student.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.fonyou.exams.persistence.model.student.StudentEntity;
import com.fonyou.exams.persistence.repository.student.IStudentRepository;
import com.fonyou.exams.util.UtilMockStudent;

/**
 * 
 * @author Julian Velasquez
 *
 */
@ExtendWith(MockitoExtension.class)
class StudentServiceImplTest {

	@Mock
	IStudentRepository studentRepository;
	
	@InjectMocks
	StudentServiceImpl studentServiceImpl;
	
	@Test
	void saveStudentTest() {
		
		when(studentRepository.save(any(StudentEntity.class)))
			.thenReturn(UtilMockStudent.buildStudentEntity());
		
		var result = studentServiceImpl.saveStudent(UtilMockStudent.buildStudentDto());
		
		assertNotNull(result);
		assertEquals("Tokyo", result.getCity());
	}
	
	@Test
	void findAllStudentsTest() {
		when(studentRepository.findAllStudents())
			.thenReturn(UtilMockStudent.buildListStudentProjection());
		
		var result = studentServiceImpl.findAllStudents();
		
		assertFalse(result.isEmpty());
		verify(studentRepository).findAllStudents();
	}
}
