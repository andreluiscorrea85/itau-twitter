package com.alc.itautwitter.exceptions.impl;

import com.alc.itautwitter.exceptions.base.AbstractRuntimeException;
import org.springframework.validation.Errors;

/**
 * The type Not found exception.
 */
public class NotFoundException
	extends AbstractRuntimeException {

	private static final long serialVersionUID = -2469712669473202086L;

	/**
	 * Instantiates a new Not found exception.
	 */
	public NotFoundException() {
		super();
	}

	/**
	 * Instantiates a new Not found exception.
	 *
	 * @param message the message
	 */
	public NotFoundException(final String message) {
        super(message);
    }

	/**
	 * Instantiates a new Not found exception.
	 *
	 * @param cause the cause
	 */
	public NotFoundException(final Throwable cause) {
        super(cause);
    }

	/**
	 * Instantiates a new Not found exception.
	 *
	 * @param errors the errors
	 */
	public NotFoundException(final Errors errors) {
		super(errors);
    }

	/**
	 * Instantiates a new Not found exception.
	 *
	 * @param message the message
	 * @param cause   the cause
	 */
	public NotFoundException(final String message, final Throwable cause) {
        super(message, cause);
    }

	/**
	 * Instantiates a new Not found exception.
	 *
	 * @param message the message
	 * @param errors  the errors
	 */
	public NotFoundException(final String message, final Errors errors) {
		super(message, errors);
    }

	/**
	 * Instantiates a new Not found exception.
	 *
	 * @param cause  the cause
	 * @param errors the errors
	 */
	public NotFoundException(final Throwable cause, final Errors errors) {
		super(cause, errors);
    }

	/**
	 * Instantiates a new Not found exception.
	 *
	 * @param message the message
	 * @param cause   the cause
	 * @param errors  the errors
	 */
	public NotFoundException(
		final String message,
		final Throwable cause,
		final Errors errors
	) {
		super(message, cause, errors);
    }

	/**
	 * Instantiates a new Not found exception.
	 *
	 * @param message            the message
	 * @param cause              the cause
	 * @param enableSuppression  the enable suppression
	 * @param writableStackTrace the writable stack trace
	 */
	protected NotFoundException(
		final String message,
		final Throwable cause,
		final boolean enableSuppression,
		final boolean writableStackTrace
	) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	/**
	 * Instantiates a new Not found exception.
	 *
	 * @param message            the message
	 * @param cause              the cause
	 * @param enableSuppression  the enable suppression
	 * @param writableStackTrace the writable stack trace
	 * @param errors             the errors
	 */
	protected NotFoundException(
		final String message,
		final Throwable cause,
		final boolean enableSuppression,
		final boolean writableStackTrace,
		final Errors errors
	) {
		super(message, cause, enableSuppression, writableStackTrace, errors);
	}

}
