import java.util.Scanner;

public class RPGDadosSimulador {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o número total de usuários: ");
        int numeroUsuarios = scanner.nextInt();

        System.out.print("Digite o número de dados que cada usuário terá: ");
        int numeroDados = scanner.nextInt();

        // Crie uma matriz para armazenar os dados dos usuários
        DadosRPG[][] matrizDados = new DadosRPG[numeroUsuarios][numeroDados];

        String[] nomesUsuarios = new String[numeroUsuarios];

        // Solicite o nome de cada usuário
        for (int i = 0; i < numeroUsuarios; i++) {
            System.out.print("Digite o nome do usuário " + (i + 1) + ": ");
            nomesUsuarios[i] = scanner.next();
        }

        // Crie os objetos da classe DadosRPG para cada usuário e dado
        for (int i = 0; i < numeroUsuarios; i++) { // Loop para cada usuário
            System.out.println("\nUsuário " + nomesUsuarios[i] + ":");
            for (int j = 0; j < numeroDados; j++) { // Loop para cada dado do usuário
                System.out.print("Digite o número de lados do dado " + (j + 1) + ": ");
                int numeroLados = scanner.nextInt(); // Ler o número de lados do dado
                matrizDados[i][j] = new DadosRPG(numeroLados); // Criar o dado e armazená-lo na matriz
            }
        }

        // Simule rolagens para cada usuário e dado
        for (int i = 0; i < numeroUsuarios; i++) { // Loop para cada usuário
            System.out.println("\nResultados para Usuário " + nomesUsuarios[i] + ":");
            for (int j = 0; j < numeroDados; j++) { // Loop para cada dado do usuário
                System.out.print("Rolagens para dado " + (j + 1) + ": ");
                int numeroRolagens = scanner.nextInt(); // Ler o número de rolagens desejado
                for (int k = 0; k < numeroRolagens; k++) { // Loop para cada rolagem do dado
                    int resultado = matrizDados[i][j].rolar(); // Simular a rolagem do dado
                    System.out.print(resultado + " "); // Exibir o resultado da rolagem
                }
                System.out.println();
            }
        }
    }
}

class DadosRPG {
    private int numeroLados; // Número de lados do dado

    public DadosRPG(int numeroLados) { // Construtor para definir o número de lados do dado
        this.numeroLados = numeroLados;
    }

    public int rolar() { // Método para simular a rolagem do dado
        return (int) (Math.random() * numeroLados) + 1; // Retorna um número aleatório entre 1 e o número de lados
    }
}
