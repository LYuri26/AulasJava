import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Scanner;
import java.sql.SQLException;

public class IntelSystem {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/intel";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bem-vindo ao Sistema de Cadastro da Intel!");
        System.out.print("Digite o número de produtos que deseja cadastrar: ");
        int numProdutos = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer

        for (int i = 0; i < numProdutos; i++) {
            System.out.println("\nCadastro do Produto #" + (i + 1));
            System.out.print("Digite o nome do produto: ");
            String nome = scanner.nextLine();

            System.out.print("Digite a descrição do produto: ");
            String descricao = scanner.nextLine();

            System.out.println("Escolha o tipo de produto:");
            System.out.println("1. Processador");
            System.out.println("2. Sistema Operacional");
            System.out.println("3. Computador");
            int tipoProduto = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer

            if (tipoProduto == 1) {
                System.out.print("Digite o modelo do processador: ");
                String modelo = scanner.nextLine();
                System.out.print("Digite a velocidade do processador (GHz): ");
                double velocidade = scanner.nextDouble();
                scanner.nextLine(); // Limpar o buffer
                Processador processador = new Processador(nome, descricao, modelo, velocidade);
                inserirProduto(processador);
            } else if (tipoProduto == 2) {
                System.out.print("Digite a versão do sistema operacional: ");
                String versao = scanner.nextLine();
                SistemaOperacional sistemaOperacional = new SistemaOperacional(nome, descricao, versao);
                inserirProduto(sistemaOperacional);
            } else if (tipoProduto == 3) {
                System.out.print("Digite o tipo de computador: ");
                String tipo = scanner.nextLine();
                Computador computador = new Computador(nome, descricao, tipo);
                inserirProduto(computador);
            } else {
                System.out.println("Opção inválida. Produto não cadastrado.");
            }
        }
    }

    public static void criarTabela() {
        try (Connection conn = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
                Statement stmt = conn.createStatement()) {

            String createTableSQL = "CREATE TABLE IF NOT EXISTS produtos (" +
                    "id INT AUTO_INCREMENT PRIMARY KEY," +
                    "nome VARCHAR(100)," +
                    "descricao VARCHAR(200)," +
                    "tipo_produto VARCHAR(50)," +
                    "especifico VARCHAR(100)" +
                    ")";
            stmt.executeUpdate(createTableSQL);
            System.out.println("Tabela 'produtos' criada com sucesso.");

        } catch (SQLException e) {
            System.out.println("Erro ao criar tabela: " + e.getMessage());
        }
    }

    public static void inserirProduto(Produto produto) {
        criarTabela();

        try (Connection conn = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
                PreparedStatement stmt = conn.prepareStatement(
                        "INSERT INTO produtos(nome, descricao, tipo_produto, especifico) VALUES (?, ?, ?, ?)")) {

            stmt.setString(1, produto.getNome());
            stmt.setString(2, produto.getDescricao());

            if (produto instanceof Processador) {
                stmt.setString(3, "Processador");
                stmt.setString(4, "Modelo: " + ((Processador) produto).getModelo() + ", Velocidade: "
                        + ((Processador) produto).getVelocidadeGHz() + " GHz");
            } else if (produto instanceof SistemaOperacional) {
                stmt.setString(3, "Sistema Operacional");
                stmt.setString(4, "Versão: " + ((SistemaOperacional) produto).getVersao());
            } else if (produto instanceof Computador) {
                stmt.setString(3, "Computador");
                stmt.setString(4, "Tipo: " + ((Computador) produto).getTipo());
            }

            stmt.executeUpdate();
            System.out.println("Produto inserido no banco de dados.");

        } catch (SQLException e) {
            System.out.println("Erro ao inserir no banco de dados: " + e.getMessage());
        }
    }
}
