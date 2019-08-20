package com.alc.itautwitter.exceptions.impl;

import com.alc.itautwitter.model.base.ItauTwitterModel;
import com.alc.itautwitter.helper.utils.ItauTwitterUtils;
import com.alc.itautwitter.helper.constants.ItauTwitterConstants;
import org.springframework.validation.Errors;

import java.io.Serializable;
import java.util.Objects;

/**
 * The type Model not found exception.
 */
public class ModelNotFoundException
	extends NotFoundException {

	private static final long serialVersionUID = -5024501689184720828L;

	/**
	 * The Model class.
	 */
	protected Class<?> modelClass;

	/**
	 * The Id class.
	 */
	protected Class<?> idClass;

	/**
	 * The Id.
	 */
	protected Serializable id;

	/**
	 * Instantiates a new Model not found exception.
	 *
	 * @param modelClass the model class
	 */
	public <T extends ItauTwitterModel<I>, I extends Serializable> ModelNotFoundException(final Class<T> modelClass) {
		this(modelClass, null, null, null);
	}

	/**
	 * Instantiates a new Model not found exception.
	 *
	 * @param modelClass the model class
	 * @param idClass    the id class
	 */
	public <T extends ItauTwitterModel<I>, I extends Serializable> ModelNotFoundException(final Class<T> modelClass, final Class<?> idClass) {
		this(modelClass, idClass, null, null);
	}

	/**
	 * Instantiates a new Model not found exception.
	 *
	 * @param modelClass the model class
	 * @param idClass    the id class
	 * @param errors     the errors
	 */
	public <T extends ItauTwitterModel<I>, I extends Serializable> ModelNotFoundException(final Class<T> modelClass, final Class<?> idClass, final Errors errors) {
		this(modelClass, idClass, null, errors);
	}

	/**
	 * Instantiates a new Model not found exception.
	 *
	 * @param modelClass the model class
	 * @param id         the id
	 */
	public <T extends ItauTwitterModel<I>, I extends Serializable> ModelNotFoundException(final Class<T> modelClass, final I id) {
		this(modelClass, null, id, null);
	}

	/**
	 * Instantiates a new Model not found exception.
	 *
	 * @param modelClass the model class
	 * @param id         the id
	 * @param errors     the errors
	 */
	public <T extends ItauTwitterModel<I>, I extends Serializable> ModelNotFoundException(final Class<T> modelClass, final I id, final Errors errors) {
		this(modelClass, null, id, errors);
	}

	/**
	 * Instantiates a new Model not found exception.
	 *
	 * @param modelClass the model class
	 * @param idClass    the id class
	 * @param id         the id
	 */
	public <T extends ItauTwitterModel<I>, I extends Serializable> ModelNotFoundException(
		final Class<T> modelClass,
		final Class<?> idClass,
		final I id
	) {
		this(modelClass, idClass, id, null);
	}

	/**
	 * Instantiates a new Model not found exception.
	 *
	 * @param modelClass the model class
	 * @param idClass    the id class
	 * @param id         the id
	 * @param errors     the errors
	 */
	public <T extends ItauTwitterModel<I>, I extends Serializable> ModelNotFoundException(
		final Class<T> modelClass,
		final Class<?> idClass,
		final I id,
		final Errors errors
	) {
        super(
        	(
        		(
        			(Objects.nonNull(modelClass))
        				? modelClass.getClass().getSimpleName()
        				: ItauTwitterConstants.MODEL
        		)
        	).concat(
        		(ItauTwitterConstants.STRING_SPACE)
        	).concat(
        		(
        			(ItauTwitterUtils.validateIdOfModel(id))
        				? ("(").concat(ItauTwitterConstants.ID).concat("=").concat(id.toString()).concat(")")
        				: ItauTwitterConstants.STRING_EMPTY
        		)
			).concat(
	        		(ItauTwitterConstants.STRING_SPACE).concat(ItauTwitterConstants.EXCEPTION_MESSAGE_NOT_FOUND).concat(".")
	        ),
        	errors
        );

        this.setModelClass(modelClass);
        this.setIdClass((Objects.nonNull(idClass)) ? ((Class<I>) idClass) : (Objects.nonNull(id)) ? ((Class<I>) id.getClass()) : null) ;
        this.setId(id);
    }

	/**
	 * Gets model class.
	 *
	 * @param <T> the type parameter
	 * @param <I> the type parameter
	 *
	 * @return the model class
	 */
	public <T extends ItauTwitterModel<I>, I extends Serializable> Class<T> getModelClass() {
		return (
			(Class<T>) this.modelClass
		);
	}

	/**
	 * Sets model class.
	 *
	 * @param <T>        the type parameter
	 * @param <I>        the type parameter
	 * @param modelClass the model class
	 */
	protected <T extends ItauTwitterModel<I>, I extends Serializable> void setModelClass(final Class<T> modelClass) {
		this.modelClass = modelClass;
	}

	/**
	 * Gets id class.
	 *
	 * @param <I> the type parameter
	 *
	 * @return the id class
	 */
	public <I extends Serializable> Class<I> getIdClass() {
		return (
			(Class<I>) this.idClass
		);
	}

	/**
	 * Sets id class.
	 *
	 * @param <I>     the type parameter
	 * @param idClass the id class
	 */
	protected <I extends Serializable> void setIdClass(final Class<I> idClass) {
		this.idClass = idClass;
	}

	/**
	 * Gets id.
	 *
	 * @param <I> the type parameter
	 *
	 * @return the id
	 */
	public <I extends Serializable> I getId() {
		return (
			(I) this.id
		);
	}

	/**
	 * Gets id as long.
	 *
	 * @return the id as long
	 */
	public Long getIdAsLong() {
		return (
			(Objects.nonNull(this.getId()))
				? ((Long) this.getId())
				: null
		);
	}

	/**
	 * Gets id as string.
	 *
	 * @return the id as string
	 */
	public String getIdAsString() {
		return (
			(Objects.nonNull(this.getId()))
				? this.getId().toString()
				: null
		);
	}

	/**
	 * Sets id.
	 *
	 * @param <I> the type parameter
	 * @param id  the id
	 */
	protected <I extends Serializable> void setId(final I id) {
		this.id = id;
	}

}
