import java.util.Timer;
import java.util.TimerTask;

public class PomodoroTimer {
    public static void main(String[] args) {
        Timer timer = new Timer();

        int pomodoroCount = 0;
        int maxPomodoros = 4;

        while (pomodoroCount < maxPomodoros) {
            startWorkPeriod(timer);
            waitForDuration(25 * 60 * 1000); // Esperar 25 minutos

            startBreakPeriod(timer);
            waitForDuration(5 * 60 * 1000); // Esperar 5 minutos

            pomodoroCount++;
            System.out.println("Pomodoro concluído: " + pomodoroCount);
        }

        timer.cancel();
        System.out.println("Pomodoros concluídos! Hora de descansar.");
    }

    private static void startWorkPeriod(Timer timer) {
        TimerTask workTask = new TimerTask() {
            @Override
            public void run() {
                System.out.println("Tempo de trabalho! 25 minutos começaram.");
            }
        };

        timer.schedule(workTask, 0);
    }

    private static void startBreakPeriod(Timer timer) {
        TimerTask breakTask = new TimerTask() {
            @Override
            public void run() {
                System.out.println("Intervalo de descanso! 5 minutos começaram.");
            }
        };

        timer.schedule(breakTask, 0);
    }

    private static void waitForDuration(long duration) {
        long startTime = System.currentTimeMillis();
        while (System.currentTimeMillis() - startTime < duration) {
            // Aguardar
        }
    }
}
