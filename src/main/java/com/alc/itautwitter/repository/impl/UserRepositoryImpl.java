package com.alc.itautwitter.repository.impl;

import com.alc.itautwitter.model.impl.UserModel;
import com.alc.itautwitter.repository.base.AbstractItauTwitterRepositoryCustom;
import com.alc.itautwitter.repository.interfaces.UserRepositoryCustom;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository()
public class UserRepositoryImpl
	extends AbstractItauTwitterRepositoryCustom<UserModel, Long>
	implements UserRepositoryCustom {

	private static final long serialVersionUID = -2045885963850124986L;

	public UserRepositoryImpl(final EntityManager entityManager) {
		super(entityManager);
	}

}
