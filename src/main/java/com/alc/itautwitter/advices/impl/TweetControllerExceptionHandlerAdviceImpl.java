package com.alc.itautwitter.advices.impl;

import com.alc.itautwitter.advices.base.AbstractItauTwitterModelControllerExceptionHandlerAdvice;
import com.alc.itautwitter.controller.impl.TweetControllerImpl;
import com.alc.itautwitter.exceptions.impl.NullArgumentException;
import com.alc.itautwitter.exceptions.impl.TweetCollectionNotFoundException;
import com.alc.itautwitter.exceptions.impl.TweetDuplicateException;
import com.alc.itautwitter.exceptions.impl.TweetNotFoundException;
import com.alc.itautwitter.helper.constants.ItauTwitterConstants;
import com.alc.itautwitter.model.impl.TweetModel;
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

/**
 * The type Tweet controller exception handler advice.
 */
@ControllerAdvice(assignableTypes={TweetControllerImpl.class})
//@RequestMapping(produces={GithubConstants.APPLICATION_VND_ERROR_JSON})
@RequestMapping(produces={MediaType.APPLICATION_JSON_VALUE})
public final class TweetControllerExceptionHandlerAdviceImpl
	extends AbstractItauTwitterModelControllerExceptionHandlerAdvice<TweetModel, Long> {

	private static final long serialVersionUID = 6522383187683708916L;

	/**
	 * Instantiates a new Tweet controller exception handler advice.
	 */
	public TweetControllerExceptionHandlerAdviceImpl() {
		super();
	}

	/**
	 * Handle exception response entity.
	 *
	 * @param <E>        the type parameter
	 * @param exception  the exception
	 * @param webRequest the web request
	 *
	 * @return the response entity
	 */
	@ExceptionHandler(
		value={
			TweetNotFoundException.class,
			TweetCollectionNotFoundException.class,
			TweetDuplicateException.class,
			NullArgumentException.class
		}
	)
	@ResponseBody()
	@Override()
	public <E extends Throwable> ResponseEntity<VndErrors> handleException(final E exception, final WebRequest webRequest) {
		final ResponseEntity<VndErrors> responseEntity;

		if (exception instanceof TweetNotFoundException) {
			responseEntity = this.handleTweetNotFoundException((TweetNotFoundException) exception, webRequest);
		}
		else if (exception instanceof TweetCollectionNotFoundException) {
			responseEntity = this.handleTweetCollectionNotFoundException((TweetCollectionNotFoundException) exception, webRequest);
		}
		else if (exception instanceof TweetDuplicateException) {
			responseEntity = this.handleTweetDuplicateException((TweetDuplicateException) exception, webRequest);
		}
		else if (exception instanceof NullArgumentException) {
			responseEntity = this.handleNullArgumentException((NullArgumentException) exception, webRequest);
		}
		else {
			responseEntity = super.handleException(exception, webRequest, ItauTwitterConstants.ADVICES_PRODUCES_XML);
		}

		return responseEntity;
	}

	private ResponseEntity<VndErrors> handleTweetNotFoundException(
		final TweetNotFoundException exception,
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

	private ResponseEntity<VndErrors> handleTweetCollectionNotFoundException(
		final TweetCollectionNotFoundException exception,
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

	private ResponseEntity<VndErrors> handleTweetDuplicateException(
		final TweetDuplicateException exception,
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
