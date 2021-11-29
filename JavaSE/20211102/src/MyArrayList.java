import java.util.Arrays;

/**
 * 顺序表
 */
public class MyArrayList {

    public int[] elem;
    public int usedsize; // 当前有效的数据个数

    public MyArrayList() {
        this.elem = new int[10];
    }

    // 1、打印顺序表
    public void display() {
        for (int i = 0; i < usedsize; i++) {
            System.out.print(this.elem[i]+" ");
        }
        System.out.println();
    }

    // 2、获取顺序表的有效长度
    public int size() {
        return this.usedsize;
    }

    public boolean isFull() {
        return this.usedsize == this.elem.length;
    }

    // 3、在 pos 位置新增元素
    public void add(int pos, int data) {
        if(pos < 0 || pos > usedsize) {
            System.out.println("pos 位置不合法！");
            return;
        }

        if(isFull()) {
            this.elem = Arrays.copyOf(this.elem, 2*this.elem.length);
            // 扩容后的数组
        }

        for (int i = usedsize-1; i >= pos; i--) {
            this.elem[i+1] = this.elem[i];
        }
        this.elem[pos] = data;
        this.usedsize++;
    }

    // 4、判定是否包含某个元素
    public boolean contains(int toFind) {
        for (int i = 0; i < this.usedsize; i++) {
            if(this.elem[i] == toFind) {
                return true;
            }
        }
        return false;
    }

    // 5、查找某个元素对应的位置
    public int search(int toFind) {
        for (int i = 0; i < this.usedsize; i++) {
            if(this.elem[i] == toFind) {
                return i;
            }
        }
        return -1;
    }

    public boolean isEmpty() {
        return this.usedsize == 0;
    }

    // 6、获取 pos 位置的元素
    public int getPos(int pos) {
        if(pos < 0 || pos >= usedsize) {
            System.out.println("pos 位置不合法！");
            return -1; // 不考虑业务上的处理-1 后期可以抛异常
        }
        if(isEmpty()) {
            System.out.println("顺序表为空！");
            return -1;
        }
        return this.elem[pos];
    }

    // 7、给 pos 位置的元素设为 value
    public void setPos(int pos, int value) {
        if(pos < 0 || pos >= usedsize) {
            System.out.println("pos 位置不合法！");
            return;
        }
        if(isEmpty()) {
            System.out.println("顺序表为空！");
            return;
        }
        this.elem[pos] = value;
    }

    // 8、删除第一次出现的关键字key
    public void remove(int toRemove) {
        if(isEmpty()) {
            System.out.println("顺序表为空！");
            return;
        }
        int index = search(toRemove);
        if(index == -1) {
            System.out.println("没有你要删除的数!");
            return;
        }
        for (int i = index; i < this.usedsize - 1; i++) {
            this.elem[i] = this.elem[i+1];
        }
        this.usedsize--;
        // this.elem[usedsize] = null; // 如果数组里是引用数据类型
    }

    // 9、清空顺序表
    public void clear() {
        this.usedsize = 0;
        /*
        引用类型：
        for (int i = 0; i < usedsize; i++) {
            this.elem[i] = null;
        }*/
    }

}
