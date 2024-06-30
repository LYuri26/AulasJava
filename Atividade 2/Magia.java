public class Magia {
    // Atributo da classe
    private int nivelPoder;

    // Construtor da classe
    public Magia(int nivelPoder) {
        this.nivelPoder = nivelPoder;
    }

    // Método para calcular e retornar a intensidade da magia
    public String calcularIntensidade() {
        if (nivelPoder >= 80) {
            return "Intensidade da magia: Muito alta";
        } else if (nivelPoder >= 50) {
            return "Intensidade da magia: Alta";
        } else if (nivelPoder >= 20) {
            return "Intensidade da magia: Moderada";
        } else {
            return "Intensidade da magia: Baixa";
        }
    }

    // Método para calcular e retornar o alcance da magia
    public String calcularAlcance() {
        if (nivelPoder >= 80) {
            return "Alcance da magia: Global";
        } else if (nivelPoder >= 50) {
            return "Alcance da magia: Regional";
        } else if (nivelPoder >= 20) {
            return "Alcance da magia: Local";
        } else {
            return "Alcance da magia: Curto";
        }
    }

    // Método main para testar a classe
    public static void main(String[] args) {
        // Criando objetos da classe Magia com diferentes níveis de poder
        Magia magia1 = new Magia(90);
        Magia magia2 = new Magia(60);

        // Imprimindo os resultados dos cálculos de cada magia
        System.out.println("Resultados dos Feitiços de Magia:");
        System.out.println("Magia 1:");
        System.out.println(magia1.calcularIntensidade());
        System.out.println(magia1.calcularAlcance());
        System.out.println("----------------------");

        System.out.println("Magia 2:");
        System.out.println(magia2.calcularIntensidade());
        System.out.println(magia2.calcularAlcance());
        System.out.println("----------------------");
    }
}
