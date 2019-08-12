package com.alc.itautwitter.controller.base;

import com.alc.itautwitter.model.base.ItauTwitterModel;
import com.alc.itautwitter.service.base.ItauTwitterService;

import java.io.Serializable;

public abstract class AbstractItauTwitterModelController<T extends ItauTwitterModel<I>, I extends Serializable>
	extends AbstractItauTwitterController
	implements ItauTwitterModelController<T, I> {

	public AbstractItauTwitterModelController() {
		super();

		this.initObject();
	}

	protected void initObject() {

	}

	protected abstract <S extends ItauTwitterService> void setService(final S service);

}
