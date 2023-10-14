package com.javaspring.javaspringapp;

// Importação necessária para usar a interface JpaRepository, que fornece operações de banco de dados comuns.
import org.springframework.data.jpa.repository.JpaRepository;

// Esta interface estende JpaRepository e é parametrizada com a classe Aluno e o tipo da chave primária (Long).
// Isso significa que ela será capaz de lidar com operações de banco de dados relacionadas à entidade Aluno.
public interface AlunoRepository extends JpaRepository<Aluno, Long> {
}

// Esta é a definição da interface AlunoRepository, mas não contém nenhum método adicional.
// A interface JpaRepository já fornece todos os métodos necessários para interagir com o banco de dados, como salvar, excluir, buscar por ID, listar todos, etc.
