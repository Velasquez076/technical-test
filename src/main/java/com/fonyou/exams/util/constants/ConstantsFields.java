package com.fonyou.exams.util.constants;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * 
 * @author Julian Velasquez
 *
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ConstantsFields {

	// nombre de los campos del request a crear examen

	public static final String TYPE = "type";

	public static final String QUESTION_EXAM = "questionExam";

	public static final String FIRST = "firstOption";

	public static final String SECOND = "secondOption";

	public static final String THIRD = "thirdOption";

	public static final String FOURTH = "fourthOption";

	public static final String CORRECT_ANSWER = "correctAnswer";

	// nombre de los campos del request a crear estudiante

	public static final String NAME = "name";

	public static final String AGE = "age";

	public static final String CITY = "city";

	public static final String TIME_ZONE = "timezone";
	
	public static final String TIME_ZONE_CO = "America/Bogota";
	
	// nombre de los campos de las respuestas
	public static final String FIRST_AN = "firstAnswer";
	
	public static final String SECOND_AN = "secondAnswer";
	
	public static final String THIRD_AN = "thirdAnswer";
	
	public static final String ID_EXAM = "idExam";
	
	public static final String ID_STUDENT = "idStudent";
}
