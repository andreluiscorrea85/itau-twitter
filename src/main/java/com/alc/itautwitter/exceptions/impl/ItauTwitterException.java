package com.alc.itautwitter.exceptions.impl;

import com.alc.itautwitter.exceptions.base.AbstractException;
import org.springframework.validation.Errors;

public class ItauTwitterException
	extends AbstractException {

	private static final long serialVersionUID = 9114039977512883503L;

	public ItauTwitterException() {
		super();
	}

	public ItauTwitterException(final String message) {
		super(message);
	}

	public ItauTwitterException(final Throwable cause) {
		super(cause);
	}

	public ItauTwitterException(final Errors errors) {
		this();

		this.setErrors(errors);
	}

	public ItauTwitterException(final String message, final Throwable cause) {
		super(message, cause);
	}

	public ItauTwitterException(final String message, final Errors errors) {
		this(message);

		this.setErrors(errors);
	}

	public ItauTwitterException(final Throwable cause, final Errors errors) {
		this(cause);

		this.setErrors(errors);
	}

	public ItauTwitterException(
		final String message,
		final Throwable cause,
		final Errors errors
	) {
		this(message, cause);

		this.setErrors(errors);
	}

	protected ItauTwitterException(
		final String message,
		final Throwable cause,
		final boolean enableSuppression,
		final boolean writableStackTrace
	) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

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

	@Override()
	public Errors getErrors() {
		return this.errors;
	}

	protected void setErrors(final Errors errors) {
		this.errors = errors;
	}

}
