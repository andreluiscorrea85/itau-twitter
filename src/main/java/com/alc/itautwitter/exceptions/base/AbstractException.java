package com.alc.itautwitter.exceptions.base;

import org.springframework.validation.Errors;

/**
 * The type Abstract exception.
 */
public abstract class AbstractException
	extends Exception
	implements IException {

	private static final long serialVersionUID = -2220423820168004196L;

	/**
	 * The Errors.
	 */
	protected Errors errors;

	/**
	 * Instantiates a new Abstract exception.
	 */
	public AbstractException() {
		super();
	}

	/**
	 * Instantiates a new Abstract exception.
	 *
	 * @param message the message
	 */
	public AbstractException(final String message) {
		super(message);
	}

	/**
	 * Instantiates a new Abstract exception.
	 *
	 * @param cause the cause
	 */
	public AbstractException(final Throwable cause) {
		super(cause);
	}

	/**
	 * Instantiates a new Abstract exception.
	 *
	 * @param errors the errors
	 */
	public AbstractException(final Errors errors) {
		this();

		this.setErrors(errors);
	}

	/**
	 * Instantiates a new Abstract exception.
	 *
	 * @param message the message
	 * @param cause   the cause
	 */
	public AbstractException(final String message, final Throwable cause) {
		super(message, cause);
	}

	/**
	 * Instantiates a new Abstract exception.
	 *
	 * @param message the message
	 * @param errors  the errors
	 */
	public AbstractException(final String message, final Errors errors) {
		this(message);

		this.setErrors(errors);
	}

	/**
	 * Instantiates a new Abstract exception.
	 *
	 * @param cause  the cause
	 * @param errors the errors
	 */
	public AbstractException(final Throwable cause, final Errors errors) {
		this(cause);

		this.setErrors(errors);
	}

	/**
	 * Instantiates a new Abstract exception.
	 *
	 * @param message the message
	 * @param cause   the cause
	 * @param errors  the errors
	 */
	public AbstractException(
		final String message,
		final Throwable cause,
		final Errors errors
	) {
		this(message, cause);

		this.setErrors(errors);
	}

	/**
	 * Instantiates a new Abstract exception.
	 *
	 * @param message            the message
	 * @param cause              the cause
	 * @param enableSuppression  the enable suppression
	 * @param writableStackTrace the writable stack trace
	 */
	protected AbstractException(
		final String message,
		final Throwable cause,
		final boolean enableSuppression,
		final boolean writableStackTrace
	) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	/**
	 * Instantiates a new Abstract exception.
	 *
	 * @param message            the message
	 * @param cause              the cause
	 * @param enableSuppression  the enable suppression
	 * @param writableStackTrace the writable stack trace
	 * @param errors             the errors
	 */
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
