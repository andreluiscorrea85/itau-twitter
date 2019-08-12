package com.alc.itautwitter.model.auxiliary;

import java.time.LocalTime;

public final class CountPostsByCreatedAtHour {

	private Long count;

	private LocalTime hour;

	public CountPostsByCreatedAtHour() {
		super();
	}

	public CountPostsByCreatedAtHour(final Long count, final LocalTime hour) {
		this();

		this.count = count;
		this.hour = hour;
	}

	public Long getCount() {
		return this.count;
	}

	public void setCount(final Long count) {
		this.count = count;
	}

	public LocalTime getHour() {
		return this.hour;
	}

	public void setHour(final LocalTime hour) {
		this.hour = hour;
	}

}
