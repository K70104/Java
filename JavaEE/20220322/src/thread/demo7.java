package thread;

public class demo7 {
    private static final long count = 10_0000_0000;

    public static void serial() {
        long begin = System.currentTimeMillis();
        long a = 0;
        for (int i = 0; i < count; i++) {
            a++;
        }
        long b = 0;
        for (int i = 0; i < count; i++) {
            b++;
        }
        long end = System.currentTimeMillis();
        System.out.println("消耗时间： " + (end- begin) + "ms");
    }

    public static void concurrency() throws InterruptedException {
        long begin = System.currentTimeMillis();
        Thread t1 = new Thread(() -> {
            long a = 0;
            for (int i = 0; i < count; i++) {
                a++;
            }
        });
        t1.start();
        Thread t2 = new Thread(() -> {
            long b = 0;
            for (int i = 0; i < count; i++) {
                b++;
            }
        });
        t2.start();

        t1.join(); // 让 main 线程等待 t1 结束
        t2.join(); // 让 main 线程等待 t2 结束

        long end = System.currentTimeMillis();
        System.out.println("消耗时间： " + (end- begin) + "ms");
    }

    public static void main(String[] args) throws InterruptedException {
        // serial();
        concurrency();
    }
}
