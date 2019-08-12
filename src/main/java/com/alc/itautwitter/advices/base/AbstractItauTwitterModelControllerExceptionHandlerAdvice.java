package com.alc.itautwitter.advices.base;

import com.alc.itautwitter.model.base.ItauTwitterModel;

import java.io.Serializable;

public abstract class AbstractItauTwitterModelControllerExceptionHandlerAdvice<T extends ItauTwitterModel<I>, I extends Serializable>
	extends AbstractItauTwitterControllerExceptionHandlerAdvice
	implements ItauTwitterModelControllerExceptionHandlerAdvice<T, I> {

	private static final long serialVersionUID = 696247661409323805L;

	public AbstractItauTwitterModelControllerExceptionHandlerAdvice() {
		super();
	}

	protected void initObject() {

	}

}
