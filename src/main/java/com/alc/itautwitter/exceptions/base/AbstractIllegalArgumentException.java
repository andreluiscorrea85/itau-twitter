package com.alc.itautwitter.exceptions.base;

import org.springframework.validation.Errors;

public abstract class AbstractIllegalArgumentException
	extends IllegalArgumentException
	implements IException {

	private static final long serialVersionUID = 6067750630705519335L;

	protected Errors errors;

	public AbstractIllegalArgumentException() {
		super();
	}

	public AbstractIllegalArgumentException(final String message) {
        super(message);
    }

	public AbstractIllegalArgumentException(final Throwable cause) {
        super(cause);
    }

	public AbstractIllegalArgumentException(final Errors errors) {
        this();

        this.setErrors(errors);
    }

	public AbstractIllegalArgumentException(final String message, final Throwable cause) {
        super(message, cause);
    }

	public AbstractIllegalArgumentException(final String message, final Errors errors) {
        this(message);

        this.setErrors(errors);
    }

	public AbstractIllegalArgumentException(final Throwable cause, final Errors errors) {
        this(cause);

        this.setErrors(errors);
    }

	public AbstractIllegalArgumentException(
		final String message,
		final Throwable cause,
		final Errors errors
	) {
        this(message, cause);

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
