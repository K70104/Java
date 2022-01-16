import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class TestDemo {
    public static void main(String[] args) {
        MyQueueOj queue = new MyQueueOj();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        System.out.println(queue.poll()); // 1
        System.out.println(queue.poll()); // 2
        System.out.println(queue.poll()); // 3
    }

    public static void main1(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        // 入队列
        queue.add(1); // 容量限制 -> 可能对抛异常
        queue.offer(2);
        // 获取队首元素
        System.out.println(queue.peek()); // 1
        System.out.println(queue.element()); // 1
        // 出队列
        System.out.println(queue.poll()); // 1
        System.out.println(queue.remove()); // 2

        System.out.println("================");

        Deque<Integer> queue2 = new LinkedList<>();
        queue2.offerFirst(1);
        queue2.offerFirst(2);
        queue2.offer(3); // 默认队尾入队
        // 2 1 3
        System.out.println(queue2.peek()); // 2 默认获取队首元素
        System.out.println(queue2.peekFirst()); // 2
        System.out.println(queue2.peekLast()); // 3
    }
}
