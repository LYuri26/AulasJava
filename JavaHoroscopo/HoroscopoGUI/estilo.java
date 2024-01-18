package HoroscopoGUI;

import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class estilo extends JFrame {

    private JTextField campoData;
    private JTextField campoHoraNascimento;
    private JTextField campoHoraNascerSol;

    private JButton botaoCalcular;

    public estilo() {
        // Configurações do JFrame
        setTitle("Horóscopo GUI");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Personaliza o gradiente de fundo da janela
        setContentPane(new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                // Define o gradiente de verde para verde-água
                g2d.setPaint(new GradientPaint(0, 0, Color.GREEN, getWidth(), getHeight(), new Color(135, 206, 235)));
                g2d.fillRect(0, 0, getWidth(), getHeight());
            }
        });

        // Cria e adiciona componentes ao JFrame
        criarComponentes();

        // Adiciona ouvinte de ação ao botão
        botaoCalcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Método chamado quando o botão é clicado
                calcularHoroscopo();
            }
        });

        // Torna a janela visível
        setVisible(true);
    }

    private void criarComponentes() {
        // Layout do JFrame
        setLayout(new java.awt.FlowLayout());

        // Componentes do formulário
        JLabel rotuloData = new JLabel("Data de Nascimento (dd/mm/aaaa): ");
        campoData = new JTextField(10);
        formatarCampoData(campoData); // Aplica a formatação ao campo de data

        JLabel rotuloHoraNascimento = new JLabel("Hora de Nascimento (hh:mm): ");
        campoHoraNascimento = new JTextField(10);
        formatarCampoHora(campoHoraNascimento); // Aplica a formatação ao campo de hora de nascimento

        JLabel rotuloHoraNascerSol = new JLabel("Hora do Nascer do Sol (hh:mm): ");
        campoHoraNascerSol = new JTextField(10);
        formatarCampoHora(campoHoraNascerSol); // Aplica a formatação ao campo de nascer do sol

        botaoCalcular = new JButton("Calcular");
        personalizarBotao(botaoCalcular);

        // Adiciona os componentes ao JFrame
        add(rotuloData);
        add(campoData);
        add(rotuloHoraNascimento);
        add(campoHoraNascimento);
        add(rotuloHoraNascerSol);
        add(campoHoraNascerSol);
        add(botaoCalcular);
    }

    private void formatarCampoData(JTextField campo) {
        ((AbstractDocument) campo.getDocument()).setDocumentFilter(new DocumentFilter() {
            @Override
            public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr)
                    throws BadLocationException {
                // Adiciona "/" automaticamente após o segundo e o quinto caractere
                if (string.matches("\\d") && offset == 2 || string.matches("\\d") && offset == 5) {
                    string = "/" + string;
                }
                super.insertString(fb, offset, string, attr);
            }

            @Override
            public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs)
                    throws BadLocationException {
                // Adiciona "/" automaticamente após o segundo e o quinto caractere durante a
                // substituição
                if (text.matches("\\d") && offset == 2 || text.matches("\\d") && offset == 5) {
                    text = "/" + text;
                }
                super.replace(fb, offset, length, text, attrs);
            }
        });
    }

    private void formatarCampoHora(JTextField campo) {
        ((AbstractDocument) campo.getDocument()).setDocumentFilter(new DocumentFilter() {
            @Override
            public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr)
                    throws BadLocationException {
                // Adiciona ":" automaticamente após o segundo caractere
                if (string.matches("\\d") && offset == 2) {
                    string = ":" + string;
                }
                super.insertString(fb, offset, string, attr);
            }

            @Override
            public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs)
                    throws BadLocationException {
                // Adiciona ":" automaticamente após o segundo caractere durante a substituição
                if (text.matches("\\d") && offset == 2) {
                    text = ":" + text;
                }
                super.replace(fb, offset, length, text, attrs);
            }
        });
    }

    private void personalizarBotao(JButton botao) {
        botao.setBackground(new Color(0, 0, 255)); // Define a cor de fundo azul
        botao.setForeground(Color.WHITE); // Define a cor do texto como branco
        botao.setFocusPainted(false); // Remove a borda de foco
        botao.setBorderPainted(false); // Remove a borda padrão
        botao.setOpaque(true); // Permite a customização da cor de fundo

        // Adiciona um ouvinte para mudar a cor quando o botão é pressionado
        botao.getModel().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Muda a cor de fundo para verde quando pressionado
                botao.setBackground(new Color(0, 128, 0));
            }
        });
    }

    private void calcularHoroscopo() {
        // Obtém os valores dos campos
        String data = campoData.getText();
        String horaNascimento = campoHoraNascimento.getText();
        String horaNascerSol = campoHoraNascerSol.getText();

        // Cria instâncias das classes 'signo' e 'ascendente'
        signo s = new signo();
        ascendente a = new ascendente();

        // Determina o signo solar usando o objeto 's' da classe 'signo'
        String signoSolar = s.determinarsigno(data);

        // Determina o signo ascendente usando o objeto 'a' da classe 'ascendente'
        String signoAscendente = a.determinarascendente(data, horaNascimento, horaNascerSol);

        // Exibe os resultados em uma caixa de diálogo
        if (!signoSolar.equals("dados inválidos") && !signoAscendente.equals("dados inválidos")) {
            JOptionPane.showMessageDialog(this,
                    "O signo solar é: " + signoSolar + "\nO signo ascendente é: " + signoAscendente);
        } else {
            JOptionPane.showMessageDialog(this, "Dados inválidos");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new estilo());
    }
}
