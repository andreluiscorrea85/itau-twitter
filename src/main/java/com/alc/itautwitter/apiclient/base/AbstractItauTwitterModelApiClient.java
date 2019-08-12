package com.alc.itautwitter.apiclient.base;

import com.alc.itautwitter.service.base.ItauTwitterService;

public abstract class AbstractItauTwitterModelApiClient
	extends AbstractItauTwitterApiClient
	implements ItauTwitterModelApiClient {

	public AbstractItauTwitterModelApiClient() {
		super();
	}

	protected abstract <S extends ItauTwitterService> void setService(final S service);

}
