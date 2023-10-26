package com.fonyou.exams.util.mapper.exam;

import java.util.Objects;

import com.fonyou.exams.exceptions.GlobalException;
import com.fonyou.exams.persistence.dto.exam.QualificationDto;
import com.fonyou.exams.persistence.repository.projections.QualificationProjection;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * 
 * @author Julian Velasquez
 *
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class QualificationMapper {

	public static QualificationDto buildQualificationDto(QualificationProjection projection) {
		QualificationDto dto = new QualificationDto();
		dto.setArea(projection.getType());
		dto.setName(projection.getName());
		dto.setCity(projection.getCity());
		dto.setFirstAnswer(projection.getFirst());
		dto.setSecondAnswer(projection.getSecond());
		dto.setThirdAnswer(projection.getThird());
		dto.setQualification(validQualification(projection.getQualification()));
		return dto;
	}

	private static Double validQualification(String qualification) {
		if (Objects.isNull(qualification)) {
			throw new GlobalException(200, "Examen sin completar!");
		}
		return Double.parseDouble(qualification) / 10;
	}
}
