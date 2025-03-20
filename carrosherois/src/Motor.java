public class Motor extends Veiculo {
    // Atributo específico da classe Motor
    private int potencia; // Armazena a potência do motor em cavalos

    // Construtor da classe Motor
    public Motor(String nome, String descricao, int potencia) {
        super(nome, descricao);
        this.potencia = potencia;
    }

    // Método getter para o atributo 'potencia'
    public int getPotencia() {
        return potencia;
    }
}