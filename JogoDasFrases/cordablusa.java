public class cordablusa {
    public String escolherCor(int escolha) {

        String[] associacoes = {
                "Os pimentões", "As alfaces", "Os pepinos", "As cenouras",
                "Os tomates", "As abobrinhas", "Os quiabos", "Os espinafres",
                "As couves", "Os brócolis", "Os repolhos", "As beterrabas",
                "Os rabanetes", "Os aspargos"
        };

        String fraseblusa = associacoes[escolha - 1];
        return fraseblusa;
    }
}
