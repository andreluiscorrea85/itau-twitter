package com.alc.itautwitter.exceptions.base;

import org.springframework.validation.Errors;

public abstract class AbstractException
	extends Exception
	implements IException {

	private static final long serialVersionUID = -2220423820168004196L;

	protected Errors errors;

	public AbstractException() {
		super();
	}

	public AbstractException(final String message) {
		super(message);
	}

	public AbstractException(final Throwable cause) {
		super(cause);
	}

	public AbstractException(final Errors errors) {
		this();

		this.setErrors(errors);
	}

	public AbstractException(final String message, final Throwable cause) {
		super(message, cause);
	}

	public AbstractException(final String message, final Errors errors) {
		this(message);

		this.setErrors(errors);
	}

	public AbstractException(final Throwable cause, final Errors errors) {
		this(cause);

		this.setErrors(errors);
	}

	public AbstractException(
		final String message,
		final Throwable cause,
		final Errors errors
	) {
		this(message, cause);

		this.setErrors(errors);
	}

	protected AbstractException(
		final String message,
		final Throwable cause,
		final boolean enableSuppression,
		final boolean writableStackTrace
	) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	protected AbstractException(
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
