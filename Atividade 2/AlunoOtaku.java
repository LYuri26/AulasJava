public class AlunoOtaku {
    // Atributos da classe
    private String nome;
    private int matricula;
    private double[] notas;

    // Construtor da classe
    public AlunoOtaku(String nome, int matricula, double[] notas) {
        this.nome = nome;
        this.matricula = matricula;
        this.notas = notas;
    }

    // Método para calcular e retornar a média das notas do aluno
    public double calcularMedia() {
        if (notas.length == 0) {
            return 0.0;
        }
        double soma = 0;
        for (double nota : notas) {
            soma += nota;
        }
        return soma / notas.length;
    }

    // Método para verificar se o aluno está aprovado com louvor otaku (média >= 9.0)
    public boolean aprovadoComLouvorOtaku() {
        double media = calcularMedia();
        return media >= 9.0;
    }

    // Método main para testar a classe
    public static void main(String[] args) {
        // Criando um objeto da classe AlunoOtaku
        double[] notasAluno1 = {8.5, 9.0, 9.5};
        AlunoOtaku aluno1 = new AlunoOtaku("Sakura Haruno", 123456, notasAluno1);

        // Imprimindo os resultados dos cálculos
        System.out.println("Dados do Aluno Otaku:");
        System.out.println("Nome: " + aluno1.nome);
        System.out.println("Matrícula: " + aluno1.matricula);
        System.out.println("Notas: " + java.util.Arrays.toString(aluno1.notas));
        System.out.println("Média: " + aluno1.calcularMedia());
        if (aluno1.aprovadoComLouvorOtaku()) {
            System.out.println("Situação: Aprovado com louvor otaku!");
        } else {
            System.out.println("Situação: Não aprovado com louvor otaku.");
        }
    }
}
