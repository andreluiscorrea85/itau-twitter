package com.alc.itautwitter.exceptions.impl;

import com.alc.itautwitter.exceptions.base.AbstractException;
import org.springframework.validation.Errors;

/**
 * The type Itau twitter exception.
 */
public class ItauTwitterException
	extends AbstractException {

	private static final long serialVersionUID = 9114039977512883503L;

	/**
	 * Instantiates a new Itau twitter exception.
	 */
	public ItauTwitterException() {
		super();
	}

	/**
	 * Instantiates a new Itau twitter exception.
	 *
	 * @param message the message
	 */
	public ItauTwitterException(final String message) {
		super(message);
	}

	/**
	 * Instantiates a new Itau twitter exception.
	 *
	 * @param cause the cause
	 */
	public ItauTwitterException(final Throwable cause) {
		super(cause);
	}

	/**
	 * Instantiates a new Itau twitter exception.
	 *
	 * @param errors the errors
	 */
	public ItauTwitterException(final Errors errors) {
		this();

		this.setErrors(errors);
	}

	/**
	 * Instantiates a new Itau twitter exception.
	 *
	 * @param message the message
	 * @param cause   the cause
	 */
	public ItauTwitterException(final String message, final Throwable cause) {
		super(message, cause);
	}

	/**
	 * Instantiates a new Itau twitter exception.
	 *
	 * @param message the message
	 * @param errors  the errors
	 */
	public ItauTwitterException(final String message, final Errors errors) {
		this(message);

		this.setErrors(errors);
	}

	/**
	 * Instantiates a new Itau twitter exception.
	 *
	 * @param cause  the cause
	 * @param errors the errors
	 */
	public ItauTwitterException(final Throwable cause, final Errors errors) {
		this(cause);

		this.setErrors(errors);
	}

	/**
	 * Instantiates a new Itau twitter exception.
	 *
	 * @param message the message
	 * @param cause   the cause
	 * @param errors  the errors
	 */
	public ItauTwitterException(
		final String message,
		final Throwable cause,
		final Errors errors
	) {
		this(message, cause);

		this.setErrors(errors);
	}

	/**
	 * Instantiates a new Itau twitter exception.
	 *
	 * @param message            the message
	 * @param cause              the cause
	 * @param enableSuppression  the enable suppression
	 * @param writableStackTrace the writable stack trace
	 */
	protected ItauTwitterException(
		final String message,
		final Throwable cause,
		final boolean enableSuppression,
		final boolean writableStackTrace
	) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	/**
	 * Instantiates a new Itau twitter exception.
	 *
	 * @param message            the message
	 * @param cause              the cause
	 * @param enableSuppression  the enable suppression
	 * @param writableStackTrace the writable stack trace
	 * @param errors             the errors
	 */
	protected ItauTwitterException(
		final String message,
		final Throwable cause,
		final boolean enableSuppression,
		final boolean writableStackTrace,
		final Errors errors
	) {
		this(message, cause, enableSuppression, writableStackTrace);

		this.setErrors(errors);
	}

	/**
	 * Gets errors.
	 *
	 * @return the errors
	 */
	@Override()
	public Errors getErrors() {
		return this.errors;
	}

	/**
	 * Sets errors.
	 *
	 * @param errors the errors
	 */
	protected void setErrors(final Errors errors) {
		this.errors = errors;
	}

}
