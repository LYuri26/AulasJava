public class signo {
    protected static final String[] SIGNOS = {
            "Áries", "Touro", "Gêmeos", "Câncer", "Leão", "Virgem",
            "Libra", "Escorpião", "Sagitário", "Capricórnio", "Aquário", "Peixes"
    };

    public String determinarsigno(String data) {
        if (!validarData(data)) {
            return "dados inválidos";
        }

        String[] partes = data.split("/");
        int dia = Integer.parseInt(partes[0]);
        int mes = Integer.parseInt(partes[1]);

        if (mes == 1) {
            if (dia >= 20) {
                return SIGNOS[10]; // Aquário
            } else {
                return SIGNOS[9]; // Capricórnio
            }
        } else if (mes == 2) {
            if (dia >= 19) {
                return SIGNOS[11]; // Peixes
            } else {
                return SIGNOS[10]; // Aquário
            }
        } else if (mes == 3) {
            if (dia >= 21) {
                return SIGNOS[0]; // Áries
            } else {
                return SIGNOS[11]; // Peixes
            }
        } else if (mes == 4) {
            if (dia >= 20) {
                return SIGNOS[1]; // Touro
            } else {
                return SIGNOS[0]; // Áries
            }
        } else if (mes == 5) {
            if (dia >= 21) {
                return SIGNOS[2]; // Gêmeos
            } else {
                return SIGNOS[1]; // Touro
            }
        } else if (mes == 6) {
            if (dia >= 21) {
                return SIGNOS[3]; // Câncer
            } else {
                return SIGNOS[2]; // Gêmeos
            }
        } else if (mes == 7) {
            if (dia >= 23) {
                return SIGNOS[4]; // Leão
            } else {
                return SIGNOS[3]; // Câncer
            }
        } else if (mes == 8) {
            if (dia >= 23) {
                return SIGNOS[5]; // Virgem
            } else {
                return SIGNOS[4]; // Leão
            }
        } else if (mes == 9) {
            if (dia >= 23) {
                return SIGNOS[6]; // Libra
            } else {
                return SIGNOS[5]; // Virgem
            }
        } else if (mes == 10) {
            if (dia >= 23) {
                return SIGNOS[7]; // Escorpião
            } else {
                return SIGNOS[6]; // Libra
            }
        } else if (mes == 11) {
            if (dia >= 22) {
                return SIGNOS[8]; // Sagitário
            } else {
                return SIGNOS[7]; // Escorpião
            }
        } else if (mes == 12) {
            if (dia >= 22) {
                return SIGNOS[9]; // Capricórnio
            } else {
                return SIGNOS[8]; // Sagitário
            }
        } else {
            return "dados inválidos";
        }
    }

    protected boolean validarData(String data) {
        String[] partes = data.split("/");
        if (partes.length != 3) {
            return false;
        }

        try {
            int dia = Integer.parseInt(partes[0]);
            int mes = Integer.parseInt(partes[1]);
            return mes >= 1 && mes <= 12 && dia >= 1 && dia <= 31;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}