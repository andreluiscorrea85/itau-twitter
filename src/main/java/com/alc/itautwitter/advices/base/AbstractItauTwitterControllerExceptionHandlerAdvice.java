package com.alc.itautwitter.advices.base;

import com.alc.itautwitter.exceptions.base.IException;
import com.alc.itautwitter.exceptions.impl.ItauTwitterException;
import com.alc.itautwitter.helper.constants.ItauTwitterConstants;
import com.alc.itautwitter.helper.utils.ItauTwitterUtils;
import org.springframework.hateoas.VndErrors;
import org.springframework.hateoas.VndErrors.VndError;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.util.WebUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * The type Abstract itau twitter controller exception handler advice.
 */
public abstract class AbstractItauTwitterControllerExceptionHandlerAdvice
	extends Object
	implements ItauTwitterControllerExceptionHandlerAdvice {

	private static final long serialVersionUID = 7636157928345496256L;

	/**
	 * Instantiates a new Abstract itau twitter controller exception handler advice.
	 */
	public AbstractItauTwitterControllerExceptionHandlerAdvice() {
		super();
	}

	/**
	 * Init object.
	 */
	protected void initObject() {

	}

	/**
	 * Handle exception response entity.
	 *
	 * @param <E>       the type parameter
	 * @param exception the exception
	 *
	 * @return the response entity
	 */
	@Override()
	public <E extends Throwable> ResponseEntity<VndErrors> handleException(
		final E exception
	) {
		return this.handleException(exception, null);
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
	@Override()
	public <E extends Throwable> ResponseEntity<VndErrors> handleException(
		final E exception,
		final WebRequest webRequest
	) {
		return this.handleException(exception, null, ItauTwitterConstants.ADVICES_PRODUCES_XML);
	}

	/**
	 * Handle exception response entity.
	 *
	 * @param <E>         the type parameter
	 * @param exception   the exception
	 * @param webRequest  the web request
	 * @param producesXML the produces xml
	 *
	 * @return the response entity
	 */
	@Override()
	public <E extends Throwable> ResponseEntity<VndErrors> handleException(
		final E exception,
		final WebRequest webRequest,
		final boolean producesXML
	) {
		return this.handleException(exception, webRequest, null, producesXML);
	}

	/**
	 * Handle exception response entity.
	 *
	 * @param <E>         the type parameter
	 * @param exception   the exception
	 * @param webRequest  the web request
	 * @param httpStatus  the http status
	 * @param producesXML the produces xml
	 *
	 * @return the response entity
	 */
	@Override()
	public <E extends Throwable> ResponseEntity<VndErrors> handleException(
		final E exception,
		final WebRequest webRequest,
		final HttpStatus httpStatus,
		final boolean producesXML
	) {
		return this.handleException(exception, webRequest, httpStatus, null, null, producesXML);
	}

	/**
	 * Handle exception response entity.
	 *
	 * @param <E>         the type parameter
	 * @param exception   the exception
	 * @param webRequest  the web request
	 * @param httpStatus  the http status
	 * @param logRef      the log ref
	 * @param message     the message
	 * @param producesXML the produces xml
	 *
	 * @return the response entity
	 */
	@Override()
	public <E extends Throwable> ResponseEntity<VndErrors> handleException(
		final E exception,
		final WebRequest webRequest,
		final HttpStatus httpStatus,
		final String logRef,
		final String message,
		final boolean producesXML
	) {
		return this.handleException(exception, null, null, null, httpStatus, logRef, message, producesXML);
	}

	/**
	 * Handle exception response entity.
	 *
	 * @param <E>         the type parameter
	 * @param exception   the exception
	 * @param webRequest  the web request
	 * @param httpBody    the http body
	 * @param httpHeaders the http headers
	 * @param httpStatus  the http status
	 * @param logRef      the log ref
	 * @param message     the message
	 * @param producesXML the produces xml
	 *
	 * @return the response entity
	 */
	@Override()
	public <E extends Throwable> ResponseEntity<VndErrors> handleException(
		final E exception,
		final WebRequest webRequest,
		final VndErrors httpBody,
		final HttpHeaders httpHeaders,
		final HttpStatus httpStatus,
		final String logRef,
		final String message,
		final boolean producesXML
	) {
		if (
			(AbstractItauTwitterControllerExceptionHandlerAdvice.getVerifiedHttpStatus(httpStatus).equals(HttpStatus.INTERNAL_SERVER_ERROR)) &&
			(Objects.nonNull(webRequest))
		) {
			webRequest.setAttribute(
				WebUtils.ERROR_EXCEPTION_ATTRIBUTE,
				exception, RequestAttributes.SCOPE_REQUEST
			);
		}

		return (
			new ResponseEntity<>(
				AbstractItauTwitterControllerExceptionHandlerAdvice.getVerifiedHttpBody(
					exception,
					httpBody,
					logRef,
					message
				),
				AbstractItauTwitterControllerExceptionHandlerAdvice.getVerifiedHttpHeaders(httpHeaders, producesXML),
				AbstractItauTwitterControllerExceptionHandlerAdvice.getVerifiedHttpStatus(httpStatus)
			)
		);
	}

	/**
	 * Gets verified exception.
	 *
	 * @param <E>       the type parameter
	 * @param exception the exception
	 *
	 * @return the verified exception
	 */
	protected static <E extends Throwable> E getVerifiedException(final E exception) {
		return (
			(Objects.nonNull(exception))
				? exception
				: ((E) new ItauTwitterException())
		);
	}

	/**
	 * Gets verified http headers.
	 *
	 * @param httpHeaders the http headers
	 * @param producesXML the produces xml
	 *
	 * @return the verified http headers
	 */
	protected static HttpHeaders getVerifiedHttpHeaders(final HttpHeaders httpHeaders, final boolean producesXML) {
		final HttpHeaders verifiedHttpHeaders;

		if (Objects.nonNull(httpHeaders)) {
			verifiedHttpHeaders = httpHeaders;
		}
		else {
			verifiedHttpHeaders = new HttpHeaders();

			verifiedHttpHeaders.setContentType(
				(producesXML)
					? MediaType.APPLICATION_XML
					: MediaType.APPLICATION_JSON
			);
		}

		return verifiedHttpHeaders;
	}

	/**
	 * Gets verified http status.
	 *
	 * @param httpStatus the http status
	 *
	 * @return the verified http status
	 */
	protected static HttpStatus getVerifiedHttpStatus(final HttpStatus httpStatus) {
		return (
			(Objects.nonNull(httpStatus))
				? httpStatus
				: ItauTwitterConstants.DEFAULT_RESPONSE_ERROR_HTTP_STATUS
		);
	}

	/**
	 * Gets verified log ref.
	 *
	 * @param logRef the log ref
	 *
	 * @return the verified log ref
	 */
	protected static String getVerifiedLogRef(final String logRef) {
		return (
			(ItauTwitterUtils.validateString(logRef))
				? logRef.trim()
				: ItauTwitterConstants.LOG_ERROR
		);
	}

	/**
	 * Gets verified message.
	 *
	 * @param <E>       the type parameter
	 * @param exception the exception
	 * @param message   the message
	 *
	 * @return the verified message
	 */
	protected static <E extends Throwable> String getVerifiedMessage(
		final E exception,
		final String message
	) {
		return (
			(ItauTwitterUtils.validateString(message))
				? message.trim()
				: (!(Objects.nonNull(exception)))
					? ItauTwitterConstants.NOT_IDENTIFIED_EXCEPTION
					: (ItauTwitterUtils.validateString(exception.getMessage()))
						? exception.getMessage().trim()
						: exception.getClass().getSimpleName()
		);
	}

	/**
	 * Gets verified vnd error list.
	 *
	 * @param <E>       the type parameter
	 * @param exception the exception
	 * @param logRef    the log ref
	 * @param message   the message
	 *
	 * @return the verified vnd error list
	 */
	protected static <E extends Throwable> List<VndError> getVerifiedVndErrorList(
		final E exception,
		final String logRef,
		final String message
	) {
		final List<VndError> vndErrorList;
		List<VndError> vndErrorListInternal;

		if (Objects.nonNull(exception)) {
			try {
				vndErrorListInternal = new ArrayList<>();

				final var githubErrorException = ((IException) exception);

				for (final var fieldErrorItemIteration : githubErrorException.getErrors().getFieldErrors()) {
					if (! (ItauTwitterUtils.validateString(fieldErrorItemIteration.getDefaultMessage())) ) {
						continue;
					}
					else {
						final var vndErrorIteration = new VndError(
							fieldErrorItemIteration.getField(),
							(
								(ItauTwitterUtils.validateString(fieldErrorItemIteration.getDefaultMessage()))
									? fieldErrorItemIteration.getDefaultMessage()
									: (Objects.nonNull(fieldErrorItemIteration.getRejectedValue()))
										? fieldErrorItemIteration.getRejectedValue().toString()
										: fieldErrorItemIteration.getField()
							)
						);

						vndErrorListInternal.add(vndErrorIteration);
					}
				}
			}
			catch (final Exception exceptionError) {
				vndErrorListInternal = new ArrayList<>();
			}
		}
		else {
			vndErrorListInternal = null;
		}

		vndErrorList = new ArrayList<>();
		vndErrorList.add(
			new VndError(
				AbstractItauTwitterControllerExceptionHandlerAdvice.getVerifiedLogRef(logRef),
				AbstractItauTwitterControllerExceptionHandlerAdvice.getVerifiedMessage(exception, message)
			)
		);
		vndErrorList.addAll(
			(Objects.nonNull(vndErrorListInternal))
				? vndErrorListInternal
				: new ArrayList<>()
		);

		return vndErrorList;
	}

	/**
	 * Gets verified http body.
	 *
	 * @param <E>       the type parameter
	 * @param exception the exception
	 * @param httpBody  the http body
	 * @param logRef    the log ref
	 * @param message   the message
	 *
	 * @return the verified http body
	 */
	protected static <E extends Throwable> VndErrors getVerifiedHttpBody(
		final E exception,
		final VndErrors httpBody,
		final String logRef,
		final String message
	) {
		return (
			(Objects.nonNull(httpBody))
				? httpBody
				: (
					new VndErrors(
						AbstractItauTwitterControllerExceptionHandlerAdvice.getVerifiedVndErrorList(
							exception,
							logRef,
							message
						)
					)
				)
		);
	}

}
