import java.util.*;

class Card {
    public int rank; // 数值
    public String suit; // 花色
    public Card(int rank, String suit) {
        this.rank = rank;
        this.suit = suit;
    }

    @Override
    public String toString() {
        return "Card{" +
                "rank=" + rank +
                ", suit='" + suit + '\'' +
                '}';
    }
}

class RankComparator implements Comparator<Card> {
    @Override
    public int compare(Card o1, Card o2) {
        return o2.rank - o1.rank;
    }
}

public class TestDemo {
    // 从10W个数据中 找出第一个重复的数据
    public static int func3(int[] array) {
        Set<Integer> set = new HashSet<>();
        for (int x : array) {
            if(set.contains(x)) {
                return x;
            } else {
                set.add(x);
            }
        }
        return -1;
    }

    // 将10W个数据去重
    public static Set<Integer> func2(int[] array) {
        Set<Integer> set = new HashSet<>();
        for (int x : array) {
            set.add(x);
        }
        return set;
    }

    // 给定10W数据 统计每个数据出现的次数
    public static Map<Integer, Integer> func1(int[] array) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int x : array) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        return map;
    }

    // 2、优先级队列
    public List<String> topKFrequent(String[] words, int k) {
        // 1、统计每个单词出现的次数
        Map<String, Integer> map = new HashMap<>();
        for(String word : words) {
            map.put(word, map.getOrDefault(map, 0) + 1);
        }
        // 2、建立一个大小为 K 的小根堆
        PriorityQueue<Map.Entry<String, Integer>> minHeap = new PriorityQueue<>(k, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                // 如果不满k个 a-2 b-2 最后会逆置
                // 如果频率相同 相反
                if(o1.getValue().compareTo(o2.getValue()) == 0) {
                    return o2.getKey().compareTo(o1.getKey());
                }
                return o1.getValue() - o2.getValue();
            }
        });
        // 3、遍历 map
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if(minHeap.size() < k) {
                minHeap.offer(entry);
            } else {
                // 拿出堆顶元素
                Map.Entry<String, Integer> top = minHeap.peek();
                // 堆中放满 k 个元素，比较堆顶的元素的数据，和当前数据的大小关系
                if(top.getValue().compareTo(entry.getValue()) == 0) {
                    // 和堆顶元素出现次数相同 比较单词次数 单词小的入堆
                    if(top.getKey().compareTo(entry.getKey()) > 0) {
                        minHeap.poll(); // 堆顶元素大
                        minHeap.offer(entry);
                    }
                } else {
                    // 频率不相等时 小堆的堆顶元素最小 如果当前单词单词频率比堆顶大 出堆
                    if (top.getValue().compareTo(entry.getValue()) < 0) {
                        minHeap.poll();
                        minHeap.offer(entry);
                    }
                }
            }
        }
        // 4、返回
        List<String> ret = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            Map.Entry<String, Integer> top = minHeap.poll();
            ret.add(top.getKey());
        }
        Collections.reverse(ret); // 逆置
        return ret;
    }

    // 1、哈希表 排序
    public List<String> topKFrequent1(String[] words, int k) {
        // 统计 word 次数
        Map<String, Integer> map = new HashMap<>();
        for(String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        // Key 加入 List
        List<String> list = new ArrayList<>();
        for(Map.Entry<String, Integer> entry : map.entrySet()) {
            list.add(entry.getKey());
        }
        // 重写 Comparator 方法。按出现次数比较，次数相同，按字典顺序比较
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return map.get(o1) == map.get(o2) ? o1.compareTo(o2) : map.get(o2) - map.get(o1);
            }
        });
        // 返回前 k 个
        return list.subList(0, k);
    }

    public static void main(String[] args) {
        String str = "12345678";
        String tmp1 = str.substring(2);
        System.out.println(tmp1);

        String tmp = str.substring(1, 2);
        System.out.println(tmp);

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        List<Integer> list2 = list.subList(0 ,2);
        System.out.println(list2); // [1, 2]
    }

    public static void main6(String[] args) {
        int[] array = new int[1_0000];
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(1000);
        }
        /*Map<Integer, Integer> map = func1(array);
        System.out.println(map);*/
        /*Set<Integer> set = func2(array);
        System.out.println(set);*/
        System.out.println(func3(array));
    }


    public static void move_Parity(int[] arr, int sz) {
        int left = 0;
        int right = sz - 1;
        while (left < right) {
            while ((left < right) && arr[left] % 2 == 1) {
                left++;
            }
            while ((left < right) && arr[right] % 2 == 0) {
                right--;
            }
            if (left < right) {
                int tmp = arr[left];
                arr[left] = arr[right];
                arr[right] = tmp;
            }
            left++;
            right--;
        }
    }

    public String reverseOnlyLetters(String s) {
        char[] ret = s.toCharArray();
        int left = 0;
        int right = ret.length - 1; //
        while(left < right) {
            while(left < right && !Character.isLetter(ret[left])) {
                left++;
            }
            while(left < right && !Character.isLetter(ret[right])) {
                right--;
            }
            if(left < right) {
                char tmp = ret[left];
                ret[left] = ret[right];
                ret[right] = tmp;
            }
            left++;
            right--;
        }
        return new String(ret);
    }


    public static void main5(String[] args) {
        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(3);
        Iterator<Integer> iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " "); // 1 2 3
        }
    }

    public static void main4(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("abc", 2);
        map.put("bit", 5);

        map.put(null, null);
        map.put(null, 2);
        map.put("bds", null );

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        // abc: 2
        // bit: 5
        Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
        for (Map.Entry<String, Integer> set : entrySet) {
            System.out.println(set.getKey() + ": " + set.getValue());
        }
        // abc: 2
        // bit: 5
    }

    public static void main3(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("abc", 2);
        map.put("bit", 5);

        Set<String> set = map.keySet();
        System.out.println(set); // [abc, bit]

        Collection<Integer> collection = map.values();
        System.out.println(collection); // [2, 5]
    }

    public static void main2(String[] args) {
        int[] arr = { 12,23,3,4,5,6,7,8,92,11 };
        move_Parity(arr, arr.length);
        System.out.println(Arrays.toString(arr));
        // [11, 23, 3, 7, 5, 6, 4, 8, 92, 12]
        // [11, 23, 3, 7, 5, 6, 4, 8, 92, 12]
    }

    public static void main1(String[] args) {
        Card card1 = new Card(1, "♥");
        Card card2 = new Card(2, "♦");

        RankComparator rankComparator = new RankComparator();
        int ret = rankComparator.compare(card1, card2);
        System.out.println(ret); // -1

        PriorityQueue<Card> pr = new PriorityQueue<>(rankComparator);
        pr.offer(card1);
        pr.offer(card2);
        System.out.println(pr);
    }
}
