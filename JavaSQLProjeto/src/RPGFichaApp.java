import java.util.Scanner;

public class RPGFichaApp {
    public static void main(String[] args) {
        TableCreator.createTables();
        
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o nome do personagem: ");
        String nome = scanner.nextLine();
        System.out.print("Digite a classe do personagem: ");
        String classe = scanner.nextLine();
        System.out.print("Digite o nível do personagem: ");
        int nivel = scanner.nextInt();

        CharacterInserter.insertCharacter(nome, classe, nivel);
    }
}
