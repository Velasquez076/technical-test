package com.fonyou.exams.persistence.repository.exam;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.fonyou.exams.persistence.model.exam.QuestionEntity;

/**
 * 
 * @author Julián Velásquez
 *
 */
public interface IQuestionRepository extends JpaRepository<QuestionEntity, Long> {

	@Query(value = "SELECT teq.exm_correct_answer "
			+ "FROM tb_exm_questions teq WHERE teq.exm_fk_id_exam = :idExam", nativeQuery = true)
	List<String> answuersExam(@Param("idExam") Long idExam);
}
