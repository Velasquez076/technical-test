package com.fonyou.exams.services.exams.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fonyou.exams.persistence.dto.exam.CollectAnswerDto;
import com.fonyou.exams.persistence.dto.exam.QualificationDto;
import com.fonyou.exams.persistence.repository.exam.ICollectAnswerRepository;
import com.fonyou.exams.persistence.repository.exam.IExamRepository;
import com.fonyou.exams.persistence.repository.exam.IQuestionRepository;
import com.fonyou.exams.persistence.repository.student.IStudentRepository;
import com.fonyou.exams.services.exams.ICollectAnswerService;
import com.fonyou.exams.util.mapper.exam.AnswersMapper;
import com.fonyou.exams.util.mapper.exam.QualificationMapper;
import com.fonyou.exams.util.messages.MessagesEnum;
import com.fonyou.exams.util.validate.ValidateAnswers;
import com.fonyou.exams.util.validate.ValidateFields;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @author Julian Velasquez
 *
 */
@Slf4j
@Service
@RequiredArgsConstructor
class CollectAnswerServiceImpl implements ICollectAnswerService {

	private final ICollectAnswerRepository collectAnswerRepository;

	private final IStudentRepository studentRepository;

	private final IQuestionRepository questionRepository;

	private final IExamRepository examRepository;

	@Override
	@Transactional
	public CollectAnswerDto saveAnswers(CollectAnswerDto answerDto) {

		log.info(".:: Se inicia consulta - guardar respuestas ::.");

		ValidateFields.validExist(studentRepository.existsById(answerDto.getIdSFkStudent()),
				MessagesEnum.STUDENT_NOT_FOUNT);

		var listAnswers = questionRepository.answuersExam(answerDto.getIdFkExam());

		ValidateFields.validExist(!listAnswers.isEmpty(), MessagesEnum.EXAM_ANOT_FOUND);

		var valid = ValidateAnswers.validateAnswers(answerDto, listAnswers);

		studentRepository.updateQualification(valid.getQualification(), answerDto.getIdSFkStudent());

		var result = collectAnswerRepository.save(AnswersMapper.dtoToEntity(valid));

		return AnswersMapper.entityToDto(result, valid.getQualification());
	}

	@Override
	public QualificationDto getQualification(Long idStudent, Long idExam) {

		log.info(".:: Se consultan las calificaciones de un estudiante ::.");

		var student = studentRepository.existsById(idStudent);

		ValidateFields.validExist(student, MessagesEnum.STUDENT_NOT_FOUNT);

		var exam = examRepository.existsById(idExam);

		ValidateFields.validExist(exam, MessagesEnum.EXAM_ANOT_FOUND);

		var result = collectAnswerRepository.getStudentAndQualification(idStudent, idExam);

		return QualificationMapper.buildQualificationDto(result);
	}
}
