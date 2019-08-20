package com.alc.itautwitter.helper.utils;

import com.alc.itautwitter.helper.constants.ItauTwitterConstants;
import com.alc.itautwitter.model.base.ItauTwitterModel;
import org.apache.commons.collections4.IterableUtils;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

/**
 * The type Itau twitter utils.
 */
public final class ItauTwitterUtils
	extends Object {

	private ItauTwitterUtils() {
		super();

		throw new RuntimeException(ItauTwitterConstants.EXCEPTION_MESSAGE_NOT_APPLICABLE);
	}

	/**
	 * Create default id class class.
	 *
	 * @param <I> the type parameter
	 *
	 * @return the class
	 */
	public static final <I extends Serializable> Class<I> createDefaultIdClass() {
		return (
			(Class<I>) (ItauTwitterConstants.DEFAULT_ID_CLASS)
		);
	}

	/**
	 * Gets id as long.
	 *
	 * @param <I> the type parameter
	 * @param id  the id
	 *
	 * @return the id as long
	 */
	public static final <I extends Serializable> Long getIdAsLong(final I id) {
		Long idAsLong;

		try {
			idAsLong = ((Long) id);
		}
		catch (final Exception exception) {
			idAsLong = null;
		}

		return idAsLong;
	}

	/**
	 * Validate model boolean.
	 *
	 * @param <T>                      the type parameter
	 * @param <I>                      the type parameter
	 * @param model                    the model
	 * @param validateId               the validate id
	 * @param validateIdGraterThanZero the validate id grater than zero
	 *
	 * @return the boolean
	 */
	public static final <T extends ItauTwitterModel<I>, I extends Serializable> boolean validateModel(
		final T model,
		final boolean validateId,
		final boolean validateIdGraterThanZero
	) {
			return (
				(Objects.nonNull(model)) &&
				(ItauTwitterUtils.validateIdOfModel(model.getId(), validateIdGraterThanZero))
			);
	}

	/**
	 * Validate model with id boolean.
	 *
	 * @param <T>   the type parameter
	 * @param <I>   the type parameter
	 * @param model the model
	 *
	 * @return the boolean
	 */
	public static final <T extends ItauTwitterModel<I>, I extends Serializable> boolean validateModelWithId(final T model) {
		return (ItauTwitterUtils.validateModel(model, true, true));
	}

	/**
	 * Validate id of model boolean.
	 *
	 * @param <I> the type parameter
	 * @param id  the id
	 *
	 * @return the boolean
	 */
	public static final <I extends Serializable> boolean validateIdOfModel(final I id) {
		return (ItauTwitterUtils.validateIdOfModel(id, true));
	}

	/**
	 * Validate id of model boolean.
	 *
	 * @param <I>                      the type parameter
	 * @param id                       the id
	 * @param validateIdGraterThanZero the validate id grater than zero
	 *
	 * @return the boolean
	 */
	public static final <I extends Serializable> boolean validateIdOfModel(final I id, final boolean validateIdGraterThanZero) {
		return (
			(Objects.nonNull(id)) &&
			(
				(! (validateIdGraterThanZero) ) ||
				(
					(validateIdGraterThanZero) &&
					(((Long) id) > 0)
				)
			)
		);
	}

	/**
	 * Validate string boolean.
	 *
	 * @param string the string
	 *
	 * @return the boolean
	 */
	public static final boolean validateString(final String string) {
		var valid = true;

		if (Objects.nonNull(string)) {
			for (final Character characterIteration : string.toCharArray()) {
				valid = (valid & ((Character.isSpaceChar(characterIteration)) || (Character.isWhitespace(characterIteration))));
			}
		}

		return (! (valid) );
	}

	/**
	 * Validate array objects boolean.
	 *
	 * @param <T>          the type parameter
	 * @param objectsArray the objects array
	 *
	 * @return the boolean
	 */
	public static final <T extends Object> boolean validateArrayObjects(final T[] objectsArray) {
		return ( (Objects.nonNull(objectsArray)) && (objectsArray.length > 0) );
	}

	/**
	 * Validate iterable boolean.
	 *
	 * @param <T>      the type parameter
	 * @param iterable the iterable
	 *
	 * @return the boolean
	 */
	public static final <T extends Object> boolean validateIterable(final Iterable<?> iterable) {
		return ( (Objects.nonNull(iterable)) && (IterableUtils.size(iterable)) > 0 );
	}

	/**
	 * Validate list boolean.
	 *
	 * @param <T>  the type parameter
	 * @param list the list
	 *
	 * @return the boolean
	 */
	public static final <T extends Object> boolean validateList(final List<?> list) {
		return ( (Objects.nonNull(list)) && (list.size() > 0) );
	}

	/**
	 * Create arguments for null argument exception message string.
	 *
	 * @param mainArgumentName    the main argument name
	 * @param defaultArgumentName the default argument name
	 * @param argumentsNamesArray the arguments names array
	 *
	 * @return the string
	 */
	public static final String createArgumentsForNullArgumentExceptionMessage(
		final String mainArgumentName,
		final String defaultArgumentName,
		final String... argumentsNamesArray
	) {
		var message = (
			(ItauTwitterUtils.validateString(mainArgumentName))
				? mainArgumentName.trim()
				: "Argument(s)"
		);

		if (ItauTwitterUtils.validateArrayObjects(argumentsNamesArray)) {
			final var sb = new StringBuilder();

			sb.append("[");

			Arrays.asList(argumentsNamesArray).forEach(
				a -> sb.append(
					(", ").concat(
						(ItauTwitterUtils.validateString(a))
							? a
							: (ItauTwitterUtils.validateString(mainArgumentName))
								? mainArgumentName.trim()
								: "Argument"
					).concat(" ")
				)
			);

			sb.append("]");

			message = message.concat(sb.toString().replaceFirst(",", ""));
		}

		message = message.concat(" must not be null.");

		return message;
	}

	/**
	 * Create arguments for null argument exception message string.
	 *
	 * @param argumentsNamesArray the arguments names array
	 *
	 * @return the string
	 */
	public static final String createArgumentsForNullArgumentExceptionMessage(
		final String... argumentsNamesArray
	) {
		return (ItauTwitterUtils.createArgumentsForNullArgumentExceptionMessage(null, null, argumentsNamesArray));
	}

	/**
	 * Gets locale.
	 *
	 * @param languageLocale the language locale
	 *
	 * @return the locale
	 */
	public static final Locale getLocale(final String languageLocale) {
		return (
			(ItauTwitterUtils.validateString(languageLocale))
				? new Locale(languageLocale)
				: null
		);
	}

	/**
	 * Gets language name.
	 *
	 * @param languageLocale the language locale
	 *
	 * @return the language name
	 */
	public static final String getLanguageName(final String languageLocale) {
		String languageName = null;

		if (ItauTwitterUtils.validateString(languageLocale)) {
			var locale = ItauTwitterUtils.getLocale(languageLocale);

			if (locale != null) {
				languageName = locale.getDisplayName();
			}
		}

		return languageName;
	}

	/**
	 * Convert to local date local date.
	 *
	 * @param from the from
	 *
	 * @return the local date
	 */
	public static final LocalDate convertToLocalDate(final Date from) {
		return (
			(from != null)
				? from.toInstant().atZone(ZoneId.systemDefault()).toLocalDate()
				: null
		);
	}

	/**
	 * Convert to local date time local date time.
	 *
	 * @param from the from
	 *
	 * @return the local date time
	 */
	public static final LocalDateTime convertToLocalDateTime(final Date from) {
		return (
			(from != null)
				? from.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime()
				: null
		);
	}

}
