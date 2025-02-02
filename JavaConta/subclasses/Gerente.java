class Gerente extends Funcionario {
    private int senha;
    private int numeroDeFuncionariosGerenciados;

    public void setSenha(int senha) {
        this.senha = senha;
    }

    public boolean autentica(int senha) {
        if (this.senha == senha) {
            System.out.println("Acesso Permitido!");
            return true;
        } else {
            System.out.println("Acesso Negado!");
            return false;
        }
    }

    @Override
    public double getBonificacao() {
        return this.salario * 0.15;
    }
}
