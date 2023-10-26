package com.fonyou.exams.persistence.repository.projections;

/**
 * 
 * @author Julian Velasquez
 *
 */
public interface StudentsProjection {

	Long getIdStudent();

	String getName();

	String getCity();

	String getDateAssign();

	String getArea();

	String getStatusExam();
}
