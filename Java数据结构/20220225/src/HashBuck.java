import sun.util.resources.cldr.zh.CalendarData_zh_Hans_HK;

public class HashBuck {

    static class Node {
        public int key;
        public int val;
        public Node next;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    public Node[] array;
    public int usedSize;
    // 负载因子
    public static final double DEFAULT_LOAD_FACTOR = 0.75;

    public HashBuck() {
        this.array = new Node[10];
    }

    /**
     * put
     * @param key
     * @param val
     */
    public void put(int key, int val) {
        // 1、找到 key 所在的位置
        int index = key % this.array.length;
        // 2、遍历这个下标的链表，看是不是有相同 key的节点，如果有，更新它的 val值
        Node cur = array[index];
        while (cur != null) {
            if(cur.key == key) {
                cur.val = val; // 更新完 结束
                return;
            }
            cur = cur.next;
        }
        // 3、如果没有 key 这个元素，头插法插入
        Node node = new Node(key, val);
        node.next = array[index]; // 先后
        array[index] = node; // 再前
        this.usedSize++;
        // 4、插入元素成功之后，检查当前散列表的负载因子
        if(loadFactor() > DEFAULT_LOAD_FACTOR) {
            // 增加散链表的长度
            resize();
        }
    }

    // 增加散链表的长度
    private void resize() {
        Node[] newArray = new Node[array.length * 2];
        for (int i = 0; i < array.length; i++) {
            Node cur = array[i]; // 每个下标下的链表
            while (cur != null) {
                int index = cur.key % newArray.length; // 获取新的下标
                // 就是把cur这个节点，以头插/尾插的形式插入到新的数组对应下标的链表当中
                Node curNext = cur.next; // 如果cur的后面还有节点
                cur.next = newArray[index]; // 先绑定后面
                newArray[index] = cur; // 再绑定前面
                cur = curNext;
            }
        }
        array = newArray;
    }

    // 检查当前散列表的负载因子
    private double loadFactor() {
        return 1.0 * this.usedSize / array.length;
    }

    /**
     * 根据 key 获取 val 的值
     * @param key
     * @return
     */
    public int get(int key) {
        // 1、找到 key 所在的位置
        int index = key % this.array.length;
        // 2、遍历这个下标的链表，看是不是有相同 key的节点
        Node cur = array[index];
        while (cur != null) {
            if(cur.key == key) {
                return cur.val;
            }
            cur = cur.next;
        }
        return -1;
    }

    public static void main(String[] args) {
        HashBuck hashBuck = new HashBuck();
        hashBuck.put(1,1);
        hashBuck.put(12,12);
        hashBuck.put(3,3);
        hashBuck.put(6,6);
        hashBuck.put(7,7);
        hashBuck.put(2,2);
        hashBuck.put(11,11);
        // hashBuck.put(8,8); // 8/10>0.75 扩容
        System.out.println(hashBuck.get(11));
    }
}
