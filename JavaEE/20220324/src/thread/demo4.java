package thread;

public class demo4 {
    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("hello thread");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t.start();

        // 在主线程中，使用等待操作，等 t 线程执行结束
        try {
            t.join(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
