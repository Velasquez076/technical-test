package com.fonyou.exams.exceptions.handler;

import java.sql.SQLTransientConnectionException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import com.fonyou.exams.exceptions.GlobalException;
import com.fonyou.exams.persistence.dto.response.error.ResponseError;
import com.fonyou.exams.util.messages.MessagesEnum;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @author juveme88
 *
 */
@Slf4j
@RestControllerAdvice
public class RestExceptionHandler {

	@ResponseBody
	@ExceptionHandler({Exception.class})
	public ResponseEntity<ResponseError> exceptionHandler(Exception ex) {

		log.error(ex.getMessage(), ex);

		if (ex instanceof GlobalException) {
			GlobalException exception = (GlobalException) ex;
			return new ResponseEntity<>(
					new ResponseError(buildStatus(exception.getCode()),
							exception.getMessage()),
					buildStatus(exception.getCode()));
		}

		if (ex instanceof SQLTransientConnectionException) {
			SQLTransientConnectionException exception = (SQLTransientConnectionException) ex;
			return new ResponseEntity<>(
					new ResponseError(buildStatus(409), exception.getMessage()),
					buildStatus(409));
		}

		return new ResponseEntity<>(
				new ResponseError(buildStatus(400),
						MessagesEnum.SERVER_ERROR.getMessage()),
				buildStatus(400));

	}

	@ResponseBody
	@ExceptionHandler({MethodArgumentTypeMismatchException.class})
	public ResponseEntity<ResponseError> exceptionHandler(
			MethodArgumentTypeMismatchException ex) {

		log.error(ex.getMessage(), ex);

		return new ResponseEntity<>(
				new ResponseError(
						buildStatus(MessagesEnum.DATE_INVALID.getCode()),
						MessagesEnum.DATE_INVALID.getMessage()),
				buildStatus(400));
	}

	private HttpStatus buildStatus(int status) {
		return HttpStatus.valueOf(status);
	}
}
