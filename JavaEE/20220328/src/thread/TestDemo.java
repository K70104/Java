package thread;

import jdk.nashorn.internal.ir.SplitReturn;

import javax.swing.tree.TreeNode;
import java.sql.Time;

class MyBlockingQueue {
    // 保存数据的本体
    private int[] data = new int[1000];
    // 有效元素个数
    private int size = 0;
    // 队首下标
    private int head = 0;
    // 队尾下标
    private int tail = 0;

    // 专门的所对象
    private Object loker = new Object();

    // 入队列
    public void put(int value) throws InterruptedException {
        synchronized (loker) {
            // 1、队列满了
            if (size == data.length) {
                // 队列满了，暂时先直接返回
                // return;
                loker.wait();
            }
            // 2、把新的元素放入 tail 位置
            data[tail] = value;
            tail++;
            // 3、处理 tail 到达数组末尾的情况
            if (tail >= data.length) {
                tail = 0;
            }
            // 代码可读性差，除法速度不如比较，不利于开发效率也不利于运行效率
            // tail = tail % data.length;
            // 4、插入完成，修改元素个数
            size++;
            // 如果入队列成功，则对了非空，唤醒 take 中的 wait
            loker.notify();
        }
    }

    // 出队列
    public Integer take() throws InterruptedException {
        synchronized (loker) {
            // 1、队列为空
            if (size == 0) {
                // 如果队列为空，返回一个非法值
                // return null;
                loker.wait();
            }
            // 2、取出 head 位置的元素
            int ret = data[head];
            head++;
            // 3、head 到末尾 重新等于 0
            if (head >= data.length) {
                head = 0;
            }
            // 4、数组元素个数--
            size--;
            // take 成后，唤醒 put 中的 wait
            loker.notify();
            return ret;
        }
    }
}

public class TestDemo {
    private static MyBlockingQueue queue = new MyBlockingQueue();

    public static void main(String[] args) throws InterruptedException {
        // 实现一个而简单的生产者消费者模型
        Thread producer = new Thread(() -> {
            int num = 0;
            while (true) {
                try {
                    System.out.println("生产了：" + num);
                    queue.put(num);
                    num++;
                    // 当消费者生产地慢，消费者就得跟着生产者的步伐走
                    // Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        producer.start();

        Thread customer = new Thread(() -> {
            while (true) {
                try {
                    int num = queue.take();
                    System.out.println("消费了：" + num);
                    // 消费者消费地慢
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }}
        });
        customer.start();

        /*MyBlockingQueue queue = new MyBlockingQueue();
        queue.put(1);
        queue.put(2);
        queue.put(3);
        queue.put(4);
        System.out.println(queue.take());
        System.out.println(queue.take());
        System.out.println(queue.take());
        System.out.println(queue.take());*/
    }
}