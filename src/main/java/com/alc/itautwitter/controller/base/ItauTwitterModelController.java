package com.alc.itautwitter.controller.base;

import com.alc.itautwitter.model.base.ItauTwitterModel;
import com.alc.itautwitter.service.base.ItauTwitterService;

import java.io.Serializable;

public abstract interface ItauTwitterModelController<T extends ItauTwitterModel<I>, I extends Serializable> {

	public abstract <S extends ItauTwitterService> S getService();

}
