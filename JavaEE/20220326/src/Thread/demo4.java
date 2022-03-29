package Thread;

public class demo4 {
    private static Object locker = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            // 进行 wait
            synchronized (locker) {
                System.out.println("wait 前");
                try {
                    locker.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("wait 后");
            }
        });
        t1.start();

        Thread.sleep(3000);

        Thread t2 = new Thread(() -> {
            // 进行 notify
            synchronized (locker) {
                System.out.println("notify 前");
                locker.notify();
                System.out.println("notify 后");
            }
        });
        t2.start();
    }
}
