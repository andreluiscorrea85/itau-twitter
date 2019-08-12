package com.alc.itautwitter.exceptions.base;

import org.springframework.validation.Errors;

import java.io.Serializable;

public abstract interface IException
	extends Serializable {

	public abstract Errors getErrors();

}
