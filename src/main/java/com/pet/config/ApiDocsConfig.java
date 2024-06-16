package com.pet.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Configuration;

import static lombok.AccessLevel.PRIVATE;

@OpenAPIDefinition(info = @Info(title = "KY PET Backend API", description = "KY PET API Docs", version = "1.0"))
@Configuration(proxyBeanMethods = false)
@NoArgsConstructor(access = PRIVATE)
public class ApiDocsConfig {

}
