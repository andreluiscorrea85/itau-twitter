package com.alc.itautwitter.advices.base;

import com.alc.itautwitter.model.base.ItauTwitterModel;

import java.io.Serializable;

/**
 * The interface Itau twitter model controller exception handler advice.
 *
 * @param <T> the type parameter
 * @param <I> the type parameter
 */
public abstract interface ItauTwitterModelControllerExceptionHandlerAdvice<T extends ItauTwitterModel<I>, I extends Serializable>
	extends ItauTwitterControllerExceptionHandlerAdvice {

}
