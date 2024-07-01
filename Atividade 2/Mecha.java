public class Mecha {
    // Atributos da classe
    private String modelo;
    private String fabricante;
    private int anoFabricacao;

    // Construtor da classe
    public Mecha(String modelo, String fabricante, int anoFabricacao) {
        this.modelo = modelo;
        this.fabricante = fabricante;
        this.anoFabricacao = anoFabricacao;
    }

    // Métodos para modificar e obter os valores dos atributos
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getModelo() {
        return modelo;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setAnoFabricacao(int anoFabricacao) {
        this.anoFabricacao = anoFabricacao;
    }

    public int getAnoFabricacao() {
        return anoFabricacao;
    }

    // Método main para testar a classe
    public static void main(String[] args) {
        // Criando instâncias da classe Mecha
        Mecha mecha1 = new Mecha("RX-78-2 Gundam", "Earth Federation", 1979);
        Mecha mecha2 = new Mecha("EVA-01", "Nerv", 2015);

        // Imprimindo os detalhes de cada Mecha
        System.out.println("Detalhes dos Mechas:");
        System.out.println("Mecha 1:");
        System.out.println("Modelo: " + mecha1.getModelo());
        System.out.println("Fabricante: " + mecha1.getFabricante());
        System.out.println("Ano de Fabricação: " + mecha1.getAnoFabricacao());
        System.out.println("----------------------");

        System.out.println("Mecha 2:");
        System.out.println("Modelo: " + mecha2.getModelo());
        System.out.println("Fabricante: " + mecha2.getFabricante());
        System.out.println("Ano de Fabricação: " + mecha2.getAnoFabricacao());
        System.out.println("----------------------");
    }
}
