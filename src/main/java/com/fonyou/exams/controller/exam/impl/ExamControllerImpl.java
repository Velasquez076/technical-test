package com.fonyou.exams.controller.exam.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fonyou.exams.controller.exam.IExamController;
import com.fonyou.exams.controller.exam.handler.ExamHandler;
import com.fonyou.exams.persistence.dto.exam.CollectAnswerDto;
import com.fonyou.exams.persistence.dto.exam.QualificationDto;
import com.fonyou.exams.persistence.dto.exam.QuestionDto;
import com.fonyou.exams.persistence.dto.request.RequestExam;
import com.fonyou.exams.persistence.dto.response.BuildResponse;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @author Julián D. Velásquez
 *
 */
@Slf4j
@RestController
@RequestMapping(path = "/exam")
@RequiredArgsConstructor
class ExamControllerImpl implements IExamController {

	private final ExamHandler handler;

	@Override
	@PostMapping(path = "create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<BuildResponse<List<QuestionDto>>> createExam(@RequestBody RequestExam requestExam) {
		log.info(".:: Se inicia la creación de un examen en db");
		return new ResponseEntity<>(handler.createExam(requestExam), HttpStatus.CREATED);
	}

	@Override
	@PostMapping(path = "assign", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<BuildResponse<String>> assignExam(
			@RequestParam(name = "dateAssign") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dateAssign,
			@RequestParam(name = "idExam") Long idExam) {

		log.info(".:: Se inicia la asignación de los examenes a los estudiantes ::.");
		return new ResponseEntity<>(handler.assignExam(dateAssign, idExam), HttpStatus.CREATED);
	}

	@Override
	@PostMapping(path = "answer", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<BuildResponse<CollectAnswerDto>> createAnswers(@RequestBody CollectAnswerDto answerDto) {
		log.info(".:: Se inicia la insercion y validacion de las respuestas ::.");
		return new ResponseEntity<>(handler.createAnswers(answerDto), HttpStatus.CREATED);
	}

	@Override
	@GetMapping(path = "qualifications/{idStudent}/{idExam}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<BuildResponse<QualificationDto>> getQualifications(@PathVariable Long idStudent,
			@PathVariable Long idExam) {
		log.info(".:: Se inicia la consulta de la calificacion del estudiante ::.");
		return new ResponseEntity<>(handler.qualifications(idStudent, idExam), HttpStatus.OK);
	}

}
