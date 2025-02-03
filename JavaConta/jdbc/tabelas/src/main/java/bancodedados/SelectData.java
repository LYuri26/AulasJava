package bancodedados;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectData {
    public static void main(String[] args) {
        String query = "SELECT a.FirstName, a.LastName, t.Title FROM Authors a "
                + "JOIN AuthorISBN ai ON a.AuthorID = ai.AuthorID "
                + "JOIN Titles t ON ai.ISBN = t.ISBN";

        try (Connection conn = DatabaseConnection.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                String firstName = rs.getString("FirstName");
                String lastName = rs.getString("LastName");
                String title = rs.getString("Title");

                System.out.printf("Autor: %s %s - Livro: %s%n", firstName, lastName, title);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
