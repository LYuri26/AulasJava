class Jogador {
    private String nome;
    private String posicao;
    private int numero;

    public Jogador(String nome, String posicao, int numero) {
        this.nome = nome;
        this.posicao = posicao;
        if (numero >= 1 && numero <= 99) {
            this.numero = numero;
        } else {
            this.numero = 0;
        }
    }

    public void fazerGol() {
        System.out.println("Gol de " + this.nome + "!");
    }

    public void exibirDados() {
        System.out.println("Nome: " + this.nome);
        System.out.println("Posição: " + this.posicao);
        System.out.println("Número: " + this.numero);
    }

    public boolean mudarNumero(int novoNumero) {
        if (novoNumero >= 1 && novoNumero <= 99) {
            this.numero = novoNumero;
            return true;
        }
        return false;
    }

    public String mostrarResumo() {
        return "Camisa " + this.numero + ": " + this.nome + " (" + this.posicao + ")";
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPosicao() {
        return this.posicao;
    }

    public void setPosicao(String posicao) {
        this.posicao = posicao;
    }

    public int getNumero() {
        return this.numero;
    }

    public void setNumero(int numero) {
        if (numero >= 1 && numero <= 99) {
            this.numero = numero;
        }
    }
}