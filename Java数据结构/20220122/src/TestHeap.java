import java.util.Arrays;

public class TestHeap {
    public int[] elem;
    public int usedSize;

    public TestHeap() {
        this.elem = new int[10];
    }

    /**
     * 向下调整
     * @param parent 每棵树的根节点
     * @param len 每棵树的调整的结束位置
     */
    public void shiftDown(int parent, int len) {
        int child = 2 * parent + 1;
        // 判断有右孩子
        while(child < len) {
            if(child + 1 < len && this.elem[child] < this.elem[child + 1]) {
                child++; // child 指向左右孩子中最大值的那一个下标
            }
            if(this.elem[child] > this.elem[parent]) {
                int tmp = this.elem[child];
                this.elem[child] = this.elem[parent];
                this.elem[parent] = tmp;
                parent = child;
                child = 2 * parent + 1;
            } else {
                break;
            }
        }
    }

    public void createHeap(int[] array) {
        for (int i = 0; i < array.length; i++) {
            this.elem[i] = array[i];
            usedSize++;
        }
        // 双亲(parent)下标 = (child - 1) / 2
        for (int parent = (usedSize-1-1)/2; parent >= 0 ; parent--) {
            // 调整
            shiftDown(parent, usedSize);
        }
    }


    private void shiftUp(int child) {
        int parent = (child - 1) / 2;
        while(child > 0) {
            if(elem[child] > elem[parent]) {
                int tmp = elem[child];
                elem[child] = elem[parent];
                elem[parent] = tmp;
                child = parent;
                parent = (child - 1) / 2;
            } else {
                break;
            }
        }
    }

    // 入队列  向上调整
    public void offer(int val) {
        if(isFull()) { // 扩容
            elem = Arrays.copyOf(elem, 2*elem.length);
        }
        this.elem[usedSize++] = val;
        shiftUp(usedSize - 1);
    }

    public boolean isFull() {
        return usedSize == this.elem.length;
    }


    // 出队列
    public int pop() {
        if(isEmpty()) {
            throw new RuntimeException("优先级队列为空");
        }
        // 1、交换0下标和最后一个元素
        int tmp = elem[0];
        elem[0] = elem[usedSize - 1];
        elem[usedSize - 1] = tmp;
        // 2、调整0下标
        shiftDown(0, usedSize);
        return tmp;
    }

    public boolean isEmpty() {
        return usedSize == 0;
    }

    public int peek() {
        if(isEmpty()) {
            throw new RuntimeException("优先级队列为空");
        }
        return elem[0];
    }
}
