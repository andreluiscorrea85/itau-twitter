package com.alc.itautwitter.apiclient.base;

import com.alc.itautwitter.model.base.ItauTwitterModel;
import com.alc.itautwitter.service.base.ItauTwitterService;

import java.io.Serializable;

public abstract interface ItauTwitterModelApiClient<T extends ItauTwitterModel<I>, I extends Serializable>
	extends ItauTwitterApiClient{

	public abstract <S extends ItauTwitterService> S getService();

}
