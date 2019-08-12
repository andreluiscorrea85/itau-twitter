package com.alc.itautwitter.repository.base;

import com.alc.itautwitter.model.base.ItauTwitterModel;
import org.springframework.data.repository.NoRepositoryBean;

import javax.persistence.EntityManager;
import java.io.Serializable;

@NoRepositoryBean()
public abstract interface ItauTwitterRepositoryCustom<T extends ItauTwitterModel<I>, I extends Serializable>
	extends Serializable {

	public abstract EntityManager getEntityManager();

}
