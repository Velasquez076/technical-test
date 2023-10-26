package com.fonyou.exams.persistence.model.student;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "TB_EXM_STUDENT", schema = "DB_EXAMS")
public class StudentEntity {

	@Id
	@Column(name = "EXM_ID_STUDENT")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idStudent;

	@Column(name = "EXM_NAME_STUDENT")
	private String nameStudent;

	@Column(name = "EXM_AGE_STUDENT")
	private String ageStudent;

	@Column(name = "EXM_CITY_STUDENT")
	private String city;

	@Column(name = "EXM_TIME_ZONE_STUDENT")
	private String timeZone;

	@Column(name = "EXM_QUALIFICATION")
	private Double qualification;
}
