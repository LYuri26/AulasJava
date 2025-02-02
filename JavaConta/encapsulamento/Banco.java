// Definição da classe Cliente
class Cliente {
    private String nome;
    private String cpf;
    private int idade;

    // Construtor para inicializar um cliente
    public Cliente(String nome, String cpf, int idade) {
        this.nome = nome;
        this.cpf = cpf;
        this.idade = idade;
    }

    // Getter para obter o nome
    public String getNome() {
        return this.nome;
    }

    // Setter para modificar o nome
    public void setNome(String nome) {
        this.nome = nome;
    }

    // Getter para obter o CPF
    public String getCpf() {
        return this.cpf;
    }

    // Método para alterar o CPF com validação
    public void setCpf(String cpf) {
        if (validaCPF(cpf)) {
            this.cpf = cpf;
        } else {
            System.out.println("CPF inválido!");
        }
    }

    // Simulação da validação de CPF (aqui poderia ser uma lógica real)
    private boolean validaCPF(String cpf) {
        return cpf.length() == 11; // Exemplo simplificado: CPF deve ter 11 dígitos
    }

    // Getter para obter a idade
    public int getIdade() {
        return this.idade;
    }

    // Setter para modificar a idade
    public void setIdade(int idade) {
        this.idade = idade;
    }
}

// Definição da classe Conta Bancária
class Conta {
    private double saldo;
    private double limite;
    private Cliente titular;

    // Construtor para inicializar a conta
    public Conta(Cliente titular, double saldoInicial, double limite) {
        this.titular = titular;
        this.saldo = saldoInicial;
        this.limite = limite;
    }

    // Método para depositar dinheiro
    public void deposita(double valor) {
        if (valor > 0) {
            this.saldo += valor;
            System.out.println("Depósito de R$" + valor + " realizado com sucesso!");
        } else {
            System.out.println("Valor inválido para depósito!");
        }
    }

    // Método para sacar dinheiro com verificação de saldo e limite
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

    // Método para transferir dinheiro para outra conta
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

    // Getter para obter o saldo + limite
    public double getSaldo() {
        return this.saldo + this.limite; // Encapsulamento: retornamos saldo + limite
    }

    // Getter para obter o titular
    public Cliente getTitular() {
        return this.titular;
    }

    // Setter para alterar o titular da conta
    public void setTitular(Cliente titular) {
        this.titular = titular;
    }
}

// Classe de Teste para verificar o funcionamento
public class Banco {
    public static void main(String[] args) {
        // Criando clientes
        Cliente cliente1 = new Cliente("Carlos Silva", "12345678901", 35);
        Cliente cliente2 = new Cliente("Ana Souza", "98765432100", 29);

        // Criando contas para os clientes
        Conta conta1 = new Conta(cliente1, 2000.0, 500.0);
        Conta conta2 = new Conta(cliente2, 1500.0, 300.0);

        // Testando operações
        System.out.println("Titular da conta1: " + conta1.getTitular().getNome());
        System.out.println("Saldo inicial conta1: R$" + conta1.getSaldo());

        conta1.deposita(500);
        conta1.saca(1000);
        conta1.transfere(conta2, 800);

        System.out.println("Saldo final conta1: R$" + conta1.getSaldo());
        System.out.println("Saldo final conta2: R$" + conta2.getSaldo());
    }
}
