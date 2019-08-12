package com.alc.itautwitter.repository.interfaces;

import com.alc.itautwitter.model.impl.UserModel;
import com.alc.itautwitter.repository.base.ItauTwitterRepository;
import org.springframework.stereotype.Repository;

@Repository()
public abstract interface UserRepository
	extends ItauTwitterRepository<UserModel, Long>, UserRepositoryCustom {

}
