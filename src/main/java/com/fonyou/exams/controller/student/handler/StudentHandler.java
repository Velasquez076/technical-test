package com.fonyou.exams.controller.student.handler;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.fonyou.exams.persistence.dto.response.BuildResponse;
import com.fonyou.exams.persistence.dto.student.StudentDto;
import com.fonyou.exams.persistence.repository.projections.StudentsProjection;
import com.fonyou.exams.services.student.IStudentService;
import com.fonyou.exams.util.messages.MessagesEnum;
import com.fonyou.exams.util.validate.ValidateFields;

import lombok.RequiredArgsConstructor;

/**
 * 
 * @author Julian Velasquez
 *
 */
@Component
@RequiredArgsConstructor
public class StudentHandler {

	private final IStudentService studentService;

	public BuildResponse<StudentDto> createStudent(StudentDto studentDto) {

		ValidateFields.validRequestStudent(studentDto);

		var status = HttpStatus.CREATED;

		return new BuildResponse<>(status.value(), status.name(), UUID.randomUUID().toString(),
				MessagesEnum.STUDENT_CREATED.getMessage(), null, studentService.saveStudent(studentDto));
	}

	public BuildResponse<List<StudentsProjection>> getAllStudents() {

		var status = HttpStatus.OK;

		return new BuildResponse<>(status.value(), status.name(), UUID.randomUUID().toString(),
				MessagesEnum.SUCCESS.getMessage(), null, studentService.findAllStudents());
	}
}
