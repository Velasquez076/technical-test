package com.fonyou.exams.persistence.model.exam;

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
@Table(name = "tb_exm_collect_answers", schema = "db_exams")
public class CollectAnswerEntity {

	@Id
	@Column(name = "exm_id_collect_answers")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCollect;

	@Column(name = "exm_first_answer_exam")
	private String firstAnswer;

	@Column(name = "exm_second_answer_exam")
	private String secondAnswer;

	@Column(name = "exm_third_answer_exam")
	private String thirdAnswer;

	@Column(name = "exm_fk_id_exam")
	private Long idFkExam;
	
	@Column(name = "exm_fk_id_student")
	private Long idFkStudent;
}
