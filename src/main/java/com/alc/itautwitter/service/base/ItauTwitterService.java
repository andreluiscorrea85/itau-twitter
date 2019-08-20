package com.alc.itautwitter.service.base;

import com.alc.itautwitter.model.base.ItauTwitterModel;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;

/**
 * The interface Itau twitter service.
 *
 * @param <T> the type parameter
 * @param <I> the type parameter
 */
@Service()
public abstract interface ItauTwitterService<T extends ItauTwitterModel<I>, I extends Serializable>
	extends Serializable {

	/**
	 * Find all list.
	 *
	 * @return the list
	 */
	public abstract List<T> findAll();

	/**
	 * Find all by id list.
	 *
	 * @param ids the ids
	 *
	 * @return the list
	 */
	public abstract List<T> findAllById(final Iterable<I> ids);

	/**
	 * Gets one.
	 *
	 * @param id the id
	 *
	 * @return the one
	 */
	public abstract T getOne(final I id);

	/**
	 * Find by id t.
	 *
	 * @param id the id
	 *
	 * @return the t
	 */
	public abstract T findById(final I id);

	/**
	 * Save t.
	 *
	 * @param model the model
	 *
	 * @return the t
	 */
	@Transactional()
	public abstract T save(final T model);

	/**
	 * Save and flush t.
	 *
	 * @param model the model
	 *
	 * @return the t
	 */
	@Transactional()
	public abstract T saveAndFlush(final T model);

	/**
	 * Save all list.
	 *
	 * @param models the models
	 *
	 * @return the list
	 */
	@Transactional()
	public abstract List<T> saveAll(final Iterable<T> models);

	/**
	 * Delete.
	 *
	 * @param model the model
	 */
	@Transactional()
	public abstract void delete(final T model);

	/**
	 * Delete by id.
	 *
	 * @param id the id
	 */
	@Transactional()
	public abstract void deleteById(final I id);

	/**
	 * Exists by id boolean.
	 *
	 * @param id the id
	 *
	 * @return the boolean
	 */
	public abstract boolean existsById(final I id);

	/**
	 * Count long.
	 *
	 * @return the long
	 */
	public abstract long count();

}
