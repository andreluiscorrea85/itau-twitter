package com.alc.itautwitter.repository.interfaces;

import com.alc.itautwitter.model.auxiliary.CountPostsByCreatedAtHour;
import com.alc.itautwitter.model.auxiliary.CountPostsByLanguage;
import com.alc.itautwitter.model.impl.TweetModel;
import com.alc.itautwitter.repository.base.ItauTwitterRepositoryCustom;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * The interface Tweet repository custom.
 */
@Repository()
public abstract interface TweetRepositoryCustom
	extends ItauTwitterRepositoryCustom<TweetModel, Long> {

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
