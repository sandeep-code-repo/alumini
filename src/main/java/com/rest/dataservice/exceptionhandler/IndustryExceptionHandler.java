package com.rest.dataservice.exceptionhandler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.rest.dataservice.exception.ErrorResponse;
import com.rest.dataservice.exception.SystemException;



@RestControllerAdvice
public class IndustryExceptionHandler {
	private static final Logger logger = LoggerFactory.getLogger(IndustryExceptionHandler.class);

	@ExceptionHandler(SystemException.class)
	public ResponseEntity<ErrorResponse> handleSystemExceptions(SystemException ex) {
		logger.error(ex.getLocalizedMessage(), ex);
		ErrorResponse error = new ErrorResponse();
		HttpStatus status = ex.getErrorCode().getHttpStatus();
		error.setHttpStatus(status.value());
		error.setErrorCode(ex.getErrorCode().getCode());
		error.setMessage(ex.getMessage());
		return new ResponseEntity<ErrorResponse>(error, status);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponse> handleGeneralExceptions(Exception ex) {

		logger.error(ex.getLocalizedMessage());
		ErrorResponse error = new ErrorResponse();
		error.setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
		error.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
		error.setMessage(ex.getMessage());
		return new ResponseEntity<ErrorResponse>(error, HttpStatus.INTERNAL_SERVER_ERROR);

	}
}
