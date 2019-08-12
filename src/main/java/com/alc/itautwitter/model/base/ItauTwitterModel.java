package com.alc.itautwitter.model.base;

import java.io.Serializable;

public abstract interface ItauTwitterModel<I extends Serializable>
	extends Serializable, Cloneable, Comparable<ItauTwitterModel<I>> {

	public abstract Class<I> getIdClass();

	public abstract I getId();

	public abstract Long getIdAsLong();

	public abstract void setId(final I id);

}
