public class Computador extends Produto {
    private String tipo;

    public Computador(String nome, String descricao, String tipo) {
        super(nome, descricao);
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }
}