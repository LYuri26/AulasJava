public class signo {

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
                    return "aquário";
                else
                    return "capricórnio";
            case 2:
                if (dia >= 19)
                    return "peixes";
                else
                    return "aquário";
            case 3:
                if (dia >= 21)
                    return "áries";
                else
                    return "peixes";
            case 4:
                if (dia >= 20)
                    return "touro";
                else
                    return "áries";
            case 5:
                if (dia >= 21)
                    return "gêmeos";
                else
                    return "touro";
            case 6:
                if (dia >= 21)
                    return "câncer";
                else
                    return "gêmeos";
            case 7:
                if (dia >= 23)
                    return "leão";
                else
                    return "câncer";
            case 8:
                if (dia >= 23)
                    return "virgem";
                else
                    return "leão";
            case 9:
                if (dia >= 23)
                    return "libra";
                else
                    return "virgem";
            case 10:
                if (dia >= 23)
                    return "escorpião";
                else
                    return "libra";
            case 11:
                if (dia >= 22)
                    return "sagitário";
                else
                    return "escorpião";
            case 12:
                if (dia >= 22)
                    return "capricórnio";
                else
                    return "sagitário";
            default:
                return "dados inválidos";
        }
    }
}
