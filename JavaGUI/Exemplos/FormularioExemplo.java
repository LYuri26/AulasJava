import javax.swing.*;

public class FormularioExemplo extends JFrame {
    public FormularioExemplo() {
        // Configurações do JFrame
        setTitle("Exemplo de Formulário");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Cria e adiciona o painel do formulário ao JFrame
        add(new FormularioPanel());

        // Torna a janela visível
        setVisible(true);
    }

    public static void main(String[] args) {
        // Cria uma instância da classe principal
        SwingUtilities.invokeLater(() -> new FormularioExemplo());
    }
}
