package com.alc.itautwitter.controller.impl;

import com.alc.itautwitter.controller.base.AbstractItauTwitterModelController;
import com.alc.itautwitter.exceptions.impl.NullArgumentException;
import com.alc.itautwitter.exceptions.impl.TweetNotFoundException;
import com.alc.itautwitter.helper.utils.ItauTwitterUtils;
import com.alc.itautwitter.model.auxiliary.CountPostsByCreatedAtHour;
import com.alc.itautwitter.model.auxiliary.CountPostsByLanguage;
import com.alc.itautwitter.model.impl.TweetModel;
import com.alc.itautwitter.service.base.ItauTwitterService;
import com.alc.itautwitter.service.interfaces.TweetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import twitter4j.TwitterException;

import java.util.List;

/**
 * The type Tweet controller.
 */
@RestController()
@RequestMapping(value = {"/tweets"})
public class TweetControllerImpl
	extends AbstractItauTwitterModelController<TweetModel, Long> {

	@Autowired()
	private TweetService service;

	/**
	 * Instantiates a new Tweet controller.
	 */
	public TweetControllerImpl() {
		super();
	}

	/**
	 * Gets service.
	 *
	 * @return the service
	 */
	@Override()
	public TweetService getService() {
		return this.service;
	}

	/**
	 * Sets service.
	 *
	 * @param <S>     the type parameter
	 * @param service the service
	 */
	@Override()
	protected <S extends ItauTwitterService> void setService(final S service) {
		this.service = ((TweetService) service);
	}

	/**
	 * Gets total posts group by created at hour.
	 *
	 * @return the total posts group by created at hour
	 *
	 * @throws TwitterException the twitter exception
	 */
	@GetMapping(
		name = "totalPostsGroupByCreatedAtHour",
		value = {"/totalPostsGroupByHour", "/totalPostsGroupByHour/"},
		produces = MediaType.APPLICATION_JSON_VALUE
	)
	public ResponseEntity<List<CountPostsByCreatedAtHour>> getTotalPostsGroupByCreatedAtHour() throws TwitterException {
		var totalPostsGroupByCreatedAtHourList = this.getService().getTotalPostsGroupByCreatedAtHour();

		return new ResponseEntity<>(totalPostsGroupByCreatedAtHourList, HttpStatus.OK);
	}

	/**
	 * Gets total posts group by language.
	 *
	 * @return the total posts group by language
	 *
	 * @throws TwitterException the twitter exception
	 */
	@GetMapping(
		name = "totalPostsGroupByLanguage",
		value = {"/totalPostsGroupByLang", "/totalPostsGroupByLang/"},
		produces = MediaType.APPLICATION_JSON_VALUE
	)
	public ResponseEntity<List<CountPostsByLanguage>> getTotalPostsGroupByLanguage() throws TwitterException {
		var totalPostsGroupByLanguageList = this.getService().getTotalPostsGroupByLanguage();

		return new ResponseEntity<>(totalPostsGroupByLanguageList, HttpStatus.OK);
	}

	/**
	 * Find by id response entity.
	 *
	 * @param id the id
	 *
	 * @return the response entity
	 *
	 * @throws TwitterException      the twitter exception
	 * @throws NullArgumentException the null argument exception
	 */
	@GetMapping(
		name = "findById",
		value = {"/{id}", "/{id}/"},
		produces = MediaType.APPLICATION_JSON_VALUE
	)
	public ResponseEntity<TweetModel> findById(
		@PathVariable(name = "id", required = true) final Long id
	) throws TwitterException, NullArgumentException {
		if (! (ItauTwitterUtils.validateIdOfModel(id)) ) {
			throw new NullArgumentException("id");
		}

		var tweetModel = this.getService().findById(id);

		if (! (ItauTwitterUtils.validateModelWithId(tweetModel)) ) {
			throw new TweetNotFoundException(id);
		}

		return new ResponseEntity<>(tweetModel, HttpStatus.OK);
	}

	/**
	 * Create response entity.
	 *
	 * @param tweetModel the tweet model
	 *
	 * @return the response entity
	 *
	 * @throws TwitterException      the twitter exception
	 * @throws NullArgumentException the null argument exception
	 */
	@PostMapping(
		name = "create",
		value = {"", "/"},
		consumes= MediaType.APPLICATION_JSON_VALUE,
		produces = MediaType.APPLICATION_JSON_VALUE
	)
	public ResponseEntity<TweetModel> create(
		@RequestBody() final TweetModel tweetModel
	) throws TwitterException, NullArgumentException {
		if (! (ItauTwitterUtils.validateModel(tweetModel, false, false)) ) {
			throw new NullArgumentException("tweetModel");
		}

		var tweetModelNew = this.getService().save(tweetModel);

		return new ResponseEntity<>(tweetModelNew, HttpStatus.CREATED);
	}

	/**
	 * Update response entity.
	 *
	 * @param id         the id
	 * @param tweetModel the tweet model
	 *
	 * @return the response entity
	 *
	 * @throws TwitterException      the twitter exception
	 * @throws NullArgumentException the null argument exception
	 */
	@PutMapping(
		name = "update",
		value = {"/{id}", "/{id}/"},
		consumes= MediaType.APPLICATION_JSON_VALUE,
		produces = MediaType.APPLICATION_JSON_VALUE
	)
	public ResponseEntity<TweetModel> update(
		@PathVariable(name = "id", required = true) final Long id,
		@RequestBody() final TweetModel tweetModel
	) throws TwitterException, NullArgumentException {
		if (
			(
				! (
					(ItauTwitterUtils.validateIdOfModel(id)) &&
					(ItauTwitterUtils.validateModelWithId(tweetModel))
				)
			) ||
			(id != tweetModel.getId())
		) {
			throw new NullArgumentException("tweetModel");
		}

		var tweetModelNew = this.getService().findById(id);

		if (! (ItauTwitterUtils.validateModelWithId(tweetModelNew)) ) {
			throw new TweetNotFoundException(id);
		}

		return new ResponseEntity<>(tweetModelNew, HttpStatus.OK);
	}

	/**
	 * Delete response entity.
	 *
	 * @param id the id
	 *
	 * @return the response entity
	 *
	 * @throws TwitterException      the twitter exception
	 * @throws NullArgumentException the null argument exception
	 */
	@DeleteMapping(
		name="delete",
		value = {"/{id}", "/{id}/"},
		produces= MediaType.APPLICATION_JSON_VALUE
	)
	public ResponseEntity<TweetModel> delete(
		@PathVariable(name = "id", required = true) final Long id
	) throws TwitterException, NullArgumentException {
		if (! (ItauTwitterUtils.validateIdOfModel(id)) ) {
			throw new NullArgumentException("tweetModel");
		}

		var tweetModelNew = this.getService().findById(id);

		if (! (ItauTwitterUtils.validateModelWithId(tweetModelNew)) ) {
			throw new TweetNotFoundException(id);
		}

		this.getService().deleteById(id);

		return new ResponseEntity<>(HttpStatus.OK);
	}

}
