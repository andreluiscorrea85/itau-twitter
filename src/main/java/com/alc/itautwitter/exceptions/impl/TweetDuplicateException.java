package com.alc.itautwitter.exceptions.impl;

import com.alc.itautwitter.model.base.ItauTwitterModel;
import com.alc.itautwitter.model.impl.TweetModel;
import org.springframework.validation.Errors;

import java.io.Serializable;

public final class TweetDuplicateException
	extends ModelDuplicateException {

	private static final long serialVersionUID = -8500965791540866953L;

	public TweetDuplicateException(final Long id) {
        this(null, id);
    }

	public TweetDuplicateException(final Long id, final Errors errors) {
        this(null, id, null);
    }

	public <T extends ItauTwitterModel<I>, I extends Serializable> TweetDuplicateException(final Class<?> idClass, final Long id) {
        this(idClass, id, null);
    }

	public <T extends ItauTwitterModel<I>, I extends Serializable> TweetDuplicateException(final Class<?> idClass, final Long id, final Errors errors) {
        super(TweetModel.class, idClass, id, errors);
    }

}
