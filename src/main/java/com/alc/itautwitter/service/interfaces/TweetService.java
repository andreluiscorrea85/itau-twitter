package com.alc.itautwitter.service.interfaces;

import com.alc.itautwitter.model.auxiliary.CountPostsByCreatedAtHour;
import com.alc.itautwitter.model.auxiliary.CountPostsByLanguage;
import com.alc.itautwitter.model.impl.TweetModel;
import com.alc.itautwitter.service.base.ItauTwitterService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * The interface Tweet service.
 */
@Service()
public abstract interface TweetService
	extends ItauTwitterService<TweetModel, Long> {

	/**
	 * Gets total posts group by created at hour.
	 *
	 * @return the total posts group by created at hour
	 */
	public abstract List<CountPostsByCreatedAtHour> getTotalPostsGroupByCreatedAtHour();

	/**
	 * Gets total posts group by language.
	 *
	 * @return the total posts group by language
	 */
	public abstract List<CountPostsByLanguage> getTotalPostsGroupByLanguage();

}
