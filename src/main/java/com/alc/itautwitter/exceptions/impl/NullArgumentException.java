package com.alc.itautwitter.exceptions.impl;

import com.alc.itautwitter.exceptions.base.AbstractIllegalArgumentException;
import com.alc.itautwitter.helper.utils.ItauTwitterUtils;
import org.springframework.validation.Errors;

/**
 * The type Null argument exception.
 */
public class NullArgumentException
	extends AbstractIllegalArgumentException {

	private static final long serialVersionUID = -5727490976897318690L;

	/**
	 * Instantiates a new Null argument exception.
	 *
	 * @param argumentName the argument name
	 */
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

	/**
	 * Instantiates a new Null argument exception.
	 *
	 * @param argumentName the argument name
	 * @param errors       the errors
	 */
	public NullArgumentException(final String argumentName, final Errors errors) {
		this(argumentName);

		this.setErrors(errors);
	}

	/**
	 * Instantiates a new Null argument exception.
	 *
	 * @param mainArgumentName    the main argument name
	 * @param defaultArgumentName the default argument name
	 * @param argumentsNamesArray the arguments names array
	 */
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

	/**
	 * Instantiates a new Null argument exception.
	 *
	 * @param mainArgumentName    the main argument name
	 * @param defaultArgumentName the default argument name
	 * @param errors              the errors
	 * @param argumentsNamesArray the arguments names array
	 */
	public NullArgumentException(
		final String mainArgumentName,
		final String defaultArgumentName,
		final Errors errors,
		final String... argumentsNamesArray
	) {
		this(mainArgumentName, defaultArgumentName, argumentsNamesArray);

		this.setErrors(errors);
	}

	/**
	 * Hash code int.
	 *
	 * @return the int
	 */
	@Override()
	public int hashCode() {
		return super.hashCode();
	}

	/**
	 * Equals boolean.
	 *
	 * @param object the object
	 *
	 * @return the boolean
	 */
	@Override()
	public boolean equals(final Object object) {
		return super.equals(object);
	}

	/**
	 * To string string.
	 *
	 * @return the string
	 */
	@Override()
	public String toString() {
		return super.toString();
	}

}
