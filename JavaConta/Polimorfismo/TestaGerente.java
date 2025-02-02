// Classe Funcionario - Superclasse
class Funcionario {
    protected String nome;
    protected String cpf;
    protected double salario;

    // Método para definir o nome do funcionário
    public void setNome(String nome) {
        this.nome = nome;
    }

    // Método para definir o salário do funcionário
    public void setSalario(double salario) {
        this.salario = salario;
    }

    // Método para obter a bonificação padrão (10% do salário)
    public double getBonificacao() {
        return this.salario * 0.10;
    }
}

// Classe Gerente - Subclasse de Funcionario
class Gerente extends Funcionario {
    private int senha;
    private int numeroDeFuncionariosGerenciados;

    // Método para definir a senha do gerente
    public void setSenha(int senha) {
        this.senha = senha;
    }

    // Método para autenticação do gerente
    public boolean autentica(int senha) {
        if (this.senha == senha) {
            System.out.println("Acesso Permitido!");
            return true;
        } else {
            System.out.println("Acesso Negado!");
            return false;
        }
    }

    // Reescrita do método getBonificacao para gerentes (15% do salário)
    @Override
    public double getBonificacao() {
        return this.salario * 0.15;
    }
}

// Classe TestaGerente - Testando a herança e métodos
public class TestaGerente {
    public static void main(String[] args) {
        // Criando um objeto do tipo Gerente
        Gerente gerente = new Gerente();

        // Definindo valores para o gerente
        gerente.setNome("João da Silva");
        gerente.setSalario(5000.0);
        gerente.setSenha(4231);

        // Testando autenticação
        gerente.autentica(4231); // Deve exibir "Acesso Permitido!"

        // Testando bonificação
        System.out.println("Bonificação do Gerente: " + gerente.getBonificacao()); // Deve exibir 750.0
    }
}
