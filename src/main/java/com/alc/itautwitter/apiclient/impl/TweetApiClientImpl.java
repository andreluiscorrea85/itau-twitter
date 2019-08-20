package com.alc.itautwitter.apiclient.impl;

import com.alc.itautwitter.apiclient.base.AbstractItauTwitterModelApiClient;
import com.alc.itautwitter.service.base.ItauTwitterService;
import com.alc.itautwitter.service.interfaces.TweetService;

/**
 * The type Tweet api client.
 */
public final class TweetApiClientImpl
	extends AbstractItauTwitterModelApiClient {

	private TweetService service;

	/**
	 * Instantiates a new Tweet api client.
	 *
	 * @param service the service
	 */
	public TweetApiClientImpl(final TweetService service) {
		super();

		this.service = service;
	}

	/**
	 * Gets service.
	 *
	 * @return the service
	 */
	@Override()
	public ItauTwitterService getService() {
		return this.service;
	}

	/**
	 * Sets service.
	 *
	 * @param <S>     the type parameter
	 * @param service the service
	 */
	@Override()
	protected <S extends ItauTwitterService> void setService(final S service) {
		this.service = ((TweetService) service);
	}

}
