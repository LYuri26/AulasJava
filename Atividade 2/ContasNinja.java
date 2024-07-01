public class ContasNinja {
    public static class ContaShinobi {
        // Atributos da classe ContaShinobi
        private int numeroConta;
        private double saldo;
        private String titular;
        private double limiteJutsus;

        // Construtor da classe ContaShinobi
        public ContaShinobi(int numeroConta, double saldoInicial, String titular, double limiteJutsus) {
            this.numeroConta = numeroConta;
            this.saldo = saldoInicial;
            this.titular = titular;
            this.limiteJutsus = limiteJutsus;
        }

        // Método para depositar um valor na conta
        public void depositar(double valor) {
            saldo += valor;
            System.out.println("Depósito de " + valor + " jutsus realizado com sucesso.");
        }

        // Método para sacar um valor da conta, considerando o limite de jutsus disponíveis
        public void sacar(double valor) {
            if (valor <= saldo + limiteJutsus) {
                saldo -= valor;
                System.out.println("Saque de " + valor + " jutsus realizado com sucesso.");
            } else {
                System.out.println("Saldo insuficiente para realizar o saque de " + valor + " jutsus.");
            }
        }

        // Método para verificar o saldo da conta
        public double verificarSaldo() {
            return saldo;
        }

        // Método para imprimir os dados da conta shinobi
        public void imprimirDados() {
            System.out.println("=== Dados da Conta Shinobi ===");
            System.out.println("Número da Conta: " + numeroConta);
            System.out.println("Titular: " + titular);
            System.out.println("Saldo: " + saldo + " jutsus");
            System.out.println("Limite de Jutsus: " + limiteJutsus + " jutsus");
            System.out.println("==============================");
        }
    }

    public static class ContaHokage {
        // Atributos da classe ContaHokage
        private int numeroConta;
        private double saldo;
        private String titular;
        private boolean autorizacaoEspecial;

        // Construtor da classe ContaHokage
        public ContaHokage(int numeroConta, double saldoInicial, String titular, boolean autorizacaoEspecial) {
            this.numeroConta = numeroConta;
            this.saldo = saldoInicial;
            this.titular = titular;
            this.autorizacaoEspecial = autorizacaoEspecial;
        }

        // Método para depositar um valor na conta Hokage
        public void depositar(double valor) {
            saldo += valor;
            System.out.println("Depósito de R$" + valor + " realizado com sucesso.");
        }

        // Método para sacar um valor da conta Hokage, com controle rigoroso de verba autorizada
        public void sacar(double valor) {
            if (autorizacaoEspecial) {
                saldo -= valor;
                System.out.println("Saque de R$" + valor + " realizado com sucesso.");
            } else {
                System.out.println("Operação não autorizada. Consulte a autorização especial.");
            }
        }

        // Método para verificar o saldo da conta Hokage
        public double verificarSaldo() {
            return saldo;
        }

        // Método para imprimir os dados da conta Hokage
        public void imprimirDados() {
            System.out.println("=== Dados da Conta Hokage ===");
            System.out.println("Número da Conta: " + numeroConta);
            System.out.println("Titular: " + titular);
            System.out.println("Saldo: R$" + saldo);
            System.out.println("Autorização Especial: " + (autorizacaoEspecial ? "Sim" : "Não"));
            System.out.println("=============================");
        }
    }

    // Método main para testar as classes ContaShinobi e ContaHokage
    public static void main(String[] args) {
        // Criando uma instância da classe ContaShinobi
        ContaShinobi contaShinobi = new ContaShinobi(1001, 1000.0, "Naruto Uzumaki", 500.0);

        // Realizando operações típicas na conta shinobi
        contaShinobi.depositar(300.0);
        System.out.println("Saldo após depósito: " + contaShinobi.verificarSaldo() + " jutsus");

        contaShinobi.sacar(200.0);
        System.out.println("Saldo após saque: " + contaShinobi.verificarSaldo() + " jutsus");

        contaShinobi.sacar(1500.0); // Tentativa de saque acima do saldo disponível
        System.out.println("Saldo após tentativa de saque: " + contaShinobi.verificarSaldo() + " jutsus");

        // Imprimindo os dados da conta shinobi
        contaShinobi.imprimirDados();

        // Criando uma instância da classe ContaHokage
        ContaHokage contaHokage = new ContaHokage(2001, 10000.0, "Hiruzen Sarutobi", true);

        // Realizando operações típicas na conta hokage
        contaHokage.depositar(5000.0);
        System.out.println("Saldo após depósito: R$" + contaHokage.verificarSaldo());

        contaHokage.sacar(2000.0); // Saque com autorização especial
        System.out.println("Saldo após saque: R$" + contaHokage.verificarSaldo());

        contaHokage.sacar(5000.0); // Tentativa de saque sem autorização especial
        System.out.println("Saldo após tentativa de saque: R$" + contaHokage.verificarSaldo());

        // Imprimindo os dados da conta hokage
        contaHokage.imprimirDados();
    }
}
