package com.alc.itautwitter.settings.properties;

import com.alc.itautwitter.helper.constants.ItauTwitterConstants;

/**
 * The type Spring properties.
 */
public final class SpringProperties
	extends Object {

	private SpringProperties() {
		super();

		throw new RuntimeException(ItauTwitterConstants.EXCEPTION_MESSAGE_NOT_APPLICABLE);
	}

	/**
	 * The constant ComponentScanBasePackage.
	 */
	public static final String ComponentScanBasePackage = "com.alc.itautwitter";

	/**
	 * The constant ComponentScanBasePackageController.
	 */
	public static final String ComponentScanBasePackageController = "com.alc.itautwitter.controller";
	/**
	 * The constant ComponentScanBasePackageControllerBase.
	 */
	public static final String ComponentScanBasePackageControllerBase = "com.alc.itautwitter.controller.base";
	/**
	 * The constant ComponentScanBasePackageControllerImpl.
	 */
	public static final String ComponentScanBasePackageControllerImpl = "com.alc.itautwitter.controller.impl";

	/**
	 * The constant ComponentScanBasePackageSettingsConfig.
	 */
	public static final String ComponentScanBasePackageSettingsConfig = "com.alc.itautwitter.settings.config";

	/**
	 * The constant ComponentScanBasePackageSettingsProperties.
	 */
	public static final String ComponentScanBasePackageSettingsProperties = "com.alc.itautwitter.settings.properties";

	/**
	 * The constant EntityScanBasePackageModel.
	 */
	public static final String EntityScanBasePackageModel = "com.alc.itautwitter.model";
	/**
	 * The constant EntityScanBasePackageModelBase.
	 */
	public static final String EntityScanBasePackageModelBase = "com.alc.itautwitter.model.base";
	/**
	 * The constant EntityScanBasePackageModelImpl.
	 */
	public static final String EntityScanBasePackageModelImpl = "com.alc.itautwitter.model.impl";

	/**
	 * The constant EnableJpaRepositoriesBasePackageRepository.
	 */
	public static final String EnableJpaRepositoriesBasePackageRepository = "com.alc.itautwitter.repository";
	/**
	 * The constant EnableJpaRepositoriesBasePackageRepositoryBase.
	 */
	public static final String EnableJpaRepositoriesBasePackageRepositoryBase = "com.alc.itautwitter.repository.base";
	/**
	 * The constant EnableJpaRepositoriesBasePackageRepositoryImpl.
	 */
	public static final String EnableJpaRepositoriesBasePackageRepositoryImpl = "com.alc.itautwitter.repository.impl";
	/**
	 * The constant EnableJpaRepositoriesBasePackageRepositoryInterfaces.
	 */
	public static final String EnableJpaRepositoriesBasePackageRepositoryInterfaces = "com.alc.itautwitter.repository.interfaces";

}
