package edu.akanatbekuulu.rabbitmqprocessor.config;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition(
        servers = {
                @Server(url = "http://localhost:8081", description = "local server"),
        },
        info = @Info(title = "Rabbit MQ Processor API",
                description = "Rabbit Mq Processor"),
        tags = {
                @Tag(name = "PUBLISHER_API", description = "API sending Message to RabbitMq"),
        }
)
@Configuration
public class SwaggerConfiguration {
}
