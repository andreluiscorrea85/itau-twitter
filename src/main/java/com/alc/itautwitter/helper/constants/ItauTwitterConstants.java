package com.alc.itautwitter.helper.constants;

import org.springframework.http.HttpStatus;

public final class ItauTwitterConstants
	extends Object {

	private ItauTwitterConstants() {
		super();

		throw new RuntimeException(ItauTwitterConstants.EXCEPTION_MESSAGE_NOT_APPLICABLE);
	}

	public static final Class<?> DEFAULT_ID_CLASS = Long.class;

	public static final String TWITTER4J_PREFIX = "twitter4j";

	public static final String TEXT_PLAIN = "text/plain";

	public static final String APPLICATION_VND_ERROR_JSON = "application/vnd.error+json";

	public static final boolean ADVICES_PRODUCES_XML = false;

	public static final String ID = "Id";

	public static final String MODEL = "Model";

	public static final String COLLECTION = "Collection";

	public static final String STRING_EMPTY = "";

	public static final String STRING_SPACE = " ";

	public static final HttpStatus DEFAULT_RESPONSE_ERROR_HTTP_STATUS = HttpStatus.INTERNAL_SERVER_ERROR;

	public static final String EXCEPTION_MESSAGE_NOT_APPLICABLE = "Not Applicable";

	public static final String EXCEPTION_MESSAGE_NOT_FOUND = "Not Found";

	public static final String LOG_ERROR = "Log Error";

	public static final String NOT_IDENTIFIED_EXCEPTION = "Not Identified Exception.";

}
