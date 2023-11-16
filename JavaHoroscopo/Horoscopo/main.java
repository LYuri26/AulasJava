import java.util.Scanner;

public class main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Solicita ao usuário para inserir a data de nascimento
        System.out.print("Digite a data no formato dd/mm/aaaa: ");
        String data = scanner.nextLine();

        // Solicita ao usuário para inserir a hora de nascimento
        System.out.print("Digite a hora de nascimento (formato 24h - hh:mm): ");
        String horaNascimento = scanner.nextLine();

        // Solicita ao usuário para inserir a hora do nascer do sol
        System.out.print("Digite a hora do nascer do sol (formato 24h - hh:mm): ");
        String horaNascerDoSol = scanner.nextLine();

        // Cria uma instância (objeto) da classe 'signo' para determinar o signo solar
        signo s = new signo();

        // Cria uma instância (objeto) da classe 'ascendente' para determinar o signo ascendente
        ascendente a = new ascendente();

        // Determina o signo solar usando o objeto 's' da classe 'signo'
        String signoSolar = s.determinarsigno(data);

        // Determina o signo ascendente usando o objeto 'a' da classe 'ascendente'
        String signoascendente = a.determinarascendente(data, horaNascimento, horaNascerDoSol);

        // Verifica se os dados inseridos são válidos e imprime os resultados
        if (!signoSolar.equals("dados inválidos") && !signoascendente.equals("dados inválidos")) {
            System.out.println("O signo solar é: " + signoSolar);
            System.out.println("O signo ascendente é: " + signoascendente);
        } else {
            System.out.println("Dados inválidos");
        }

        scanner.close();
    }
}
