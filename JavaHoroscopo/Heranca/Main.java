package Heranca; // Este é o pacote onde a classe Main está definida

import java.util.Scanner; // Importa a classe Scanner para permitir entrada de dados pelo usuário

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in); // Cria uma instância de Scanner para ler entrada do usuário

        // Solicita ao usuário para inserir a data de nascimento
        System.out.print("Digite a data no formato dd/mm/aaaa: ");
        String data = scanner.nextLine();

        // Solicita ao usuário para inserir a hora de nascimento
        System.out.print("Digite a hora de nascimento (formato 24h - hh:mm): ");
        String horaNascimento = scanner.nextLine();

        // Solicita ao usuário para inserir a hora do nascer do sol
        System.out.print("Digite a hora do nascer do sol (formato 24h - hh:mm): ");
        String horaNascerDoSol = scanner.nextLine();

        Pessoa pessoa = new Pessoa(data, horaNascimento, horaNascerDoSol);

        String ascendente = pessoa.determinarAscendente(); // Determina o ascendente da pessoa
        String signo = pessoa.determinarSigno(); // Determina o signo da pessoa

        // Exibe o ascendente e o signo calculados
        System.out.println("Ascendente: " + ascendente);
        System.out.println("Signo: " + signo);
    }
}

