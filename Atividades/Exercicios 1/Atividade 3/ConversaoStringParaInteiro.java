import java.util.Scanner;

public class ConversaoStringParaInteiro {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Digite um número inteiro: ");
            String input = scanner.nextLine();

            int numero = Integer.parseInt(input);
            System.out.println("Número digitado: " + numero);
        } catch (NumberFormatException e) {
            System.out.println("Erro: Digite um número inteiro válido.");
        }
    }
}
