package com.fuad.test;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;

import java.sql.Timestamp;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Configuration
public class SwaggerConfig {
    @Bean
    public Docket admin() {
        Set<String> responseProduceType = new HashSet<>();
        responseProduceType.add(PRODUCE_TYPE);
        return new Docket(DocumentationType.SWAGGER_2)
                .select().apis(RequestHandlerSelectors.basePackage("com.fuad.test.controller.admin"))
                .paths(PathSelectors.any()).build()
                .useDefaultResponseMessages(false)
                .genericModelSubstitutes(ResponseEntity.class)
                .produces(responseProduceType)
                .consumes(responseProduceType)
                .groupName("Admin")
                .apiInfo(apiInfo()).directModelSubstitute(Timestamp.class, Long.class);
    }
    @Bean
    public Docket general() {
        Set<String> responseProduceType = new HashSet<>();
        responseProduceType.add(PRODUCE_TYPE);
        return new Docket(DocumentationType.SWAGGER_2)
                .select().apis(RequestHandlerSelectors.basePackage("com.fuad.test.controller"))
                .paths(PathSelectors.any()).build()
                .useDefaultResponseMessages(false)
                .genericModelSubstitutes(ResponseEntity.class)
                .produces(responseProduceType)
                .consumes(responseProduceType)
                .groupName("GeneralApi")
                .apiInfo(apiInfo()).directModelSubstitute(Timestamp.class, Long.class);
    }
    @SuppressWarnings("deprecation")
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("Spring Boot User CRUD ReST API")
                .description("Spring Boot CRUD REST API")
                .contact("Fuad").license("Apache License")
                .licenseUrl("Fuad").version("2.0").build();
    }

}