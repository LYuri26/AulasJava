class Conta {
    private double saldo;
    private double limite;
    private Cliente titular;

    public Conta(Cliente titular, double saldoInicial, double limite) {
        this.titular = titular;
        this.saldo = saldoInicial;
        this.limite = limite;
    }

    public void deposita(double valor) {
        if (valor > 0) {
            this.saldo += valor;
            System.out.println("Depósito de R$" + valor + " realizado com sucesso!");
        } else {
            System.out.println("Valor inválido para depósito!");
        }
    }

    public boolean saca(double valor) {
        if (valor > 0 && (this.saldo + this.limite) >= valor) {
            this.saldo -= valor;
            System.out.println("Saque de R$" + valor + " realizado com sucesso!");
            return true;
        } else {
            System.out.println("Saldo insuficiente para saque!");
            return false;
        }
    }

    public boolean transfere(Conta destino, double valor) {
        if (this.saca(valor)) {
            destino.deposita(valor);
            System.out.println("Transferência de R$" + valor + " realizada com sucesso!");
            return true;
        } else {
            System.out.println("Transferência falhou!");
            return false;
        }
    }

    public double getSaldo() {
        return this.saldo + this.limite;
    }

    public Cliente getTitular() {
        return this.titular;
    }

    public void setTitular(Cliente titular) {
        this.titular = titular;
    }
}
