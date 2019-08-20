package com.alc.itautwitter.exceptions.base;

import org.springframework.validation.Errors;

import java.io.Serializable;

/**
 * The interface Exception.
 */
public abstract interface IException
	extends Serializable {

	/**
	 * Gets errors.
	 *
	 * @return the errors
	 */
	public abstract Errors getErrors();

}
