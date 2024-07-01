public class ArrayExemplo {
    public static void main(String[] args) {
        int[] numeros = {2, 4, 6, 8, 10};

        // Exibindo os elementos na ordem original
        for (int i = 0; i < numeros.length; i++) {
            System.out.println("Elemento na posição " + i + ": " + numeros[i]);
        }

        System.out.println(); // linha em branco para separar a saída

        // Exibindo os elementos na ordem inversa
        for (int i = numeros.length - 1; i >= 0; i--) {
            System.out.println("Elemento na posição " + i + ": " + numeros[i]);
        }
    }
}
