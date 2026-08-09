package cl.duoc.curso_service.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {

        return new OpenAPI()
                .info(new Info()
                        .title("Learning Platform API")
                        .version("1.0")
                        .description("Microservicio para la gestión de cursos de una plataforma educativa.")
                        .contact(new Contact()
                                .name("Kevin")
                                .email("kevin@example.com")));
    }
}