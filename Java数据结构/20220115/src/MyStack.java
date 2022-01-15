import java.util.Arrays;

public class MyStack {
    public int[] elem;
    public int usedSize;

    public MyStack() {
        this.elem = new int[5];
    }

    public void push(int val) {
        if(isFull()) { // 2被扩容
            this.elem = Arrays.copyOf(this.elem, 2*this.elem.length);
        }
        this.elem[this.usedSize] = val;
        this.usedSize++;
    }

    // 判断数组满
    public boolean isFull() {
        return this.usedSize == this.elem.length;
    }

    public int pop() {
        if(isEmpty()) {
            throw new RuntimeException("栈为空");
        }
        int oldVal = this.elem[usedSize - 1];
        this.usedSize--;
        return oldVal;
    }

    public int peek() {
        if(isEmpty()) {
            throw new RuntimeException("栈为空");
        }
        return this.elem[usedSize - 1];
    }

    // 判断空
    public boolean isEmpty() {
        return this.usedSize == 0;
    }
}
