package com.alc.itautwitter.model.enums;

import com.alc.itautwitter.helper.utils.ItauTwitterUtils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum ETags {

	OPEN_BANKING("openbanking", "OpenBanking", "Open Banking"),

	API_FIRST("apifirst", "APIFirst", "API First"),

	DEV_OPS("devops", "DevOps", "Development and Operations"),

	CLOUD_FIRST("cloudfirst", "CloudFirst", "Cloud First"),

	MICROSERVICES("microservices", "Microservices", "Microservices"),

	API_GATEWAY("apigateway", "APIGateway", "API Gateway"),

	OAUTH("oauth", "OAuth", "OAuth"),

	SWAGGER("swagger", "Swagger", "Swagger"),

	RAML("raml", "RAML", "RESTful API Modeling Language"),

	OPEN_APIS("openapis", "OpenAPIs", "Open APIs");

	private final String code;

	private final String name;

	private final String description;

	private ETags(final String code, final String name, final String description) {
		this.code = code;
		this.name = name;
		this.description = description;
	}

	public final String getCode() {
		return this.code;
	}

	public final String getName() {
		return this.name;
	}

	public final String getDescription() {
		return this.description;
	}

	public static final ETags loadByCode(final String code) {
		return (
			(ItauTwitterUtils.validateString(code))
				? Arrays.stream(ETags.values()).filter(e -> e.getCode().trim().equalsIgnoreCase(code.trim())).findFirst().orElse(null)
				: null
		);
	}

	public static final ETags loadByName(final String name) {
		return (
			(ItauTwitterUtils.validateString(name))
				? Arrays.stream(ETags.values()).filter(e -> e.getName().trim().equalsIgnoreCase(name.trim())).findFirst().orElse(null)
				: null
		);
	}

	public static final List<String> getTagsList() {
		return Arrays.stream(ETags.values()).map(e -> e.getCode()).collect(Collectors.toList());
	}

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
