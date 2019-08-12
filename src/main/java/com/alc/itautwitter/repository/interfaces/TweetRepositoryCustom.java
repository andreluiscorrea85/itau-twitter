package com.alc.itautwitter.repository.interfaces;

import com.alc.itautwitter.model.auxiliary.CountPostsByCreatedAtHour;
import com.alc.itautwitter.model.auxiliary.CountPostsByLanguage;
import com.alc.itautwitter.model.impl.TweetModel;
import com.alc.itautwitter.repository.base.ItauTwitterRepositoryCustom;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;

@NoRepositoryBean()
public abstract interface TweetRepositoryCustom
	extends ItauTwitterRepositoryCustom<TweetModel, Long> {

	public abstract List<CountPostsByCreatedAtHour> getTotalPostsGroupByCreatedAtHour();

	public abstract List<CountPostsByLanguage> getTotalPostsGroupByLanguage();

}
