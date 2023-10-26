package com.fonyou.exams.services.student.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fonyou.exams.persistence.dto.student.StudentDto;
import com.fonyou.exams.persistence.repository.projections.StudentsProjection;
import com.fonyou.exams.persistence.repository.student.IStudentRepository;
import com.fonyou.exams.services.student.IStudentService;
import com.fonyou.exams.util.mapper.student.StudentMapper;

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
class StudentServiceImpl implements IStudentService {

	private final IStudentRepository studentRepository;

	@Override
	@Transactional
	public StudentDto saveStudent(StudentDto studentDto) {

		var resp = studentRepository
				.save(StudentMapper.dtoToEntity(studentDto));

		return StudentMapper.entityToDto(resp);
	}

	@Override
	public List<StudentsProjection> findAllStudents() {
		log.info(
				".:: Consultando los estudiantes con su fecha asignada de examen ::.");
		return studentRepository.findAllStudents();
	}
}
