package com.alc.itautwitter.helper.constants;

import org.springframework.http.HttpStatus;

/**
 * The type Itau twitter constants.
 */
public final class ItauTwitterConstants
	extends Object {

	private ItauTwitterConstants() {
		super();

		throw new RuntimeException(ItauTwitterConstants.EXCEPTION_MESSAGE_NOT_APPLICABLE);
	}

	/**
	 * The constant DEFAULT_ID_CLASS.
	 */
	public static final Class<?> DEFAULT_ID_CLASS = Long.class;

	/**
	 * The constant TWITTER4J_PREFIX.
	 */
	public static final String TWITTER4J_PREFIX = "twitter4j";

	/**
	 * The constant TEXT_PLAIN.
	 */
	public static final String TEXT_PLAIN = "text/plain";

	/**
	 * The constant APPLICATION_VND_ERROR_JSON.
	 */
	public static final String APPLICATION_VND_ERROR_JSON = "application/vnd.error+json";

	/**
	 * The constant ADVICES_PRODUCES_XML.
	 */
	public static final boolean ADVICES_PRODUCES_XML = false;

	/**
	 * The constant ID.
	 */
	public static final String ID = "Id";

	/**
	 * The constant MODEL.
	 */
	public static final String MODEL = "Model";

	/**
	 * The constant COLLECTION.
	 */
	public static final String COLLECTION = "Collection";

	/**
	 * The constant STRING_EMPTY.
	 */
	public static final String STRING_EMPTY = "";

	/**
	 * The constant STRING_SPACE.
	 */
	public static final String STRING_SPACE = " ";

	/**
	 * The constant DEFAULT_RESPONSE_ERROR_HTTP_STATUS.
	 */
	public static final HttpStatus DEFAULT_RESPONSE_ERROR_HTTP_STATUS = HttpStatus.INTERNAL_SERVER_ERROR;

	/**
	 * The constant EXCEPTION_MESSAGE_NOT_APPLICABLE.
	 */
	public static final String EXCEPTION_MESSAGE_NOT_APPLICABLE = "Not Applicable";

	/**
	 * The constant EXCEPTION_MESSAGE_NOT_FOUND.
	 */
	public static final String EXCEPTION_MESSAGE_NOT_FOUND = "Not Found";

	/**
	 * The constant LOG_ERROR.
	 */
	public static final String LOG_ERROR = "Log Error";

	/**
	 * The constant NOT_IDENTIFIED_EXCEPTION.
	 */
	public static final String NOT_IDENTIFIED_EXCEPTION = "Not Identified Exception.";

}
