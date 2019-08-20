package com.alc.itautwitter.exceptions.impl;

import com.alc.itautwitter.model.base.ItauTwitterModel;
import com.alc.itautwitter.model.impl.UserModel;
import org.springframework.validation.Errors;

import java.io.Serializable;

/**
 * The type User duplicate exception.
 */
public final class UserDuplicateException
	extends ModelDuplicateException {

	private static final long serialVersionUID = 4932131859630193492L;

	/**
	 * Instantiates a new User duplicate exception.
	 *
	 * @param id the id
	 */
	public UserDuplicateException(final Long id) {
        this(null, id);
    }

	/**
	 * Instantiates a new User duplicate exception.
	 *
	 * @param id     the id
	 * @param errors the errors
	 */
	public UserDuplicateException(final Long id, final Errors errors) {
        this(null, id, null);
    }

	/**
	 * Instantiates a new User duplicate exception.
	 *
	 * @param idClass the id class
	 * @param id      the id
	 */
	public <T extends ItauTwitterModel<I>, I extends Serializable> UserDuplicateException(final Class<?> idClass, final Long id) {
        this(idClass, id, null);
    }

	/**
	 * Instantiates a new User duplicate exception.
	 *
	 * @param idClass the id class
	 * @param id      the id
	 * @param errors  the errors
	 */
	public <T extends ItauTwitterModel<I>, I extends Serializable> UserDuplicateException(final Class<?> idClass, final Long id, final Errors errors) {
        super(UserModel.class, idClass, id, errors);
    }

}
