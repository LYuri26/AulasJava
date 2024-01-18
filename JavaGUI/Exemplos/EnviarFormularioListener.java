import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EnviarFormularioListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        // Método chamado quando o botão é clicado

        // Obtém os valores dos campos do painel
        String nome = ((JTextField) ((JPanel) ((JButton) e.getSource()).getParent()).getComponent(1)).getText();
        int idade = Integer
                .parseInt(((JTextField) ((JPanel) ((JButton) e.getSource()).getParent()).getComponent(3)).getText());

        // Exibe uma mensagem com os dados do formulário
        JOptionPane.showMessageDialog(null, "Nome: " + nome + "\nIdade: " + idade);
    }
}
