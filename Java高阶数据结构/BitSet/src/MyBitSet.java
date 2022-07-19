import java.util.Arrays;
import java.util.BitSet;

public class MyBitSet {
    public byte[] elem;
    public int usedSize; // 记录当前位图存了多少有效数据

    public MyBitSet() {
        this.elem = new byte[1];
    }

    /**
     * @param n 给定多少个比特位
     */
    public MyBitSet(int n) {
        this.elem = new byte[n / 8 + 1]; // 向上取整
    }

    /**
     * 设置某一位为一
     * @param val
     */
    public void set(int val) {
        if (val < 0) {
            throw new IndexOutOfBoundsException("val 下标有误");
        }
        int arrayIndex = val / 8;
        // 扩容
        if (arrayIndex > elem.length - 1) {
            elem = Arrays.copyOf(elem, arrayIndex + 1);
        }
        int bitIndex = val % 8;
        elem[arrayIndex] |= (1 << bitIndex);
        usedSize++;
    }

    /**
     * 判断某一位是否为一 测试该数字是否存在
     * @param val
     * @return
     */
    public boolean get(int val) {
        if (val < 0) {
            throw new IndexOutOfBoundsException("val 下标有误");
        }
        int arrayIndex = val / 8;
        int bitIndex = val % 8;
        // 不等于 0 即存在，等于 0 返回 false
        return (elem[arrayIndex] & (1 << bitIndex)) != 0;
    }

    /**
     * 将给定位置 置为 0
     * @param val
     */
    public void reSet(int val) {
        if (val < 0) {
            throw new IndexOutOfBoundsException("val 下标有误");
        }
        int arrayIndex = val / 8;
        int bitIndex = val % 8;
        elem[arrayIndex] &= (~(1 << bitIndex));
        usedSize--;
    }

    /**
     * 当前比特位有多少个 1
     * @return
     */
    public int getUsedSize() {
        return this.usedSize;
    }


    // 测试 MyBitSet
    public static void main2(String[] args) {
        int[] array = {3, 2, 10, 5, 12};
        MyBitSet myBitSet = new MyBitSet(18);
        for (int i = 0; i < array.length; i++) {
            myBitSet.set(array[i]);
        }
        System.out.println("目前有 " + myBitSet.getUsedSize() + " 个元素"); // 5
        System.out.println("有没有 10：" + myBitSet.get(10)); // true
        myBitSet.reSet(10);
        System.out.println("有没有 10：" + myBitSet.get(10)); // false
    }

    // 排序
    public static void main3(String[] args) {
        int[] array = {1, 3, 2, 13, 10, 3, 14, 18, 3};
        MyBitSet myBitSet = new MyBitSet(18);
        for (int i = 0; i < array.length; i++) {
            myBitSet.set(array[i]);
        }
        for (int i = 0; i < myBitSet.elem.length; i++) { // i 遍历 elem 每一个 byte
            for (int j = 0; j < 8; j++) { // j 遍历每一个 byte 的 8 位，0-7，8-15，...
                if ((myBitSet.elem[i] & (1 << j)) != 0) { // 如果是 1 输入对应的数
                    System.out.print(i * 8 + j + " "); // 输出：1 2 3 10 13 14 18
                }
            }
        }
    }



    // java 位图
    public static void main(String[] args) {
        int[] array = {3, 2, 10, 5, 12};
        BitSet bitSet = new BitSet();
        for (int i = 0; i < array.length; i++) {
            bitSet.set(array[i]);
        }
        System.out.println("有没有 10：" + bitSet.get(10)); // true
        System.out.println("有没有 20：" + bitSet.get(20)); // false
    }
}
