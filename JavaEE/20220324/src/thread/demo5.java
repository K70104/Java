package thread;

public class demo5 {
    public static void main(String[] args) {
        /*Thread t = new Thread(){
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()); // Thread-0
                System.out.println(this.getName());
            }
        };
        t.start();*/

        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        });
        t.start();


        // 在 main 线程中调用的，拿到的就是 main 这个线程的实例
        System.out.println(Thread.currentThread().getName()); // main
    }
}
