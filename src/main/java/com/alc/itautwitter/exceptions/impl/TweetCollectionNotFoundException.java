package com.alc.itautwitter.exceptions.impl;

import com.alc.itautwitter.model.impl.TweetModel;
import org.springframework.validation.Errors;

import java.io.Serializable;

/**
 * The type Tweet collection not found exception.
 */
public final class TweetCollectionNotFoundException
	extends ModelCollectionNotFoundException {

	private static final long serialVersionUID = 8324949548843993618L;

	/**
	 * Instantiates a new Tweet collection not found exception.
	 */
	public TweetCollectionNotFoundException() {
		this(null, null);
	}

	/**
	 * Instantiates a new Tweet collection not found exception.
	 *
	 * @param errors the errors
	 */
	public TweetCollectionNotFoundException(final Errors errors) {
        this(null, errors);
    }

	/**
	 * Instantiates a new Tweet collection not found exception.
	 *
	 * @param idClass the id class
	 */
	public <I extends Serializable> TweetCollectionNotFoundException(final Class<I> idClass) {
		this(idClass, null);
    }

	/**
	 * Instantiates a new Tweet collection not found exception.
	 *
	 * @param idClass the id class
	 * @param errors  the errors
	 */
	public <I extends Serializable> TweetCollectionNotFoundException(final Class<I> idClass, final Errors errors) {
		super(TweetModel.class, idClass, errors);
    }

}
