package com.alc.itautwitter;

import com.alc.itautwitter.settings.properties.SpringProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * The type Itau twitter application.
 */
@SpringBootApplication(
	scanBasePackages = {
		SpringProperties.ComponentScanBasePackage,
		SpringProperties.ComponentScanBasePackageController,
		SpringProperties.ComponentScanBasePackageControllerBase,
		SpringProperties.ComponentScanBasePackageControllerImpl,
		SpringProperties.ComponentScanBasePackageSettingsConfig,
		SpringProperties.ComponentScanBasePackageSettingsProperties
	}
)
@EntityScan(
	basePackages = {
		SpringProperties.EntityScanBasePackageModel,
		SpringProperties.EntityScanBasePackageModelBase,
		SpringProperties.EntityScanBasePackageModelImpl,
		SpringProperties.ComponentScanBasePackageSettingsConfig,
		SpringProperties.ComponentScanBasePackageSettingsProperties
	}
)
@EnableJpaRepositories(
	basePackages = {
		SpringProperties.EnableJpaRepositoriesBasePackageRepository,
		SpringProperties.EnableJpaRepositoriesBasePackageRepositoryBase,
		SpringProperties.EnableJpaRepositoriesBasePackageRepositoryImpl,
		SpringProperties.EnableJpaRepositoriesBasePackageRepositoryInterfaces
	}
)
@EnableSwagger2()
public class ItauTwitterApplication
extends Object {

	/**
	 * Instantiates a new Itau twitter application.
	 */
	public ItauTwitterApplication() {
		super();
	}

	/**
	 * Main.
	 *
	 * @param args the args
	 */
	public static void main(final String[] args) {
		SpringApplication.run(ItauTwitterApplication.class, args);
	}

}
