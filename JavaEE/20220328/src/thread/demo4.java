package thread;

import java.util.Timer;
import java.util.TimerTask;

public class demo4 {
    public static void main(String[] args) {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("hello time");
            }
        }, 3000);
        System.out.println("main");
    }
}
