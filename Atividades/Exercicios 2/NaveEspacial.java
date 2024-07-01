public class NaveEspacial {
    // Atributos da classe
    private double comprimento;
    private double largura;

    // Construtor da classe
    public NaveEspacial(double comprimento, double largura) {
        this.comprimento = comprimento;
        this.largura = largura;
    }

    // Método para calcular e retornar a área da nave espacial
    public double calcularArea() {
        double area = comprimento * largura;
        return area;
    }

    // Método para calcular e retornar o perímetro da nave espacial
    public double calcularPerimetro() {
        double perimetro = 2 * (comprimento + largura);
        return perimetro;
    }

    // Método main para testar a classe
    public static void main(String[] args) {
        // Criando instâncias da classe NaveEspacial com diferentes tamanhos
        NaveEspacial nave1 = new NaveEspacial(50.5, 30.2);
        NaveEspacial nave2 = new NaveEspacial(80.0, 40.0);

        // Imprimindo os cálculos de área e perímetro de cada nave espacial
        System.out.println("Cálculos da Nave Espacial 1:");
        System.out.println("Área: " + nave1.calcularArea());
        System.out.println("Perímetro: " + nave1.calcularPerimetro());
        System.out.println("----------------------");

        System.out.println("Cálculos da Nave Espacial 2:");
        System.out.println("Área: " + nave2.calcularArea());
        System.out.println("Perímetro: " + nave2.calcularPerimetro());
        System.out.println("----------------------");
    }
}
