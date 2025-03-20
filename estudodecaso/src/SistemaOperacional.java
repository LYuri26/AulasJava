public class SistemaOperacional extends Produto {
    private String versao;

    public SistemaOperacional(String nome, String descricao, String versao) {
        super(nome, descricao);
        this.versao = versao;
    }

    public String getVersao() {
        return versao;
    }
}
