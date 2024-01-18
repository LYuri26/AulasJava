package HoroscopoGUI;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class ascendente {

    // Método para determinar o ascendente com base na data de nascimento, hora de nascimento e hora do nascer do sol
    public String determinarascendente(String data, String horaNascimento, String horaNascerSol) {

        // Divide a data em partes usando o caractere '/'
        String[] partesData = data.split("/");
        // Divide a hora de nascimento em partes usando o caractere ':'
        String[] partesHora = horaNascimento.split(":");

        // Verifica se foram obtidas corretamente três partes na data e duas na hora de nascimento
        if (partesData.length != 3 || partesHora.length != 2) {
            return "dados inválidos"; // Retorna uma mensagem de erro se os dados estiverem incorretos
        }

        // Converte as partes em inteiros para validação
        int dia = Integer.parseInt(partesData[0]);
        int mes = Integer.parseInt(partesData[1]);
        int hora = Integer.parseInt(partesHora[0]);
        int minutos = Integer.parseInt(partesHora[1]);

        // Verifica a validade dos dados inseridos
        if (mes < 1 || mes > 12 || dia < 1 || dia > 31 || hora < 0 || hora > 23 || minutos < 0 || minutos > 59) {
            return "dados inválidos"; // Retorna uma mensagem de erro se os dados estiverem incorretos
        }

        int intervalo = 2;

        // Lista de signos em ordem
        String[] signos = {
                "Áries", "Touro", "Gêmeos", "Câncer", "Leão", "Virgem",
                "Libra", "Escorpião", "Sagitário", "Capricórnio", "Aquário", "Peixes"
        };

        int posicao = -1;

        // Encontra a posição do signo na lista
        for (int i = 0; i < signos.length; i++) {
            if (signos[i].equals(determinarSigno(data))) {
                posicao = i;
                break;
            }
        }

        // Verifica se o signo foi encontrado
        if (posicao != -1) {
            // Calcular a hora do nascer do sol
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
            LocalTime horaNascerSolParsed = LocalTime.parse(horaNascerSol, formatter);

            // Comparar a hora do nascer do sol com a hora de nascimento
            if (horaNascerSolParsed.isBefore(LocalTime.of(hora, minutos))) {
                // Atualizar o ascendente
                int horasDiferenca = (int) horaNascerSolParsed.until(LocalTime.of(hora, minutos),
                        java.time.temporal.ChronoUnit.HOURS);
                int novaPosicao = (posicao + (horasDiferenca / intervalo)) % 12;
                return signos[novaPosicao];
            } else {
                return signos[posicao]; // Não houve mudança de ascendente
            }
        } else {
            return "dados inválidos"; // Retorna uma mensagem de erro se o signo não for encontrado
        }
    }

    // Método para determinar o signo com base na data de nascimento
    public String determinarSigno(String data) {
        // Divide a data em partes usando o caractere '/'
        String[] partesData = data.split("/");

        // Verifica se existem três partes (dia, mês, ano)
        if (partesData.length != 3) {
            return "dados inválidos"; // Retorna uma mensagem de erro se os dados estiverem incorretos
        }

        // Converte as partes em números inteiros para validação
        int dia = Integer.parseInt(partesData[0]);
        int mes = Integer.parseInt(partesData[1]);

        // Verifica a validade dos dados inseridos (mês entre 1 e 12, dia entre 1 e 31)
        if (mes < 1 || mes > 12 || dia < 1 || dia > 31) {
            return "dados inválidos"; // Retorna uma mensagem de erro se os dados estiverem incorretos
        }

        // Determina o signo com base no mês e dia de nascimento
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
                return "dados inválidos"; // Retorna uma mensagem de erro se o mês for inválido
        }
    }
}
