package com.fonyou.exams.persistence.dto.exam;

import lombok.Data;

/**
 * 
 * @author Julian Velasquez
 *
 */
@Data
public class QualificationDto {

	private String area;

	private String name;

	private String city;

	private String firstAnswer;

	private String secondAnswer;

	private String thirdAnswer;

	private Double qualification;
}
