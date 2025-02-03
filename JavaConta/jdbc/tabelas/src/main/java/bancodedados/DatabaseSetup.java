package bancodedados; //este package deve respeitar o nome da sua pasta principal

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseSetup {
    public static void main(String[] args) {
        try (Connection conn = DatabaseConnection.getConnection();
                Statement stmt = conn.createStatement()) {
            String createAuthorsTable = "CREATE TABLE IF NOT EXISTS Authors ("
                    + "AuthorID INT AUTO_INCREMENT PRIMARY KEY, "
                    + "FirstName VARCHAR(50), "
                    + "LastName VARCHAR(50))";
            String createTitlesTable = "CREATE TABLE IF NOT EXISTS Titles ("
                    + "ISBN VARCHAR(13) PRIMARY KEY, "
                    + "Title VARCHAR(100), "
                    + "EditionNumber INT, "
                    + "Copyright INT)";
            String createAuthorISBNTable = "CREATE TABLE IF NOT EXISTS AuthorISBN ("
                    + "AuthorID INT, "
                    + "ISBN VARCHAR(13), "
                    + "PRIMARY KEY (AuthorID, ISBN), "
                    + "FOREIGN KEY (AuthorID) REFERENCES Authors(AuthorID), "
                    + "FOREIGN KEY (ISBN) REFERENCES Titles(ISBN))";
            stmt.executeUpdate(createAuthorsTable);
            stmt.executeUpdate(createTitlesTable);
            stmt.executeUpdate(createAuthorISBNTable);
            System.out.println("Tabelas criadas com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
