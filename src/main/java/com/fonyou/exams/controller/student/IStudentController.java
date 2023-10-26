package com.fonyou.exams.controller.student;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.fonyou.exams.persistence.dto.response.BuildResponse;
import com.fonyou.exams.persistence.dto.student.StudentDto;
import com.fonyou.exams.persistence.repository.projections.StudentsProjection;

/**
 * 
 * @author Julian Velasquez
 *
 */
public interface IStudentController {

	ResponseEntity<BuildResponse<StudentDto>> saveStudent(
			StudentDto studentDto);
	
	ResponseEntity<BuildResponse<List<StudentsProjection>>> getAllStudents();
}
