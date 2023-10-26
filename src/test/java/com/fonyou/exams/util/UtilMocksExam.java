package com.fonyou.exams.util;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;

import com.fonyou.exams.persistence.dto.exam.CollectAnswerDto;
import com.fonyou.exams.persistence.dto.exam.QualificationDto;
import com.fonyou.exams.persistence.dto.exam.QuestionDto;
import com.fonyou.exams.persistence.dto.request.RequestExam;
import com.fonyou.exams.persistence.dto.response.BuildResponse;
import com.fonyou.exams.persistence.model.exam.ExamEntity;
import com.fonyou.exams.persistence.model.exam.QuestionEntity;
import com.fonyou.exams.persistence.repository.projections.QualificationProjection;
import com.fonyou.exams.util.messages.ExamStatusEnum;
import com.fonyou.exams.util.messages.MessagesEnum;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * 
 * @author Julian Velasquez
 *
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UtilMocksExam {

	public static final String GENERIC_MESSAGE = "Generic_message";

	public static QuestionDto buildQuestionDto() {
		return QuestionDto.builder().idQuestions(1L).questionExam("cuanto es 2X2").firstOption("1").secondOption("3")
				.thirdOption("4").fourthOption("22").correctAnswer("4").build();
	}

	public static List<QuestionDto> buildListQuestionDtos() {
		List<QuestionDto> list = new ArrayList<>();
		list.add(buildQuestionDto());
		list.add(buildQuestionDto());
		list.add(buildQuestionDto());
		return list;
	}

	public static BuildResponse<List<QuestionDto>> buildResponseListQuestion() {
		return new BuildResponse<List<QuestionDto>>(201, "creado", UUID.randomUUID().toString(), "creado", 1L,
				buildListQuestionDtos());
	}

	public static BuildResponse<String> buildResponseAssign() {
		return new BuildResponse<>(201, "Created", UUID.randomUUID().toString(), null, 1L,
				MessagesEnum.ASSIGN_SUCCESS.getMessage());
	}

	public static BuildResponse<CollectAnswerDto> buildResponseAnswers() {
		return new BuildResponse<>(201, "Created", UUID.randomUUID().toString(), null, 1L, buildCollectAnswerDto());
	}

	public static CollectAnswerDto buildCollectAnswerDto() {
		var dto = new CollectAnswerDto();
		dto.setFirstAnswer("1");
		dto.setSecondAnswer("2");
		dto.setThirdAnswer("3");
		dto.setQualification(6D);
		dto.setIdFkExam(1l);
		dto.setIdSFkStudent(1L);
		return dto;
	}

	public static RequestExam buildRequestExam() {
		var req = new RequestExam();
		req.setExamTopic("Ingles");
		req.setQuestions(buildListQuestionDtos());
		return req;
	}

	public static ExamEntity buildExamEntity() {
		return new ExamEntity("Ingles", ExamStatusEnum.ACTIVE.name());
	}

	public static QuestionEntity buildQuestionEntity() {
		return new QuestionEntity(1L, GENERIC_MESSAGE, GENERIC_MESSAGE, GENERIC_MESSAGE, GENERIC_MESSAGE,
				GENERIC_MESSAGE, GENERIC_MESSAGE, 1l);
	}

	public static List<QuestionEntity> buildListQuestionEntities() {
		List<QuestionEntity> list = new ArrayList<>();
		list.add(buildQuestionEntity());
		return list;
	}

	public static QualificationDto buildQualificationDto() {
		QualificationDto dto = new QualificationDto();
		dto.setArea("ingles");
		dto.setName("Julian");
		dto.setFirstAnswer(GENERIC_MESSAGE);
		dto.setSecondAnswer(GENERIC_MESSAGE);
		dto.setThirdAnswer(GENERIC_MESSAGE);
		dto.setQualification(6D);
		return dto;
	}

	public static BuildResponse<QualificationDto> buildResponseQualificationDto() {
		return new BuildResponse<QualificationDto>(200, HttpStatus.OK.name(), UUID.randomUUID().toString(),
				GENERIC_MESSAGE, 1L, buildQualificationDto());
	}
	
	public static QualificationProjection buildQualificationProjection() {
		return new QualificationProjection() {
			
			@Override
			public String getType() {
				return "Ingles";
			}
			
			@Override
			public String getThird() {
				return GENERIC_MESSAGE;
			}
			
			@Override
			public String getSecond() {
				return GENERIC_MESSAGE;
			}
			
			@Override
			public String getQualification() {
				return "3.0";
			}
			
			@Override
			public String getName() {
				return "Ryan Ray";
			}
			
			@Override
			public String getFirst() {
				return GENERIC_MESSAGE;
			}
			
			@Override
			public String getCity() {
				return "Tokyo";
			}
		};
	}
}
