package com.alc.itautwitter.repository.interfaces;

import com.alc.itautwitter.model.impl.UserModel;
import com.alc.itautwitter.repository.base.ItauTwitterRepositoryCustom;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean()
public abstract interface UserRepositoryCustom
	extends ItauTwitterRepositoryCustom<UserModel, Long> {

}
