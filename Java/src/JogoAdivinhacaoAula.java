import java.util.Scanner;
import java.util.Random;

public class JogoAdivinhacaoAula {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int[] numerosSecretos = new int[5];
        for (int i = 0; i < 5; i++) {
            numerosSecretos[i] = random.nextInt(10);
        }

        int tentativasMaximas = 7;
        int tentativas = 0;

        boolean[] numerosRevelados = new boolean[5];

        System.out.println("Bem-vindo ao Jogo de Adivinhação!");
        System.out.println("Tente adivinhar um número de 0 a 9.");

        boolean acertouTodos = false;
        while (tentativas < tentativasMaximas && !acertouTodos) {
            System.out.print("Tentativa " + (tentativas + 1) + ": ");
            int tentativa = scanner.nextInt();

            if (tentativa < 0 || tentativa > 9) {
                System.out.println("Número inválido. Digite um número entre 0 e 9.");
                continue;
            }

            for (int i = 0; i < 5; i++) {
                if (numerosSecretos[i] == tentativa) {
                    numerosRevelados[i] = true;
                }
            }

            for (int i = 0; i < 5; i++) {
                if (numerosRevelados[i]) {
                    System.out.print(numerosSecretos[i]);
                } else {
                    System.out.print("_");
                }
            }

            boolean acertouNumero = false;
            for (int i = 0; i < 5; i++) {
                if (numerosSecretos[i] == tentativa) {
                    acertouNumero = true;
                    break;
                }
            }

            if (acertouNumero) {
                System.out.println("\nParabéns! Você acertou um número secreto!");
                acertouTodos = true;
                acertouTodos = true;
                for (int i = 0; i < 5; i++) {
                    if (!numerosRevelados[i]) {
                        acertouTodos = false;
                        break;
                    }
                }
                if (acertouTodos) {
                    System.out.println("Parabéns! Você acertou todos os números secretos!");
                    scanner.close();
                    return;
                }
            } else {
                System.out.println("\nNenhum número correto encontrado. Tente novamente.");
            }

            tentativas++;
        }

        System.out.println("Você esgotou todas as tentativas. Números secretos:");
        for (int i = 0; i < 5; i++) {
            System.out.print(numerosSecretos[i]);
        }

        System.out.println("");

        scanner.close();
    }
}
