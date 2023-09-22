import java.util.Scanner;

public class main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite a data no formato dd/mm/aaaa: ");
        String data = scanner.nextLine();

        System.out.print("Digite a hora de nascimento (formato 24h - hh:mm): ");
        String horaNascimento = scanner.nextLine();

        System.out.print("Digite a hora do nascer do sol (formato 24h - hh:mm): ");
        String horaNascerDoSol = scanner.nextLine();

        signo s = new signo();
        ascendente a = new ascendente();

        String signoSolar = s.determinarsigno(data);
        String signoascendente = a.determinarascendente(data, horaNascimento, horaNascerDoSol);

        if (!signoSolar.equals("Dados inválidos") && !signoascendente.equals("Dados inválidos")) {
            System.out.println("O signo solar é: " + signoSolar);
            System.out.println("O signo ascendente é: " + signoascendente);
        } else {
            System.out.println("Dados inválidos");
        }

        scanner.close();
    }
}
