package com.formulariogui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * A classe FormularioVenda é responsável por criar a interface gráfica do
 * formulário de vendas.
 */
public class FormularioVenda extends JFrame {

    private JTextField campoNomeCliente;
    private JTextField campoValorCompra;
    private JComboBox<String> comboTipoPagamento;
    private JTextField campoNomeVendedor;

    /**
     * Construtor da classe FormularioVenda.
     * Inicializa a interface gráfica e chama o método para criar a tabela no banco
     * de dados.
     */
    public FormularioVenda() {
        setTitle("Formulário de Venda");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        ConexaoBanco.criarTabelaVendas(); // Chama o método para criar a tabela

        criarComponentes();

        setVisible(true);
    }

    /**
     * Cria os componentes da interface gráfica.
     */
    private void criarComponentes() {
        setLayout(new GridLayout(5, 2, 10, 10));

        JLabel rotuloNomeCliente = new JLabel("Nome do Cliente:");
        campoNomeCliente = new JTextField();

        JLabel rotuloValorCompra = new JLabel("Valor da Compra:");
        campoValorCompra = new JTextField();

        JLabel rotuloTipoPagamento = new JLabel("Tipo de Pagamento:");
        String[] opcoesTipoPagamento = { "Crédito", "À Vista", "Dinheiro", "PIX" };
        comboTipoPagamento = new JComboBox<>(opcoesTipoPagamento);

        JLabel rotuloNomeVendedor = new JLabel("Nome do Vendedor:");
        campoNomeVendedor = new JTextField();

        JButton botaoRegistrar = new JButton("Registrar Venda");
        botaoRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registrarVenda();
            }
        });

        add(rotuloNomeCliente);
        add(campoNomeCliente);
        add(rotuloValorCompra);
        add(campoValorCompra);
        add(rotuloTipoPagamento);
        add(comboTipoPagamento);
        add(rotuloNomeVendedor);
        add(campoNomeVendedor);
        add(botaoRegistrar);
    }

    /**
     * Método chamado ao clicar no botão de registrar venda.
     * Captura os dados do formulário, cria uma instância de Venda e persiste no
     * banco de dados.
     */
    private void registrarVenda() {
        try {
            // Cria uma instância da classe Venda
            Venda venda = new Venda(campoNomeCliente.getText(), campoValorCompra.getText(),
                    (String) comboTipoPagamento.getSelectedItem(), campoNomeVendedor.getText());

            // Adiciona o código para persistir a venda no banco de dados
            ConexaoBanco.persistirVenda(venda);

            JOptionPane.showMessageDialog(this, "Venda registrada com sucesso!");
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Erro ao registrar a venda: " + ex.getMessage());
        }
    }

    /**
     * Método main que inicia a aplicação.
     * Carrega o driver JDBC do MySQL e cria uma instância do formulário de vendas.
     */
    public static void main(String[] args) {
        // Carrega o driver JDBC do MySQL
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao carregar o driver JDBC do MySQL");
            System.exit(1);
        }

        // Cria uma instância diretamente no método main
        new FormularioVenda();
    }
}
