// Classe Funcionario (implementando Bonificavel)
public class Funcionario implements Bonificavel {
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
    @Override
    public double getBonificacao() {
        return this.salario * 0.10;
    }
}
