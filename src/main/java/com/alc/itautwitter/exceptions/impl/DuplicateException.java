package com.alc.itautwitter.exceptions.impl;

import com.alc.itautwitter.exceptions.base.AbstractRuntimeException;
import org.springframework.validation.Errors;

/**
 * The type Duplicate exception.
 */
public class DuplicateException
	extends AbstractRuntimeException {

	private static final long serialVersionUID = -6620445212423768754L;

	/**
	 * Instantiates a new Duplicate exception.
	 */
	public DuplicateException() {
		super();
	}

	/**
	 * Instantiates a new Duplicate exception.
	 *
	 * @param message the message
	 */
	public DuplicateException(final String message) {
        super(message);
    }

	/**
	 * Instantiates a new Duplicate exception.
	 *
	 * @param cause the cause
	 */
	public DuplicateException(final Throwable cause) {
        super(cause);
    }

	/**
	 * Instantiates a new Duplicate exception.
	 *
	 * @param errors the errors
	 */
	public DuplicateException(final Errors errors) {
        this();

        this.setErrors(errors);
    }

	/**
	 * Instantiates a new Duplicate exception.
	 *
	 * @param message the message
	 * @param cause   the cause
	 */
	public DuplicateException(final String message, final Throwable cause) {
        super(message, cause);
    }

	/**
	 * Instantiates a new Duplicate exception.
	 *
	 * @param message the message
	 * @param errors  the errors
	 */
	public DuplicateException(final String message, final Errors errors) {
        this(message);

        this.setErrors(errors);
    }

	/**
	 * Instantiates a new Duplicate exception.
	 *
	 * @param cause  the cause
	 * @param errors the errors
	 */
	public DuplicateException(final Throwable cause, final Errors errors) {
        this(cause);

        this.setErrors(errors);
    }

	/**
	 * Instantiates a new Duplicate exception.
	 *
	 * @param message the message
	 * @param cause   the cause
	 * @param errors  the errors
	 */
	public DuplicateException(final String message, final Throwable cause, final Errors errors) {
        this(message, cause);

        this.setErrors(errors);
    }

	/**
	 * Instantiates a new Duplicate exception.
	 *
	 * @param message            the message
	 * @param cause              the cause
	 * @param enableSuppression  the enable suppression
	 * @param writableStackTrace the writable stack trace
	 */
	protected DuplicateException(
		final String message,
		final Throwable cause,
		final boolean enableSuppression,
		final boolean writableStackTrace
	) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	/**
	 * Instantiates a new Duplicate exception.
	 *
	 * @param message            the message
	 * @param cause              the cause
	 * @param enableSuppression  the enable suppression
	 * @param writableStackTrace the writable stack trace
	 * @param errors             the errors
	 */
	protected DuplicateException(
		final String message,
		final Throwable cause,
		final boolean enableSuppression,
		final boolean writableStackTrace,
		final Errors errors
	) {
		this(message, cause, enableSuppression, writableStackTrace);

		this.setErrors(errors);
	}

}
