package com.alc.itautwitter.service.base;

import com.alc.itautwitter.model.base.ItauTwitterModel;

import java.io.Serializable;
import java.util.List;

public abstract interface ItauTwitterService<T extends ItauTwitterModel<I>, I extends Serializable>
	extends Serializable {

	public abstract List<T> findAll();

	public abstract List<T> findAllById(final Iterable<I> ids);

	public abstract T getOne(final I id);

	public abstract T findById(final I id);

	public abstract T save(final T model);

	public abstract T saveAndFlush(final T model);

	public abstract List<T> saveAll(final Iterable<T> models);

	public abstract void delete(final T model);

	public abstract void deleteById(final I id);

	public abstract boolean existsById(final I id);

	public abstract long count();

}
