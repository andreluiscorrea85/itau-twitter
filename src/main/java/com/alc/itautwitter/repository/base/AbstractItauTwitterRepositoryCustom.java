package com.alc.itautwitter.repository.base;

import com.alc.itautwitter.model.base.ItauTwitterModel;
import org.springframework.data.repository.NoRepositoryBean;

import javax.persistence.EntityManager;
import java.io.Serializable;

/**
 * The type Abstract itau twitter repository custom.
 *
 * @param <T> the type parameter
 * @param <I> the type parameter
 */
@NoRepositoryBean()
public class AbstractItauTwitterRepositoryCustom<T extends ItauTwitterModel<I>, I extends Serializable>
	extends Object
	implements ItauTwitterRepositoryCustom<T, I> {

	private static final long serialVersionUID = 7468744982200993479L;

	/**
	 * The Entity manager.
	 */
	protected EntityManager entityManager;

	/**
	 * Instantiates a new Abstract itau twitter repository custom.
	 *
	 * @param entityManager the entity manager
	 */
	public AbstractItauTwitterRepositoryCustom(
		final EntityManager entityManager
	) {
		super();
	}

	/**
	 * Gets entity manager.
	 *
	 * @return the entity manager
	 */
	@Override()
	public EntityManager getEntityManager() {
		return this.entityManager;
	}

}
