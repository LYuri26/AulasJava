import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LeituraArquivoInexistente {
    public static void main(String[] args) {
        try {
            File arquivo = new File("arquivo.txt");
            Scanner scanner = new Scanner(arquivo);

            while (scanner.hasNextLine()) {
                String linha = scanner.nextLine();
                System.out.println(linha);
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Erro: Arquivo não encontrado.");
        }
    }
}
