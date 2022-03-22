package thread;

public class demo4 {
    public static void main(String[] args) {
        Thread t = new Thread() {
            @Override
            public void run() {
                System.out.println("hello thread!");
            }
        };
        t.start();
    }
}
