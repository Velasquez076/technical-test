package com.fonyou.exams.services.student;

import java.util.List;

import com.fonyou.exams.persistence.dto.student.StudentDto;
import com.fonyou.exams.persistence.repository.projections.StudentsProjection;

/**
 * 
 * @author Julian Velasquez
 *
 */
public interface IStudentService {

	StudentDto saveStudent(StudentDto studentDto);
	
	List<StudentsProjection> findAllStudents();
}
