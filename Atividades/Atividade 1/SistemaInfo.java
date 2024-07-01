public class SistemaInfo {
    public static void main(String[] args) {
        // Exibe o nome do sistema operacional
        System.out.println("Sistema Operacional: " + System.getProperty("os.name"));
        
        // Exibe a versão do Java em uso
        System.out.println("Versão do Java: " + System.getProperty("java.version"));
        
        // Exibe o nome do usuário atual do sistema
        System.out.println("Usuário Atual: " + System.getProperty("user.name"));
    }
}
