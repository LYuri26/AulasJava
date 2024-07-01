public class AcessoIndiceInvalidoArray {
    public static void main(String[] args) {
        int[] array = { 1, 2, 3, 4, 5 };

        try {
            // Acesso ao índice fora do limite do array
            int valor = array[5];
            System.out.println("Valor do índice 5: " + valor);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Erro: Acesso a índice inválido no array.");
        }
    }
}
