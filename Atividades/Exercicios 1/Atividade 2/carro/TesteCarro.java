public class TesteCarro {
    public static void main(String[] args) {
        Carro carro1 = new Carro();
        carro1.marca = "Toyota";
        carro1.ano = 2020;
        carro1.exibirDetalhes();

        System.out.println(); // linha em branco para separar a saída

        Carro carro2 = new Carro();
        carro2.marca = "Honda";
        carro2.ano = 2018;
        carro2.exibirDetalhes();
    }
}
