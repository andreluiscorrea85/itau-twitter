package com.alc.itautwitter.advices.impl;

import com.alc.itautwitter.advices.base.AbstractItauTwitterModelControllerExceptionHandlerAdvice;
import com.alc.itautwitter.controller.impl.UserControllerImpl;
import com.alc.itautwitter.exceptions.impl.NullArgumentException;
import com.alc.itautwitter.exceptions.impl.UserCollectionNotFoundException;
import com.alc.itautwitter.exceptions.impl.UserDuplicateException;
import com.alc.itautwitter.exceptions.impl.UserNotFoundException;
import com.alc.itautwitter.helper.constants.ItauTwitterConstants;
import com.alc.itautwitter.model.impl.UserModel;
import org.springframework.hateoas.VndErrors;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;

import java.util.Objects;

@ControllerAdvice(assignableTypes={UserControllerImpl.class})
//@RequestMapping(produces={GithubConstants.APPLICATION_VND_ERROR_JSON})
@RequestMapping(produces={MediaType.APPLICATION_JSON_VALUE})
public final class UserControllerExceptionHandlerAdviceImpl
	extends AbstractItauTwitterModelControllerExceptionHandlerAdvice<UserModel, Long> {

	private static final long serialVersionUID = -5718603865921483639L;

	public UserControllerExceptionHandlerAdviceImpl() {
		super();
	}

	@ExceptionHandler(
		value={
			UserNotFoundException.class,
			UserCollectionNotFoundException.class,
			UserDuplicateException.class,
			NullArgumentException.class
		}
	)
	@ResponseBody()
	@Override()
	public <E extends Throwable> ResponseEntity<VndErrors> handleException(final E exception, final WebRequest webRequest) {
		final ResponseEntity<VndErrors> responseEntity;

		if (exception instanceof UserNotFoundException) {
			responseEntity = this.handleUserNotFoundException((UserNotFoundException) exception, webRequest);
		}
		else if (exception instanceof UserCollectionNotFoundException) {
			responseEntity = this.handleUserCollectionNotFoundException((UserCollectionNotFoundException) exception, webRequest);
		}
		else if (exception instanceof UserDuplicateException) {
			responseEntity = this.handleUserDuplicateException((UserDuplicateException) exception, webRequest);
		}
		else if (exception instanceof NullArgumentException) {
			responseEntity = this.handleNullArgumentException((NullArgumentException) exception, webRequest);
		}
		else {
			responseEntity = super.handleException(exception, webRequest, ItauTwitterConstants.ADVICES_PRODUCES_XML);
		}

		return responseEntity;
	}

	private ResponseEntity<VndErrors> handleUserNotFoundException(
		final UserNotFoundException exception,
		final WebRequest webRequest
	) {
		return (
			super.handleException(
				exception,
				webRequest,
				HttpStatus.NOT_FOUND,
				ItauTwitterConstants.ID,
				exception.getIdAsString(),
				ItauTwitterConstants.ADVICES_PRODUCES_XML
			)
		);
	}

	private ResponseEntity<VndErrors> handleUserCollectionNotFoundException(
		final UserCollectionNotFoundException exception,
		final WebRequest webRequest
	) {
		return (
			super.handleException(
				exception,
				webRequest,
				HttpStatus.NOT_FOUND,
				ItauTwitterConstants.ADVICES_PRODUCES_XML
			)
		);
	}

	private ResponseEntity<VndErrors> handleUserDuplicateException(
		final UserDuplicateException exception,
		final WebRequest webRequest
	) {
		return (
			super.handleException(
				exception,
				webRequest,
				HttpStatus.BAD_REQUEST,
			ItauTwitterConstants.ID,
				exception.getIdAsString(),
				ItauTwitterConstants.ADVICES_PRODUCES_XML
			)
		);
	}

	private ResponseEntity<VndErrors> handleNullArgumentException(
		final NullArgumentException exception,
		final WebRequest webRequest
	) {
		return (
			super.handleException(
				exception,
				webRequest,
				HttpStatus.BAD_REQUEST,
				null,
				(
					(Objects.nonNull(exception))
						? exception.getLocalizedMessage()
						: null
				),
				ItauTwitterConstants.ADVICES_PRODUCES_XML
			)
		);
	}

}
