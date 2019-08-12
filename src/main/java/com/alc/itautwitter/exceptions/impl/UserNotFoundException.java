package com.alc.itautwitter.exceptions.impl;

import com.alc.itautwitter.model.base.ItauTwitterModel;
import com.alc.itautwitter.model.impl.UserModel;
import org.springframework.validation.Errors;

import java.io.Serializable;

public final class UserNotFoundException
	extends ModelNotFoundException {

	private static final long serialVersionUID = 567596148003652240L;

	public UserNotFoundException(final Long id) {
        this(null, id);
    }

	public UserNotFoundException(final Long id, final Errors errors) {
        this(null, id, null);
    }

	public <T extends ItauTwitterModel<I>, I extends Serializable> UserNotFoundException(final Class<?> idClass, final Long id) {
        this(idClass, id, null);
    }

	public <T extends ItauTwitterModel<I>, I extends Serializable> UserNotFoundException(final Class<?> idClass, final Long id, final Errors errors) {
        super(UserModel.class, idClass, id, errors);
    }

	@Override()
	public int hashCode() {
		return super.hashCode();
	}

	@Override()
	public boolean equals(final Object object) {
		return super.equals(object);
	}

	@Override()
	public String toString() {
		return super.toString();
	}

}
