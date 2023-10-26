package com.fonyou.exams.controller.student.impl;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fonyou.exams.controller.student.IStudentController;
import com.fonyou.exams.controller.student.handler.StudentHandler;
import com.fonyou.exams.persistence.dto.response.BuildResponse;
import com.fonyou.exams.persistence.dto.student.StudentDto;
import com.fonyou.exams.persistence.repository.projections.StudentsProjection;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @author Julián D. Velásquez
 *
 */
@Slf4j
@RestController
@RequestMapping(path = "student")
@RequiredArgsConstructor
class StudentControllerImpl implements IStudentController {

	private final StudentHandler studentHandler;

	@Override
	@PostMapping(path = "create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<BuildResponse<StudentDto>> saveStudent(
			@RequestBody StudentDto studentDto) {
		log.info(".:: Se inicia el registro del estudiante ::.");
		return new ResponseEntity<>(studentHandler.createStudent(studentDto),
				HttpStatus.CREATED);
	}

	@Override
	@GetMapping(path = "all", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<BuildResponse<List<StudentsProjection>>> getAllStudents() {
		log.info(
				".:: Inicio consulta todos los estudiantes con examen asignado ::.");
		return new ResponseEntity<>(studentHandler.getAllStudents(),
				HttpStatus.OK);
	}

}
