import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Escolha o tipo de animal:");
        System.out.println("1. Mamifero");
        System.out.println("2. Reptil");
        System.out.println("3. Ave");
        System.out.println("4. Consulta");

        int escolha = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer

        switch (escolha) {
            case 1:
                System.out.print("Digite o nome do animal: ");
                String nomeMamifero = scanner.nextLine();
                System.out.print("Digite a idade do animal: ");
                int idadeMamifero = scanner.nextInt();
                scanner.nextLine(); // Limpar o buffer
                System.out.print("Digite a cor da pelagem do mamífero: ");
                String caracteristicaMamifero = scanner.nextLine();
                Mamifero novoMamifero = new Mamifero(nomeMamifero, idadeMamifero, caracteristicaMamifero);
                novoMamifero.exibirInfo();
                BancoDeDados.inserirAnimal(novoMamifero);

                break;

            case 2:
                System.out.print("Digite o nome do animal: ");
                String nomeReptil = scanner.nextLine();
                System.out.print("Digite a idade do animal: ");
                int idadeReptil = scanner.nextInt();
                scanner.nextLine(); // Limpar o buffer
                System.out.print("Digite a cor da Placa do Reptil: ");
                String caracteristicaReptil = scanner.nextLine();
                Reptil novoReptil = new Reptil(nomeReptil, idadeReptil, caracteristicaReptil);
                novoReptil.exibirInfo();
                BancoDeDados.inserirAnimal(novoReptil);
                break;

            case 3:
                System.out.print("Digite o nome do animal: ");
                String nomeAve = scanner.nextLine();
                System.out.print("Digite a idade do animal: ");
                int idadeAve = scanner.nextInt();
                scanner.nextLine(); // Limpar o buffer
                System.out.print("Digite a cor da Pena da Ave: ");
                String caracteristicaAve = scanner.nextLine();
                Ave novaAve = new Ave(nomeAve, idadeAve, caracteristicaAve);
                novaAve.exibirInfo();
                BancoDeDados.inserirAnimal(novaAve);
                break;

            case 4:
                ConsultaSQL.ConsultaSQL();
                break;

            default:
                System.out.println("Opção inválida.");
                break;
        }
    }
}