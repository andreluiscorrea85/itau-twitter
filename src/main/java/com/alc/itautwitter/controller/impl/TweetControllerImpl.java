package com.alc.itautwitter.controller.impl;

import com.alc.itautwitter.apiclient.impl.TweetApiClientImpl;
import com.alc.itautwitter.controller.base.AbstractItauTwitterModelController;
import com.alc.itautwitter.model.auxiliary.CountPostsByCreatedAtHour;
import com.alc.itautwitter.model.auxiliary.CountPostsByLanguage;
import com.alc.itautwitter.model.impl.TweetModel;
import com.alc.itautwitter.model.impl.UserModel;
import com.alc.itautwitter.service.base.ItauTwitterService;
import com.alc.itautwitter.service.interfaces.TweetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import twitter4j.TwitterException;

import java.util.List;

@RestController()
@RequestMapping("/tweets")
public class TweetControllerImpl
	extends AbstractItauTwitterModelController<TweetModel, Long> {

	@Autowired()
	private TweetService service;

	public TweetControllerImpl() {
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

	@GetMapping(
		name = "loadTweets",
		path = "/loadTweets",
		produces = MediaType.APPLICATION_JSON_VALUE
	)
	public ResponseEntity loadTweets() throws TwitterException {
		new TweetApiClientImpl().loadTweets();

		return new ResponseEntity(HttpStatus.OK);
	}

	@GetMapping(
		name = "top5Users",
		path = "/top5Users",
		produces = MediaType.APPLICATION_JSON_VALUE
	)
	public ResponseEntity<List<UserModel>> findTop5UserModelOrderByFollowersCountDesc() throws TwitterException {
		var userModelList =  this.getService().findTop5UserModelOrderByFollowersCountDesc();

		return new ResponseEntity<>(userModelList, HttpStatus.OK);
	}

	@GetMapping(
		name = "totalPostsGroupByCreatedAtHour",
		path = "/totalPostsGroupByHour",
		produces = MediaType.APPLICATION_JSON_VALUE
	)
	public ResponseEntity<List<CountPostsByCreatedAtHour>> getTotalPostsGroupByCreatedAtHour() throws TwitterException {
		var totalPostsGroupByCreatedAtHourList = this.getService().getTotalPostsGroupByCreatedAtHour();

		return new ResponseEntity<>(totalPostsGroupByCreatedAtHourList, HttpStatus.OK);
	}

	@GetMapping(
		name = "totalPostsGroupByLanguage",
		path = "/totalPostsGroupByLang",
		produces = MediaType.APPLICATION_JSON_VALUE
	)
	public ResponseEntity<List<CountPostsByLanguage>> getTotalPostsGroupByLanguage() throws TwitterException {
		var totalPostsGroupByLanguageList = this.getService().getTotalPostsGroupByLanguage();

		return new ResponseEntity<>(totalPostsGroupByLanguageList, HttpStatus.OK);
	}

}
