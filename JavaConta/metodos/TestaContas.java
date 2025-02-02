// Definição da classe Conta
class Conta {
    int numero;         // Número da conta
    String dono;        // Nome do titular da conta
    double saldo;       // Saldo da conta
    double limite;      // Limite da conta

    // Método para sacar um valor da conta
    boolean saca(double quantidade) {
        if (this.saldo < quantidade) {
            return false; // Saque não permitido
        } else {
            this.saldo -= quantidade;
            return true; // Saque bem-sucedido
        }
    }

    // Método para depositar um valor na conta
    void deposita(double quantidade) {
        this.saldo += quantidade;
    }
}

// Classe principal para testar o funcionamento do sistema bancário
class TestaContas {
    public static void main(String[] args) {
        // Criando a primeira conta
        Conta minhaConta = new Conta();
        minhaConta.numero = 12345;
        minhaConta.dono = "Duke";
        minhaConta.saldo = 1000.0;
        minhaConta.limite = 500.0;

        // Criando a segunda conta
        Conta meuSonho = new Conta();
        meuSonho.numero = 67890;
        meuSonho.dono = "Alice";
        meuSonho.saldo = 1500000.0;
        meuSonho.limite = 10000.0;

        // Exibindo informações iniciais
        System.out.println("Conta de " + minhaConta.dono + " - Saldo: R$" + minhaConta.saldo);
        System.out.println("Conta de " + meuSonho.dono + " - Saldo: R$" + meuSonho.saldo);
        System.out.println("-----------------------------------------");

        // Realizando um saque na conta do Duke
        boolean saqueRealizado = minhaConta.saca(200);
        if (saqueRealizado) {
            System.out.println("Saque de R$200 realizado com sucesso!");
        } else {
            System.out.println("Saque não permitido! Saldo insuficiente.");
        }

        // Realizando um depósito na conta do Duke
        minhaConta.deposita(500);
        System.out.println("Depósito de R$500 realizado na conta de " + minhaConta.dono);

        // Exibindo os saldos atualizados
        System.out.println("-----------------------------------------");
        System.out.println("Saldo atualizado de " + minhaConta.dono + ": R$" + minhaConta.saldo);
        System.out.println("Saldo atualizado de " + meuSonho.dono + ": R$" + meuSonho.saldo);
    }
}
