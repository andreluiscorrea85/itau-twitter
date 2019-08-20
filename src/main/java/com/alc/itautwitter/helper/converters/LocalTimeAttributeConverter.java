package com.alc.itautwitter.helper.converters;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.sql.Time;
import java.time.LocalTime;

/**
 * The type Local time attribute converter.
 */
@Converter(autoApply = true)
public class LocalTimeAttributeConverter implements AttributeConverter<LocalTime, Time> {

	/**
	 * Convert to database column time.
	 *
	 * @param attribute the attribute
	 *
	 * @return the time
	 */
	@Override()
	public Time convertToDatabaseColumn(final LocalTime attribute) {
		return (
			(attribute != null)
				? Time.valueOf(attribute)
				: null
		);
	}

	/**
	 * Convert to entity attribute local time.
	 *
	 * @param databaseColumn the database column
	 *
	 * @return the local time
	 */
	@Override()
	public LocalTime convertToEntityAttribute(final Time databaseColumn) {
		return (
			(databaseColumn != null)
				? databaseColumn.toLocalTime()
				: null
		);
	}
}
