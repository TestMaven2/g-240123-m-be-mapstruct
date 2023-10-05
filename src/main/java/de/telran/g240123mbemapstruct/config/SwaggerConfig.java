package de.telran.g240123mbemapstruct.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(
        info = @Info(
                title = "Swagger test App",
                description = "Application for testing Swagger framework",
                version = "1.0.0",
                contact = @Contact(
                        name = "Test name",
                        email = "test@example.com",
                        url = "http://tel-ran.de"
                )
        )
)
public class SwaggerConfig {
}