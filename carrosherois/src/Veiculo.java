public class Veiculo {
    // Atributos da classe Veiculo
    private String nome; // Armazena o nome do veículo
    private String descricao; // Armazena a descrição do veículo

    // Construtor da classe Veiculo
    public Veiculo(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
    }

    // Métodos getters e setters
    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    // Método toString para representação textual do objeto
    @Override
    public String toString() {
        return String.format("Veiculo: nome=%s, descricao=%s", nome, descricao);
    }
}