package com.api.atmsystem.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;

//@Configuration
//@EnableSwagger2
//public class SwaggerConfig {
//
//    @Bean
//    public Docket docket() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .useDefaultResponseMessages(false)
//                .select()
//                .apis(RequestHandlerSelectors
//                        .basePackage("com.api.atmsystem.presentation.controllers"))
//                .paths(PathSelectors.any())
//                .build()
//                .apiInfo(new ApiInfoBuilder()
//                        .title("ATM System API")
//                        .description("API para um sistema de caixa eletrônico")
//                        .version("1.0")
//                        .contact(contact())
//                        .build());
//    }
//
////    private ApiInfo apiInfo() {
////        return new ApiInfoBuilder()
////                .title("ATM System API")
////                .description("API do projeto de para um sistema de caixa eletrônico")
////                .version("1.0")
////                .contact(contact())
////                .build();
////    }
//
//    private Contact contact() {
//        return new Contact("Nataly Lucena Moreira",
//                "https://github.com/moreiranat",
//                "natalylucena.pb@gmail.com");
//    }
//}
