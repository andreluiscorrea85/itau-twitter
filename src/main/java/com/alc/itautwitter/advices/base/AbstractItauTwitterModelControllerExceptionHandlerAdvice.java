package com.alc.itautwitter.advices.base;

import com.alc.itautwitter.model.base.ItauTwitterModel;

import java.io.Serializable;

/**
 * The type Abstract itau twitter model controller exception handler advice.
 *
 * @param <T> the type parameter
 * @param <I> the type parameter
 */
public abstract class AbstractItauTwitterModelControllerExceptionHandlerAdvice<T extends ItauTwitterModel<I>, I extends Serializable>
	extends AbstractItauTwitterControllerExceptionHandlerAdvice
	implements ItauTwitterModelControllerExceptionHandlerAdvice<T, I> {

	private static final long serialVersionUID = 696247661409323805L;

	/**
	 * Instantiates a new Abstract itau twitter model controller exception handler advice.
	 */
	public AbstractItauTwitterModelControllerExceptionHandlerAdvice() {
		super();
	}

	/**
	 * Init object.
	 */
	protected void initObject() {

	}

}
