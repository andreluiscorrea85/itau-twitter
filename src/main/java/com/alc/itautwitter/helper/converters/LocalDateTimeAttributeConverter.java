package com.alc.itautwitter.helper.converters;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Converter(autoApply = true)
public class LocalDateTimeAttributeConverter implements AttributeConverter<LocalDateTime, Timestamp> {

	@Override()
	public Timestamp convertToDatabaseColumn(final LocalDateTime attribute) {
		return (
			(attribute != null)
				? Timestamp.valueOf(attribute)
				: null
		);
	}

	@Override()
	public LocalDateTime convertToEntityAttribute(final Timestamp databaseColumn) {
		return (
			(databaseColumn != null)
				? databaseColumn.toLocalDateTime()
				: null
		);
	}
}
