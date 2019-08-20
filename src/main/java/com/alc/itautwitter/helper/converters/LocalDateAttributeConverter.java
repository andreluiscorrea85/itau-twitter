package com.alc.itautwitter.helper.converters;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.sql.Date;
import java.time.LocalDate;

/**
 * The type Local date attribute converter.
 */
@Converter(autoApply = true)
public class LocalDateAttributeConverter implements AttributeConverter<LocalDate, Date> {

	/**
	 * Convert to database column date.
	 *
	 * @param attribute the attribute
	 *
	 * @return the date
	 */
	@Override()
	public Date convertToDatabaseColumn(final LocalDate attribute) {
		return (
			(attribute != null)
				? Date.valueOf(attribute)
				: null
		);
	}

	/**
	 * Convert to entity attribute local date.
	 *
	 * @param databaseColumn the database column
	 *
	 * @return the local date
	 */
	@Override()
	public LocalDate convertToEntityAttribute(final Date databaseColumn) {
		return (
			(databaseColumn != null)
				? databaseColumn.toLocalDate()
				: null
		);
	}
}
