package com.alc.itautwitter.service.base;

import com.alc.itautwitter.model.base.ItauTwitterModel;
import com.alc.itautwitter.repository.base.ItauTwitterRepository;

import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;

@Transactional()
public abstract class AbstractItauTwitterService<T extends ItauTwitterModel<I>, I extends Serializable>
	extends Object
	implements ItauTwitterService<T, I> {

	private static final long serialVersionUID = -4706110368266106269L;

	public AbstractItauTwitterService() {
		super();

		this.initObject();
	}

	protected void initObject() {

	}

	protected abstract <R extends ItauTwitterRepository<T, I>> R getRepository();

	@Override()
	public List<T> findAll() {
		return this.getRepository().findAll();
	}

	@Override()
	public List<T> findAllById(final Iterable<I> ids) {
		return this.getRepository().findAllById(ids);
	}

	@Override()
	public T getOne(final I id) {
		return this.getRepository().getOne(id);
	}

	@Override()
	public T findById(final I id) {
		return this.getRepository().findById(id).orElse(null);
	}

	@Override()
	public T save(final T model) {
		return this.getRepository().save(model);
	}

	@Override()
	public T saveAndFlush(final T model) {
		return this.getRepository().saveAndFlush(model);
	}

	@Override()
	public List<T> saveAll(final Iterable<T> models) {
		return this.getRepository().saveAll(models);
	}

	@Override()
	public void delete(final T model) {
		this.getRepository().delete(model);
	}

	@Override()
	public void deleteById(final I id) {
		this.getRepository().deleteById(id);
	}

	@Override()
	public boolean existsById(final I id) {
		return this.getRepository().existsById(id);
	}

	@Override()
	public long count() {
		return this.getRepository().count();
	}

}
