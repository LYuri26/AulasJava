package com.javaspring.javaspringapp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

// Esta classe representa um modelo de dados para um Aluno.
// Um modelo de dados é uma representação de um objeto em um aplicativo Java.

// A anotação @Entity indica que esta classe é uma entidade que pode ser mapeada para uma tabela em um banco de dados.
// Com isso, objetos desta classe podem ser persistidos e recuperados usando JPA (Java Persistence API).

@Entity
public class Aluno {

    // O campo 'id' representa a chave primária da entidade.
    // A anotação @Id indica isso para o JPA.
    // A anotação @GeneratedValue(strategy = GenerationType.IDENTITY) especifica que o valor do 'id' será gerado automaticamente pelo banco de dados.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Os campos abaixo representam informações associadas a um aluno.
    // Eles são mapeados diretamente para colunas na tabela correspondente no banco de dados.

    private String nome; // Nome do aluno.
    private String sobrenome; // Sobrenome do aluno.
    private String email; // Endereço de e-mail do aluno.
    private String turma; // Turma à qual o aluno está associado.
    private String turno; // Turno de estudo do aluno (manhã, tarde, noite, etc.).

    // Construtor vazio necessário para a criação de instâncias da classe sem a necessidade de passar argumentos.
    public Aluno() {
    }

    // Construtor para criar uma instância de Aluno com todas as informações.
    public Aluno(String nome, String sobrenome, String email, String turma, String turno) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.email = email;
        this.turma = turma;
        this.turno = turno;
    }

    // Métodos de acesso (getters e setters) para recuperar e definir os valores dos campos da classe.

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTurma() {
        return turma;
    }

    public void setTurma(String turma) {
        this.turma = turma;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }
}
