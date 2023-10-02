package com.cryptoinvestment.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Swagger configuration.
 *
 * @author maksim aleksandrov
 */
@Configuration
public class SwaggerConfig {
    @Bean
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
                .group("api")
                .pathsToMatch("/**")
                .build();
    }

    @Bean
    public OpenAPI springCryptoInvestOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("Crypto Investment API")
                        .description("Crypto Investment Project")
                        .version("v0.0.1")
                        .license(new License().name("Apache 2.0")
                                .url("http://springdoc.org")));
    }
}
