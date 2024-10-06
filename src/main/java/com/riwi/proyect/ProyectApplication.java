package com.riwi.proyect;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProyectApplication {

	public static void main(String[] args) {
		// Cargar el archivo .env
		Dotenv dotenv = Dotenv.load();

		// Establecer las propiedades del sistema
		System.setProperty("spring.application.name", dotenv.get("SPRING_APPLICATION_NAME"));
		System.setProperty("spring.datasource.url", dotenv.get("SPRING_DATASOURCE_URL"));
		System.setProperty("spring.datasource.username", dotenv.get("SPRING_DATASOURCE_USERNAME"));
		System.setProperty("spring.datasource.password", dotenv.get("SPRING_DATASOURCE_PASSWORD"));
		System.setProperty("spring.datasource.driver-class-name", dotenv.get("SPRING_DATASOURCE_DRIVER_CLASS_NAME"));
		System.setProperty("spring.jpa.hibernate.ddl-auto", dotenv.get("SPRING_JPA_HIBERNATE_DDL_AUTO"));
		System.setProperty("spring.jpa.show-sql", dotenv.get("SPRING_JPA_SHOW_SQL"));
		System.setProperty("spring.jpa.properties.hibernate.dialect", dotenv.get("SPRING_JPA_PROPERTIES_HIBERNATE_DIALECT"));
		System.setProperty("jwt.secret", dotenv.get("JWT_SECRET"));
		System.setProperty("jwt.expiration", dotenv.get("JWT_EXPIRATION"));
		System.setProperty("cloudinary.cloud.name", dotenv.get("CLOUDINARY_CLOUD_NAME"));
		System.setProperty("cloudinary.api.key", dotenv.get("CLOUDINARY_API_KEY"));
		System.setProperty("cloudinary.api.secret", dotenv.get("CLOUDINARY_API_SECRET"));
		System.setProperty("spring.main.allow-bean-definition-overriding", dotenv.get("SPRING_MAIN_ALLOW_BEAN_DEFINITION_OVERRIDING"));

		SpringApplication.run(ProyectApplication.class, args);
	}

}
