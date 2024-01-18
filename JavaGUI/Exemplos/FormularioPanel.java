import javax.swing.*;
import java.awt.*;

public class FormularioPanel extends JPanel {
    private JLabel rotuloNome;
    private JTextField campoNome;
    private JLabel rotuloIdade;
    private JTextField campoIdade;
    private JButton botaoEnviar;

    public FormularioPanel() {
        // Cria os componentes do formulário
        rotuloNome = new JLabel("Nome:");
        campoNome = new JTextField(20);

        rotuloIdade = new JLabel("Idade:");
        campoIdade = new JTextField(3);

        botaoEnviar = new JButton("Enviar");

        // Configura o layout do painel
        setLayout(new FlowLayout());

        // Adiciona os componentes ao painel
        add(rotuloNome);
        add(campoNome);
        add(rotuloIdade);
        add(campoIdade);
        add(botaoEnviar);

        // Adiciona o ouvinte de ação ao botão
        botaoEnviar.addActionListener(new EnviarFormularioListener());
    }
}
