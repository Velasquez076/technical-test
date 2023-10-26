package com.fonyou.exams.util;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import com.fonyou.exams.persistence.dto.response.BuildResponse;
import com.fonyou.exams.persistence.dto.student.StudentDto;
import com.fonyou.exams.persistence.model.exam.AssignExamEntity;
import com.fonyou.exams.persistence.model.student.StudentEntity;
import com.fonyou.exams.persistence.repository.projections.AssignProjection;
import com.fonyou.exams.persistence.repository.projections.StudentsProjection;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * 
 * @author Julian Velasquez
 *
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UtilMockStudent {

	public static StudentDto buildStudentDto() {
		StudentDto dto = new StudentDto();
		dto.setIdStudent(1L);
		dto.setNameStudent("Ryan Ray");
		dto.setAgeStudent("22");
		dto.setCity("Tokyo");
		dto.setTimeZone("Asia/Tokyo");
		dto.setQualification(3D);
		return dto;
	}

	public static BuildResponse<StudentDto> buildResponseStudentDto() {
		return new BuildResponse<>(201, "Created", UUID.randomUUID().toString(), "created", 1L, buildStudentDto());
	}

	public static BuildResponse<List<StudentsProjection>> buildResponsebuildListStudentProjection() {
		return new BuildResponse<>(200, "Ok", UUID.randomUUID().toString(), "Ok", 1L, buildListStudentProjection());
	}

	public static List<StudentsProjection> buildListStudentProjection() {
		List<StudentsProjection> list = new ArrayList<>();
		list.add(buildStudentProjection());
		return list;
	}

	public static StudentsProjection buildStudentProjection() {
		return new StudentsProjection() {

			@Override
			public String getStatusExam() {
				return "Active";
			}

			@Override
			public String getName() {
				return "Ryan";
			}

			@Override
			public Long getIdStudent() {
				return 1L;
			}

			@Override
			public String getDateAssign() {
				return "2023-10-24T18:00:00.333Z";
			}

			@Override
			public String getCity() {
				return "Tokyo";
			}

			@Override
			public String getArea() {
				return "Ingles";
			}
		};
	}

	public static Set<AssignProjection> buildSetAssignProjections() {
		Set<AssignProjection> set = new HashSet<>();
		set.add(buildAssignProjections());
		return set;
	}

	public static AssignProjection buildAssignProjections() {
		return new AssignProjection() {

			@Override
			public String getTimezone() {
				return "Asia/Tokyo";
			}

			@Override
			public Long getIdStudent() {
				return 1L;
			}
		};
	}

	public static List<AssignExamEntity> buildListAssignExamEntities() {
		List<AssignExamEntity> list = new ArrayList<>();
		list.add(buildAssignExamEntity());
		return list;
	}

	public static AssignExamEntity buildAssignExamEntity() {
		return new AssignExamEntity(LocalDateTime.now(), 1L, 1L);
	}
	
	public static StudentEntity buildStudentEntity() {
		StudentEntity model = new StudentEntity();
		model.setIdStudent(1L);
		model.setNameStudent("Ryan Ray");
		model.setAgeStudent("22");
		model.setCity("Tokyo");
		model.setTimeZone("Asia/Tokyo");
		model.setQualification(6D);
		return model;
	}
}
