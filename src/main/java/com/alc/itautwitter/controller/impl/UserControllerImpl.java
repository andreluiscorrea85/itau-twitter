package com.alc.itautwitter.controller.impl;

import com.alc.itautwitter.controller.base.AbstractItauTwitterModelController;
import com.alc.itautwitter.model.auxiliary.ResumedUser;
import com.alc.itautwitter.model.impl.UserModel;
import com.alc.itautwitter.service.base.ItauTwitterService;
import com.alc.itautwitter.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import twitter4j.TwitterException;

import java.util.List;

/**
 * The type User controller.
 */
@RestController()
@RequestMapping(value = {"/users"})
public class UserControllerImpl
	extends AbstractItauTwitterModelController<UserModel, Long> {

	@Autowired()
	private UserService service;

	/**
	 * Instantiates a new User controller.
	 */
	public UserControllerImpl() {
		super();
	}

	/**
	 * Gets service.
	 *
	 * @return the service
	 */
	@Override()
	public UserService getService() {
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
		this.service = ((UserService) service);
	}

	/**
	 * Find top 5 user model order by followers count desc response entity.
	 *
	 * @return the response entity
	 *
	 * @throws TwitterException the twitter exception
	 */
	@GetMapping(
		name = "top5Users",
		value = {"/top5Users", "/top5Users/"},
		produces = MediaType.APPLICATION_JSON_VALUE
	)
	public ResponseEntity<List<ResumedUser>> findTop5UserModelOrderByFollowersCountDesc() throws TwitterException {
		var userModelList =  this.getService().findTop5OrderByFollowersCountDesc();

		return new ResponseEntity<>(userModelList, HttpStatus.OK);
	}

}
