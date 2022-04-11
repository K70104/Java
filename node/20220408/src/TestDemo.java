import javafx.concurrent.Task;

import java.util.concurrent.PriorityBlockingQueue;

// 创建一个类，表示一个任务
class MyTask implements Comparable<MyTask> {
    // 任务具体要做什么
    private Runnable runnable;
    // 任务具体什么做，保存任务要执行的毫秒级时间戳
    private long time;

    // delay 是一个时间戳，不是绝对的时间戳的值
    public MyTask(Runnable runnable, long delay) {
        this.runnable = runnable;
        this.time = System.currentTimeMillis() + delay;
    }

    public void run() {
        runnable.run();
    }

    public long getTime() {
        return time;
    }

    @Override
    public int compareTo(MyTask o) {
        return (int) (this.time - o.time);
    }
}

class MyTimer {
    // 定时器内部要能够存放多个任务
    private PriorityBlockingQueue<MyTask> queue = new PriorityBlockingQueue<>();

    public void schedule(Runnable runnable, long delay) {
        MyTask task = new MyTask(runnable, delay);
        queue.put(task); // 任务放入堆
        synchronized (locker) {
            locker.notify();
        }
    }

    private Object locker = new Object();

    public MyTimer() {
        Thread t = new Thread(() -> {
            while (true) {
                try {
                    // 取出队首元素
                    MyTask task = queue.take();
                    // 再计较这个任务有没有到时间
                    long curTime = System.currentTimeMillis();
                    if (curTime < (task).getTime()) { // 没到时间，任务放回堆
                        queue.put(task);
                        synchronized (locker) {
                            locker.wait(task.getTime() - curTime);
                        }
                    } else { // 时间到了，执行任务
                        task.run();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t.start();
    }
}

public class TestDemo {
    public static void main(String[] args) {
        MyTimer myTimer = new MyTimer();
        myTimer.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("hello timer");
            }
        }, 3000);
        System.out.println("main");
    }
}

