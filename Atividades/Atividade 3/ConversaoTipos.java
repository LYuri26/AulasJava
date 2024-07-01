public class ConversaoTipos {
    public static void main(String[] args) {
        Object obj = "123";

        try {
            // Tentativa de conversão para Integer
            Integer numero = (Integer) obj;
            System.out.println("Número: " + numero);
        } catch (ClassCastException e) {
            System.out.println("Erro: Conversão de tipos inválida.");
        }
    }
}
