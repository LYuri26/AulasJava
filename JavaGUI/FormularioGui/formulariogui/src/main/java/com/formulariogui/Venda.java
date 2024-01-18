package com.formulariogui;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * A classe Venda representa uma transação de venda.
 */
public class Venda {

    private String nomeCliente; // Nome do cliente
    private String dataCompra; // Data da compra formatada como "yyyy-MM-dd"
    private double valorCompra; // Valor da compra
    private String tipoPagamento; // Tipo de pagamento (por exemplo, Crédito, À Vista, Dinheiro, PIX)
    private String nomeVendedor; // Nome do vendedor

    /**
     * Construtor da classe Venda.
     *
     * @param nomeCliente   Nome do cliente.
     * @param valorCompra   Valor da compra (formato String).
     * @param tipoPagamento Tipo de pagamento.
     * @param nomeVendedor  Nome do vendedor.
     */
    public Venda(String nomeCliente, String valorCompra, String tipoPagamento, String nomeVendedor) {
        this.nomeCliente = nomeCliente;
        this.dataCompra = getDataAtualFormatted();
        this.valorCompra = Double.parseDouble(valorCompra);
        this.tipoPagamento = tipoPagamento;
        this.nomeVendedor = nomeVendedor;
    }

    /**
     * Obtém a data atual formatada como "yyyy-MM-dd".
     *
     * @return String representando a data formatada.
     */
    private String getDataAtualFormatted() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(new Date());
    }

    /**
     * Obtém o nome do cliente.
     *
     * @return Nome do cliente.
     */
    public String getNomeCliente() {
        return nomeCliente;
    }

    /**
     * Obtém a data da compra.
     *
     * @return Data da compra formatada como "yyyy-MM-dd".
     */
    public String getDataCompra() {
        return dataCompra;
    }

    /**
     * Obtém o valor da compra.
     *
     * @return Valor da compra.
     */
    public double getValorCompra() {
        return valorCompra;
    }

    /**
     * Obtém o tipo de pagamento.
     *
     * @return Tipo de pagamento.
     */
    public String getTipoPagamento() {
        return tipoPagamento;
    }

    /**
     * Obtém o nome do vendedor.
     *
     * @return Nome do vendedor.
     */
    public String getNomeVendedor() {
        return nomeVendedor;
    }

    /**
     * Sobrescrita do método toString para fornecer uma representação textual da
     * instância de Venda.
     *
     * @return String representando a instância de Venda.
     */
    @Override
    public String toString() {
        return "Venda{" +
                "nomeCliente='" + nomeCliente + '\'' +
                ", dataCompra='" + dataCompra + '\'' +
                ", valorCompra=" + valorCompra +
                ", tipoPagamento='" + tipoPagamento + '\'' +
                ", nomeVendedor='" + nomeVendedor + '\'' +
                '}';
    }
}
