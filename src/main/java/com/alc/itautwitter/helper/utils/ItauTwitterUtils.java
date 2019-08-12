package com.alc.itautwitter.helper.utils;

import com.alc.itautwitter.helper.constants.ItauTwitterConstants;
import com.alc.itautwitter.model.base.ItauTwitterModel;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

public final class ItauTwitterUtils
	extends Object {

	private ItauTwitterUtils() {
		super();

		throw new RuntimeException(ItauTwitterConstants.EXCEPTION_MESSAGE_NOT_APPLICABLE);
	}

	public static final <I extends Serializable> Class<I> createDefaultIdClass() {
		return (
			(Class<I>) (ItauTwitterConstants.DEFAULT_ID_CLASS)
		);
	}

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

	public static final <T extends ItauTwitterModel<I>, I extends Serializable> boolean validateModel(
		final T model,
		final boolean validateId,
		final boolean validateIdGraterThanZero
	) {
			return (
			(Objects.nonNull(model)) &&
			(validateIdOfModel(model.getId(), validateIdGraterThanZero))
			);
	}

	public static final <I extends Serializable> boolean validateIdOfModel(final I id) {
		return (ItauTwitterUtils.validateIdOfModel(id, true));
	}

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

	public static final <T extends ItauTwitterModel<I>, I extends Serializable> boolean validateModelWithId(final T model) {
		return (validateModel(model, true, true));
	}

	public static final boolean validateString(final String string) {
		var valid = true;

		if (Objects.nonNull(string)) {
			for (final Character characterIteration : string.toCharArray()) {
				valid = (valid & ((Character.isSpaceChar(characterIteration)) || (Character.isWhitespace(characterIteration))));
			}
		}

		return (! (valid) );
	}

	public static final <T extends Object> boolean validateArrayObjects(final T[] objectsArray) {
		return ( (Objects.nonNull(objectsArray)) && (objectsArray.length > 0) );
	}

	public static final <T extends Object> boolean validateList(final List<?> list) {
		return ( (Objects.nonNull(list)) && (list.size() > 0) );
	}

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

	public static final String createArgumentsForNullArgumentExceptionMessage(
		final String... argumentsNamesArray
	) {
		return (ItauTwitterUtils.createArgumentsForNullArgumentExceptionMessage(null, null, argumentsNamesArray));
	}

	public static final Locale getLocale(final String languageLocale) {
		return (
			(ItauTwitterUtils.validateString(languageLocale))
				? new Locale(languageLocale)
				: null
		);
	}

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

	public static final LocalDate convertToLocalDate(final Date from) {
		return (
			(from != null)
				? from.toInstant().atZone(ZoneId.systemDefault()).toLocalDate()
				: null
		);
	}

	public static final LocalDateTime convertToLocalDateTime(final Date from) {
		return (
			(from != null)
				? from.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime()
				: null
		);
	}

}
