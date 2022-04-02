import java.util.concurrent.atomic.AtomicInteger;

public class TestDemo {
    public static void main(String[] args) throws InterruptedException {
       AtomicInteger num = new AtomicInteger(0); // 创建一个整数 值是 0
        // 此方法相当于 num++
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 50000; i++) {
                num.getAndIncrement();
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 50000; i++) {
                num.getAndIncrement();
            }
        });

        num.incrementAndGet(); // ++num
        num.decrementAndGet(); // --num
        num.getAndIncrement(); // num++;
        num.getAndDecrement(); // num--;
        num.getAndAdd(10); // += 10

        t1.start();
        t2.start();
        t1.join();
        t2.join();
        // 通过 get 方法得到原子类 内部的数值
        System.out.println(num.get()); // 100000
    }
}
