// Classe BatalhaAnime para representar uma batalha épica de anime
public class BatalhaAnime {
    // Atributos da classe
    private String nomeEvento;
    private String local;
    private String data;
    private String[] participantes;

    // Construtor da classe
    public BatalhaAnime(String nomeEvento, String local, String data, String[] participantes) {
        this.nomeEvento = nomeEvento;
        this.local = local;
        this.data = data;
        this.participantes = participantes;
    }

    // Métodos para modificar e obter os valores dos atributos
    public void setNomeEvento(String nomeEvento) {
        this.nomeEvento = nomeEvento;
    }

    public String getNomeEvento() {
        return nomeEvento;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getLocal() {
        return local;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }

    public void setParticipantes(String[] participantes) {
        this.participantes = participantes;
    }

    public String[] getParticipantes() {
        return participantes;
    }

    // Método para simular a batalha entre dois personagens
    public void simularBatalha(String personagem1, String personagem2) {
        // Estratégia simples: quem tiver o nome mais longo ganha
        if (personagem1.length() > personagem2.length()) {
            System.out.println(personagem1 + " venceu a batalha contra " + personagem2);
        } else if (personagem2.length() > personagem1.length()) {
            System.out.println(personagem2 + " venceu a batalha contra " + personagem1);
        } else {
            System.out.println("Empate entre " + personagem1 + " e " + personagem2);
        }
    }

    // Método main para testar a classe
    public static void main(String[] args) {
        // Criando uma instância da classe BatalhaAnime
        String[] participantes = {"Goku", "Vegeta", "Naruto", "Sasuke"};
        BatalhaAnime batalha = new BatalhaAnime("Torneio dos Heróis", "Arena Kamehameha", "01/07/2024", participantes);

        // Imprimindo informações do evento
        System.out.println("Detalhes do Evento:");
        System.out.println("Nome do Evento: " + batalha.getNomeEvento());
        System.out.println("Local: " + batalha.getLocal());
        System.out.println("Data: " + batalha.getData());
        System.out.println("Participantes: ");
        for (String participante : batalha.getParticipantes()) {
            System.out.println("- " + participante);
        }
        System.out.println("-------------------");

        // Simulando uma batalha entre dois participantes
        batalha.simularBatalha("Goku", "Naruto");
    }
}
