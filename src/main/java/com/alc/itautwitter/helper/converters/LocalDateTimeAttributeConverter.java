package com.alc.itautwitter.helper.converters;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.sql.Timestamp;
import java.time.LocalDateTime;

/**
 * The type Local date time attribute converter.
 */
@Converter(autoApply = true)
public class LocalDateTimeAttributeConverter implements AttributeConverter<LocalDateTime, Timestamp> {

	/**
	 * Convert to database column timestamp.
	 *
	 * @param attribute the attribute
	 *
	 * @return the timestamp
	 */
	@Override()
	public Timestamp convertToDatabaseColumn(final LocalDateTime attribute) {
		return (
			(attribute != null)
				? Timestamp.valueOf(attribute)
				: null
		);
	}

	/**
	 * Convert to entity attribute local date time.
	 *
	 * @param databaseColumn the database column
	 *
	 * @return the local date time
	 */
	@Override()
	public LocalDateTime convertToEntityAttribute(final Timestamp databaseColumn) {
		return (
			(databaseColumn != null)
				? databaseColumn.toLocalDateTime()
				: null
		);
	}
}
