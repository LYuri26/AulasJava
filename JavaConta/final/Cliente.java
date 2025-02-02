// Classe Cliente
public class Cliente {
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
