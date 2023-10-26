package com.fonyou.exams.util.validate;

import static com.fonyou.exams.util.constants.ConstantsFields.AGE;
import static com.fonyou.exams.util.constants.ConstantsFields.CITY;
import static com.fonyou.exams.util.constants.ConstantsFields.CORRECT_ANSWER;
import static com.fonyou.exams.util.constants.ConstantsFields.FIRST;
import static com.fonyou.exams.util.constants.ConstantsFields.FOURTH;
import static com.fonyou.exams.util.constants.ConstantsFields.ID_EXAM;
import static com.fonyou.exams.util.constants.ConstantsFields.ID_STUDENT;
import static com.fonyou.exams.util.constants.ConstantsFields.NAME;
import static com.fonyou.exams.util.constants.ConstantsFields.QUESTION_EXAM;
import static com.fonyou.exams.util.constants.ConstantsFields.SECOND;
import static com.fonyou.exams.util.constants.ConstantsFields.THIRD;
import static com.fonyou.exams.util.constants.ConstantsFields.TIME_ZONE;
import static com.fonyou.exams.util.constants.ConstantsFields.TYPE;

import java.time.ZoneId;
import java.util.List;
import java.util.Objects;

import com.fonyou.exams.exceptions.GlobalException;
import com.fonyou.exams.persistence.dto.exam.CollectAnswerDto;
import com.fonyou.exams.persistence.dto.exam.QuestionDto;
import com.fonyou.exams.persistence.dto.request.RequestExam;
import com.fonyou.exams.persistence.dto.student.StudentDto;
import com.fonyou.exams.util.messages.MessagesEnum;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * 
 * @author Julian Velasquez
 *
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ValidateFields {

	/*
	 * validacion de los campos para la insercion de un examen nuevo
	 */
	public static void validRequestExam(RequestExam requestExam) {

		valid(removeSpacesField(requestExam.getExamTopic()), TYPE);

		requestExam.getQuestions().forEach(err -> {

			valid(removeSpacesField(err.getQuestionExam()), QUESTION_EXAM);

			valid(removeSpacesField(err.getFirstOption()), FIRST);

			valid(removeSpacesField(err.getSecondOption()), SECOND);

			valid(removeSpacesField(err.getThirdOption()), THIRD);

			valid(removeSpacesField(err.getFourthOption()), FOURTH);

			valid(removeSpacesField(err.getCorrectAnswer()), CORRECT_ANSWER);
		});
	}

	public static void validRequestStudent(StudentDto studentDto) {

		valid(removeSpacesField(studentDto.getNameStudent()), NAME);

		valid(removeSpacesField(studentDto.getAgeStudent()), AGE);

		valid(removeSpacesField(studentDto.getCity()), CITY);

		valid(removeSpacesField(studentDto.getTimeZone()), TIME_ZONE);

		validTimeZone(studentDto.getTimeZone());
	}

	public static void validExistExam(boolean exist) {
		if (!exist) {
			messageException(MessagesEnum.EXAM_NOT_FOUND);
		}
	}

	public static void validNumberOfQuestions(List<QuestionDto> questions) {
		if (questions.size() != 3) {
			messageException(MessagesEnum.SIZE_INVALID);
		}
	}

	public static void validAnswers(CollectAnswerDto answerDto) {

		valid(removeSpacesField(String.valueOf(answerDto.getIdFkExam())), ID_EXAM);

		valid(removeSpacesField(String.valueOf(answerDto.getIdSFkStudent())), ID_STUDENT);
	}

	public static void validExist(boolean exist, MessagesEnum message) {
		if (!exist) {
			messageException(message);
		}

	}

	private static void valid(String field, String fieldName) {
		if (Objects.isNull(field) || field.isEmpty() || field.equals("null")) {
			messageException(fieldName);
		}
	}

	private static void validTimeZone(String timeZoneId) {
		if (!ZoneId.getAvailableZoneIds().contains(timeZoneId)) {
			messageException(MessagesEnum.TIME_ZONE_INVALID);
		}
	}

	private static void messageException(MessagesEnum message) {
		throw new GlobalException(message.getCode(), message.getMessage());
	}

	private static void messageException(String field) {
		throw new GlobalException(MessagesEnum.FIELD_NOT_NULL.getCode(),
				String.format(MessagesEnum.FIELD_NOT_NULL.getMessage(), field));
	}

	private static String removeSpacesField(String field) {
		if (field != null) {
			return field.trim();
		}
		return field;
	}
}
