package com.coding.employee.backend;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Driver;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "OpenAPI",version="1.0",description = "OpenAPI demo for Swagger-UI"))
public class EmployeeBackendApplication {

	public static void main(String[] args) {


		SpringApplication.run(EmployeeBackendApplication.class, args);
		
	}

}
