package com.alc.itautwitter.exceptions.impl;

import com.alc.itautwitter.model.impl.UserModel;
import org.springframework.validation.Errors;

import java.io.Serializable;

/**
 * The type User collection not found exception.
 */
public final class UserCollectionNotFoundException
	extends ModelCollectionNotFoundException {

	private static final long serialVersionUID = 6081574530967503911L;

	/**
	 * Instantiates a new User collection not found exception.
	 */
	public UserCollectionNotFoundException() {
		this(null, null);
	}

	/**
	 * Instantiates a new User collection not found exception.
	 *
	 * @param errors the errors
	 */
	public UserCollectionNotFoundException(final Errors errors) {
        this(null, errors);
    }

	/**
	 * Instantiates a new User collection not found exception.
	 *
	 * @param idClass the id class
	 */
	public <I extends Serializable> UserCollectionNotFoundException(final Class<I> idClass) {
		this(idClass, null);
    }

	/**
	 * Instantiates a new User collection not found exception.
	 *
	 * @param idClass the id class
	 * @param errors  the errors
	 */
	public <I extends Serializable> UserCollectionNotFoundException(final Class<I> idClass, final Errors errors) {
		super(UserModel.class, idClass, errors);
    }

}
