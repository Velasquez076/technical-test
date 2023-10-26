package com.fonyou.exams.services.exams;

import java.time.LocalDateTime;

/**
 * 
 * @author Julian Velasquez
 *
 */
public interface IAssignService {

	String createAssignExam(LocalDateTime dateAssign, Long idExam);
}
