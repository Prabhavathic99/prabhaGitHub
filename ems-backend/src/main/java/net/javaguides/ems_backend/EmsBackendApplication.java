package net.javaguides.ems_backend;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "Springboot Employee Management webservice",
				description = "Springboot Employee Management RESTFul Webservice handsOn",
				version = "v1.0",
				contact = @Contact(
						name = "Prabhavathi",
						email = "prabhavathic99@gmail.com"
				),
				license =  @License(
						name = "Employee Management Licence",
						url = "https://github.com/Prabhavathic99/"
				)
		),
		externalDocs = @ExternalDocumentation(
				description = "SpringBoot Employee Management System",
				url = "url.."
		)
)
public class EmsBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmsBackendApplication.class, args);
	}

}
