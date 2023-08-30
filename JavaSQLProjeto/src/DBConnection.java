import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static final String jdbcUrl = "jdbc:mysql://localhost:3306/";
    private static final String dbName = "rpg_db";
    private static final String username = "root";
    private static final String password = "";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(jdbcUrl + dbName, username, password);
    }
}
