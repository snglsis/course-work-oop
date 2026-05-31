package ua.opnu.labwork4.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {

        return new OpenAPI()
                .info(
                        new Info()
                                .title("Система управління подіями")
                                .version("1.0.0")
                                .description("""
                                        Інформаційна система для управління подіями,
                                        організаторами, залами, будівлями та обладнанням.

                                        Реалізована з використанням:
                                        Spring Boot,
                                        Spring Data JPA,
                                        PostgreSQL,
                                        OpenAPI 3 (Swagger).
                                        """)
                                .contact(
                                        new Contact()
                                                .name("Кафедра інформаційних систем")
                                                .email("student@opnu.ua")
                                )
                );
    }
}