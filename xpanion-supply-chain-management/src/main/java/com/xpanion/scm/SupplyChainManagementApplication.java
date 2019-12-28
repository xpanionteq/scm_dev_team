package com.xpanion.scm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;


@SpringBootApplication
@EnableConfigurationProperties({ com.xpanion.scm.property.FileStorageProperties.class })


public class SupplyChainManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(SupplyChainManagementApplication.class, args);
	}

}
