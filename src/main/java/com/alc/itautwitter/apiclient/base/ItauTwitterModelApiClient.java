package com.alc.itautwitter.apiclient.base;

import com.alc.itautwitter.model.base.ItauTwitterModel;
import com.alc.itautwitter.service.base.ItauTwitterService;

import java.io.Serializable;

/**
 * The interface Itau twitter model api client.
 *
 * @param <T> the type parameter
 * @param <I> the type parameter
 */
public abstract interface ItauTwitterModelApiClient<T extends ItauTwitterModel<I>, I extends Serializable>
	extends ItauTwitterApiClient{

	/**
	 * Gets service.
	 *
	 * @param <S> the type parameter
	 *
	 * @return the service
	 */
	public abstract <S extends ItauTwitterService> S getService();

}
