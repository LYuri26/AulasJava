import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SimpleJDBCExample {
    public static void main(String[] args) {
        String jdbcUrl = "jdbc:mysql://localhost:3306/test";
        String username = "root";
        String password = "";

        try {
            // Conectar ao banco de dados
            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
            System.out.println("Conexão com o banco de dados estabelecida!");

            // Criar uma declaração SQL
            Statement statement = connection.createStatement();

            // Executar uma consulta
            String sqlQuery = "SELECT * FROM tabela_exemplo";
            ResultSet resultSet = statement.executeQuery(sqlQuery);

            // Processar os resultados
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nome = resultSet.getString("nome");
                System.out.println("ID: " + id + ", Nome: " + nome);
            }

            // Fechar os recursos
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
