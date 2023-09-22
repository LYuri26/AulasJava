import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class ascendente {

    public String determinarascendente(String data, String horanascimento, String horanascersol) {
        String[] partesdata = data.split("/");
        String[] parteshora = horanascimento.split(":");
        
        if (partesdata.length != 3 || parteshora.length != 2) {
            return "dados inválidos";
        }

        int dia = Integer.parseInt(partesdata[0]);
        int mes = Integer.parseInt(partesdata[1]);
        int hora = Integer.parseInt(parteshora[0]);
        int minutos = Integer.parseInt(parteshora[1]);

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
            if (signos[i].equals(determinarsigno(data))) {
                posicao = i;
                break;
            }
        }

        if (posicao != -1) {
            // Calcular a hora do nascer do sol
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
            LocalTime horanascersolParsed = LocalTime.parse(horanascersol, formatter);

            // Comparar a hora do nascer do sol com a hora de nascimento
            if (horanascersolParsed.isBefore(LocalTime.of(hora, minutos))) {
                // Atualizar o ascendente
                int horasDiferenca = (int) horanascersolParsed.until(LocalTime.of(hora, minutos), java.time.temporal.ChronoUnit.HOURS);
                int novaposicao = (posicao + (horasDiferenca / intervalo)) % 12;
                return signos[novaposicao];
            } else {
                return signos[posicao]; // Não houve mudança de ascendente
            }
        } else {
            return "dados inválidos";
        }
    }

    public String determinarsigno(String data) {
        String[] partesdata = data.split("/");
        
        if (partesdata.length != 3) {
            return "dados inválidos";
        }

        int dia = Integer.parseInt(partesdata[0]);
        int mes = Integer.parseInt(partesdata[1]);

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
