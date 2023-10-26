package com.fonyou.exams.persistence.repository.exam;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.fonyou.exams.persistence.model.exam.CollectAnswerEntity;
import com.fonyou.exams.persistence.repository.projections.QualificationProjection;

/**
 * 
 * @author Julian Velasquez
 *
 */
public interface ICollectAnswerRepository extends JpaRepository<CollectAnswerEntity, Long> {

	@Query(value = "SELECT teq.exm_correct_answer FROM tb_exm_questions teq "
			+ "INNER JOIN tb_exm_collect_answers teca ON teq.exm_fk_id_exam = :idExam ", nativeQuery = true)
	List<String> answuersExam(@Param("idExam") Long idExam);

	@Query(value = "SELECT tee.exm_exam_topic as type, "
			+ "tes.exm_name_student as name, tes.exm_city_student as city, " + "teca.exm_first_answer_exam as first, "
			+ "teca.exm_second_answer_exam as second, " + "teca.exm_third_answer_exam as third, "
			+ "tes.exm_qualification as qualification "
			+ "FROM tb_exm_collect_answers teca INNER JOIN tb_exm_student tes ON "
			+ "tes.exm_id_student = :idStudent INNER JOIN tb_exm_exam tee ON "
			+ "tee.exm_id_exam = :idExam ", nativeQuery = true)
	QualificationProjection getStudentAndQualification(@Param("idStudent") Long idStudent,
			@Param("idExam") Long idExam);
}
