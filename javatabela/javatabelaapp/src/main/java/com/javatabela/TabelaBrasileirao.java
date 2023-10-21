package com.javatabela;

import java.util.Scanner; // Importa a classe Scanner do pacote java.util

public class TabelaBrasileirao {

    public static void main(String[] args) {
        // Lista de times do Brasileirão
        String[] times = {
            "América Mineiro", "Athletico-PR", "Atlético Mineiro", "Bahia", "Botafogo",
            "Corinthians", "Coritiba", "Cruzeiro", "Cuiabá", "Flamengo",
            "Fluminense", "Fortaleza", "Goiás", "Grêmio", "Internacional",
            "Palmeiras", "Red Bull Bragantino", "Santos", "São Paulo", "Vasco"
        };

        int[] pontuacoes = new int[times.length]; // Array para armazenar as pontuações

        Scanner scanner = new Scanner(System.in); // Cria um objeto Scanner para leitura de entrada

        while (true) {
            // Exibe o menu principal
            System.out.println("\nEscolha uma opção:");
            System.out.println("1 - Visualizar Tabela");
            System.out.println("2 - Editar Pontuação");
            System.out.println("0 - Sair");

            int opcao = scanner.nextInt(); // Recebe a opção do usuário

            switch (opcao) {
                case 0:
                    scanner.close(); // Fecha o scanner
                    return; // Encerra o programa
                case 1:
                    exibirTabela(times, pontuacoes); // Chama o módulo para exibir a tabela
                    break;
                case 2:
                    editarPontuacao(times, pontuacoes, scanner); // Chama o módulo para editar a pontuação
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente."); // Mensagem para opção inválida
                    break;
            }
        }
    }

    // Módulo para exibir a tabela
    public static void exibirTabela(String[] times, int[] pontuacoes) {
        System.out.println("\nPosição | Time | Pontuação");
        for (int i = 0; i < times.length; i++) {
            System.out.println((i + 1) + "       | " + times[i] + " | " + pontuacoes[i]);
        }
    }

    // Módulo para exibir os times disponíveis para edição
    public static void exibirTimes(String[] times, int[] pontuacoes) {
        for (int i = 0; i < times.length; i++) {
            System.out.println((i + 1) + " - " + times[i] + " | Pontuação: " + pontuacoes[i]);
        }
    }

    // Módulo para editar a pontuação dos times
    public static void editarPontuacao(String[] times, int[] pontuacoes, Scanner scanner) {
        while (true) {
            // Exibe os times disponíveis para edição
            System.out.println("\nTimes disponíveis para edição:");
            exibirTimes(times, pontuacoes);
            System.out.println("Escolha o número do time para editar a pontuação (ou 0 para voltar):");
            int posicao = scanner.nextInt();

            if (posicao == 0) {
                break; // Sai do loop de edição
            }

            if (posicao >= 1 && posicao <= times.length) {
                System.out.println("Digite a nova pontuação para " + times[posicao - 1] + ":");
                int novaPontuacao = scanner.nextInt();

                if (novaPontuacao >= 0) {
                    pontuacoes[posicao - 1] = novaPontuacao; // Atualiza a pontuação
                } else {
                    System.out.println("A pontuação não pode ser negativa.");
                }
            } else {
                System.out.println("Posição inválida. Tente novamente.");
            }

            scanner.nextLine(); // Limpa o buffer do scanner
        }
        ordenarPorPontuacao(times, pontuacoes);
    }

    // Módulo para ordenar os times por pontuação
    public static void ordenarPorPontuacao(String[] times, int[] pontuacoes) {
        for (int i = 0; i < pontuacoes.length - 1; i++) {
            for (int j = i + 1; j < pontuacoes.length; j++) {
                if (pontuacoes[i] < pontuacoes[j]) {
                    // Troca as pontuações
                    int tempPontuacao = pontuacoes[i];
                    pontuacoes[i] = pontuacoes[j];
                    pontuacoes[j] = tempPontuacao;

                    // Troca os times
                    String tempTime = times[i];
                    times[i] = times[j];
                    times[j] = tempTime;
                }
            }
        }
    }
}
