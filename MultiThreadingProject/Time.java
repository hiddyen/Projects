package Project1;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Scanner;

public class Time extends Thread {
    public static LocalDate date = LocalDate.now();

    public Time() {
        date = LocalDate.now();
    }

    public static LocalDate BEGINNING = LocalDate.now();
    static long between;
    public static String monitor = new String();



    @Override
    public void run() {
        try {
            while (!Thread.interrupted() ) {
                synchronized (monitor){
                    sleep(5000);
                    this.date = date.plusDays(1);
                    between = ChronoUnit.DAYS.between(BEGINNING, date);
                }
            }

        } catch (InterruptedException e) {
        }
    }
        public static LocalDate getDate () {
            return date;
        }
}
