package com.alc.itautwitter.service.impl;

import com.alc.itautwitter.model.auxiliary.CountPostsByCreatedAtHour;
import com.alc.itautwitter.model.auxiliary.CountPostsByLanguage;
import com.alc.itautwitter.model.impl.TweetModel;
import com.alc.itautwitter.repository.interfaces.TweetRepository;
import com.alc.itautwitter.service.base.AbstractItauTwitterService;
import com.alc.itautwitter.service.interfaces.TweetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * The type Tweet service.
 */
@Service()
@Primary()
@Transactional()
public class TweetServiceImpl
	extends AbstractItauTwitterService<TweetModel, Long>
	implements TweetService {

	@Autowired()
	private TweetRepository repository;

	/**
	 * Instantiates a new Tweet service.
	 */
	public TweetServiceImpl() {
		super();
	}

	/**
	 * Gets repository.
	 *
	 * @return the repository
	 */
	@Override()
	public TweetRepository getRepository() {
		return this.repository;
	}

	/**
	 * Gets total posts group by created at hour.
	 *
	 * @return the total posts group by created at hour
	 */
	@Override()
	public List<CountPostsByCreatedAtHour> getTotalPostsGroupByCreatedAtHour() {
		return this.getRepository().getTotalPostsGroupByCreatedAtHour();
	}

	/**
	 * Gets total posts group by language.
	 *
	 * @return the total posts group by language
	 */
	@Override()
	public List<CountPostsByLanguage> getTotalPostsGroupByLanguage() {
		return this.getRepository().getTotalPostsGroupByLanguage();
	}
}
