package com.fonyou.exams.persistence.repository.exam;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fonyou.exams.persistence.model.exam.AssignExamEntity;

/**
 * 
 * @author Julian Velasquez
 *
 */
public interface IAssignRepository extends JpaRepository<AssignExamEntity, Long> {

}
