package com.alc.itautwitter.repository.interfaces;

import com.alc.itautwitter.model.auxiliary.ResumedUser;
import com.alc.itautwitter.model.impl.UserModel;
import com.alc.itautwitter.repository.base.ItauTwitterRepositoryCustom;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * The interface User repository custom.
 */
@Repository()
public abstract interface UserRepositoryCustom
	extends ItauTwitterRepositoryCustom<UserModel, Long> {

	public abstract List<ResumedUser> findTop5OrderByFollowersCountDesc();

}
