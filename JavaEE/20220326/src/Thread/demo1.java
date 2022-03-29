package Thread;

class Counter {
    // 这两个线程要自增的变量
    public int count;

    /*synchronized public void increase() {
        count++;
    }*/

    synchronized public void increase() {
        synchronized (this) {
            count++;
        }
    }


    /*public static void func() {
        synchronized (Counter.class) {

        }
    }*/
    synchronized public static void func() {

    }
}

public class demo1 {
    private static Counter counter = new Counter();

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 50000; i++) {
                counter.increase();
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 50000; i++) {
                counter.increase();
            }
        });
        t1.start();
        t2.start();

        // 必须要在 t1 和 t2 都执行完后，再打印，否则 main 和 t1 t2 是并发关系
        // 导致t1 t2 还没执行完，就执行了下面的打印
        t1.join(); // 两个join 顺序前后没关系
        t2.join();

        // 在 main 中打印两个线程自增完 得到的 count
        System.out.println(counter.count);
    }
}


