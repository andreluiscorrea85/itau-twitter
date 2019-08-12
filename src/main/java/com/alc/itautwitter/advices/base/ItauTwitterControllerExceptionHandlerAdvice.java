package com.alc.itautwitter.advices.base;

import org.springframework.hateoas.VndErrors;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.WebRequest;

import java.io.Serializable;

public abstract interface ItauTwitterControllerExceptionHandlerAdvice
	extends Serializable {

	public abstract <E extends Throwable> ResponseEntity<VndErrors> handleException(
		final E exception
	);

	public abstract <E extends Throwable> ResponseEntity<VndErrors> handleException(
		final E exception,
		final WebRequest webRequest
	);

	public abstract <E extends Throwable> ResponseEntity<VndErrors> handleException(
		final E exception,
		final WebRequest webRequest,
		final boolean producesXML
	);

	public abstract <E extends Throwable> ResponseEntity<VndErrors> handleException(
		final E exception,
		final WebRequest webRequest,
		final HttpStatus httpStatus,
		final boolean producesXML
	);

	public abstract <E extends Throwable> ResponseEntity<VndErrors> handleException(
		final E exception,
		final WebRequest webRequest,
		final HttpStatus httpStatus,
		final String logRef,
		final String message,
		final boolean producesXML
	);

	public abstract <E extends Throwable> ResponseEntity<VndErrors> handleException(
		final E exception,
		final WebRequest webRequest,
		final VndErrors httpBody,
		final HttpHeaders httpHeaders,
		final HttpStatus httpStatus,
		final String logRef,
		final String message,
		final boolean producesXML
	);

}
