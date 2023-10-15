// Define o pacote no qual a classe está localizada
package com.javaspringprojeto.springjavaapp;

// Importa a classe SpringApplication do Spring Boot
import org.springframework.boot.SpringApplication;

// Importa a anotação que indica que esta classe é uma aplicação Spring Boot
import org.springframework.boot.autoconfigure.SpringBootApplication;

// Indica que esta classe é a classe principal da aplicação
@SpringBootApplication
public class SpringjavaappApplication {

    // Método principal que é chamado quando a aplicação é iniciada
    public static void main(String[] args) {
        // Inicia a aplicação Spring Boot
        SpringApplication.run(SpringjavaappApplication.class, args);
    }
}
