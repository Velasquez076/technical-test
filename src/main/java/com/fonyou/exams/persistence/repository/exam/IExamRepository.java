package com.fonyou.exams.persistence.repository.exam;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fonyou.exams.persistence.model.exam.ExamEntity;

/**
 * 
 * @author Julian Velasquez
 *
 */
public interface IExamRepository extends JpaRepository<ExamEntity, Long> {

}
