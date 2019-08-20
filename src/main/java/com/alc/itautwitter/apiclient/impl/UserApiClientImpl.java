package com.alc.itautwitter.apiclient.impl;

import com.alc.itautwitter.apiclient.base.AbstractItauTwitterModelApiClient;
import com.alc.itautwitter.service.base.ItauTwitterService;
import com.alc.itautwitter.service.interfaces.UserService;

/**
 * The type User api client.
 */
public final class UserApiClientImpl
	extends AbstractItauTwitterModelApiClient {

	private UserService service;

	/**
	 * Instantiates a new User api client.
	 *
	 * @param service the service
	 */
	public UserApiClientImpl(final UserService service) {
		super();

		this.service = service;
	}

	/**
	 * Gets service.
	 *
	 * @return the service
	 */
	@Override()
	public UserService getService() {
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
		this.service = ((UserService) service);
	}

}
