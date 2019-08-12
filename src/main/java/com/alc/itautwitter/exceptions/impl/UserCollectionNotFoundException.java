package com.alc.itautwitter.exceptions.impl;

import com.alc.itautwitter.model.impl.UserModel;
import org.springframework.validation.Errors;

import java.io.Serializable;

public final class UserCollectionNotFoundException
	extends ModelCollectionNotFoundException {

	private static final long serialVersionUID = 6081574530967503911L;

	public UserCollectionNotFoundException() {
		this(null, null);
	}

	public UserCollectionNotFoundException(final Errors errors) {
        this(null, errors);
    }

	public <I extends Serializable> UserCollectionNotFoundException(final Class<I> idClass) {
		this(idClass, null);
    }

	public <I extends Serializable> UserCollectionNotFoundException(final Class<I> idClass, final Errors errors) {
		super(UserModel.class, idClass, errors);
    }

}
