package com.allianz.medicaltourism.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ControllerAdvisor extends ResponseEntityExceptionHandler {

	@ExceptionHandler(NullPointerException.class)
	public ResponseEntity<Object> handleNullPointer(Exception ex, WebRequest request) {
		Map<String, Object> exBody = new HashMap<>();
		exBody.put("message", ex.getMessage());
		exBody.put("status", 400);
		exBody.put("TimeStamp", LocalDateTime.now());
		return new ResponseEntity<>(exBody, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<Object> handleIllegalPointer(Exception ex, WebRequest request) {
		Map<String, Object> exBody = new HashMap<>();
		exBody.put("message", ex.getMessage());
		exBody.put("status", 400);
		exBody.put("TimeStamp", LocalDateTime.now());
		return new ResponseEntity<>(exBody, HttpStatus.BAD_REQUEST);
	}

}
