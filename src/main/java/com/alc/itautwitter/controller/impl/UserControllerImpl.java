package com.alc.itautwitter.controller.impl;

import com.alc.itautwitter.controller.base.AbstractItauTwitterModelController;
import com.alc.itautwitter.exceptions.impl.ModelNotFoundException;
import com.alc.itautwitter.exceptions.impl.NullArgumentException;
import com.alc.itautwitter.exceptions.impl.UserNotFoundException;
import com.alc.itautwitter.helper.utils.ItauTwitterUtils;
import com.alc.itautwitter.model.impl.UserModel;
import com.alc.itautwitter.model.impl.TweetModel;
import com.alc.itautwitter.service.base.ItauTwitterService;
import com.alc.itautwitter.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/tags")
public class UserControllerImpl
	extends AbstractItauTwitterModelController<UserModel, Long> {

	@Autowired()
	private UserService service;


	public UserControllerImpl() {
		super();
	}

	@Override()
	public UserService getService() {
		return this.service;
	}

	@Override()
	protected <S extends ItauTwitterService> void setService(final S service) {
		this.service = ((UserService) service);
	}

	@GetMapping(
		name = "tagsFindById",
		value = {"/{id}", "/{id}/"},
		produces = MediaType.APPLICATION_JSON_VALUE
	)
	public ResponseEntity<UserModel> findById(@PathVariable(name="id", required=true) final Long id)
	throws ModelNotFoundException, NullArgumentException {
		if (! (ItauTwitterUtils.validateIdOfModel(id)) ) {
			throw new NullArgumentException("id");
		}

		final var model = this.getService().findById(id);

		if (! (ItauTwitterUtils.validateModelWithId(model)) ) {
			throw new UserNotFoundException(TweetModel.class, id);
		}

		return new ResponseEntity<>(model, HttpStatus.OK);
	}

}
