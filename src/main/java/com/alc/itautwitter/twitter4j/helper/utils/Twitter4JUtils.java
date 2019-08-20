package com.alc.itautwitter.twitter4j.helper.utils;

import com.alc.itautwitter.helper.constants.ItauTwitterConstants;
import com.alc.itautwitter.helper.utils.ItauTwitterUtils;
import com.alc.itautwitter.model.impl.TweetModel;
import com.alc.itautwitter.model.impl.UserModel;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.TwitterStream;
import twitter4j.TwitterStreamFactory;
import twitter4j.User;

import java.time.LocalDateTime;

/**
 * The type Twitter 4 j utils.
 */
public final class Twitter4JUtils
	extends Object {

	private Twitter4JUtils() {
		super();

		throw new RuntimeException(ItauTwitterConstants.EXCEPTION_MESSAGE_NOT_APPLICABLE);
	}

	/**
	 * Gets twitter instance.
	 *
	 * @return the twitter instance
	 */
	public static final Twitter getTwitterInstance() {
		return TwitterFactory.getSingleton();
	}

	/**
	 * Gets twitter stream instance.
	 *
	 * @return the twitter stream instance
	 */
	public static final TwitterStream getTwitterStreamInstance() {
		return TwitterStreamFactory.getSingleton();
	}

	/**
	 * Convert to user model user model.
	 *
	 * @param from the from
	 *
	 * @return the user model
	 */
	public static final UserModel convertToUserModel(final User from) {
		UserModel userModel;

		if (from != null) {
			userModel = new UserModel();
			userModel.setUserId(from.getId());
			userModel.setScreenName(from.getScreenName());
			userModel.setFollowersCount(from.getFollowersCount());
			userModel.setLanguageLocale(from.getLang());
			userModel.setCreationDateTime(LocalDateTime.now());
		}
		else {
			userModel = null;
		}

		return userModel;
	}

	/**
	 * Convert to tweet model tweet model.
	 *
	 * @param from the from
	 *
	 * @return the tweet model
	 */
	public static final TweetModel convertToTweetModel(final Status from) {
		TweetModel tweetModel;

		if (from != null) {
			tweetModel = new TweetModel();
			tweetModel.setStatusId(from.getId());
			tweetModel.setCreatedAt(ItauTwitterUtils.convertToLocalDateTime(from.getCreatedAt()));
			tweetModel.setText(from.getText());
			tweetModel.setLanguageLocale(from.getLang());
			tweetModel.setUserModel(Twitter4JUtils.convertToUserModel(from.getUser()));
			tweetModel.setCreationDateTime(tweetModel.getUserModel().getCreationDateTime());
		}
		else {
			tweetModel = null;
		}

		return tweetModel;
	}

}
