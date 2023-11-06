package POO;

import java.util.Scanner;

public class MainHoroscopoPOO {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite a data no formato dd/mm/aaaa: ");
        String data = scanner.nextLine();

        System.out.print("Digite a hora de nascimento (formato 24h - hh:mm): ");
        String horaNascimento = scanner.nextLine();

        System.out.print("Digite a hora do nascer do sol (formato 24h - hh:mm): ");
        String horaNascerSol = scanner.nextLine();

        HoroscopoPOO horoscopo = new HoroscopoPOO();

        String signoSolar = horoscopo.determinarSigno(data);
        String signoAscendente = horoscopo.determinarAscendente(data, horaNascimento, horaNascerSol);

        if (!signoSolar.equals("dados inválidos") && !signoAscendente.equals("dados inválidos")) {
            System.out.println("O signo solar é: " + signoSolar);
            System.out.println("O signo ascendente é: " + signoAscendente);
        } else {
            System.out.println("Dados inválidos");
        }

        scanner.close();
    }
}
