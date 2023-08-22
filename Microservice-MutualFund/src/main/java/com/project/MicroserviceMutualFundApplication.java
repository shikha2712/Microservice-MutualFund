package com.project;

import java.util.ArrayList;
import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableDiscoveryClient
@EnableSwagger2
public class MicroserviceMutualFundApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceMutualFundApplication.class, args);
		System.out.println("MutualFund Microservice started...");
	}

	
	@Bean
	public Docket swaggerConfiguration()
	{
		ParameterBuilder aParameterBuilder=new ParameterBuilder();
		
		aParameterBuilder.name("Authorization")
		.modelRef(new ModelRef("string"))
		.parameterType("header")
		.defaultValue("Basic i38kdks8x")
		.required(false)
		.build();
		
		java.util.List<Parameter> allParameters=new ArrayList<>();
		
		allParameters.add(aParameterBuilder.build());

		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.paths(PathSelectors.ant("/**")) // this is for all URIs & sub-URIs
				//.paths(PathSelectors.ant("/*")) // this is only for all URIs
				//.paths(PathSelectors("/api/*")) ;; this is for all URIs starting with api
				.apis(RequestHandlerSelectors.basePackage("com.project"))
				.build()
				.globalOperationParameters(allParameters)
				.apiInfo(apiDetails());
	}

	private ApiInfo apiDetails()
	{

		
		return new ApiInfo("MUTUAL FUND MICROSERVICES", 
				"CRUD OPEARTIONS MUTUAL FUND", 
				"1.0", 
				"Free APIs",
				new springfox.documentation.service.Contact("GROUP-5", "GROUP-5.com", "ofss.group5@gmail.com"),
				"API license",
				"http://www.group5.com",
				Collections.emptyList()
				
				);
	}
}
