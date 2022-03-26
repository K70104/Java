package thread;

public class demo3 {
    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                System.out.println("hello thread");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    // 当前触发异常后，立即退出循环
                    System.out.println("这个是收尾工作");
                    break;
                }
            }
        });
        t.start();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 在主线程中，调用 interrupt 方法，中断这个线程
        // 让 t 线程被中断
        t.interrupt();
    }
}
