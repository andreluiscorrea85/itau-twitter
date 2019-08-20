package com.alc.itautwitter.service.base;

import com.alc.itautwitter.helper.utils.ItauTwitterUtils;
import com.alc.itautwitter.model.base.ItauTwitterModel;
import com.alc.itautwitter.repository.base.ItauTwitterRepository;

import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;

/**
 * The type Abstract itau twitter service.
 *
 * @param <T> the type parameter
 * @param <I> the type parameter
 */
@Transactional()
public abstract class AbstractItauTwitterService<T extends ItauTwitterModel<I>, I extends Serializable>
	extends Object
	implements ItauTwitterService<T, I> {

	private static final long serialVersionUID = -4706110368266106269L;

	/**
	 * Instantiates a new Abstract itau twitter service.
	 */
	public AbstractItauTwitterService() {
		super();

		this.initObject();
	}

	/**
	 * Init object.
	 */
	protected void initObject() {

	}

	/**
	 * Gets repository.
	 *
	 * @param <R> the type parameter
	 *
	 * @return the repository
	 */
	protected abstract <R extends ItauTwitterRepository<T, I>> R getRepository();

	/**
	 * Find all list.
	 *
	 * @return the list
	 */
	@Override()
	public List<T> findAll() {
		return this.getRepository().findAll();
	}

	/**
	 * Find all by id list.
	 *
	 * @param ids the ids
	 *
	 * @return the list
	 */
	@Override()
	public List<T> findAllById(final Iterable<I> ids) {
		return (
			(ItauTwitterUtils.validateIterable(ids))
				? this.getRepository().findAllById(ids)
				: null
		);
	}

	/**
	 * Gets one.
	 *
	 * @param id the id
	 *
	 * @return the one
	 */
	@Override()
	public T getOne(final I id) {
		return (
			(ItauTwitterUtils.validateIdOfModel(id))
				? this.getRepository().getOne(id)
				: null
		);
	}

	/**
	 * Find by id t.
	 *
	 * @param id the id
	 *
	 * @return the t
	 */
	@Override()
	public T findById(final I id) {
		return (
			(ItauTwitterUtils.validateIdOfModel(id))
				? this.getRepository().findById(id).orElse(null)
				: null
		);
	}

	/**
	 * Save t.
	 *
	 * @param model the model
	 *
	 * @return the t
	 */
	@Override()
	public T save(final T model) {
		return (
			(ItauTwitterUtils.validateModelWithId(model))
				? this.getRepository().save(model)
				: null
		);
	}

	/**
	 * Save and flush t.
	 *
	 * @param model the model
	 *
	 * @return the t
	 */
	@Override()
	public T saveAndFlush(final T model) {
		return (
			(ItauTwitterUtils.validateModelWithId(model))
				? this.getRepository().saveAndFlush(model)
				: null
		);
	}

	/**
	 * Save all list.
	 *
	 * @param models the models
	 *
	 * @return the list
	 */
	@Override()
	public List<T> saveAll(final Iterable<T> models) {
		return (
			(ItauTwitterUtils.validateIterable(models))
				? this.getRepository().saveAll(models)
				: null
		);
	}

	/**
	 * Delete.
	 *
	 * @param model the model
	 */
	@Override()
	public void delete(final T model) {
		if (ItauTwitterUtils.validateModelWithId(model)) {
			this.getRepository().delete(model);
		}
	}

	/**
	 * Delete by id.
	 *
	 * @param id the id
	 */
	@Override()
	public void deleteById(final I id) {
		if (ItauTwitterUtils.validateIdOfModel(id)) {
			this.getRepository().deleteById(id);
		}
	}

	/**
	 * Exists by id boolean.
	 *
	 * @param id the id
	 *
	 * @return the boolean
	 */
	@Override()
	public boolean existsById(final I id) {
		return (
			(ItauTwitterUtils.validateIdOfModel(id))
				? this.getRepository().existsById(id)
				: false
		);
	}

	/**
	 * Count long.
	 *
	 * @return the long
	 */
	@Override()
	public long count() {
		return this.getRepository().count();
	}

}
