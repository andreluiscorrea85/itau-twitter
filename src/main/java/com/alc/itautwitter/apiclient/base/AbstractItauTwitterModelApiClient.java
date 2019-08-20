package com.alc.itautwitter.apiclient.base;

import com.alc.itautwitter.service.base.ItauTwitterService;

/**
 * The type Abstract itau twitter model api client.
 */
public abstract class AbstractItauTwitterModelApiClient
	extends AbstractItauTwitterApiClient
	implements ItauTwitterModelApiClient {

	/**
	 * Instantiates a new Abstract itau twitter model api client.
	 */
	public AbstractItauTwitterModelApiClient() {
		super();
	}

	/**
	 * Sets service.
	 *
	 * @param <S>     the type parameter
	 * @param service the service
	 */
	protected abstract <S extends ItauTwitterService> void setService(final S service);

}
