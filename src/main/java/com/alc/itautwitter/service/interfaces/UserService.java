package com.alc.itautwitter.service.interfaces;

import com.alc.itautwitter.model.impl.UserModel;
import com.alc.itautwitter.service.base.ItauTwitterService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * The interface User service.
 */
@Service()
public abstract interface UserService
	extends ItauTwitterService<UserModel, Long> {

	/**
	 * Find top 5 order by followers count desc list.
	 *
	 * @return the list
	 */
	public abstract List<UserModel> findTop5OrderByFollowersCountDesc();

}
