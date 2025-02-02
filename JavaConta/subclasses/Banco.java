public class Banco {
    public static void main(String[] args) {
        Cliente cliente1 = new Cliente("Carlos Silva", "12345678901", 35);
        Cliente cliente2 = new Cliente("Ana Souza", "98765432100", 29);

        Conta conta1 = new Conta(cliente1, 2000.0, 500.0);
        Conta conta2 = new Conta(cliente2, 1500.0, 300.0);

        System.out.println("Titular da conta1: " + conta1.getTitular().getNome());
        System.out.println("Saldo inicial conta1: R$" + conta1.getSaldo());

        conta1.deposita(500);
        conta1.saca(1000);
        conta1.transfere(conta2, 800);

        System.out.println("Saldo final conta1: R$" + conta1.getSaldo());
        System.out.println("Saldo final conta2: R$" + conta2.getSaldo());
    }
}
