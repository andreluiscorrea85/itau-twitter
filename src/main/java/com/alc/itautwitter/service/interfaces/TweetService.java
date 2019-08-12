package com.alc.itautwitter.service.interfaces;

import com.alc.itautwitter.model.auxiliary.CountPostsByCreatedAtHour;
import com.alc.itautwitter.model.auxiliary.CountPostsByLanguage;
import com.alc.itautwitter.model.impl.TweetModel;
import com.alc.itautwitter.model.impl.UserModel;
import com.alc.itautwitter.service.base.ItauTwitterService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service()
public abstract interface TweetService
	extends ItauTwitterService<TweetModel, Long> {

	public abstract List<UserModel> findTop5UserModelOrderByFollowersCountDesc();

	public abstract List<CountPostsByCreatedAtHour> getTotalPostsGroupByCreatedAtHour();

	public abstract List<CountPostsByLanguage> getTotalPostsGroupByLanguage();

}
