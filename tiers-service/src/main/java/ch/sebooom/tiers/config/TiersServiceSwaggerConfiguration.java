package ch.sebooom.tiers.config;



import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Component
@EnableSwagger2
public class TiersServiceSwaggerConfiguration {
    @Bean
    public Docket swaggerApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("ch.sebooom.tiers.api"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
                "UsersService REST API",
                "API permettant d'interragir avec les tiers de l'application",
                "V1.0",
                "Terms of service",
                new Contact("Seb Chèvre", "github.com/sebChevre", "seb.chevre@gmail.com"),
                "License of API", "API license URL", Collections.emptyList());
    }
}
