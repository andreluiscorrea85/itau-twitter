package com.alc.itautwitter.exceptions.base;

import org.springframework.validation.Errors;

/**
 * The type Abstract illegal argument exception.
 */
public abstract class AbstractIllegalArgumentException
	extends IllegalArgumentException
	implements IException {

	private static final long serialVersionUID = 6067750630705519335L;

	/**
	 * The Errors.
	 */
	protected Errors errors;

	/**
	 * Instantiates a new Abstract illegal argument exception.
	 */
	public AbstractIllegalArgumentException() {
		super();
	}

	/**
	 * Instantiates a new Abstract illegal argument exception.
	 *
	 * @param message the message
	 */
	public AbstractIllegalArgumentException(final String message) {
        super(message);
    }

	/**
	 * Instantiates a new Abstract illegal argument exception.
	 *
	 * @param cause the cause
	 */
	public AbstractIllegalArgumentException(final Throwable cause) {
        super(cause);
    }

	/**
	 * Instantiates a new Abstract illegal argument exception.
	 *
	 * @param errors the errors
	 */
	public AbstractIllegalArgumentException(final Errors errors) {
        this();

        this.setErrors(errors);
    }

	/**
	 * Instantiates a new Abstract illegal argument exception.
	 *
	 * @param message the message
	 * @param cause   the cause
	 */
	public AbstractIllegalArgumentException(final String message, final Throwable cause) {
        super(message, cause);
    }

	/**
	 * Instantiates a new Abstract illegal argument exception.
	 *
	 * @param message the message
	 * @param errors  the errors
	 */
	public AbstractIllegalArgumentException(final String message, final Errors errors) {
        this(message);

        this.setErrors(errors);
    }

	/**
	 * Instantiates a new Abstract illegal argument exception.
	 *
	 * @param cause  the cause
	 * @param errors the errors
	 */
	public AbstractIllegalArgumentException(final Throwable cause, final Errors errors) {
        this(cause);

        this.setErrors(errors);
    }

	/**
	 * Instantiates a new Abstract illegal argument exception.
	 *
	 * @param message the message
	 * @param cause   the cause
	 * @param errors  the errors
	 */
	public AbstractIllegalArgumentException(
		final String message,
		final Throwable cause,
		final Errors errors
	) {
        this(message, cause);

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
