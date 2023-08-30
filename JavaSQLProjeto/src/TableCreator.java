import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;

public class TableCreator {
    public static void createTables() {
        try (Connection connection = DBConnection.getConnection();
             Statement statement = connection.createStatement()) {

            // Criar tabela de personagens
            String createTableQuery = "CREATE TABLE IF NOT EXISTS personagens (" +
                                     "id INT AUTO_INCREMENT PRIMARY KEY," +
                                     "nome VARCHAR(255)," +
                                     "classe VARCHAR(255)," +
                                     "nivel INT)";
            statement.executeUpdate(createTableQuery);

            System.out.println("Tabela criada com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
