public class Carro extends Veiculo {
    // Atributos específicos da classe Carro
    private String modelo; // Armazena o modelo do carro
    private String heroiAssociado; // Armazena o super-herói associado ao carro

    // Construtor da classe Carro
    public Carro(String nome, String descricao, String modelo, String heroiAssociado) {
        super(nome, descricao);
        this.modelo = modelo;
        this.heroiAssociado = heroiAssociado;
    }

    // Métodos getters
    public String getModelo() {
        return modelo;
    }

    public String getHeroiAssociado() {
        return heroiAssociado;
    }
}