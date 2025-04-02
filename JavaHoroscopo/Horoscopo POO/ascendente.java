import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class ascendente extends signo {
    public String determinarascendente(String data, String horaNascimento, String horaNascerSol) {
        if (!validarData(data) || !validarHora(horaNascimento)) {
            return "dados inválidos";
        }

        String signoSolar = determinarsigno(data);
        int posicao = encontrarPosicaoSigno(signoSolar);

        if (posicao == -1) {
            return "dados inválidos";
        }

        return calcularAscendente(posicao, horaNascimento, horaNascerSol);
    }

    private boolean validarHora(String hora) {
        String[] partes = hora.split(":");
        if (partes.length != 2) {
            return false;
        }

        try {
            int h = Integer.parseInt(partes[0]);
            int m = Integer.parseInt(partes[1]);
            return h >= 0 && h <= 23 && m >= 0 && m <= 59;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private int encontrarPosicaoSigno(String signo) {
        for (int i = 0; i < SIGNOS.length; i++) {
            if (SIGNOS[i].equalsIgnoreCase(signo)) {
                return i;
            }
        }
        return -1;
    }

    private String calcularAscendente(int posicao, String horaNasc, String horaSol) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        LocalTime nascerSol = LocalTime.parse(horaSol, formatter);

        String[] partesHora = horaNasc.split(":");
        LocalTime nascimento = LocalTime.of(
                Integer.parseInt(partesHora[0]),
                Integer.parseInt(partesHora[1]));

        if (nascerSol.isBefore(nascimento)) {
            int horasDiferenca = (int) nascerSol.until(nascimento, java.time.temporal.ChronoUnit.HOURS);
            int novaPosicao = (posicao + (horasDiferenca / 2)) % 12;
            return SIGNOS[novaPosicao];
        }
        return SIGNOS[posicao];
    }
}