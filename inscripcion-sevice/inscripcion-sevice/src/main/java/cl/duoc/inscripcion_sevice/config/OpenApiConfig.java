package cl.duoc.inscripcion_sevice.config;

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
                        .title("Learning Platform - Inscripciones API")
                        .version("1.0")
                        .description(
                                "Microservicio encargado de gestionar las inscripciones de estudiantes."
                        )
                        .contact(new Contact()
                                .name("Kevin")));
    }
}