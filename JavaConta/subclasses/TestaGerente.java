public class TestaGerente {
    public static void main(String[] args) {
        Gerente gerente = new Gerente();
        gerente.setNome("João da Silva");
        gerente.setSalario(5000.0);
        gerente.setSenha(4231);

        gerente.autentica(4231);
        System.out.println("Bonificação do Gerente: " + gerente.getBonificacao());
    }
}
