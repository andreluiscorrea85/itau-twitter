package com.alc.itautwitter.exceptions.impl;

import com.alc.itautwitter.exceptions.base.AbstractRuntimeException;
import org.springframework.validation.Errors;

public class NotFoundException
	extends AbstractRuntimeException {

	private static final long serialVersionUID = -2469712669473202086L;

	public NotFoundException() {
		super();
	}

	public NotFoundException(final String message) {
        super(message);
    }

	public NotFoundException(final Throwable cause) {
        super(cause);
    }

	public NotFoundException(final Errors errors) {
		super(errors);
    }

	public NotFoundException(final String message, final Throwable cause) {
        super(message, cause);
    }

	public NotFoundException(final String message, final Errors errors) {
		super(message, errors);
    }

	public NotFoundException(final Throwable cause, final Errors errors) {
		super(cause, errors);
    }

	public NotFoundException(
		final String message,
		final Throwable cause,
		final Errors errors
	) {
		super(message, cause, errors);
    }

	protected NotFoundException(
		final String message,
		final Throwable cause,
		final boolean enableSuppression,
		final boolean writableStackTrace
	) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

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
