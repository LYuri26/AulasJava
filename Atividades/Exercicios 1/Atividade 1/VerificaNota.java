import java.util.Scanner;

public class VerificaNota {
    public static void main(String[] args) {
        // Criação de um objeto Scanner para leitura da entrada do usuário
        Scanner scanner = new Scanner(System.in);

        // Solicita e lê a nota do aluno
        System.out.print("Digite a nota do aluno: ");
        int nota = scanner.nextInt();

        // Estrutura de controle if-else para verificar a aprovação
        if (nota >= 60) {
            System.out.println("Aluno aprovado!");
        } else {
            System.out.println("Aluno reprovado!");
        }

        // Fecha o scanner para evitar vazamento de recursos
        scanner.close();
    }
}
