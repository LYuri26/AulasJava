import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite a data no formato dd/mm/aaaa: ");
        String dataNascimento = scanner.nextLine();

        System.out.print("Digite a hora de nascimento (formato 24h - hh:mm): ");
        String horaNascimento = scanner.nextLine();

        System.out.print("Digite a hora do nascer do sol (formato 24h - hh:mm): ");
        String horaNascerSol = scanner.nextLine();

        signo calculadoraSigno = new signo();
        ascendente calculadoraAscendente = new ascendente();

        String signoSolar = calculadoraSigno.determinarsigno(dataNascimento);
        String signoAscendente = calculadoraAscendente.determinarascendente(
                dataNascimento, horaNascimento, horaNascerSol);

        if (!signoSolar.equals("dados inválidos") && !signoAscendente.equals("dados inválidos")) {
            System.out.println("\nResultados:");
            System.out.println("Signo Solar: " + signoSolar);
            System.out.println("Signo Ascendente: " + signoAscendente);
        } else {
            System.out.println("Dados inválidos fornecidos. Verifique as informações inseridas.");
        }

        scanner.close();
    }
}