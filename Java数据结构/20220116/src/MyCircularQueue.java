

public class MyCircularQueue {

    public int[] elem;
    public int front; // 对头下标
    public int rear; // 队尾下标

    public MyCircularQueue(int k) {
        this.elem = new int[k + 1]; // k + 1
    }

    // 入队列
    public boolean enQueue(int value) {
        if(isFull()) return false;
        this.elem[rear] = value;
        rear = (rear + 1) % elem.length;
        return true;
    }

    // 出队列
    public boolean deQueue() {
        if(isEmpty()) return false;
        front = (front +  1) % elem.length;
        return true;
    }

    // 得到队头元素
    public int Front() {
        if(isEmpty()) return -1;
        return elem[front];
    }

    // 得到队尾元素
    public int Rear() {
        if(isEmpty()) return -1;
        int index = -1;
        if(rear == 0) {
            index = elem.length - 1;
        } else {
            index = rear - 1;
        }
        return elem[index];
    }

    public boolean isEmpty() {
        return front == rear; // 相遇
    }

    public boolean isFull() {
        // rear 的下一个是 front
        if((this.rear + 1) % elem.length == front) {
            return true;
        }
        return false;
    }
}
