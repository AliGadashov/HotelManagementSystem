package com.gadashov.hotelmanagementsystem.config;


import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Author: Ali Gadashov
 * Version: v1.0
 */

@Configuration
public class OpenAPIConfig {

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .info(
                        new Info()
                                .title("Hotel Rest Api")
                                .description("Examples for api")
                                .version("1.0")
                                .contact(
                                        new Contact()
                                            .name("Ali Gadashov")
                                            .email("gadashovali13@gmail.com")
                                                .url("https://github.com/AliGadashov")
                                )
                );
    }

}
