package com.skeleton.alumini.exception;



public class SystemException extends Exception {

	private static final long serialVersionUID = 1L;

	ErrorCodes errorCode = ErrorCodes.UNKNOWN;

	public SystemException() {
		super();
	}

	public SystemException(Exception excep) {
		super(excep);
	}

	public SystemException(ErrorCodes errorCode, String message, Exception excep) {
		super(message, excep);
		this.errorCode = errorCode;
	}

	public ErrorCodes getErrorCode() {
		return errorCode;
	}

}