package com.alc.itautwitter.model.base;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * The interface Itau twitter model.
 *
 * @param <I> the type parameter
 */
public abstract interface ItauTwitterModel<I extends Serializable>
	extends Serializable, Cloneable, Comparable<ItauTwitterModel<I>> {

	/**
	 * Gets id class.
	 *
	 * @return the id class
	 */
	public abstract Class<I> getIdClass();

	/**
	 * Gets id.
	 *
	 * @return the id
	 */
	public abstract I getId();

	/**
	 * Gets creation date time.
	 *
	 * @return the creation date time
	 */
	public abstract LocalDateTime getCreationDateTime();

	/**
	 * Sets creation date time.
	 *
	 * @param creationDateTime the creation date time
	 */
	public void setCreationDateTime(final LocalDateTime creationDateTime);

	/**
	 * Gets id as long.
	 *
	 * @return the id as long
	 */
	public abstract Long getIdAsLong();

	/**
	 * Sets id.
	 *
	 * @param id the id
	 */
	public abstract void setId(final I id);

}
