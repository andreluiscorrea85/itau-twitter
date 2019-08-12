package com.alc.itautwitter.repository.interfaces;

import com.alc.itautwitter.model.impl.TweetModel;
import com.alc.itautwitter.model.impl.UserModel;
import com.alc.itautwitter.repository.base.ItauTwitterRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository()
public abstract interface TweetRepository
	extends ItauTwitterRepository<TweetModel, Long>, TweetRepositoryCustom {

	public abstract List<UserModel> findTop5UserModelOrderByFollowersCountDesc();

}
