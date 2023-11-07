package Heranca;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Pessoa extends EntidadeAstrologica {
    private String horaNascimento; // Atributo para armazenar a hora de nascimento da pessoa
    private String horaNascerSol;  // Atributo para armazenar a hora do nascer do sol

    // Construtor que recebe a data de nascimento, hora de nascimento e hora do nascer do sol
    public Pessoa(String data, String horaNascimento, String horaNascerSol) {
        super(data); // Chama o construtor da classe pai (EntidadeAstrologica) para inicializar a data de nascimento
        this.horaNascimento = horaNascimento; // Inicializa o atributo horaNascimento com o valor passado como argumento
        this.horaNascerSol = horaNascerSol;   // Inicializa o atributo horaNascerSol com o valor passado como argumento
    }

    // Método para obter a hora de nascimento
    public String getHoraNascimento() {
        return horaNascimento; // Retorna o valor armazenado no atributo horaNascimento
    }

    // Método para obter a hora do nascer do sol
    public String getHoraNascerSol() {
        return horaNascerSol; // Retorna o valor armazenado no atributo horaNascerSol
    }

    // Método para determinar o ascendente da pessoa
    public String determinarAscendente() {
        String[] partesData = dataNascimento.split("/");
        String[] partesHora = horaNascimento.split(":");

        if (partesData.length != 3 || partesHora.length != 2) {
            return "dados inválidos";
        }

        int dia = Integer.parseInt(partesData[0]);
        int mes = Integer.parseInt(partesData[1]);
        int hora = Integer.parseInt(partesHora[0]);
        int minutos = Integer.parseInt(partesHora[1]);

        if (mes < 1 || mes > 12 || dia < 1 || dia > 31 || hora < 0 || hora > 23 || minutos < 0 || minutos > 59) {
            return "dados inválidos";
        }

        int intervalo = 2;

        String[] signos = {
                "Áries", "Touro", "Gêmeos", "Câncer", "Leão", "Virgem",
                "Libra", "Escorpião", "Sagitário", "Capricórnio", "Aquário", "Peixes"
        };

        int posicao = -1;

        for (int i = 0; i < signos.length; i++) {
            if (signos[i].equals(determinarSigno())) {
                posicao = i;
                break;
            }
        }

        if (posicao != -1) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
            LocalTime horaNascerSolParsed = LocalTime.parse(horaNascerSol, formatter);

            if (horaNascerSolParsed.isBefore(LocalTime.of(hora, minutos))) {
                int horasDiferenca = (int) horaNascerSolParsed.until(LocalTime.of(hora, minutos),
                        java.time.temporal.ChronoUnit.HOURS);
                int novaPosicao = (posicao + (horasDiferenca / intervalo)) % 12;
                return signos[novaPosicao];
            } else {
                return signos[posicao];
            }
        } else {
            return "dados inválidos";
        }
    }

    // Sobrescrita do método abstrato determinarSigno da classe pai EntidadeAstrologica
    @Override
    public String determinarSigno() {
        String[] partesData = dataNascimento.split("/");

        if (partesData.length != 3) {
            return "dados inválidos";
        }

        int dia = Integer.parseInt(partesData[0]);
        int mes = Integer.parseInt(partesData[1]);

        if (mes < 1 || mes > 12 || dia < 1 || dia > 31) {
            return "dados inválidos";
        }

        switch (mes) {
            case 1:
                if (dia >= 20)
                    return "Aquário";
                else
                    return "Capricórnio";
            case 2:
                if (dia >= 19)
                    return "Peixes";
                else
                    return "Aquário";
            case 3:
                if (dia >= 21)
                    return "Áries";
                else
                    return "Peixes";
            case 4:
                if (dia >= 20)
                    return "Touro";
                else
                    return "Áries";
            case 5:
                if (dia >= 21)
                    return "Gêmeos";
                else
                    return "Touro";
            case 6:
                if (dia >= 21)
                    return "Câncer";
                else
                    return "Gêmeos";
            case 7:
                if (dia >= 23)
                    return "Leão";
                else
                    return "Câncer";
            case 8:
                if (dia >= 23)
                    return "Virgem";
                else
                    return "Leão";
            case 9:
                if (dia >= 23)
                    return "Libra";
                else
                    return "Virgem";
            case 10:
                if (dia >= 23)
                    return "Escorpião";
                else
                    return "Libra";
            case 11:
                if (dia >= 22)
                    return "Sagitário";
                else
                    return "Escorpião";
            case 12:
                if (dia >= 22)
                    return "Capricórnio";
                else
                    return "Sagitário";
            default:
                return "dados inválidos";
        }
    }
}
