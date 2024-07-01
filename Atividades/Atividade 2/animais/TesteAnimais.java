public class TesteAnimais {
    public static void main(String[] args) {
        Cachorro cachorro = new Cachorro();
        cachorro.nome = "Rex";
        cachorro.fazerSom();

        Gato gato = new Gato();
        gato.nome = "Mimi";
        gato.fazerSom();
    }
}
