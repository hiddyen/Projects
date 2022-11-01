package Project1;

import java.time.temporal.ChronoUnit;

public class Count extends Thread{
    public static String monitor = new String();
    public static int i=0;



    @Override
    public void run() {
        try {
            while (!Thread.interrupted() ) {
                synchronized (monitor){
                    sleep(5000);
                    i++;
                }
            }

        } catch (InterruptedException e) {
        }
    }
    public static int getI(){
        return i;
    }
}
