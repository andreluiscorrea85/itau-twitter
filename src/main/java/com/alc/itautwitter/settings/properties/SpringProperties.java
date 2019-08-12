package com.alc.itautwitter.settings.properties;

import com.alc.itautwitter.helper.constants.ItauTwitterConstants;

public final class SpringProperties
	extends Object {

	private SpringProperties() {
		super();

		throw new RuntimeException(ItauTwitterConstants.EXCEPTION_MESSAGE_NOT_APPLICABLE);
	}

	public static final String ComponentScanBasePackage = "com.alc.itautwitter";

	public static final String ComponentScanBasePackageController = "com.alc.itautwitter.controller";
	public static final String ComponentScanBasePackageControllerBase = "com.alc.itautwitter.controller.base";
	public static final String ComponentScanBasePackageControllerImpl = "com.alc.itautwitter.controller.impl";

	public static final String ComponentScanBasePackageSettingsConfig = "com.alc.itautwitter.settings.config";

	public static final String ComponentScanBasePackageSettingsProperties = "com.alc.itautwitter.settings.properties";

	public static final String EntityScanBasePackageModel = "com.alc.itautwitter.model";
	public static final String EntityScanBasePackageModelBase = "com.alc.itautwitter.model.base";
	public static final String EntityScanBasePackageModelImpl = "com.alc.itautwitter.model.impl";

	public static final String EnableJpaRepositoriesBasePackageRepository = "com.alc.itautwitter.repository";
	public static final String EnableJpaRepositoriesBasePackageRepositoryBase = "com.alc.itautwitter.repository.base";
	public static final String EnableJpaRepositoriesBasePackageRepositoryImpl = "com.alc.itautwitter.repository.impl";
	public static final String EnableJpaRepositoriesBasePackageRepositoryInterfaces = "com.alc.itautwitter.repository.interfaces";

}
