package com.formulariogui;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * A classe ConexaoBanco é responsável pela conexão com o banco de dados e
 * operações relacionadas.
 */
public class ConexaoBanco {

    // Informações de conexão com o banco de dados
    private static final String URL = "jdbc:mysql://localhost:3306/formularioguijava";
    private static final String USUARIO = "root";
    private static final String SENHA = "";

    /**
     * Estabelece a conexão com o banco de dados.
     *
     * @return Objeto Connection que representa a conexão estabelecida.
     * @throws SQLException Se ocorrer um erro durante a conexão.
     */
    private static Connection conectarBanco() throws SQLException {
        return DriverManager.getConnection(URL, USUARIO, SENHA);
    }

    /**
     * Cria a tabela "vendas" no banco de dados, se ainda não existir.
     */
    public static void criarTabelaVendas() {
        try {
            // Estabelece a conexão com o banco de dados
            Connection conexao = conectarBanco();

            // Criação da tabela vendas
            Statement statement = conexao.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS vendas (" +
                    "id INT AUTO_INCREMENT PRIMARY KEY," +
                    "nome_cliente VARCHAR(255) NOT NULL," +
                    "data_compra DATE NOT NULL," +
                    "valor_compra DECIMAL(10,2) NOT NULL," +
                    "tipo_pagamento VARCHAR(20) NOT NULL," +
                    "nome_vendedor VARCHAR(255) NOT NULL)";
            statement.executeUpdate(sql);

            // Fecha a conexão
            fecharConexao(conexao);
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.exit(1);
        }
    }

    /**
     * Fecha a conexão com o banco de dados.
     *
     * @param conexao Conexão a ser fechada.
     */
    private static void fecharConexao(Connection conexao) {
        try {
            if (conexao != null && !conexao.isClosed()) {
                conexao.close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Persiste uma venda no banco de dados.
     *
     * @param venda Objeto Venda a ser persistido no banco de dados.
     */
    public static void persistirVenda(Venda venda) {
        try {
            // Estabelece a conexão com o banco de dados
            Connection conexao = conectarBanco();

            // Insere a venda na tabela
            String sql = "INSERT INTO vendas (nome_cliente, data_compra, valor_compra, tipo_pagamento, nome_vendedor) VALUES (?, ?, ?, ?, ?)";
            try (PreparedStatement preparedStatement = conexao.prepareStatement(sql)) {
                preparedStatement.setString(1, venda.getNomeCliente());
                preparedStatement.setString(2, venda.getDataCompra());
                preparedStatement.setDouble(3, venda.getValorCompra());
                preparedStatement.setString(4, venda.getTipoPagamento());
                preparedStatement.setString(5, venda.getNomeVendedor());

                preparedStatement.executeUpdate();
            }

            // Fecha a conexão
            fecharConexao(conexao);
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.exit(1);
        }
    }
}
