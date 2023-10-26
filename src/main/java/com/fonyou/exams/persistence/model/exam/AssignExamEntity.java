package com.fonyou.exams.persistence.model.exam;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**
 * 
 * @author Julián Velásquez
 *
 */
@Data
@Entity
@Table(name = "TB_EXM_ASSIGN_EXAM", schema = "DB_EXAMS")
public class AssignExamEntity {

	@Id
	@Column(name = "EXM_ID_ASSIGN_EXAM")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idAssign;

	@Column(name = "EXM_EXAM_DATE")
	private LocalDateTime dateAssign;

	@Column(name = "EXM_FK_ID_STUDENT")
	private Long idStudent;

	@Column(name = "EXM_FK_ID_EXAM")
	private Long idFkExam;

	public AssignExamEntity(LocalDateTime dateAssign, Long idStudent,
			Long idFkExam) {
		this.dateAssign = dateAssign;
		this.idStudent = idStudent;
		this.idFkExam = idFkExam;
	}
}
