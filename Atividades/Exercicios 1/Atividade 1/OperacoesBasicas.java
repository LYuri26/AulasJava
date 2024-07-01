public class OperacoesBasicas {
    public static void main(String[] args) {
        // Declaração de variáveis inteiras
        int a = 10;
        int b = 5;

        // Realização e exibição das operações
        System.out.println("Adição: " + (a + b)); // 10 + 5 = 15
        System.out.println("Subtração: " + (a - b)); // 10 - 5 = 5
        System.out.println("Multiplicação: " + (a * b)); // 10 * 5 = 50

        // Divisão e tratamento de divisão por zero
        if (b != 0) {
            System.out.println("Divisão: " + (a / b)); // 10 / 5 = 2
        } else {
            System.out.println("Divisão: Divisão por zero não é permitida.");
        }
    }
}
