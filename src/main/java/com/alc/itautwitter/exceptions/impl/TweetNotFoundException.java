package com.alc.itautwitter.exceptions.impl;

import com.alc.itautwitter.model.base.ItauTwitterModel;
import com.alc.itautwitter.model.impl.TweetModel;
import org.springframework.validation.Errors;

import java.io.Serializable;

/**
 * The type Tweet not found exception.
 */
public final class TweetNotFoundException
	extends ModelNotFoundException {

	private static final long serialVersionUID = 1758428904200008335L;

	/**
	 * Instantiates a new Tweet not found exception.
	 *
	 * @param id the id
	 */
	public TweetNotFoundException(final Long id) {
        this(null, id);
    }

	/**
	 * Instantiates a new Tweet not found exception.
	 *
	 * @param id     the id
	 * @param errors the errors
	 */
	public TweetNotFoundException(final Long id, final Errors errors) {
        this(null, id, null);
    }

	/**
	 * Instantiates a new Tweet not found exception.
	 *
	 * @param idClass the id class
	 * @param id      the id
	 */
	public <T extends ItauTwitterModel<I>, I extends Serializable> TweetNotFoundException(final Class<?> idClass, final Long id) {
        this(idClass, id, null);
    }

	/**
	 * Instantiates a new Tweet not found exception.
	 *
	 * @param idClass the id class
	 * @param id      the id
	 * @param errors  the errors
	 */
	public <T extends ItauTwitterModel<I>, I extends Serializable> TweetNotFoundException(final Class<?> idClass, final Long id, final Errors errors) {
        super(TweetModel.class, idClass, id, errors);
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
