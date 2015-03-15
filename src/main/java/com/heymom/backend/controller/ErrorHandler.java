package com.heymom.backend.controller;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.heymom.backend.common.HeymomException;
import com.heymom.backend.dto.APIResult;

@ControllerAdvice
public class ErrorHandler {

	@ExceptionHandler(value = Exception.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	public APIResult<HeymomException> errorResponse(Exception exception) {
		Logger logger = Logger.getLogger(ErrorHandler.class);
		logger.error("Exception:", exception);
		StringWriter stackTraceWriter = new StringWriter();
		exception.printStackTrace(new PrintWriter(stackTraceWriter));
		String stackTrace = stackTraceWriter.toString();
		if (HeymomException.class.isInstance(exception)) {
			return new APIResult<HeymomException>(((HeymomException) exception).getErrorCode(), stackTrace);
		} else {
			return new APIResult<HeymomException>(HeymomException.UNKNOWN, stackTrace);
		}

	}
}