package bancodedados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertData {
    public static void main(String[] args) {
        String insertAuthorsSQL = "INSERT INTO Authors (FirstName, LastName) VALUES (?, ?)";
        String insertTitlesSQL = "INSERT INTO Titles (ISBN, Title, EditionNumber, Copyright) VALUES (?, ?, ?, ?)";
        String insertAuthorISBNSQL = "INSERT INTO AuthorISBN (AuthorID, ISBN) VALUES (?, ?)";
        try (Connection conn = DatabaseConnection.getConnection()) {
            // Inserindo dados na tabela Authors
            try (PreparedStatement pstmt = conn.prepareStatement(insertAuthorsSQL)) {
                pstmt.setString(1, "Paul");
                pstmt.setString(2, "Deitel");
                pstmt.executeUpdate();
                pstmt.setString(1, "Harvey");
                pstmt.setString(2, "Deitel");
                pstmt.executeUpdate();
            }
            // Inserindo dados na tabela Titles
            try (PreparedStatement pstmt = conn.prepareStatement(insertTitlesSQL)) {
                pstmt.setString(1, "0132151006");
                pstmt.setString(2, "Java How to Program");
                pstmt.setInt(3, 10);
                pstmt.setInt(4, 2015);
                pstmt.executeUpdate();
            }
            // Inserindo dados na tabela AuthorISBN
            try (PreparedStatement pstmt = conn.prepareStatement(insertAuthorISBNSQL)) {
                pstmt.setInt(1, 1); // AuthorID
                pstmt.setString(2, "0132151006"); // ISBN
                pstmt.executeUpdate();
            }
            System.out.println("Dados inseridos com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
