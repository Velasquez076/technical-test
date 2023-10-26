package com.fonyou.exams.exceptions;

import lombok.Getter;

/**
 * 
 * @author Julián Velásquez
 *
 */
@Getter
public class GlobalException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private final int code;

	private final String message;

	public GlobalException(int code, String message) {
		super(message);
		this.code = code;
		this.message = message;
	}

	public GlobalException(int code, String message, Throwable throwable) {
		super(message, throwable);
		this.code = code;
		this.message = message;
	}
}
