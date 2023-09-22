public class time {
    public String escolhertime(int escolha) {

        String[] associacoes = {
                "Da responsabilidade", "Da tolerância", "Da compaixão", "Da generosidade",
                "Da amizade", "Da felicidade", "Da Vitória", "Da justiça", "Da liberdade",
                "Da criatividade", "Da arte", "Da música", "Da literatura", "Da dança",
                "Da destruição", "Da guerra", "Da intolerância", "Da vingança", "Da manipulação",
                "Da mentira", "Da coragem", "Da persistência", "Da determinação", "Da força",
                "Da raiva", "Do ódio", "Da vingança", "Da punição", "Da repressão",
                "Do Senai", "Da Industria", "Do Caos", "Do Java", "Do HTML", "Do C++",
                "Do Python", "Do MySQL", "Da Programação", "Da Reclamação"
        };

        String frasetime = associacoes[escolha - 1];
        return frasetime;
    }
}
