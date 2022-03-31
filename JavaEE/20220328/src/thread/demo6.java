package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class demo6 {
    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 100; i++) {
            pool.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println("hello threadPool");
                }
            });
        }
    }

    public static void main1(String[] args) {
        // 创建一个固定的线程数目的线程池，参数指定了线程的个数
        ExecutorService pool = Executors.newFixedThreadPool(10);
        // 创建一个自动扩扩容的线程池，会根据任务量自动扩容
        Executors.newCachedThreadPool();
        // 创建一个只有一个线程的线程池
        Executors.newSingleThreadExecutor();
        // 创建一个带有定时器功能的线程池，类似于 Timer
        Executors.newScheduledThreadPool(10);
    }
}
