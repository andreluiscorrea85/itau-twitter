package com.alc.itautwitter.exceptions.impl;

import com.alc.itautwitter.model.base.ItauTwitterModel;
import com.alc.itautwitter.helper.constants.ItauTwitterConstants;
import org.springframework.validation.Errors;

import java.io.Serializable;
import java.util.Objects;

public class ModelCollectionNotFoundException
	extends NotFoundException {

	private static final long serialVersionUID = 1918904308874067021L;

	protected Class<?> modelClass;

	protected Class<?> idClass;

	public <T extends ItauTwitterModel<I>, I extends Serializable> ModelCollectionNotFoundException(
		final Class<T> modelClass
	) {
		this(modelClass, null);
	}

	public <T extends ItauTwitterModel<I>, I extends Serializable> ModelCollectionNotFoundException(
		final Class<T> modelClass,
		final Class<?> idClass
	) {
		this(modelClass, idClass, null);
	}

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

	public <T extends ItauTwitterModel<I>, I extends Serializable> Class<T> getModelClass() {
		return ((Class<T>) this.modelClass);
	}

	protected <T extends ItauTwitterModel<I>, I extends Serializable> void setModelClass(final Class<T> modelClass) {
		this.modelClass = modelClass;
	}

	public <I extends Serializable> Class<I> getIdClass() {
		return ((Class<I>) this.idClass);
	}

	protected <I extends Serializable> void setIdClass(final Class<I> idClass) {
		this.idClass = idClass;
	}

}
