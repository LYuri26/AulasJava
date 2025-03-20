public class Roda extends Veiculo {
    // Atributo específico da classe Roda
    private String material; // Armazena o material da roda (ex: Liga leve, Aço)

    // Construtor da classe Roda
    public Roda(String nome, String descricao, String material) {
        super(nome, descricao);
        this.material = material;
    }

    // Método getter para o atributo 'material'
    public String getMaterial() {
        return material;
    }
}