package com.javaspringprojeto.springjavaapp.repository; 
// Aqui é o local onde mora essa interface.

import org.springframework.data.jpa.repository.JpaRepository; 
// Estamos trazendo uma super-interface poderosa do Spring Data JPA. Ela traz um monte de truques legais para mexer com dados no banco.

import com.javaspringprojeto.springjavaapp.model.Cliente; 
// Agora estamos trazendo a classe Cliente para dentro do nosso mundo. Vamos brincar com ela!

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
    // Agora, estamos criando uma nova interface. Ela se chama ClienteRepository e é
    // tipo um super-herói que tem os superpoderes do JpaRepository.
    // E o JpaRepository precisa saber com que tipo de objeto (Cliente) e com que
    // tipo de ID (Integer) ele vai trabalhar.
}
