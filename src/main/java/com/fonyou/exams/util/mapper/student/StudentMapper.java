package com.fonyou.exams.util.mapper.student;

import com.fonyou.exams.persistence.dto.student.StudentDto;
import com.fonyou.exams.persistence.model.student.StudentEntity;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * 
 * @author Julian Velasquez
 *
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class StudentMapper {

	public static StudentEntity dtoToEntity(StudentDto studentDto) {
		StudentEntity model = new StudentEntity();
		model.setIdStudent(studentDto.getIdStudent());
		model.setNameStudent(studentDto.getNameStudent());
		model.setAgeStudent(studentDto.getAgeStudent());
		model.setCity(studentDto.getCity());
		model.setTimeZone(studentDto.getTimeZone());
		model.setQualification(studentDto.getQualification());
		return model;
	}

	public static StudentDto entityToDto(StudentEntity model) {
		StudentDto studentDto = new StudentDto();
		studentDto.setIdStudent(model.getIdStudent());
		studentDto.setNameStudent(model.getNameStudent());
		studentDto.setAgeStudent(model.getAgeStudent());
		studentDto.setCity(model.getCity());
		studentDto.setTimeZone(model.getTimeZone());
		studentDto.setQualification(model.getQualification());
		return studentDto;
	}
}
