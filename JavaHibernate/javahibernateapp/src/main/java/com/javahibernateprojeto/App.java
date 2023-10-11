package com.javahibernateprojeto;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App {
    public static void main(String[] args) {
        // Configurar a fábrica de sessões
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Usuario.class) // Adicione outras classes, se houver
                .buildSessionFactory();

        // Obter uma sessão
        Session session = factory.getCurrentSession();

        try {
            // Começar uma transação
            session.beginTransaction();

            // Criar um novo objeto Usuario
            Usuario usuario = new Usuario();
            usuario.setNome("João");
            usuario.setSobrenome("Silva");
            usuario.setEmail("joao.silva@gmail.com");
            usuario.setTelefone("123456789");

            // Salvar o objeto no banco de dados
            session.save(usuario);

            // Commit da transação
            session.getTransaction().commit();

            System.out.println("Usuário salvo com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Fechar a fábrica de sessões
            factory.close();
        }
    }
}