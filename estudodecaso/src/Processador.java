public class Processador extends Produto {
    private String modelo;
    private double velocidadeGHz;

    public Processador(String nome, String descricao, String modelo, double velocidadeGHz) {
        super(nome, descricao);
        this.modelo = modelo;
        this.velocidadeGHz = velocidadeGHz;
    }

    public String getModelo() {
        return modelo;
    }

    public double getVelocidadeGHz() {
        return velocidadeGHz;
    }
}