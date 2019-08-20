package com.alc.itautwitter.exceptions.impl;

import com.alc.itautwitter.model.base.ItauTwitterModel;
import com.alc.itautwitter.model.impl.UserModel;
import org.springframework.validation.Errors;

import java.io.Serializable;

/**
 * The type User not found exception.
 */
public final class UserNotFoundException
	extends ModelNotFoundException {

	private static final long serialVersionUID = 567596148003652240L;

	/**
	 * Instantiates a new User not found exception.
	 *
	 * @param id the id
	 */
	public UserNotFoundException(final Long id) {
        this(null, id);
    }

	/**
	 * Instantiates a new User not found exception.
	 *
	 * @param id     the id
	 * @param errors the errors
	 */
	public UserNotFoundException(final Long id, final Errors errors) {
        this(null, id, null);
    }

	/**
	 * Instantiates a new User not found exception.
	 *
	 * @param idClass the id class
	 * @param id      the id
	 */
	public <T extends ItauTwitterModel<I>, I extends Serializable> UserNotFoundException(final Class<?> idClass, final Long id) {
        this(idClass, id, null);
    }

	/**
	 * Instantiates a new User not found exception.
	 *
	 * @param idClass the id class
	 * @param id      the id
	 * @param errors  the errors
	 */
	public <T extends ItauTwitterModel<I>, I extends Serializable> UserNotFoundException(final Class<?> idClass, final Long id, final Errors errors) {
        super(UserModel.class, idClass, id, errors);
    }

	/**
	 * Hash code int.
	 *
	 * @return the int
	 */
	@Override()
	public int hashCode() {
		return super.hashCode();
	}

	/**
	 * Equals boolean.
	 *
	 * @param object the object
	 *
	 * @return the boolean
	 */
	@Override()
	public boolean equals(final Object object) {
		return super.equals(object);
	}

	/**
	 * To string string.
	 *
	 * @return the string
	 */
	@Override()
	public String toString() {
		return super.toString();
	}

}
