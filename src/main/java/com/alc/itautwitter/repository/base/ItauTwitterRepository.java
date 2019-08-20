package com.alc.itautwitter.repository.base;

import com.alc.itautwitter.model.base.ItauTwitterModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

/**
 * The interface Itau twitter repository.
 *
 * @param <T> the type parameter
 * @param <I> the type parameter
 */
@NoRepositoryBean()
public abstract interface ItauTwitterRepository<T extends ItauTwitterModel<I>, I extends Serializable>
	extends ItauTwitterRepositoryCustom<T, I>, JpaRepository<T, I> {

}
