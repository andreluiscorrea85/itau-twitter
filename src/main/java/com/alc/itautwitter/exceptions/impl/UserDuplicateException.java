package com.alc.itautwitter.exceptions.impl;

import com.alc.itautwitter.model.base.ItauTwitterModel;
import com.alc.itautwitter.model.impl.UserModel;
import org.springframework.validation.Errors;

import java.io.Serializable;

public final class UserDuplicateException
	extends ModelDuplicateException {

	private static final long serialVersionUID = 4932131859630193492L;

	public UserDuplicateException(final Long id) {
        this(null, id);
    }

	public UserDuplicateException(final Long id, final Errors errors) {
        this(null, id, null);
    }

	public <T extends ItauTwitterModel<I>, I extends Serializable> UserDuplicateException(final Class<?> idClass, final Long id) {
        this(idClass, id, null);
    }

	public <T extends ItauTwitterModel<I>, I extends Serializable> UserDuplicateException(final Class<?> idClass, final Long id, final Errors errors) {
        super(UserModel.class, idClass, id, errors);
    }

}
