package com.alc.itautwitter.exceptions.impl;

import com.alc.itautwitter.model.impl.TweetModel;
import org.springframework.validation.Errors;

import java.io.Serializable;

public final class TweetCollectionNotFoundException
	extends ModelCollectionNotFoundException {

	private static final long serialVersionUID = 8324949548843993618L;

	public TweetCollectionNotFoundException() {
		this(null, null);
	}

	public TweetCollectionNotFoundException(final Errors errors) {
        this(null, errors);
    }

	public <I extends Serializable> TweetCollectionNotFoundException(final Class<I> idClass) {
		this(idClass, null);
    }

	public <I extends Serializable> TweetCollectionNotFoundException(final Class<I> idClass, final Errors errors) {
		super(TweetModel.class, idClass, errors);
    }

}
