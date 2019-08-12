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

public abstract class AbstractItauTwitterControllerExceptionHandlerAdvice
	extends Object
	implements ItauTwitterControllerExceptionHandlerAdvice {

	private static final long serialVersionUID = 7636157928345496256L;

	public AbstractItauTwitterControllerExceptionHandlerAdvice() {
		super();
	}

	protected void initObject() {

	}

	@Override()
	public <E extends Throwable> ResponseEntity<VndErrors> handleException(
		final E exception
	) {
		return this.handleException(exception, null);
	}

	@Override()
	public <E extends Throwable> ResponseEntity<VndErrors> handleException(
		final E exception,
		final WebRequest webRequest
	) {
		return this.handleException(exception, null, ItauTwitterConstants.ADVICES_PRODUCES_XML);
	}

	@Override()
	public <E extends Throwable> ResponseEntity<VndErrors> handleException(
		final E exception,
		final WebRequest webRequest,
		final boolean producesXML
	) {
		return this.handleException(exception, webRequest, null, producesXML);
	}

	@Override()
	public <E extends Throwable> ResponseEntity<VndErrors> handleException(
		final E exception,
		final WebRequest webRequest,
		final HttpStatus httpStatus,
		final boolean producesXML
	) {
		return this.handleException(exception, webRequest, httpStatus, null, null, producesXML);
	}

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

	protected static <E extends Throwable> E getVerifiedException(final E exception) {
		return (
			(Objects.nonNull(exception))
				? exception
				: ((E) new ItauTwitterException())
		);
	}

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

	protected static HttpStatus getVerifiedHttpStatus(final HttpStatus httpStatus) {
		return (
			(Objects.nonNull(httpStatus))
				? httpStatus
				: ItauTwitterConstants.DEFAULT_RESPONSE_ERROR_HTTP_STATUS
		);
	}

	protected static String getVerifiedLogRef(final String logRef) {
		return (
			(ItauTwitterUtils.validateString(logRef))
				? logRef.trim()
				: ItauTwitterConstants.LOG_ERROR
		);
	}

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
