package Thread;

public class demo3 {
    public static void main(String[] args) throws InterruptedException {
        Object object = new Object();
        synchronized (object) {
            System.out.println("wait 前");
            object.wait(); // 代码中调用 wait 就会发生阻塞
            System.out.println("wait 后");
        }
    }
}
