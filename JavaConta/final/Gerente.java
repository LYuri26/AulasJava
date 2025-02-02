// Classe Gerente (implementando Autenticavel e Bonificavel)
public class Gerente extends Funcionario implements Autenticavel {
    private int senha;
    private int numeroDeFuncionariosGerenciados;

    // Método para definir a senha do gerente
    public void setSenha(int senha) {
        this.senha = senha;
    }

    // Método para autenticação do gerente
    @Override
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
