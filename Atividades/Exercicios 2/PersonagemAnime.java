public class PersonagemAnime {
    // Atributos da classe
    private String nome;
    private int idade;

    // Construtor da classe
    public PersonagemAnime(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    // Métodos para modificar e obter os valores dos atributos
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public int getIdade() {
        return idade;
    }

    // Método para imprimir os dados do personagem
    public void imprimirDados() {
        System.out.println("Nome: " + nome);
        System.out.println("Idade: " + idade);
        System.out.println("----------------------");
    }

    // Método main para criar instâncias e testar a classe
    public static void main(String[] args) {
        // Criando instâncias da classe PersonagemAnime
        PersonagemAnime personagem1 = new PersonagemAnime("Naruto Uzumaki", 17);
        PersonagemAnime personagem2 = new PersonagemAnime("Sakura Haruno", 16);

        // Imprimindo os dados de cada personagem
        System.out.println("Dados dos Personagens de Anime:");
        personagem1.imprimirDados();
        personagem2.imprimirDados();
    }
}
