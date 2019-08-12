package com.alc.itautwitter.exceptions.impl;

import com.alc.itautwitter.exceptions.base.AbstractRuntimeException;
import org.springframework.validation.Errors;

public class DuplicateException
	extends AbstractRuntimeException {

	private static final long serialVersionUID = -6620445212423768754L;

	public DuplicateException() {
		super();
	}

	public DuplicateException(final String message) {
        super(message);
    }

	public DuplicateException(final Throwable cause) {
        super(cause);
    }

	public DuplicateException(final Errors errors) {
        this();

        this.setErrors(errors);
    }

	public DuplicateException(final String message, final Throwable cause) {
        super(message, cause);
    }

	public DuplicateException(final String message, final Errors errors) {
        this(message);

        this.setErrors(errors);
    }

	public DuplicateException(final Throwable cause, final Errors errors) {
        this(cause);

        this.setErrors(errors);
    }

	public DuplicateException(final String message, final Throwable cause, final Errors errors) {
        this(message, cause);

        this.setErrors(errors);
    }

	protected DuplicateException(
		final String message,
		final Throwable cause,
		final boolean enableSuppression,
		final boolean writableStackTrace
	) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

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
