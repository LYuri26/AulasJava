import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

// A classe 'ascendente' herda os métodos da classe 'signo'
public class ascendente extends signo {

    // Construtor da classe 'ascendente', que chama o construtor da classe mãe
    // (Signo)
    public ascendente() {
        super(); // Chama o construtor da classe mãe (Signo) se houver alguma inicialização
                 // necessária.
    }

    // Método para determinar o ascendente com base na data e hora de nascimento
    public String determinarascendente(String dataNascimento, String horaNascimento, String horaNascerSol) {

        // Chama o método 'determinarsigno' da classe 'signo' para obter o signo da
        // pessoa
        String signo = determinarsigno(dataNascimento);

        // Divide a data e a hora em partes para verificação
        String[] partesdata = dataNascimento.split("/");
        String[] parteshora = horaNascimento.split(":");

        // Verifica se as partes foram corretamente obtidas
        if (partesdata.length != 3 || parteshora.length != 2) {
            return "dados inválidos"; // Retorna uma mensagem de erro se os dados estiverem incorretos
        }

        // Converte as partes em inteiros para validação
        int dia = Integer.parseInt(partesdata[0]);
        int mes = Integer.parseInt(partesdata[1]);
        int hora = Integer.parseInt(parteshora[0]);
        int minutos = Integer.parseInt(parteshora[1]);

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
            if (signos[i].equals(determinarsigno(dataNascimento))) {
                posicao = i;
                break;
            }
        }

        // Verifica se o signo foi encontrado
        if (posicao != -1) {
            // Calcular a hora do nascer do sol
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
            LocalTime horanascersolParsed = LocalTime.parse(horaNascerSol, formatter);

            // Comparar a hora do nascer do sol com a hora de nascimento
            if (horanascersolParsed.isBefore(LocalTime.of(hora, minutos))) {
                // Atualizar o ascendente
                int horasDiferenca = (int) horanascersolParsed.until(LocalTime.of(hora, minutos),
                        java.time.temporal.ChronoUnit.HOURS);
                int novaposicao = (posicao + (horasDiferenca / intervalo)) % 12;
                return signos[novaposicao];
            } else {
                return signos[posicao]; // Não houve mudança de ascendente
            }
        } else {
            return "dados inválidos"; // Retorna uma mensagem de erro se o signo não for encontrado
        }
    }
}
