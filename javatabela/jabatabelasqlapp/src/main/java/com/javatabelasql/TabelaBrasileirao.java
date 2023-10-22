package com.javatabelasql; // Declaração do pacote onde a classe está localizada

import java.sql.*; // Importação da biblioteca necessária para trabalhar com JDBC (Java Database Connectivity)
import java.util.Scanner; // Importação da biblioteca para entrada de dados do usuário

public class TabelaBrasileirao { // Início da declaração da classe TabelaBrasileirao

    public static void main(String[] args) { // Início do método main
        // Definição das informações de conexão com o banco de dados
        String DataBase = "brasileirao"; // Nome do banco de dados
        String ServerName = "localhost"; // Endereço do servidor do banco de dados
        String Password = ""; // Senha do banco de dados
        String User = "root"; // Usuário do banco de dados

        try { // Início do bloco try-catch para tratamento de exceções
              // Estabelecendo a conexão com o banco de dados usando JDBC
            Connection conexao = DriverManager.getConnection("jdbc:mysql://" + ServerName + "/" + DataBase, User,
                    Password);

            // Array com os nomes dos times
            String[] times = { // Início da declaração do array de times
                    "América Mineiro", "Athletico-PR", "Atlético Mineiro", "Bahia", "Botafogo",
                    "Corinthians", "Coritiba", "Cruzeiro", "Cuiabá", "Flamengo",
                    "Fluminense", "Fortaleza", "Goiás", "Grêmio", "Internacional",
                    "Palmeiras", "Red Bull Bragantino", "Santos", "São Paulo", "Vasco"
            }; // Fim da declaração do array de times

            // Array para armazenar as pontuações dos times
            int[] pontuacoes = new int[times.length]; // Início da declaração do array de pontuações

            // Criação do objeto Scanner para obter entrada do usuário
            Scanner scanner = new Scanner(System.in); // Início da criação do objeto Scanner

            while (true) { // Início do loop while
                System.out.println("\nEscolha uma opção:"); // Exibição de mensagem no console
                System.out.println("1 - Visualizar Tabela"); // Exibição de mensagem no console
                System.out.println("2 - Editar Pontuação"); // Exibição de mensagem no console
                System.out.println("0 - Sair"); // Exibição de mensagem no console

                int opcao = scanner.nextInt(); // Leitura da opção escolhida pelo usuário

                switch (opcao) { // Início da estrutura de controle switch
                    case 0: // Caso a opção seja 0
                        scanner.close(); // Fechamento do objeto Scanner
                        conexao.close(); // Fechamento da conexão com o banco de dados
                        return; // Retorno para encerrar o programa
                    case 1: // Caso a opção seja 1
                        // Chamada para exibir a tabela de classificação
                        exibirTabela(conexao); // Chamada do método exibirTabela
                        break; // Encerramento do bloco de caso
                    case 2: // Caso a opção seja 2
                        // Chamada para editar a pontuação dos times
                        editarPontuacao(conexao, scanner, times, pontuacoes); // Chamada do método editarPontuacao
                        break; // Encerramento do bloco de caso
                    default: // Caso a opção não seja nenhuma das anteriores
                        System.out.println("Opção inválida. Tente novamente."); // Exibição de mensagem no console
                        break; // Encerramento do bloco de caso
                } // Fim da estrutura de controle switch
            } // Fim do loop while
        } catch (SQLException e) { // Tratamento de exceção para SQLException
            e.printStackTrace(); // Impressão do rastreamento da exceção
        } // Fim do bloco try-catch
    } // Fim do método main

    // Método para exibir a tabela de classificação
    public static void exibirTabela(Connection conexao) { // Início da declaração do método exibirTabela
        try { // Início do bloco try-catch para tratamento de exceções
            Statement statement = conexao.createStatement(); // Criação de uma instrução SQL
            ResultSet resultado = statement.executeQuery("SELECT * FROM times ORDER BY pontuacao DESC"); // Execução da consulta SQL

            System.out.println("\nPosição | Time | Pontuação"); // Exibição de mensagem no console
            int posicao = 1; // Inicialização da variável posicao
            while (resultado.next()) { // Início do loop while para percorrer o resultado
                System.out.println( // Exibição de mensagem no console
                        posicao + "       | " + resultado.getString("nome") + " | " + resultado.getInt("pontuacao")); // Impressão dos dados
                posicao++; // Incremento da variável posicao
            } // Fim do loop while

            resultado.close(); // Fechamento do resultado da consulta
            statement.close(); // Fechamento da instrução SQL
        } catch (SQLException e) { // Tratamento de exceção para SQLException
            e.printStackTrace(); // Impressão do rastreamento da exceção
        } // Fim do bloco try-catch
    } // Fim do método exibirTabela

    // Método para editar a pontuação dos times
    public static void editarPontuacao(Connection conexao, Scanner scanner, String[] times, int[] pontuacoes) { // Início da declaração do método editarPontuacao
        try { // Início do bloco try-catch para tratamento de exceções
            Statement statement = conexao.createStatement(); // Criação de uma instrução SQL

            while (true) { // Início do loop while
                System.out.println("\nTimes disponíveis para edição:"); // Exibição de mensagem no console
                for (int i = 0; i < pontuacoes.length; i++) { // Início do loop for para percorrer o array de pontuações
                    System.out.println((i + 1) + " - " + times[i] + " | Pontuação: " + pontuacoes[i]); // Impressão dos times e pontuações
                } // Fim do loop for
                System.out.println("Escolha o número do time para editar a pontuação (ou 0 para voltar):"); // Exibição de mensagem no console
                int posicao = scanner.nextInt(); // Leitura da posição escolhida pelo usuário

                if (posicao == 0) { // Se a posição for 0
                    break; // Encerra o loop
                }

                System.out.println("Digite a nova pontuação para o time:"); // Exibição de mensagem no console
                int novaPontuacao = scanner.nextInt(); // Leitura da nova pontuação

                if (novaPontuacao >= 0) { // Se a nova pontuação for maior ou igual a zero
                    pontuacoes[posicao - 1] = novaPontuacao; // Atualiza a pontuação no vetor
                    statement.executeUpdate("UPDATE times SET pontuacao = " + novaPontuacao + " WHERE id = " + posicao); // Executa a atualização no banco de dados
                } else { // Se a nova pontuação for negativa
                    System.out.println("A pontuação não pode ser negativa."); // Exibição de mensagem no console
                }
            } // Fim do loop while

            statement.close(); // Fechamento da instrução SQL
        } catch (SQLException e) { // Tratamento de exceção para SQLException
            e.printStackTrace(); // Impressão do rastreamento da exceção
        } // Fim do bloco try-catch
    } // Fim do método editarPontuacao
} // Fim da declaração da classe TabelaBrasileirao
