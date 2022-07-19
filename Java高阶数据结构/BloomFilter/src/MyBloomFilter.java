import java.util.BitSet;

/**
 * 构建哈希函数
 */
class SimpleHash {
    public int cap; // 容量
    public int seed; // 随机种子

    public SimpleHash(int cap, int seed) {
        this.cap = cap;
        this.seed = seed;
    }

    // 根据 seed 不同，创建不能的哈希函数
    int hash(String key) {
        int h;
        // (n - 1) & hash
        return (key == null) ? 0 : (seed * (cap - 1)) & ((h = key.hashCode()) ^ (h >>> 16));
    }
}

public class MyBloomFilter {
    public static final int DEFAULT_SIZE = 1 << 20;

    public BitSet bitSet; // 位图用来存储元素
    public int usedSize; // 有效元素

    public static final int[] seeds = {5, 7, 11, 13, 27, 33};

    public SimpleHash[] simpleHashes; // 哈希函数所对应类

    // 初始化 bitSet 和 simpleHashes
    public MyBloomFilter() {
        bitSet = new BitSet(DEFAULT_SIZE);
        simpleHashes = new SimpleHash[seeds.length];

        for (int i = 0; i < simpleHashes.length; i++) {
            simpleHashes[i] = new SimpleHash(DEFAULT_SIZE, seeds[i]);
        }
    }

    /**
     * 添加元素到布隆过滤器
     * @param val
     */
    public void add(String val) {
        // 让 X 个哈希函数，分别处理当前的数据
        for (SimpleHash simpleHash : simpleHashes) {
            int index = simpleHash.hash(val);
            // 得到这 X 个位置，把他们都存储在位图当中即可
            bitSet.set(index);
        }
        usedSize++;
    }

    /**
     * 判断是否包含 val (这里会存在一定的误判)
     * @param val
     * @return
     */
    public boolean contains(String val) {
        // 通过 X 个哈希函数，得到这 X 个位置
        for (SimpleHash simpleHash : simpleHashes) {
            int index = simpleHash.hash(val);
            if (!bitSet.get(index)) { // 有一个为 0，就一定不存在
                return false;
            }
        }
        return true;
    }

    // 验证
    public static void main(String[] args) {
        MyBloomFilter myBloomFilter = new MyBloomFilter();
        myBloomFilter.add("hello");
        myBloomFilter.add("hello2");
        myBloomFilter.add("bit");
        myBloomFilter.add("haha");
        System.out.println(myBloomFilter.contains("hello")); // true
        System.out.println(myBloomFilter.contains("oo")); // false
    }
}
