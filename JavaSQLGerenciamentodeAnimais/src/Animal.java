// Classe Animal.java
public class Animal {
    String nome;
    int idade;
    String caracteristica;

    public Animal(String nome, int idade, String caracteristica) {
        this.nome = nome;
        this.idade = idade;
        this.caracteristica = caracteristica;
    }

    public void exibirInfo() {
        System.out.println("Nome: " + nome);
        System.out.println("Idade: " + idade);
        System.out.println("Caracteristica: " + caracteristica);

    }
}
