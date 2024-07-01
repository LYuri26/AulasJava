public class ContaNinja {
    // Atributos da classe
    private int numeroConta;
    private double saldo;
    private String titular;

    // Construtor da classe
    public ContaNinja(int numeroConta, double saldoInicial, String titular) {
        this.numeroConta = numeroConta;
        this.saldo = saldoInicial;
        this.titular = titular;
    }

    // Método para depositar um valor na conta
    public void depositar(double valor) {
        saldo += valor;
        System.out.println("Depósito de R$" + valor + " realizado com sucesso.");
    }

    // Método para sacar um valor da conta
    public void sacar(double valor) {
        if (valor <= saldo) {
            saldo -= valor;
            System.out.println("Saque de R$" + valor + " realizado com sucesso.");
        } else {
            System.out.println("Saldo insuficiente para realizar o saque de R$" + valor + ".");
        }
    }

    // Método para verificar o saldo da conta
    public double verificarSaldo() {
        return saldo;
    }

    // Método main para testar a classe
    public static void main(String[] args) {
        // Criando uma instância da classe ContaNinja
        ContaNinja contaNinja = new ContaNinja(12345, 1000.0, "Naruto Uzumaki");

        // Realizando operações típicas
        contaNinja.depositar(500.0);
        System.out.println("Saldo após depósito: R$" + contaNinja.verificarSaldo());

        contaNinja.sacar(300.0);
        System.out.println("Saldo após saque: R$" + contaNinja.verificarSaldo());

        contaNinja.sacar(1500.0); // Tentativa de saque acima do saldo disponível
        System.out.println("Saldo após tentativa de saque: R$" + contaNinja.verificarSaldo());
    }
}
