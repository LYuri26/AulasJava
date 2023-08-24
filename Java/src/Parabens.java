import java.util.Scanner;
import java.util.Random;

public class Parabens {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int batchSize = 5;
        int currentPosition = 0;
        boolean enteringNames = true;
        String[] names = new String[batchSize];
        int[] positions = new int[batchSize];

        System.out.println("Digite os nomes e suas respectivas posições. Pressione Enter para finalizar:");

        while (true) {
            String input = scanner.nextLine();

            if (input.isEmpty()) {
                enteringNames = false;
                break; // Finalizar a entrada de nomes
            }

            String[] inputParts = input.split(" ");
            if (inputParts.length == 2) {
                names[currentPosition] = inputParts[0];
                positions[currentPosition] = Integer.parseInt(inputParts[1]);
                currentPosition++;
            } else {
                System.out.println("Entrada inválida. Tente novamente.");
            }
        }

        System.out.println("\n🎉 Parabéns a todos(as)! 🎉\n");

        if (!enteringNames) {
            for (int i = 0; i < currentPosition; i++) {
                printSlowTypingAnimation("🎉 Parabéns, " + names[i] + " 🎉", getRandomColor(), positions[i]);
            }

            System.out.println("\nParabéns a todos(as)!");
            for (int i = 0; i < currentPosition; i++) {
                printColoredNamePosition(positions[i], names[i], i % 2 == 0 ? "cyan" : "magenta");
            }
        }

        scanner.close();
    }

    public static void printSlowTypingAnimation(String text, String color, int position) {
        String colorCode = getColorCode(color);
        for (int i = 0; i <= text.length(); i++) {
            System.out.print("\033[1m" + colorCode + text.substring(0, i) + "\033[0m");
            try {
                Thread.sleep(100); // Atraso para simular digitação fluida
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clearConsole();
        }
        System.out.println();
        printEmptyLines(position - text.length());
    }

    public static void clearConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void printEmptyLines(int count) {
        for (int i = 0; i < count; i++) {
            System.out.println();
        }
    }

    public static void printColoredNamePosition(int position, String name, String color) {
        String colorCode = getColorCode(color);
        System.out.println("\033[1m" + colorCode + "Posição: " + position + " - Nome: " + name + "\033[0m");
    }

    public static String getColorCode(String color) {
        switch (color.toLowerCase()) {
            case "red":
                return "\033[31m";
            case "green":
                return "\033[32m";
            case "yellow":
                return "\033[33m";
            case "blue":
                return "\033[34m";
            case "magenta":
                return "\033[35m";
            case "cyan":
                return "\033[36m";
            default:
                return "\033[0m"; // Default color
        }
    }

    public static String getRandomColor() {
        String[] colors = {"red", "green", "yellow", "blue", "magenta", "cyan"};
        Random random = new Random();
        return colors[random.nextInt(colors.length)];
    }
}
