package com.ecom.app.ws;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@CacheConfig
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket apiDocket(){

        Docket docket = new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.ecom.app.ws"))
                .build();

        return docket;
    }

}
