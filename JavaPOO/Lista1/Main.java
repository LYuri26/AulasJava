import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Jogador[] jogadores = new Jogador[100]; // Array simples com tamanho fixo
        int totalJogadores = 0; // Contador manual

        int opcao;
        do {
            System.out.println("\nMenu:");
            System.out.println("1 - Cadastrar jogador");
            System.out.println("2 - Listar jogadores");
            System.out.println("3 - Alterar número de camisa");
            System.out.println("4 - Fazer gol");
            System.out.println("5 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar buffer

            switch (opcao) {
                case 1: // Cadastrar jogador
                    if (totalJogadores < 100) {
                        System.out.print("Nome do jogador: ");
                        String nome = scanner.nextLine();
                        System.out.print("Posição: ");
                        String posicao = scanner.nextLine();
                        System.out.print("Número: ");
                        int numero = scanner.nextInt();
                        scanner.nextLine(); // Limpar buffer

                        jogadores[totalJogadores] = new Jogador(nome, posicao, numero);
                        totalJogadores++;
                        System.out.println("Jogador cadastrado com sucesso!");
                    } else {
                        System.out.println("Limite de jogadores atingido!");
                    }
                    break;

                case 2: // Listar jogadores
                    System.out.println("\nLista de Jogadores:");
                    for (int i = 0; i < totalJogadores; i++) {
                        System.out.println(jogadores[i].mostrarResumo());
                    }
                    break;

                case 3: // Alterar número
                    if (totalJogadores == 0) {
                        System.out.println("Nenhum jogador cadastrado!");
                        break;
                    }

                    System.out.println("\nJogadores disponíveis:");
                    for (int i = 0; i < totalJogadores; i++) {
                        System.out.println(i + " - " + jogadores[i].mostrarResumo());
                    }

                    System.out.print("Digite o índice do jogador: ");
                    int indice = scanner.nextInt();
                    System.out.print("Novo número: ");
                    int novoNum = scanner.nextInt();

                    if (indice >= 0 && indice < totalJogadores) {
                        if (jogadores[indice].mudarNumero(novoNum)) {
                            System.out.println("Número alterado com sucesso!");
                        } else {
                            System.out.println("Número inválido! Deve ser entre 1 e 99.");
                        }
                    } else {
                        System.out.println("Índice inválido!");
                    }
                    break;

                case 4: // Fazer gol
                    if (totalJogadores == 0) {
                        System.out.println("Nenhum jogador cadastrado!");
                        break;
                    }

                    System.out.println("\nJogadores disponíveis:");
                    for (int i = 0; i < totalJogadores; i++) {
                        System.out.println(i + " - " + jogadores[i].mostrarResumo());
                    }

                    System.out.print("Digite o índice do jogador que fez gol: ");
                    int jogadorGol = scanner.nextInt();
                    if (jogadorGol >= 0 && jogadorGol < totalJogadores) {
                        jogadores[jogadorGol].fazerGol();
                    } else {
                        System.out.println("Índice inválido!");
                    }
                    break;

                case 5: // Sair
                    System.out.println("Saindo do sistema...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 5);

        scanner.close();
    }
}