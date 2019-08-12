package com.alc.itautwitter.advices.base;

import com.alc.itautwitter.model.base.ItauTwitterModel;

import java.io.Serializable;

public abstract interface ItauTwitterModelControllerExceptionHandlerAdvice<T extends ItauTwitterModel<I>, I extends Serializable>
	extends ItauTwitterControllerExceptionHandlerAdvice {

}
