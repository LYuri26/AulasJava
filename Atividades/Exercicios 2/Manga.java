public class Manga {
    // Atributos da classe
    private String titulo;
    private String autor;
    private int numeroPaginas;

    // Construtor da classe
    public Manga(String titulo, String autor, int numeroPaginas) {
        this.titulo = titulo;
        this.autor = autor;
        this.numeroPaginas = numeroPaginas;
    }

    // Métodos para modificar e obter os valores dos atributos
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getAutor() {
        return autor;
    }

    public void setNumeroPaginas(int numeroPaginas) {
        this.numeroPaginas = numeroPaginas;
    }

    public int getNumeroPaginas() {
        return numeroPaginas;
    }

    // Método para imprimir todas as informações do mangá, incluindo uma breve sinopse
    public void imprimirInformacoes() {
        System.out.println("Título: " + titulo);
        System.out.println("Autor: " + autor);
        System.out.println("Número de Páginas: " + numeroPaginas);
        System.out.println("Sinopse: [Breve descrição da história]");
        System.out.println("----------------------");
    }

    // Método main para testar a classe
    public static void main(String[] args) {
        // Criando uma instância da classe Manga
        Manga manga1 = new Manga("One Piece", "Eiichiro Oda", 1000);
        Manga manga2 = new Manga("Naruto", "Masashi Kishimoto", 700);

        // Imprimindo as informações de cada mangá
        System.out.println("Informações dos Mangás:");
        manga1.imprimirInformacoes();
        manga2.imprimirInformacoes();
    }
}
