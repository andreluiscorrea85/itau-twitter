package com.alc.itautwitter.repository.base;

import com.alc.itautwitter.model.base.ItauTwitterModel;
import org.springframework.data.repository.NoRepositoryBean;

import javax.persistence.EntityManager;
import java.io.Serializable;

@NoRepositoryBean()
public class AbstractItauTwitterRepositoryCustom<T extends ItauTwitterModel<I>, I extends Serializable>
	extends Object
	implements ItauTwitterRepositoryCustom<T, I> {

	private static final long serialVersionUID = 7468744982200993479L;

	protected EntityManager entityManager;

	public AbstractItauTwitterRepositoryCustom(
		final EntityManager entityManager
	) {
		super();
	}

	@Override()
	public EntityManager getEntityManager() {
		return this.entityManager;
	}
}
