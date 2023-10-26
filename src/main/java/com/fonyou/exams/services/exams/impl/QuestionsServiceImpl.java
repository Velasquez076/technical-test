package com.fonyou.exams.services.exams.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fonyou.exams.persistence.dto.exam.QuestionDto;
import com.fonyou.exams.persistence.dto.request.RequestExam;
import com.fonyou.exams.persistence.model.exam.ExamEntity;
import com.fonyou.exams.persistence.repository.exam.IExamRepository;
import com.fonyou.exams.persistence.repository.exam.IQuestionRepository;
import com.fonyou.exams.services.exams.IQuestionsService;
import com.fonyou.exams.util.mapper.exam.ExamMapper;
import com.fonyou.exams.util.messages.ExamStatusEnum;

import lombok.RequiredArgsConstructor;

/**
 * 
 * @author Julián Velásquez
 *
 */
@Service
@RequiredArgsConstructor
class QuestionsServiceImpl implements IQuestionsService {

	private final IQuestionRepository questionRepository;

	private final IExamRepository examRepository;

	@Override
	@Transactional
	public List<QuestionDto> saveExam(RequestExam requestExam) {

		var exam = examRepository.save(new ExamEntity(
				requestExam.getExamTopic(), ExamStatusEnum.ACTIVE.name()));

		return ExamMapper.entityToDto(
				questionRepository.saveAll(ExamMapper.dtoToEntity(
						requestExam.getQuestions(), exam.getIdExam())),
				exam.getIdExam());
	}
}
