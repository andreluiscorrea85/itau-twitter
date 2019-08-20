package com.alc.itautwitter.model.enums;

import com.alc.itautwitter.helper.utils.ItauTwitterUtils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * The enum E tags.
 */
public enum ETags {

	/**
	 * The Open banking.
	 */
	OPEN_BANKING("openbanking", "OpenBanking", "Open Banking"),

	/**
	 * The Api first.
	 */
	API_FIRST("apifirst", "APIFirst", "API First"),

	/**
	 * The Dev ops.
	 */
	DEV_OPS("devops", "DevOps", "Development and Operations"),

	/**
	 * The Cloud first.
	 */
	CLOUD_FIRST("cloudfirst", "CloudFirst", "Cloud First"),

	/**
	 * Microservices e tags.
	 */
	MICROSERVICES("microservices", "Microservices", "Microservices"),

	/**
	 * The Api gateway.
	 */
	API_GATEWAY("apigateway", "APIGateway", "API Gateway"),

	/**
	 * Oauth e tags.
	 */
	OAUTH("oauth", "OAuth", "OAuth"),

	/**
	 * Swagger e tags.
	 */
	SWAGGER("swagger", "Swagger", "Swagger"),

	/**
	 * The Raml.
	 */
	RAML("raml", "RAML", "RESTful API Modeling Language"),

	/**
	 * The Open apis.
	 */
	OPEN_APIS("openapis", "OpenAPIs", "Open APIs");

	private final String code;

	private final String name;

	private final String description;

	private ETags(final String code, final String name, final String description) {
		this.code = code;
		this.name = name;
		this.description = description;
	}

	/**
	 * Gets code.
	 *
	 * @return the code
	 */
	public final String getCode() {
		return this.code;
	}

	/**
	 * Gets name.
	 *
	 * @return the name
	 */
	public final String getName() {
		return this.name;
	}

	/**
	 * Gets description.
	 *
	 * @return the description
	 */
	public final String getDescription() {
		return this.description;
	}

	/**
	 * Load by code e tags.
	 *
	 * @param code the code
	 *
	 * @return the e tags
	 */
	public static final ETags loadByCode(final String code) {
		return (
			(ItauTwitterUtils.validateString(code))
				? Arrays.stream(ETags.values()).filter(e -> e.getCode().trim().equalsIgnoreCase(code.trim())).findFirst().orElse(null)
				: null
		);
	}

	/**
	 * Load by name e tags.
	 *
	 * @param name the name
	 *
	 * @return the e tags
	 */
	public static final ETags loadByName(final String name) {
		return (
			(ItauTwitterUtils.validateString(name))
				? Arrays.stream(ETags.values()).filter(e -> e.getName().trim().equalsIgnoreCase(name.trim())).findFirst().orElse(null)
				: null
		);
	}

	/**
	 * Gets tags list.
	 *
	 * @return the tags list
	 */
	public static final List<String> getTagsList() {
		return Arrays.stream(ETags.values()).map(e -> e.getCode()).collect(Collectors.toList());
	}

	/**
	 * To string string.
	 *
	 * @return the string
	 */
	@Override()
	public String toString() {
		final var stringBuilder = new StringBuilder();

		stringBuilder.append(	this.getClass().getSimpleName()		);
		stringBuilder.append(		"["								);
		stringBuilder.append(			"code="						);
		stringBuilder.append(			this.getCode()				);
		stringBuilder.append(			", "						);
		stringBuilder.append(			"name="						);
		stringBuilder.append(			this.getName()				);
		stringBuilder.append(		"]"								);

		return stringBuilder.toString();
	}

}
