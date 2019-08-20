package com.alc.itautwitter.advices.base;

import org.springframework.hateoas.VndErrors;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.WebRequest;

import java.io.Serializable;

/**
 * The interface Itau twitter controller exception handler advice.
 */
public abstract interface ItauTwitterControllerExceptionHandlerAdvice
	extends Serializable {

	/**
	 * Handle exception response entity.
	 *
	 * @param <E>       the type parameter
	 * @param exception the exception
	 *
	 * @return the response entity
	 */
	public abstract <E extends Throwable> ResponseEntity<VndErrors> handleException(
		final E exception
	);

	/**
	 * Handle exception response entity.
	 *
	 * @param <E>        the type parameter
	 * @param exception  the exception
	 * @param webRequest the web request
	 *
	 * @return the response entity
	 */
	public abstract <E extends Throwable> ResponseEntity<VndErrors> handleException(
		final E exception,
		final WebRequest webRequest
	);

	/**
	 * Handle exception response entity.
	 *
	 * @param <E>         the type parameter
	 * @param exception   the exception
	 * @param webRequest  the web request
	 * @param producesXML the produces xml
	 *
	 * @return the response entity
	 */
	public abstract <E extends Throwable> ResponseEntity<VndErrors> handleException(
		final E exception,
		final WebRequest webRequest,
		final boolean producesXML
	);

	/**
	 * Handle exception response entity.
	 *
	 * @param <E>         the type parameter
	 * @param exception   the exception
	 * @param webRequest  the web request
	 * @param httpStatus  the http status
	 * @param producesXML the produces xml
	 *
	 * @return the response entity
	 */
	public abstract <E extends Throwable> ResponseEntity<VndErrors> handleException(
		final E exception,
		final WebRequest webRequest,
		final HttpStatus httpStatus,
		final boolean producesXML
	);

	/**
	 * Handle exception response entity.
	 *
	 * @param <E>         the type parameter
	 * @param exception   the exception
	 * @param webRequest  the web request
	 * @param httpStatus  the http status
	 * @param logRef      the log ref
	 * @param message     the message
	 * @param producesXML the produces xml
	 *
	 * @return the response entity
	 */
	public abstract <E extends Throwable> ResponseEntity<VndErrors> handleException(
		final E exception,
		final WebRequest webRequest,
		final HttpStatus httpStatus,
		final String logRef,
		final String message,
		final boolean producesXML
	);

	/**
	 * Handle exception response entity.
	 *
	 * @param <E>         the type parameter
	 * @param exception   the exception
	 * @param webRequest  the web request
	 * @param httpBody    the http body
	 * @param httpHeaders the http headers
	 * @param httpStatus  the http status
	 * @param logRef      the log ref
	 * @param message     the message
	 * @param producesXML the produces xml
	 *
	 * @return the response entity
	 */
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
