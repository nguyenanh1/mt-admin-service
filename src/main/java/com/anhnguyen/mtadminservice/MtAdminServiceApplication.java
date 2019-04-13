package com.anhnguyen.mtadminservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;

@SpringBootApplication
@EnableSwagger2
@EnableJpaRepositories(basePackages = "com.anhnguyen.mtadminservice.domain.repo")
@EntityScan("com.anhnguyen.mtadminservice.domain.mysql")
public class MtAdminServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MtAdminServiceApplication.class, args);
    }

    @Bean
    public Docket swaggerPersonApi10() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select().apis(RequestHandlerSelectors.basePackage("com.anhnguyen.mtadminservice.controller"))
                .paths(PathSelectors.any())
                .build().apiInfo(new ApiInfoBuilder().version("1.0").title("Movie Emulater Api")
                        .description("Documentation Movie Emulater API v1.0").build());
    }

}
