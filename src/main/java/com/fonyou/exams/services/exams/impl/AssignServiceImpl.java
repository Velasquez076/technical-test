package com.fonyou.exams.services.exams.impl;

import static com.fonyou.exams.util.constants.ConstantsFields.TIME_ZONE_CO;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.AbstractMap.SimpleEntry;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.fonyou.exams.persistence.model.exam.AssignExamEntity;
import com.fonyou.exams.persistence.repository.exam.IAssignRepository;
import com.fonyou.exams.persistence.repository.exam.IExamRepository;
import com.fonyou.exams.persistence.repository.projections.AssignProjection;
import com.fonyou.exams.persistence.repository.student.IStudentRepository;
import com.fonyou.exams.services.exams.IAssignService;
import com.fonyou.exams.util.messages.MessagesEnum;
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
class AssignServiceImpl implements IAssignService {

	private final IStudentRepository studentRepository;

	private final IAssignRepository assignRepository;

	private final IExamRepository examRepository;

	@Override
	public String createAssignExam(LocalDateTime dateAssign, Long idExam) {

		var students = studentRepository.findByStudents();

		var result = buildTimeZoneConversion(students, dateAssign);

		ValidateFields.validExistExam(examRepository.existsById(idExam));

		assignRepository.saveAll(buildAssignEntity(result, idExam));

		return MessagesEnum.ASSIGN_SUCCESS.getMessage();
	}

	/*
	 * 
	 */
	private List<SimpleEntry<Long, LocalDateTime>> buildTimeZoneConversion(
			Set<AssignProjection> students, LocalDateTime dateAssign) {

		return students.stream()
				.map(student -> new SimpleEntry<Long, LocalDateTime>(
						student.getIdStudent(),
						studentTimeZone(dateAssign, student.getTimezone())))
				.collect(Collectors.toList());
	}

	/*
	 * 
	 */
	private LocalDateTime studentTimeZone(LocalDateTime dateAssig,
			String timezone) {

		if (timezone.equals(TIME_ZONE_CO)) {
			return dateAssig;
		}

		var timezoneAssign = ZoneId.of(timezone);

		var dateFormatter = ZonedDateTime
				.of(dateAssig, ZoneId.of(ZoneOffset.UTC.toString()))
				.withZoneSameInstant(timezoneAssign);

		log.info("Hora ajustada al timezone: {}", dateFormatter);

		return dateFormatter.toLocalDateTime();
	}

	/*
	 * 
	 */
	private List<AssignExamEntity> buildAssignEntity(
			List<SimpleEntry<Long, LocalDateTime>> lstData, Long idExam) {

		return lstData.stream()
				.map(data -> new AssignExamEntity(data.getValue(),
						data.getKey(), idExam))
				.collect(Collectors.toList());
	}
}
