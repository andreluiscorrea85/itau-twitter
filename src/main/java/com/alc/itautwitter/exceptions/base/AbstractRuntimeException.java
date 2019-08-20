package com.alc.itautwitter.exceptions.base;

import org.springframework.validation.Errors;

/**
 * The type Abstract runtime exception.
 */
public abstract class AbstractRuntimeException
	extends RuntimeException
	implements IException {

	private static final long serialVersionUID = 9018579104700028812L;

	/**
	 * The Errors.
	 */
	protected Errors errors;

	/**
	 * Instantiates a new Abstract runtime exception.
	 */
	public AbstractRuntimeException() {
		super();
	}

	/**
	 * Instantiates a new Abstract runtime exception.
	 *
	 * @param message the message
	 */
	public AbstractRuntimeException(final String message) {
        super(message);
    }

	/**
	 * Instantiates a new Abstract runtime exception.
	 *
	 * @param cause the cause
	 */
	public AbstractRuntimeException(final Throwable cause) {
        super(cause);
    }

	/**
	 * Instantiates a new Abstract runtime exception.
	 *
	 * @param errors the errors
	 */
	public AbstractRuntimeException(final Errors errors) {
        this();

        this.setErrors(errors);
    }

	/**
	 * Instantiates a new Abstract runtime exception.
	 *
	 * @param message the message
	 * @param cause   the cause
	 */
	public AbstractRuntimeException(final String message, final Throwable cause) {
        super(message, cause);
    }

	/**
	 * Instantiates a new Abstract runtime exception.
	 *
	 * @param message the message
	 * @param errors  the errors
	 */
	public AbstractRuntimeException(final String message, final Errors errors) {
        this(message);

        this.setErrors(errors);
    }

	/**
	 * Instantiates a new Abstract runtime exception.
	 *
	 * @param cause  the cause
	 * @param errors the errors
	 */
	public AbstractRuntimeException(final Throwable cause, final Errors errors) {
        this(cause);

        this.setErrors(errors);
    }

	/**
	 * Instantiates a new Abstract runtime exception.
	 *
	 * @param message the message
	 * @param cause   the cause
	 * @param errors  the errors
	 */
	public AbstractRuntimeException(
		final String message,
		final Throwable cause,
		final Errors errors
	) {
        this(message, cause);

        this.setErrors(errors);
    }

	/**
	 * Instantiates a new Abstract runtime exception.
	 *
	 * @param message            the message
	 * @param cause              the cause
	 * @param enableSuppression  the enable suppression
	 * @param writableStackTrace the writable stack trace
	 */
	protected AbstractRuntimeException(
		final String message,
		final Throwable cause,
		final boolean enableSuppression,
		final boolean writableStackTrace
	) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	/**
	 * Instantiates a new Abstract runtime exception.
	 *
	 * @param message            the message
	 * @param cause              the cause
	 * @param enableSuppression  the enable suppression
	 * @param writableStackTrace the writable stack trace
	 * @param errors             the errors
	 */
	protected AbstractRuntimeException(
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
