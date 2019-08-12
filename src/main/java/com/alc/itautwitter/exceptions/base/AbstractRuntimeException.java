package com.alc.itautwitter.exceptions.base;

import org.springframework.validation.Errors;

public abstract class AbstractRuntimeException
	extends RuntimeException
	implements IException {

	private static final long serialVersionUID = 9018579104700028812L;

	protected Errors errors;

	public AbstractRuntimeException() {
		super();
	}

	public AbstractRuntimeException(final String message) {
        super(message);
    }

	public AbstractRuntimeException(final Throwable cause) {
        super(cause);
    }

	public AbstractRuntimeException(final Errors errors) {
        this();

        this.setErrors(errors);
    }

	public AbstractRuntimeException(final String message, final Throwable cause) {
        super(message, cause);
    }

	public AbstractRuntimeException(final String message, final Errors errors) {
        this(message);

        this.setErrors(errors);
    }

	public AbstractRuntimeException(final Throwable cause, final Errors errors) {
        this(cause);

        this.setErrors(errors);
    }

	public AbstractRuntimeException(
		final String message,
		final Throwable cause,
		final Errors errors
	) {
        this(message, cause);

        this.setErrors(errors);
    }

	protected AbstractRuntimeException(
		final String message,
		final Throwable cause,
		final boolean enableSuppression,
		final boolean writableStackTrace
	) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

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

	@Override()
	public Errors getErrors() {
		return this.errors;
	}

	protected void setErrors(final Errors errors) {
		this.errors = errors;
	}

}
