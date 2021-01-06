package com.vaccnow.vaccservice.configuration;

import java.util.Collection;
import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerDocConfig {
	
	@Bean
	public Docket swaggerConfiguration() {
		
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.paths(PathSelectors.ant("/api/**"))
				.apis(RequestHandlerSelectors.basePackage("com.vaccnow.vaccservice"))
				.build()
				.apiInfo(apiDetails());
	}

	private ApiInfo apiDetails() {
		
		return new ApiInfo(
				"Address book API",
				"API for Vaccnow Vaccination service",
				"1.0",
				null,
				null,
				null,
				null,
				Collections.emptyList());
		
		//return new ApiInfo(
			//	"Address book API",
			//	"API for Vaccnow Vaccination service",
			//	"1.0",
			//	"Free to use",
			//	new springfox.documentation.service.Contact("Bikram Singh", "google.com", "a@b.com"),
			//	"API License",
			//	"Vaccnow.com",
			//	Collections.emptyList());
	}

}
