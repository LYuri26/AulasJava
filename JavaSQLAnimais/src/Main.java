import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Escolha o tipo de animal:");
        System.out.println("1. Cachorro");
        System.out.println("2. Gato");
        int escolha = scanner.nextInt();
        scanner.nextLine();  // Limpar o buffer

        System.out.print("Digite o nome do animal: ");
        String nome = scanner.nextLine();

        System.out.print("Digite a idade do animal: ");
        int idade = scanner.nextInt();
        scanner.nextLine();  // Limpar o buffer

        System.out.print("Digite a raça: ");
        String raca = scanner.nextLine();

        Animal novoAnimal;

        if (escolha == 1) {
            novoAnimal = new Cachorro(nome, idade, raca);
        } else if (escolha == 2) {
            novoAnimal = new Gato(nome, idade, raca);
        } else {
            System.out.println("Opção inválida.");
            return;
        }

        novoAnimal.exibirInfo();

        // Inserir no banco de dados
        BancoDeDados.inserirAnimal(novoAnimal);
    }
}
