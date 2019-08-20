package com.alc.itautwitter.controller.base;

import com.alc.itautwitter.model.base.ItauTwitterModel;
import com.alc.itautwitter.service.base.ItauTwitterService;

import java.io.Serializable;

/**
 * The interface Itau twitter model controller.
 *
 * @param <T> the type parameter
 * @param <I> the type parameter
 */
public abstract interface ItauTwitterModelController<T extends ItauTwitterModel<I>, I extends Serializable> {

	/**
	 * Gets service.
	 *
	 * @param <S> the type parameter
	 *
	 * @return the service
	 */
	public abstract <S extends ItauTwitterService> S getService();

}
