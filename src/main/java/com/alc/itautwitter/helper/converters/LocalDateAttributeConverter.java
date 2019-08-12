package com.alc.itautwitter.helper.converters;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.sql.Date;
import java.time.LocalDate;

@Converter(autoApply = true)
public class LocalDateAttributeConverter implements AttributeConverter<LocalDate, Date> {

	@Override()
	public Date convertToDatabaseColumn(final LocalDate attribute) {
		return (
			(attribute != null)
				? Date.valueOf(attribute)
				: null
		);
	}

	@Override()
	public LocalDate convertToEntityAttribute(final Date databaseColumn) {
		return (
			(databaseColumn != null)
				? databaseColumn.toLocalDate()
				: null
		);
	}
}
