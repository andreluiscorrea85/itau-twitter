package com.alc.itautwitter.exceptions.impl;

import com.alc.itautwitter.exceptions.base.AbstractIllegalArgumentException;
import com.alc.itautwitter.helper.utils.ItauTwitterUtils;
import org.springframework.validation.Errors;

public class NullArgumentException
	extends AbstractIllegalArgumentException {

	private static final long serialVersionUID = -5727490976897318690L;

	public NullArgumentException(
		final String argumentName
	) {
		super(
			(
				(ItauTwitterUtils.validateString(argumentName))
					? argumentName.trim()
					: "Argument"
			).concat(" must not be null.")
		);
    }

	public NullArgumentException(final String argumentName, final Errors errors) {
		this(argumentName);

		this.setErrors(errors);
	}

	public NullArgumentException(
		final String mainArgumentName,
		final String defaultArgumentName,
		final String... argumentsNamesArray
	) {
		super(
			ItauTwitterUtils.createArgumentsForNullArgumentExceptionMessage(
				mainArgumentName,
				defaultArgumentName,
				argumentsNamesArray
			)
		);
    }

	public NullArgumentException(
		final String mainArgumentName,
		final String defaultArgumentName,
		final Errors errors,
		final String... argumentsNamesArray
	) {
		this(mainArgumentName, defaultArgumentName, argumentsNamesArray);

		this.setErrors(errors);
	}

	@Override()
	public int hashCode() {
		return super.hashCode();
	}

	@Override()
	public boolean equals(final Object object) {
		return super.equals(object);
	}

	@Override()
	public String toString() {
		return super.toString();
	}

}
