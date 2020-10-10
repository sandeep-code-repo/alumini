package com.skeleton.alumini.exception;

import org.springframework.http.HttpStatus;

public enum ErrorCodes {
	// General
	BADREQUEST(400, HttpStatus.BAD_REQUEST), NOT_FOUND(404, HttpStatus.NOT_FOUND), UNKNOWN(500,
			HttpStatus.INTERNAL_SERVER_ERROR), NOT_AUTHORIZED(403,
					HttpStatus.FORBIDDEN), CONFLICT(409, HttpStatus.CONFLICT);

	private final int code;

	private final HttpStatus httpStatus;

	private ErrorCodes(int code, HttpStatus httpStatus) {
		this.code = code;
		this.httpStatus = httpStatus;
	}

	public int getCode() {
		return code;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public static String getEnumNameForValue(int code1) {
		for (ErrorCodes e : ErrorCodes.values()) {
			if (code1 == e.code)
				return e.name();
		}
		return null;
	}
}