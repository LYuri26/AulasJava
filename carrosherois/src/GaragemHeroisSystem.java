import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class GaragemHeroisSystem {
    // Configurações de conexão com o banco de dados
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/garagem_herois";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bem-vindo ao Sistema de Cadastro da Garagem dos Heróis!");

        System.out.print("Quantos produtos deseja cadastrar? ");
        int numProdutos = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer

        for (int i = 0; i < numProdutos; i++) {
            System.out.println("\n--- Cadastro do Produto #" + (i + 1) + " ---");

            System.out.print("Nome do produto: ");
            String nome = scanner.nextLine();

            System.out.print("Descrição do produto: ");
            String descricao = scanner.nextLine();

            System.out.println("Escolha o tipo de produto:");
            System.out.println("1. Carro");
            System.out.println("2. Motor");
            System.out.println("3. Roda");
            System.out.print("Digite o número correspondente: ");
            int tipoProduto = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer

            if (tipoProduto == 1) {
                System.out.print("Modelo do carro: ");
                String modelo = scanner.nextLine();

                System.out.print("Super-herói associado: ");
                String heroiAssociado = scanner.nextLine();

                Carro carro = new Carro(nome, descricao, modelo, heroiAssociado);
                inserirProduto(carro);
            } else if (tipoProduto == 2) {
                System.out.print("Potência do motor (em cavalos): ");
                int potencia = scanner.nextInt();
                scanner.nextLine(); // Limpar o buffer

                Motor motor = new Motor(nome, descricao, potencia);
                inserirProduto(motor);
            } else if (tipoProduto == 3) {
                System.out.print("Material da roda: ");
                String material = scanner.nextLine();

                Roda roda = new Roda(nome, descricao, material);
                inserirProduto(roda);
            } else {
                System.out.println("Opção inválida!");
            }
        }

        System.out.println("\nObrigado por usar o Sistema de Cadastro da Garagem dos Heróis!");
    }

    // Método para criar a tabela no banco de dados
    public static void criarTabela() {
        try (Connection conn = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
                Statement stmt = conn.createStatement()) {

            String createTableSQL = "CREATE TABLE IF NOT EXISTS produtos (" +
                    "id INT AUTO_INCREMENT PRIMARY KEY, " +
                    "nome VARCHAR(100) NOT NULL, " +
                    "descricao VARCHAR(200) NOT NULL, " +
                    "tipo_produto VARCHAR(50) NOT NULL, " +
                    "especifico VARCHAR(100) NOT NULL)";

            stmt.executeUpdate(createTableSQL);
            System.out.println("Tabela verificada/criada com sucesso!");

        } catch (SQLException e) {
            System.out.println("Erro ao criar/verificar a tabela: " + e.getMessage());
        }
    }

    // Método para inserir um produto no banco de dados
    public static void inserirProduto(Veiculo veiculo) {
        criarTabela();

        try (Connection conn = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
                PreparedStatement stmt = conn.prepareStatement(
                        "INSERT INTO produtos(nome, descricao, tipo_produto, especifico) VALUES (?, ?, ?, ?)")) {

            stmt.setString(1, veiculo.getNome());
            stmt.setString(2, veiculo.getDescricao());

            if (veiculo instanceof Carro) {
                Carro carro = (Carro) veiculo;
                stmt.setString(3, "Carro");
                stmt.setString(4, "Modelo: " + carro.getModelo() + ", Herói: " + carro.getHeroiAssociado());
            } else if (veiculo instanceof Motor) {
                Motor motor = (Motor) veiculo;
                stmt.setString(3, "Motor");
                stmt.setString(4, "Potência: " + motor.getPotencia() + " cavalos");
            } else if (veiculo instanceof Roda) {
                Roda roda = (Roda) veiculo;
                stmt.setString(3, "Roda");
                stmt.setString(4, "Material: " + roda.getMaterial());
            }

            stmt.executeUpdate();
            System.out.println("Produto cadastrado com sucesso!");

        } catch (SQLException e) {
            System.out.println("Erro ao inserir o produto: " + e.getMessage());
        }
    }
}