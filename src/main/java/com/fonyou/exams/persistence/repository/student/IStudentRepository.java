package com.fonyou.exams.persistence.repository.student;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.fonyou.exams.persistence.model.student.StudentEntity;
import com.fonyou.exams.persistence.repository.projections.AssignProjection;
import com.fonyou.exams.persistence.repository.projections.StudentsProjection;

/**
 * 
 * @author Julian Velasquez
 *
 */
public interface IStudentRepository extends JpaRepository<StudentEntity, Long> {

	@Query(value = "SELECT tes.exm_id_student as idStudent, tes.exm_time_zone_student as timezone "
			+ "FROM tb_exm_student tes ", nativeQuery = true)
	Set<AssignProjection> findByStudents();

	@Query(value = "SELECT DISTINCT tes.exm_id_student as idStudent, "
			+ "tes.exm_name_student as name, tes.exm_city_student as city, "
			+ "teae.exm_exam_date as dateAssign, tee.exm_exam_topic as area, tee.exm_status as statusExam "
			+ "FROM tb_exm_assign_exam teae "
			+ "INNER JOIN tb_exm_student tes ON teae.exm_fk_id_student = tes.exm_id_student "
			+ "INNER JOIN tb_exm_exam tee ON tee.exm_id_exam = teae.exm_fk_id_exam "
			+ "INNER JOIN tb_exm_questions teq ON teq.exm_fk_id_exam = tee.exm_id_exam ", nativeQuery = true)
	List<StudentsProjection> findAllStudents();

	@Modifying
	@Query(value = "UPDATE tb_exm_student SET exm_qualification = :qualification "
			+ "WHERE exm_id_student = :idStudent ", nativeQuery = true)
	void updateQualification(@Param("qualification") Double qualification, @Param("idStudent") Long idStudent);
}
