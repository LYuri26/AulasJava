import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        cordablusa cordablusa = new cordablusa();
        time time = new time();
        String fraseblusa = "";
        String frasetime = "";

        System.out.println("Escolha a cor da blusa:");
        System.out.println("1. Vermelha");
        System.out.println("2. Azul");
        System.out.println("3. Verde");
        System.out.println("4. Amarela");
        System.out.println("5. Verde-limão");
        System.out.println("6. Sem camisa");
        System.out.println("7. Branca");
        System.out.println("8. Cinza");
        System.out.println("9. Laranja");
        System.out.println("10. Marrom");
        System.out.println("11. Preto");
        System.out.println("12. Rosa");
        System.out.println("13. Roxa");
        System.out.println("14. Verde-escuro");
        System.out.println("15. Outras (Listrada, Estampada, etc.)");
        int corescolhida = scanner.nextInt();
        fraseblusa = cordablusa.escolherCor(corescolhida);
        scanner.nextLine(); // Limpa o buffer

        System.out.println("Escolha um time do Brasil:");
        System.out.println("1. Flamengo");
        System.out.println("2. Palmeiras");
        System.out.println("3. Corinthians");
        System.out.println("4. São Paulo");
        System.out.println("5. Grêmio");
        System.out.println("6. Internacional");
        System.out.println("7. Atlético Mineiro");
        System.out.println("8. Fluminense");
        System.out.println("9. Santos");
        System.out.println("10. Botafogo");
        System.out.println("11. Vasco da Gama");
        System.out.println("12. Cruzeiro");
        System.out.println("13. Athletico Paranaense");
        System.out.println("14. Bahia");
        System.out.println("15. Sport Recife");
        System.out.println("16. Ceará");
        System.out.println("17. Fortaleza");
        System.out.println("18. Goiás");
        System.out.println("19. Botafogo-PB");
        System.out.println("20. Vitória");
        System.out.println("21. América-MG");
        System.out.println("22. Remo");
        System.out.println("23. Náutico");
        System.out.println("24. Coritiba");
        System.out.println("25. Avaí");
        System.out.println("26. Sampaio Corrêa");
        System.out.println("27. CSA");
        System.out.println("28. Ponte Preta");
        System.out.println("29. Chapecoense");
        System.out.println("30. Guarani");
        System.out.println("31. Operário-PR");
        System.out.println("32. Vila Nova");
        System.out.println("33. Atlético Goianiense");
        System.out.println("34. CRB");
        System.out.println("35. Sport Club do Recife");
        System.out.println("36. Atlético-GO");
        System.out.println("37. Paysandu");
        System.out.println("38. Criciúma");
        System.out.println("39. Brusque");
        System.out.println("40. Novorizontino");
        int timeescolhido = scanner.nextInt();
        scanner.nextLine(); // Limpa o buffer
        frasetime = time.escolhertime(timeescolhido);

        System.out.println(fraseblusa + " " + frasetime);
    }
}