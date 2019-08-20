package com.alc.itautwitter.service.impl;

import com.alc.itautwitter.model.impl.UserModel;
import com.alc.itautwitter.repository.interfaces.UserRepository;
import com.alc.itautwitter.service.base.AbstractItauTwitterService;
import com.alc.itautwitter.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * The type User service.
 */
@Service()
@Primary()
@Transactional()
public class UserServiceImpl
	extends AbstractItauTwitterService<UserModel, Long>
	implements UserService {

	@Autowired()
	private UserRepository repository;

	/**
	 * Instantiates a new User service.
	 */
	public UserServiceImpl() {
		super();
	}

	/**
	 * Gets repository.
	 *
	 * @return the repository
	 */
	@Override()
	public UserRepository getRepository() {
		return this.repository;
	}

	/**
	 * Find top 5 order by followers count desc list.
	 *
	 * @return the list
	 */
	@Override()
	public List<UserModel> findTop5OrderByFollowersCountDesc() {
		return this.getRepository().findTop5OrderByFollowersCountDesc();
	}

}
