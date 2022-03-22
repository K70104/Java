package thread;

public class demo8 {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            while (true) {
                System.out.println("hello thread1");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "thread1");
        t1.start();
        Thread t2 = new Thread(() -> {
            while (true) {
                System.out.println("hello thread2");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "thread2");
        t2.start();
        /*
        hello thread1
hello thread2
hello thread1
hello thread2
hello thread1
hello thread2
hello thread1
hello thread2
         */
    }
}
