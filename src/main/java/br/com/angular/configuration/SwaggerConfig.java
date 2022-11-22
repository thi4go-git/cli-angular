package br.com.angular.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Configuration
@EnableSwagger2
public class SwaggerConfig {


    private Contact contact() {
        // Dados de contato do desenvolvedor
        return new Contact("Thiago Junior", "https://www.linkedin.com/in/thiago-junior-amorim-de-melo-84246a149/", "thi4go19@gmail.com");
    }


    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Serviços Prestados/Clientes API")
                .description("API de Clientes")
                .version("1.0")
                .contact(contact())
                .build();
    }


    @Bean
    public Docket docket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .useDefaultResponseMessages(false)
                .select()
                .apis(RequestHandlerSelectors
                        .basePackage("br.com.angular.rest.controller"))
                .paths(PathSelectors.any())
                .build()
                .securityContexts(Arrays.asList(securityContext()))
                .securitySchemes(Arrays.asList(apiKey()))
                .apiInfo(apiInfo());
    }

    // ----------
    public ApiKey apiKey() {
        return new ApiKey("JWT", "Authorization", "header");
    }

    private List<SecurityReference> defaultAuth() {
        //do pacote springfox.documentation.service
        AuthorizationScope authorizationScope = new AuthorizationScope(
                "global", "accessEverything");
        AuthorizationScope[] scopes = new AuthorizationScope[1];
        scopes[0] = authorizationScope;
        SecurityReference reference = new SecurityReference("JWT", scopes);
        List<SecurityReference> auths = new ArrayList<>();
        auths.add(reference);
        return auths;
    }

    private SecurityContext securityContext() {
        return SecurityContext.builder()
                .securityReferences(defaultAuth())
                .forPaths(PathSelectors.any())
                .build();
    }


}
