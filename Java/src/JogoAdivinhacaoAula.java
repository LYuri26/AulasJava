//Importa as classes Scanner e Random
import java.util.Scanner;
import java.util.Random;

//Cria a classe JogoAdivinhacaoAula
public class JogoAdivinhacaoAula {

//O método main é o ponto de entrada do programa
public static void main(String[] args) {

//Cria um objeto Scanner para ler as entradas do usuário
Scanner scanner = new Scanner(System.in);

//Cria um objeto Random para gerar números aleatórios
Random random = new Random();

//Cria um array de números secretos
int[] numerosSecretos = new int[5];

//Gera números aleatórios para os números secretos
for (int i = 0; i < 5; i++) {
numerosSecretos[i] = random.nextInt(10);
}

//Define o número máximo de tentativas
int tentativasMaximas = 7;

//Define o número atual de tentativas
int tentativas = 0;

//Cria um array de booleanos para marcar os números revelados
boolean[] numerosRevelados = new boolean[5];

//Imprime a mensagem de boas-vindas
System.out.println("Bem-vindo ao Jogo de Adivinhação!");

//Imprime a mensagem para o usuário adivinhar um número de 0 a 9
System.out.println("Tente adivinhar um número de 0 a 9.");

//O loop continua enquanto o usuário não tiver adivinhado todos os números
while (tentativas < tentativasMaximas && !acertouTodos) {

//Imprime o número da tentativa atual
System.out.print("Tentativa " + (tentativas + 1) + ": ");

//Lê a entrada do usuário
int tentativa = scanner.nextInt();

//Se a entrada do usuário não estiver no intervalo de 0 a 9, imprime uma mensagem de erro e continua
if (tentativa < 0 || tentativa > 9) {
System.out.println("Número inválido. Digite um número entre 0 e 9.");
continue;
}

//Para cada número secreto, se o número secreto for igual à entrada do usuário, marca o número como revelado
for (int i = 0; i < 5; i++) {
if (numerosSecretos[i] == tentativa) {
numerosRevelados[i] = true;
}
}

//Imprime os números secretos, com os números revelados substituídos pelos números reais e os números não revelados substituídos por underscores
for (int i = 0; i < 5; i++) {
if (numerosRevelados[i]) {
System.out.print(numerosSecretos[i]);
} else {
System.out.print("_");
}
}

//Verifica se o usuário acertou um número secreto
boolean acertouNumero = false;
for (int i = 0; i < 5; i++) {
if (numerosSecretos[i] == tentativa) {
acertouNumero = true;
break;
}
}

//Se o usuário acertou um número secreto, imprime uma mensagem de parabéns e marca o número como revelado para todos os números restantes
if (acertouNumero) {
System.out.println("\nParabéns! Você acertou um número secreto!");
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

//Incrementa o número de tentativas
tentativas++;
}

//Se o usuário não tiver adivinhado todos os números em 7 tentativas, imprime uma mensagem de derrota e os números secretos
System.out.println("Você esgotou todas as tentativas. Números secretos:");
for (int i = 0; i < 5; i++) {
System.out.print(numerosSecretos[i]);
}

//Fecha o objeto Scanner
scanner.close();
}
}
