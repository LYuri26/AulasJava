import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class JogoAdivinhacao {

	public static void main(String[] args) {
    	Scanner scanner = new Scanner(System.in); // Cria um objeto Scanner para ler a entrada do usuário
    	Random random = new Random(); // Cria um objeto Random para gerar números aleatórios

    	// Inicializa o array para armazenar os números secretos
    	int[] numerosSecretos = new int[10];

    	// Gera os números secretos aleatoriamente e os armazena no array numerosSecretos
    	for (int i = 0; i < 10; i++) {
        	numerosSecretos[i] = random.nextInt(10); // Gera um número aleatório entre 0 e 9
    	}

    	// Número máximo de tentativas permitidas
    	int tentativasMaximas = 5;

    	// Variável para contar as tentativas feitas pelo jogador
    	int tentativas = 0;

    	// Array para controlar quais números já foram revelados pelo jogador
    	boolean[] numerosRevelados = new boolean[10];

    	// Mensagem de boas-vindas e instruções para o jogador
    	System.out.println("Bem-vindo ao Jogo de Adivinhação!");
    	System.out.println("Tente adivinhar um número de 0 a 9999999999.");

    	// Loop principal do jogo, que executa enquanto o número de tentativas for menor
    	// que o máximo e enquanto o jogador não tiver acertado todos os números
    	boolean acertouTodos = false;
    	while (tentativas < tentativasMaximas && !acertouTodos) {
        	System.out.print("Tentativa " + (tentativas + 1) + ": ");

        	// Lê a tentativa do jogador
        	long tentativa = scanner.nextLong();

        	// Verifica se a tentativa está dentro do intervalo válido (0 a 9999999999)
        	if (tentativa < 0 || tentativa > 9999999999L) {
            	System.out.println("Número inválido. Digite um número entre 0 e 9999999999.");
            	continue; // Volta para o início do loop e pede uma nova tentativa
        	}

        	// Verifica se a tentativa acertou algum número e revela os números iguais
        	for (int i = 0; i < 10; i++) {
            	if (numerosSecretos[i] == tentativa) {
                	numerosRevelados[i] = true; // Marca o número como revelado no array numerosRevelados
            	}
        	}

        	// Exibe os números secretos com "_" para as casas não reveladas
        	for (int i = 0; i < 10; i++) {
            	if (numerosRevelados[i]) {
                	System.out.print(numerosSecretos[i]); // Exibe o número se estiver revelado
            	} else {
                	System.out.print("_"); // Exibe "_" se a casa ainda não foi revelada
            	}
        	}

        	// Verifica se a tentativa do jogador é igual aos números secretos
        	if (Arrays.binarySearch(numerosSecretos, (int) tentativa) >= 0) {
            	System.out.println("\nParabéns! Você acertou um número secreto!");
            	acertouTodos = true;
            	// Verifica se o jogador acertou todos os números secretos
            	for (boolean revelado : numerosRevelados) {
                	if (!revelado) {
                    	acertouTodos = false;
                    	break;
                	}
            	}
            	// Se o jogador acertou todos os números, exibe a mensagem de vitória e encerra o programa
            	if (acertouTodos) {
                	System.out.println("Parabéns! Você acertou todos os números secretos!");
                	scanner.close(); // Encerra o Scanner
                	return; // Encerra o programa
            	}
        	} else {
            	System.out.println("\nNenhum número correto encontrado. Tente novamente.");
        	}

        	tentativas++; // Incrementa o número de tentativas
    	}

    	// Se chegou aqui, o jogador esgotou todas as tentativas ou acertou todos os números
    	System.out.println("Você esgotou todas as tentativas. Números secretos:");

    	// Exibe os números secretos
    	for (int i = 0; i < 10; i++) {
        	System.out.print(numerosSecretos[i]);
    	}

    	System.out.println("");

    	scanner.close(); // Encerra o Scanner
	}
}
