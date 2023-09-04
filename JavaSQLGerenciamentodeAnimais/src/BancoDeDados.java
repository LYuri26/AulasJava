import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BancoDeDados {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/animais";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public static void inserirAnimal(Animal animal) {
        criarTabela();

        try (Connection conn = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement("INSERT INTO Animais(nome, idade, caracteristica) VALUES (?, ?, ?)")) {

            stmt.setString(1, animal.nome);
            stmt.setInt(2, animal.idade);
            stmt.setString(3, animal.caracteristica);

            stmt.executeUpdate();
            System.out.println("Animal inserido no banco de dados.");

        } catch (SQLException e) {
            System.out.println("Erro ao inserir no banco de dados: " + e.getMessage());
        }
    }

    public static void criarTabela() {
        try (Connection conn = DriverManager.getConnection(JDBC_URL, USER, PASSWORD)) {
            String createTableSQL = "CREATE TABLE IF NOT EXISTS Animais (" +
                    "id INT AUTO_INCREMENT PRIMARY KEY," +
                    "nome VARCHAR(100)," +
                    "idade INT," +
                    "caracteristica VARCHAR(100)" +
                    ")";
            try (PreparedStatement stmt = conn.prepareStatement(createTableSQL)) {
                stmt.executeUpdate();
                System.out.println("Tabela 'Animais' criada com sucesso.");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao criar tabela: " + e.getMessage());
        }
    }
}
