package com.fonyou.exams.util.validate;

import java.util.List;

import com.fonyou.exams.persistence.dto.exam.CollectAnswerDto;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * 
 * @author juveme88
 *
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ValidateAnswers {

	private static final String INCORRECT = "Incorrect!";

	private static final String CORRECT = "Correct!";

	private static final String MIDDLE_DASH = "-";

	private static Double points = 0D;

	public static CollectAnswerDto validateAnswers(CollectAnswerDto answerDto, List<String> listAnswers) {

		for (int i = 0; i < 1; i++) {

			answerDto.setFirstAnswer(valid(listAnswers.get(i), answerDto.getFirstAnswer()));

			answerDto.setSecondAnswer(valid(listAnswers.get(1), answerDto.getSecondAnswer()));

			answerDto.setThirdAnswer(valid(listAnswers.get(2), answerDto.getThirdAnswer()));

			answerDto.setQualification(points);
		}
		return answerDto;
	}

	private static String valid(String answerDb, String answerStudent) {

		var result = "";

		if (answerDb.equalsIgnoreCase(answerStudent)) {
			result = String.join(MIDDLE_DASH, answerStudent, CORRECT);
			points += 33.3;
		} else {
			result = String.join(MIDDLE_DASH, answerStudent, INCORRECT);
		}
		return result;
	}
}
