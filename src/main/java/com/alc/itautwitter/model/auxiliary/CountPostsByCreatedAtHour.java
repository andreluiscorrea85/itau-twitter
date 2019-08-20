package com.alc.itautwitter.model.auxiliary;

import java.time.LocalTime;

/**
 * The type Count posts by created at hour.
 */
public final class CountPostsByCreatedAtHour {

	private Long count;

	private LocalTime hour;

	/**
	 * Instantiates a new Count posts by created at hour.
	 */
	public CountPostsByCreatedAtHour() {
		super();
	}

	/**
	 * Instantiates a new Count posts by created at hour.
	 *
	 * @param count the count
	 * @param hour  the hour
	 */
	public CountPostsByCreatedAtHour(final Long count, final LocalTime hour) {
		this();

		this.count = count;
		this.hour = hour;
	}

	/**
	 * Gets count.
	 *
	 * @return the count
	 */
	public Long getCount() {
		return this.count;
	}

	/**
	 * Sets count.
	 *
	 * @param count the count
	 */
	public void setCount(final Long count) {
		this.count = count;
	}

	/**
	 * Gets hour.
	 *
	 * @return the hour
	 */
	public LocalTime getHour() {
		return this.hour;
	}

	/**
	 * Sets hour.
	 *
	 * @param hour the hour
	 */
	public void setHour(final LocalTime hour) {
		this.hour = hour;
	}

}
