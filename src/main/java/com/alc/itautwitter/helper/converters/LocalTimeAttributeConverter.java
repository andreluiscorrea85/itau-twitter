package com.alc.itautwitter.helper.converters;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.sql.Time;
import java.time.LocalTime;

@Converter(autoApply = true)
public class LocalTimeAttributeConverter implements AttributeConverter<LocalTime, Time> {

	@Override()
	public Time convertToDatabaseColumn(final LocalTime attribute) {
		return (
			(attribute != null)
				? Time.valueOf(attribute)
				: null
		);
	}

	@Override()
	public LocalTime convertToEntityAttribute(final Time databaseColumn) {
		return (
			(databaseColumn != null)
				? databaseColumn.toLocalTime()
				: null
		);
	}
}
