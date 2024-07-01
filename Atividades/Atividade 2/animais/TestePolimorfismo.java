public class TestePolimorfismo {
    public static void fazerTodosOsSons(Animal[] animais) {
        for (int i = 0; i < animais.length; i++) {
            animais[i].fazerSom();
        }
    }

    public static void main(String[] args) {
        Animal[] animais = new Animal[2];
        animais[0] = new Cachorro();
        animais[1] = new Gato();

        fazerTodosOsSons(animais);
    }
}
