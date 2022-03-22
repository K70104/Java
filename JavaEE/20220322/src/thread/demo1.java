package thread;

class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("hello thread!");;
    }
}

public class demo1 {
    public static void main(String[] args) {
        Thread t = new MyThread();
        t.start();
    }
}
