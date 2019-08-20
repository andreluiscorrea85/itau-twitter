package com.alc.itautwitter.controller.impl;

import com.alc.itautwitter.apiclient.impl.ItauTwiterApiClientImpl;
import com.alc.itautwitter.controller.base.AbstractItauTwitterController;
import com.alc.itautwitter.service.interfaces.TweetService;
import com.alc.itautwitter.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import twitter4j.TwitterException;

/**
 * The type Itau twitter controller.
 */
@RestController()
@RequestMapping(value = {""})
public class ItauTwitterControllerImpl
	extends AbstractItauTwitterController {

	@Autowired()
	private UserService userService;

	@Autowired()
	private TweetService tweetService;

	/**
	 * Instantiates a new Itau twitter controller.
	 */
	public ItauTwitterControllerImpl() {
		super();
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
	 * Load tweets response entity.
	 *
	 * @return the response entity
	 *
	 * @throws TwitterException the twitter exception
	 */
	@PostMapping(
		name = "loadTweets",
		value = {"/loadTweets", "/loadTweets/"},
		produces = MediaType.APPLICATION_JSON_VALUE
	)
	public ResponseEntity loadTweets() throws TwitterException {
		new ItauTwiterApiClientImpl(this.getUserService(), this.getTweetService()).loadTweets();

		return new ResponseEntity(HttpStatus.CREATED);
	}

}
