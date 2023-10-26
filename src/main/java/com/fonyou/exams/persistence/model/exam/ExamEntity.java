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
 * @author juveme88
 *
 */
@Data
@Entity
@Table(name = "tb_exm_exam", schema = "db_exams")
public class ExamEntity {

	@Id
	@Column(name = "exm_id_exam")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idExam;

	@Column(name = "exm_exam_topic")
	private String examTopic;

	@Column(name = "exm_status")
	private String status;

	public ExamEntity(String examTopic, String status) {
		this.examTopic = examTopic;
		this.status = status;
	}
}
