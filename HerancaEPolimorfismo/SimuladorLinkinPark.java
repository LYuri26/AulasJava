// EXERCÍCIO 1
class Banda {
    private String nome;
    private int anoFormacao;

    public Banda(String nome, int anoFormacao) {
        this.nome = nome;
        this.anoFormacao = anoFormacao;
    }

    public void exibirInformacoes() {
        System.out.println("Banda: " + nome);
        System.out.println("Ano de Formação: " + anoFormacao);
    }
}

// EXERCÍCIO 2
class LinkinPark extends Banda {
    private String estiloMusical;
    private int quantidadeGrammys;

    public LinkinPark(String nome, int anoFormacao, String estiloMusical, int quantidadeGrammys) {
        super(nome, anoFormacao);
        this.estiloMusical = estiloMusical;
        this.quantidadeGrammys = quantidadeGrammys;
    }

    public void exibirInformacoes() {
        super.exibirInformacoes();
        System.out.println("Estilo Musical: " + estiloMusical);
        System.out.println("Grammys Vencidos: " + quantidadeGrammys);
    }
}

// EXERCÍCIO 3
class Integrante {
    protected String nome;
    protected int idade;
    protected String instrumento;

    public Integrante(String nome, int idade, String instrumento) {
        this.nome = nome;
        this.idade = idade;
        this.instrumento = instrumento;
    }
}

class Vocalista extends Integrante {
    public Vocalista(String nome, int idade, String instrumento) {
        super(nome, idade, instrumento);
    }

    public void cantarMusica() {
        System.out.println(nome + " está cantando uma música!");
    }
}

// EXERCÍCIO 4
class Album {
    protected String titulo;
    protected int anoLancamento;

    public Album(String titulo, int anoLancamento) {
        this.titulo = titulo;
        this.anoLancamento = anoLancamento;
    }

    public void exibirInformacoes() {
        System.out.println("Álbum: " + titulo + " (" + anoLancamento + ")");
    }
}

class AlbumPlatinado extends Album {
    private int quantidadeVendas;

    public AlbumPlatinado(String titulo, int anoLancamento, int quantidadeVendas) {
        super(titulo, anoLancamento);
        this.quantidadeVendas = quantidadeVendas;
    }

    public void exibirInformacoes() {
        super.exibirInformacoes();
        System.out.println("Vendas: " + quantidadeVendas + " milhões");
    }
}

// EXERCÍCIO 5
class FuncionarioDaBanda {
    protected String nome;
    protected double salario;

    public FuncionarioDaBanda(String nome, double salario) {
        this.nome = nome;
        this.salario = salario;
    }

    public double calcularBonificacao() {
        return salario * 0.1;
    }
}

class Produtor extends FuncionarioDaBanda {
    public Produtor(String nome, double salario) {
        super(nome, salario);
    }

    public double calcularBonificacao() {
        return salario * 0.15;
    }
}

class GerenteTurne extends FuncionarioDaBanda {
    public GerenteTurne(String nome, double salario) {
        super(nome, salario);
    }

    public double calcularBonificacao() {
        return salario * 0.2;
    }
}

// EXERCÍCIO 6
class ControleDeBonificacoes {
    private double totalBonificacoes = 0;

    public void registrar(FuncionarioDaBanda funcionario) {
        totalBonificacoes += funcionario.calcularBonificacao();
    }

    public double obterTotalBonificacoes() {
        return totalBonificacoes;
    }
}

// EXERCÍCIO 7
class Show {
    protected String local;
    protected int publicoEstimado;

    public Show(String local, int publicoEstimado) {
        this.local = local;
        this.publicoEstimado = publicoEstimado;
    }

    public double calcularValorIngresso() {
        return 100.0;
    }
}

class ShowVip extends Show {
    private double valorAdicional;

    public ShowVip(String local, int publicoEstimado, double valorAdicional) {
        super(local, publicoEstimado);
        this.valorAdicional = valorAdicional;
    }

    public double calcularValorIngresso() {
        return super.calcularValorIngresso() + valorAdicional;
    }
}

// EXERCÍCIO 8, 9 e 10
public class SimuladorLinkinPark {
    public static void main(String[] args) {
        LinkinPark linkinPark = new LinkinPark("Linkin Park", 1996, "Nu Metal", 2);
        linkinPark.exibirInformacoes();

        Vocalista chester = new Vocalista("Chester Bennington", 41, "Voz");
        chester.cantarMusica();

        AlbumPlatinado album = new AlbumPlatinado("Hybrid Theory", 2000, 30);
        album.exibirInformacoes();

        FuncionarioDaBanda produtor = new Produtor("Rick Rubin", 30000);
        FuncionarioDaBanda gerente = new GerenteTurne("Joe Hahn", 35000);

        ControleDeBonificacoes controle = new ControleDeBonificacoes();
        controle.registrar(produtor);
        controle.registrar(gerente);
        System.out.println("Total em bonificações: R$ " + controle.obterTotalBonificacoes());

        Show showNormal = new Show("Los Angeles", 50000);
        ShowVip showVip = new ShowVip("Tóquio", 10000, 50.0);

        System.out.println("Ingresso Normal: R$ " + showNormal.calcularValorIngresso());
        System.out.println("Ingresso VIP: R$ " + showVip.calcularValorIngresso());
    }
}
