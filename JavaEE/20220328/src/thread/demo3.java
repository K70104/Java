package thread;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class demo3 {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<String> queue = new LinkedBlockingQueue<>();
        queue.put("hello");
        String s = queue.take();
        /* 不带阻塞
        queue.offer();
        queue.poll();
        queue.peek();*/
    }
}
