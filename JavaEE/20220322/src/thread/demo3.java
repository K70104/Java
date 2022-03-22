package thread;

// Runnable 就是在描述一个任务
class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("hello");
    }
}

public class demo3 {
    public static void main(String[] args) {
        Thread t = new Thread(new MyRunnable());
    }
}
