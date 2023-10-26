package com.fonyou.exams.persistence.model.exam;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author Julián D. Velasquez
 */
@Data
@Entity
@AllArgsConstructor
@Table(name = "tb_exm_questions", schema = "db_exams")
public class QuestionEntity {

	@Id
	@Column(name = "exm_id_question")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idQuestion;

	@Column(name = "exm_question_exam")
	private String questionExam;

	@Column(name = "exm_first_option")
	private String firstOption;

	@Column(name = "exm_second_option")
	private String secondOption;

	@Column(name = "exm_third_option")
	private String thirdOption;

	@Column(name = "exm_fourth_option")
	private String fourthOption;

	@Column(name = "exm_correct_answer")
	private String correctAnswer;
	
	@Column(name = "exm_fk_id_exam")
	private Long idFkExam;
}
