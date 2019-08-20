package com.alc.itautwitter.apiclient.impl;

import com.alc.itautwitter.apiclient.base.AbstractItauTwitterApiClient;
import com.alc.itautwitter.model.enums.ETags;
import com.alc.itautwitter.model.impl.TweetModel;
import com.alc.itautwitter.model.impl.UserModel;
import com.alc.itautwitter.service.interfaces.TweetService;
import com.alc.itautwitter.service.interfaces.UserService;
import com.alc.itautwitter.twitter4j.helper.utils.Twitter4JUtils;
import twitter4j.Query;
import twitter4j.TwitterException;

import java.util.HashSet;

/**
 * The type Itau twiter api client.
 */
public final class ItauTwiterApiClientImpl
	extends AbstractItauTwitterApiClient {

	private UserService userService;

	private TweetService tweetService;

	/**
	 * Instantiates a new Itau twiter api client.
	 *
	 * @param userService  the user service
	 * @param tweetService the tweet service
	 */
	public ItauTwiterApiClientImpl(
		final UserService userService,
		final TweetService tweetService
	) {
		super();

		this.userService = userService;
		this.tweetService = tweetService;
	}

	/**
	 * Gets user service.
	 *
	 * @return the user service
	 */
	public UserService getUserService() {
		return this.userService;
	}

	/**
	 * Sets user service.
	 *
	 * @param userService the user service
	 */
	public void setUserService(final UserService userService) {
		this.userService = userService;
	}

	/**
	 * Gets tweet service.
	 *
	 * @return the tweet service
	 */
	public TweetService getTweetService() {
		return this.tweetService;
	}

	/**
	 * Sets tweet service.
	 *
	 * @param tweetService the tweet service
	 */
	public void setTweetService(final TweetService tweetService) {
		this.tweetService = tweetService;
	}

	/**
	 * Load tweets.
	 */
	public void loadTweets() {
		try {
			var tweetModelSet = new HashSet<TweetModel>();
			var userModelSet = new HashSet<UserModel>();

			for (var tag : ETags.getTagsList()) {
				var query = new Query(tag);
				var queryResult = Twitter4JUtils.getTwitterInstance().search(query);

				if (queryResult.hasNext()) {
					var tweetsStatus = queryResult.getTweets();

					for (var tweetStatusIteration : tweetsStatus) {
						var tweetModel = Twitter4JUtils.convertToTweetModel(tweetStatusIteration);
						var userModel = tweetModel.getUserModel();

						userModel = this.getUserService().save(userModel);
						tweetModel.setUserModel(userModel);
						tweetModel = this.getTweetService().save(tweetModel);
					}
				}
			}
		}
		catch (TwitterException exception) {
			exception.printStackTrace();
		}
	}

}
