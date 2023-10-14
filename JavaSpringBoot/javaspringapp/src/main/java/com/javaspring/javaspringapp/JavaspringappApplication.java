package com.javaspring.javaspringapp;

// Importação necessária para usar as classes relacionadas ao Spring Boot.
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// Esta é a classe principal do aplicativo Spring Boot.
@SpringBootApplication
public class JavaspringappApplication {

    // O método main é o ponto de entrada para a aplicação Spring Boot.
    public static void main(String[] args) {
        // Este método inicia a aplicação Spring Boot.
        SpringApplication.run(JavaspringappApplication.class, args);
    }

}
