package com.alc.itautwitter.apiclient.impl;

import com.alc.itautwitter.apiclient.base.AbstractItauTwitterModelApiClient;
import com.alc.itautwitter.service.base.ItauTwitterService;
import com.alc.itautwitter.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;

public final class UserApiClientImpl
	extends AbstractItauTwitterModelApiClient {

	@Autowired()
	private UserService service;

	public UserApiClientImpl() {
		super();
	}

	@Override()
	public UserService getService() {
		return this.service;
	}

	@Override()
	protected <S extends ItauTwitterService> void setService(final S service) {
		this.service = ((UserService) service);
	}

}
