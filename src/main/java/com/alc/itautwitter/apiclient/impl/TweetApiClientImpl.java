package com.alc.itautwitter.apiclient.impl;

import com.alc.itautwitter.apiclient.base.AbstractItauTwitterModelApiClient;
import com.alc.itautwitter.model.impl.TweetModel;
import com.alc.itautwitter.service.base.ItauTwitterService;
import com.alc.itautwitter.service.interfaces.TweetService;
import com.alc.itautwitter.twitter4j.helper.utils.Twitter4JUtils;
import org.springframework.beans.factory.annotation.Autowired;
import twitter4j.Query;
import twitter4j.TwitterException;

import java.util.ArrayList;
import java.util.List;

public final class TweetApiClientImpl
	extends AbstractItauTwitterModelApiClient {

	@Autowired()
	private TweetService service;

	public TweetApiClientImpl() {
		super();
	}

	@Override()
	public TweetService getService() {
		return this.service;
	}

	@Override()
	protected <S extends ItauTwitterService> void setService(final S service) {
		this.service = ((TweetService) service);
	}

	public void loadTweets() {
		List<TweetModel> tweetModelList;

		try {
			var query = new Query("miakhalifa");
			var queryResult = Twitter4JUtils.getTwitterInstance().search(query);

			while ((query = queryResult.nextQuery()) != null) {
				var tweetsStatus = queryResult.getTweets();

				tweetModelList = new ArrayList<>();

				for (var tweetStatusIteration : tweetsStatus) {
					tweetModelList.add(Twitter4JUtils.convertToTweetModel(tweetStatusIteration));
				}

				this.getService().saveAll(tweetModelList);
			}
		}
		catch (TwitterException exception) {
			exception.printStackTrace();
		}
	}

}
