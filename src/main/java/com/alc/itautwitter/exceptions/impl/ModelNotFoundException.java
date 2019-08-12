package com.alc.itautwitter.exceptions.impl;

import com.alc.itautwitter.model.base.ItauTwitterModel;
import com.alc.itautwitter.helper.utils.ItauTwitterUtils;
import com.alc.itautwitter.helper.constants.ItauTwitterConstants;
import org.springframework.validation.Errors;

import java.io.Serializable;
import java.util.Objects;

public class ModelNotFoundException
	extends NotFoundException {

	private static final long serialVersionUID = -5024501689184720828L;

	protected Class<?> modelClass;

	protected Class<?> idClass;

	protected Serializable id;

	public <T extends ItauTwitterModel<I>, I extends Serializable> ModelNotFoundException(final Class<T> modelClass) {
		this(modelClass, null, null, null);
	}

	public <T extends ItauTwitterModel<I>, I extends Serializable> ModelNotFoundException(final Class<T> modelClass, final Class<?> idClass) {
		this(modelClass, idClass, null, null);
	}

	public <T extends ItauTwitterModel<I>, I extends Serializable> ModelNotFoundException(final Class<T> modelClass, final Class<?> idClass, final Errors errors) {
		this(modelClass, idClass, null, errors);
	}

	public <T extends ItauTwitterModel<I>, I extends Serializable> ModelNotFoundException(final Class<T> modelClass, final I id) {
		this(modelClass, null, id, null);
	}

	public <T extends ItauTwitterModel<I>, I extends Serializable> ModelNotFoundException(final Class<T> modelClass, final I id, final Errors errors) {
		this(modelClass, null, id, errors);
	}

	public <T extends ItauTwitterModel<I>, I extends Serializable> ModelNotFoundException(
		final Class<T> modelClass,
		final Class<?> idClass,
		final I id
	) {
		this(modelClass, idClass, id, null);
	}

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

	public <T extends ItauTwitterModel<I>, I extends Serializable> Class<T> getModelClass() {
		return (
			(Class<T>) this.modelClass
		);
	}

	protected <T extends ItauTwitterModel<I>, I extends Serializable> void setModelClass(final Class<T> modelClass) {
		this.modelClass = modelClass;
	}

	public <I extends Serializable> Class<I> getIdClass() {
		return (
			(Class<I>) this.idClass
		);
	}

	protected <I extends Serializable> void setIdClass(final Class<I> idClass) {
		this.idClass = idClass;
	}

	public <I extends Serializable> I getId() {
		return (
			(I) this.id
		);
	}

	public Long getIdAsLong() {
		return (
			(Objects.nonNull(this.getId()))
				? ((Long) this.getId())
				: null
		);
	}

	public String getIdAsString() {
		return (
			(Objects.nonNull(this.getId()))
				? this.getId().toString()
				: null
		);
	}

	protected <I extends Serializable> void setId(final I id) {
		this.id = id;
	}

}
