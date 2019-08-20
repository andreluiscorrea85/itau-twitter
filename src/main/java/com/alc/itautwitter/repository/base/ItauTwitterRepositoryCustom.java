package com.alc.itautwitter.repository.base;

import com.alc.itautwitter.model.base.ItauTwitterModel;
import org.springframework.data.repository.NoRepositoryBean;

import javax.persistence.EntityManager;
import java.io.Serializable;

/**
 * The interface Itau twitter repository custom.
 *
 * @param <T> the type parameter
 * @param <I> the type parameter
 */
@NoRepositoryBean()
public abstract interface ItauTwitterRepositoryCustom<T extends ItauTwitterModel<I>, I extends Serializable>
	extends Serializable {

	/**
	 * Gets entity manager.
	 *
	 * @return the entity manager
	 */
	public abstract EntityManager getEntityManager();

}
