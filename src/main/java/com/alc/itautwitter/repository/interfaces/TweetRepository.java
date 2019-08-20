package com.alc.itautwitter.repository.interfaces;

import com.alc.itautwitter.model.impl.TweetModel;
import com.alc.itautwitter.repository.base.ItauTwitterRepository;
import org.springframework.stereotype.Repository;

/**
 * The interface Tweet repository.
 */
@Repository()
public abstract interface TweetRepository
	extends ItauTwitterRepository<TweetModel, Long>, TweetRepositoryCustom {

}
