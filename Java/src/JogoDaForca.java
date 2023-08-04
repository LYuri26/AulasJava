package javafxexemplo;


import java.util.Scanner;
import java.util.Random;

public class JogoDaForca {
	public static void main(String[] args) {
    	Scanner scanner = new Scanner(System.in);
    	Random random = new Random();

    	// Lista de palavras secretas
    	String[] palavrasSecretas = { "java", "python", "cplusplus", "javascript", "ruby", "php" };

    	// Escolhe aleatoriamente uma palavra da lista como palavra secreta
    	String palavraSecreta = palavrasSecretas[random.nextInt(palavrasSecretas.length)];

    	// Inicializa um array de caracteres para armazenar as letras descobertas da palavra secreta
    	char[] letrasDescobertas = new char[palavraSecreta.length()];
    	for (int i = 0; i < letrasDescobertas.length; i++) {
        	letrasDescobertas[i] = '_';
    	}

    	// Inicializa o número de vidas
    	int vidas = 6;

    	// Loop principal do jogo
    	while (vidas > 0) {
        	// Exibe o estado atual da palavra com as letras descobertas e as vidas restantes
        	System.out.println("Palavra atual: " + String.valueOf(letrasDescobertas));
        	System.out.println("Vidas restantes: " + vidas);

        	// Solicita ao jogador que digite uma letra
        	System.out.print("Digite uma letra: ");
        	char letra = scanner.next().charAt(0);

        	// Verifica se a letra digitada está na palavra secreta
        	boolean letraDescoberta = false;
        	for (int i = 0; i < palavraSecreta.length(); i++) {
            	if (palavraSecreta.charAt(i) == letra) {
                	letrasDescobertas[i] = letra;
                	letraDescoberta = true;
            	}
        	}

        	// Se a letra não estiver na palavra, diminui uma vida do jogador e exibe uma mensagem
        	if (!letraDescoberta) {
            	vidas--;
            	System.out.println("Letra incorreta. Você perdeu uma vida.");
        	}

        	// Verifica se o jogador acertou todas as letras da palavra secreta
        	boolean palavraCompleta = true;
        	for (int i = 0; i < letrasDescobertas.length; i++) {
            	if (letrasDescobertas[i] == '_') {
                	palavraCompleta = false;
                	break;
            	}
        	}

        	// Se o jogador acertou todas as letras, exibe uma mensagem de parabéns e encerra o jogo
        	if (palavraCompleta) {
            	System.out.println("\nParabéns, você acertou a palavra: " + palavraSecreta);
            	break;
        	}
    	}

    	// Se o jogador esgotar todas as vidas, exibe uma mensagem informando a palavra secreta
    	if (vidas == 0) {
        	System.out.println("\nFim do jogo! A palavra era: " + palavraSecreta);
    	}

    	// Fecha o scanner
    	scanner.close();
	}
}

