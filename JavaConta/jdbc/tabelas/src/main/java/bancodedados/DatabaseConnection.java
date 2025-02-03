package bancodedados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/";
    private static final String USER = "root";
    private static final String PASSWORD = "";
    public static Connection getConnection() throws SQLException {
        // Primeiro, tentamos conectar ao MySQL
        Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
        // Se a conexão for bem-sucedida, verificamos se o banco de dados 'livros'
        // existe.
        Statement stmt = connection.createStatement();
        String checkDatabaseSQL = "SELECT SCHEMA_NAME FROM INFORMATION_SCHEMA.SCHEMATA WHERE SCHEMA_NAME = 'livros'";
        var resultSet = stmt.executeQuery(checkDatabaseSQL);
        // Se não encontrar o banco de dados, criamos ele.
        if (!resultSet.next()) {
            System.out.println("Banco de dados 'livros' não encontrado. Criando...");
            String createDatabaseSQL = "CREATE DATABASE livros";
            stmt.executeUpdate(createDatabaseSQL);
            System.out.println("Banco de dados 'livros' criado com sucesso!");
        }
        // Agora que o banco de dados existe, retornamos a conexão com o banco 'livros'.
        String databaseURL = "jdbc:mysql://localhost:3306/livros";
        return DriverManager.getConnection(databaseURL, USER, PASSWORD);
    }
}
