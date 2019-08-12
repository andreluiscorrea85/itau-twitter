package com.alc.itautwitter.service.impl;

import com.alc.itautwitter.model.impl.UserModel;
import com.alc.itautwitter.repository.interfaces.UserRepository;
import com.alc.itautwitter.service.base.AbstractItauTwitterService;
import com.alc.itautwitter.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service()
@Primary()
@Transactional()
public class UserServiceImpl
	extends AbstractItauTwitterService<UserModel, Long>
	implements UserService {

	@Autowired()
	private UserRepository repository;

	public UserServiceImpl() {
		super();
	}

	@Override()
	public UserRepository getRepository() {
		return this.repository;
	}

}
