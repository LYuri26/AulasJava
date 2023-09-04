import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConsultaSQL {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/animais";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public static void ConsultaSQL() {

        try (Connection conn = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
                PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Animais");
                ResultSet resultSet = stmt.executeQuery()) {

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nome = resultSet.getString("nome");
                int idade = resultSet.getInt("idade");
                String caracteristica = resultSet.getString("caracteristica");
                System.out.println("ID: " + id);
                System.out.println("Nome: " + nome);
                System.out.println("Idade: " + idade);
                System.out.println("Caracteristica: " + caracteristica);
                System.out.println();
            }

        } catch (SQLException e) {
            System.out.println("Erro ao consultar animais: " + e.getMessage());
        }
    }
}
