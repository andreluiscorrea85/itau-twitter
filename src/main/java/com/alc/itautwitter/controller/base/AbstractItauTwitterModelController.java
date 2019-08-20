package com.alc.itautwitter.controller.base;

import com.alc.itautwitter.model.base.ItauTwitterModel;
import com.alc.itautwitter.service.base.ItauTwitterService;

import java.io.Serializable;

/**
 * The type Abstract itau twitter model controller.
 *
 * @param <T> the type parameter
 * @param <I> the type parameter
 */
public abstract class AbstractItauTwitterModelController<T extends ItauTwitterModel<I>, I extends Serializable>
	extends AbstractItauTwitterController
	implements ItauTwitterModelController<T, I> {

	/**
	 * Instantiates a new Abstract itau twitter model controller.
	 */
	public AbstractItauTwitterModelController() {
		super();

		this.initObject();
	}

	/**
	 * Init object.
	 */
	protected void initObject() {

	}

	/**
	 * Sets service.
	 *
	 * @param <S>     the type parameter
	 * @param service the service
	 */
	protected abstract <S extends ItauTwitterService> void setService(final S service);

}
