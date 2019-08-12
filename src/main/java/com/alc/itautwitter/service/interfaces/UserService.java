package com.alc.itautwitter.service.interfaces;

import com.alc.itautwitter.model.impl.UserModel;
import com.alc.itautwitter.service.base.ItauTwitterService;
import org.springframework.stereotype.Service;

@Service()
public abstract interface UserService
	extends ItauTwitterService<UserModel, Long> {

}
