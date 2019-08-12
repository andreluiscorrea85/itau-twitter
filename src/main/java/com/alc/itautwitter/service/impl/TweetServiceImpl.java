package com.alc.itautwitter.service.impl;

import com.alc.itautwitter.model.auxiliary.CountPostsByCreatedAtHour;
import com.alc.itautwitter.model.auxiliary.CountPostsByLanguage;
import com.alc.itautwitter.model.impl.TweetModel;
import com.alc.itautwitter.model.impl.UserModel;
import com.alc.itautwitter.repository.interfaces.TweetRepository;
import com.alc.itautwitter.service.base.AbstractItauTwitterService;
import com.alc.itautwitter.service.interfaces.TweetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service()
@Primary()
@Transactional()
public class TweetServiceImpl
	extends AbstractItauTwitterService<TweetModel, Long>
	implements TweetService {

	@Autowired()
	private TweetRepository repository;

	public TweetServiceImpl() {
		super();
	}

	@Override()
	public TweetRepository getRepository() {
		return this.repository;
	}

	@Override()
	public List<UserModel> findTop5UserModelOrderByFollowersCountDesc() {
		return this.getRepository().findTop5UserModelOrderByFollowersCountDesc();
	}

	@Override()
	public List<CountPostsByCreatedAtHour> getTotalPostsGroupByCreatedAtHour() {
		return this.getRepository().getTotalPostsGroupByCreatedAtHour();
	}

	@Override()
	public List<CountPostsByLanguage> getTotalPostsGroupByLanguage() {
		return this.getRepository().getTotalPostsGroupByLanguage();
	}
}
