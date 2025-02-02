class Cliente {
    private String nome;
    private String cpf;
    private int idade;

    public Cliente(String nome, String cpf, int idade) {
        this.nome = nome;
        this.cpf = cpf;
        this.idade = idade;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return this.cpf;
    }

    public void setCpf(String cpf) {
        if (validaCPF(cpf)) {
            this.cpf = cpf;
        } else {
            System.out.println("CPF inválido!");
        }
    }

    private boolean validaCPF(String cpf) {
        return cpf.length() == 11;
    }

    public int getIdade() {
        return this.idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
}
