package com.alc.itautwitter.exceptions.impl;

import com.alc.itautwitter.model.base.ItauTwitterModel;
import com.alc.itautwitter.helper.constants.ItauTwitterConstants;
import org.springframework.validation.Errors;

import java.io.Serializable;
import java.util.Objects;

/**
 * The type Model collection not found exception.
 */
public class ModelCollectionNotFoundException
	extends NotFoundException {

	private static final long serialVersionUID = 1918904308874067021L;

	/**
	 * The Model class.
	 */
	protected Class<?> modelClass;

	/**
	 * The Id class.
	 */
	protected Class<?> idClass;

	/**
	 * Instantiates a new Model collection not found exception.
	 *
	 * @param modelClass the model class
	 */
	public <T extends ItauTwitterModel<I>, I extends Serializable> ModelCollectionNotFoundException(
		final Class<T> modelClass
	) {
		this(modelClass, null);
	}

	/**
	 * Instantiates a new Model collection not found exception.
	 *
	 * @param modelClass the model class
	 * @param idClass    the id class
	 */
	public <T extends ItauTwitterModel<I>, I extends Serializable> ModelCollectionNotFoundException(
		final Class<T> modelClass,
		final Class<?> idClass
	) {
		this(modelClass, idClass, null);
	}

	/**
	 * Instantiates a new Model collection not found exception.
	 *
	 * @param modelClass the model class
	 * @param idClass    the id class
	 * @param errors     the errors
	 */
	public <T extends ItauTwitterModel<I>, I extends Serializable> ModelCollectionNotFoundException(
		final Class<T> modelClass,
		final Class<?> idClass,
		final Errors errors
	) {
        super(
        	(
        		ItauTwitterConstants.COLLECTION
        	).concat(
            	"("
            ).concat(
        		(
        			(Objects.nonNull(modelClass))
        				? modelClass.getClass().getSimpleName()
        				: ItauTwitterConstants.MODEL
        		)
        	).concat(
        		")"
        	).concat(
	        		(ItauTwitterConstants.STRING_SPACE).concat(ItauTwitterConstants.EXCEPTION_MESSAGE_NOT_FOUND).concat(".")
	        ),
        	errors
        );

        this.setModelClass(modelClass);
        this.setIdClass((Objects.nonNull(idClass)) ? ((Class<I>) idClass) : null) ;
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
		return ((Class<T>) this.modelClass);
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
		return ((Class<I>) this.idClass);
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

}
