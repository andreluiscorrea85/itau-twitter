package com.alc.itautwitter.exceptions.impl;

import com.alc.itautwitter.model.base.ItauTwitterModel;
import com.alc.itautwitter.model.impl.TweetModel;
import org.springframework.validation.Errors;

import java.io.Serializable;

/**
 * The type Tweet duplicate exception.
 */
public final class TweetDuplicateException
	extends ModelDuplicateException {

	private static final long serialVersionUID = -8500965791540866953L;

	/**
	 * Instantiates a new Tweet duplicate exception.
	 *
	 * @param id the id
	 */
	public TweetDuplicateException(final Long id) {
        this(null, id);
    }

	/**
	 * Instantiates a new Tweet duplicate exception.
	 *
	 * @param id     the id
	 * @param errors the errors
	 */
	public TweetDuplicateException(final Long id, final Errors errors) {
        this(null, id, null);
    }

	/**
	 * Instantiates a new Tweet duplicate exception.
	 *
	 * @param idClass the id class
	 * @param id      the id
	 */
	public <T extends ItauTwitterModel<I>, I extends Serializable> TweetDuplicateException(final Class<?> idClass, final Long id) {
        this(idClass, id, null);
    }

	/**
	 * Instantiates a new Tweet duplicate exception.
	 *
	 * @param idClass the id class
	 * @param id      the id
	 * @param errors  the errors
	 */
	public <T extends ItauTwitterModel<I>, I extends Serializable> TweetDuplicateException(final Class<?> idClass, final Long id, final Errors errors) {
        super(TweetModel.class, idClass, id, errors);
    }

}
