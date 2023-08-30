import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CharacterInserter {
    public static void insertCharacter(String nome, String classe, int nivel) {
        String insertQuery = "INSERT INTO personagens (nome, classe, nivel) VALUES (?, ?, ?)";
        
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
            
            preparedStatement.setString(1, nome);
            preparedStatement.setString(2, classe);
            preparedStatement.setInt(3, nivel);
            preparedStatement.executeUpdate();

            System.out.println("Personagem inserido com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
