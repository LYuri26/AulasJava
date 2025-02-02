// Classe TestaGerente - Testando a herança e interfaces
public class TestaGerente {
    public static void main(String[] args) {
        // Criando um objeto do tipo Gerente
        Gerente gerente = new Gerente();

        // Definindo valores para o gerente
        gerente.setNome("João da Silva");
        gerente.setSalario(5000.0);
        gerente.setSenha(4231);

        // Testando autenticação
        gerente.autentica(4231); // Deve exibir "Acesso Permitido!"

        // Testando bonificação
        System.out.println("Bonificação do Gerente: R$" + gerente.getBonificacao()); // Deve exibir 750.0
    }
}
