import java.math.BigDecimal;
import java.util.*;

class Node {
    public int val;
    public Node next;
    public Node(int val) {
        this.val = val;
    }
}

public class TestDemo {
    public static void main9(String[]  args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
//            String ret = scanner.nextLine(); // n 读一行 防止换行作为了一个 s
//            int n = Integer.valueOf(ret);
            int n = scanner.nextInt();
            scanner.nextLine(); // 或者再读 line
            while (n-- != 0) {
                String s = scanner.nextLine();
                if (s.contains(",") || s.contains(" ")) {
                    if (n == 0) { // 最后一个没有逗号
                        System.out.print("\"" + s + "\"");
                    } else {
                        System.out.print("\"" + s + "\"" + ", ");
                    }
                } else {
                    if (n == 0) {
                        System.out.print(s);
                    } else {
                        System.out.print(s + ", ");
                    }
                }
            }
            System.out.println();
        }
    }
    private static int fib2(int n) {
        if (n == 1 || n == 2 || n == 3 || n == 4) {
            return 1;
        }
        return fib2(n - 1) + fib2(n - 4);
    }

    private static void fib(int n) {
        int[] array = new int[n];
        for (int i = 0; i < 4; i++) {
            array[i] = 1;
        }
        for (int i = 4; i < n; i++) {
            array[i] = array[i - 1] + array[i - 4];
        }
        System.out.println(Arrays.toString(array));
    }

    public static void main(String[] args) {
        fib(16); // [1, 1, 1, 1, 2, 3, 4, 5, 7, 10, 14, 19, 26, 36, 50, 69]
    }

    public static void main7(String[]  args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String ret = scanner.nextLine(); // 读一行 防止换行作为了一个 s
            int n = Integer.valueOf(ret);
            while (n-- != 0) {
                String s = scanner.nextLine();
                if (s.contains(",") || s.contains(" ")) {
                    if (n == 0) {
                        System.out.print("\"" + s + "\"");
                    } else {
                        System.out.print("\"" + s + "\"" + ", ");
                    }
                } else {
                    if (n == 0) {
                        System.out.print(s);
                    } else {
                        System.out.print(s + ", ");
                    }
                }
            }
            System.out.println();
        }
    }

    public static void main6(String[] args) {
        // 可以用 long
        BigDecimal[] bigDecimal = new BigDecimal[90];
        // 第一天 1只小兔子               1
        // 第二天 兔子长大                1
        // 第三天 1只大兔子 + 生了小兔子    2
        BigDecimal b1 = new BigDecimal("1");
        BigDecimal b2 = new BigDecimal("1");
        BigDecimal b3 = b1;
        for (int i = 0; i < 90; i++) {
            bigDecimal[i] = b3;
            b1 = b2;
            b2 = b3;
            b3 = b1.add(b2);
        }
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            System.out.println(bigDecimal[n - 1]);
        }
    }

    private static int cut(String s, String t) {
        int i = s.indexOf(t);
        if (i == -1) {
            return 0;
        }
        return 1 + cut(s.substring(i + t.length()), t);
    }

    public static void main5(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String s = scanner.next();
            String t = scanner.next();
            int ret = cut(s, t);
            System.out.println(ret);
        }
    }
    public static void insert(Node head, int val) {
        if (head == null) {
            throw new RuntimeException("节点为空，插入失败！");
        }
        Node cur = head;
        while (cur.next != null) { // cur.next
            cur = cur.next;
        }
        Node node = new Node(val);
        cur.next = node;
    }

    public static void print(Node head) {
        if (head == null) {
            return;
        }
        Node cur = head;
        while (cur != null) {
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
    }

    public static void main4(String[] args) {
        Node head = new Node(1);
        insert(head, 3);
        insert(head, 4);
        insert(head, 5);
        print(head);
    }

    // substrings of p are present in s.
    // 连续子串个数 不重复
    // 知道以某字符为结尾，和长度，就能确定这个子串。dp[α] 表示 p 中以字符 α 结尾且在 s 中的子串的最长长度
    public static int findSubstringInWraproundString(String p) {
        int[] dp = new int[26];
        int k = 0; // 连续递增的子串长度 k
        for (int i = 0; i < p.length(); i++) {
            // 和上一个字符 dp[i - 1] 连续
            // 相差 1 或 -25
            if (i > 0 && (p.charAt(i) - p.charAt(i - 1) + 26) % 26 == 1) {
                k++;
            } else { // 重新记录连续子串长度
                k = 1;
            }
            // 不同的子串
            dp[p.charAt(i) - 'a'] = Math.max(k, dp[p.charAt(i) - 'a']);
        }
        return Arrays.stream(dp).sum();
    }

    public static void main3(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        int count = findSubstringInWraproundString(s);
        System.out.println(count);
    }

    public static void main2(String[] args) {

        // array：Arrays.sort 重写 Comparator，不能用基本类型数组
        int[] array = {21, 2, 5, 2, 9, 31};
//        Arrays.sort(array, new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o1,compareTo(o2);
//            }
//        });
        // 使用 Integer 数组，自动装箱，排序：
        Integer[] integers = {21, 2, 5, 2, 9, 31};
        Arrays.sort(integers, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });
        System.out.println(Arrays.toString(integers)); // [2, 2, 5, 9, 21, 31]

        // strings
        String[] strings = {"dfa", "acf", "zcc"};
        Arrays.sort(strings, new Comparator<String>() {
            @Override
            public int compare(String log1, String log2) {
                return log1.compareTo(log2);
            }
        });
        System.out.println(Arrays.toString(strings)); // [acf, dfa, zcc]

        // list
        List<Integer> list = new ArrayList<>();
        list.add(21); list.add(2); list.add(5); list.add(2); list.add(9); list.add(31);
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1; // 从大到小排序
            }
        });
        System.out.println(Arrays.toString(list.toArray())); // [31, 21, 9, 5, 2, 2]
    }

    public static void main1(String[] args) {
        System.out.println(123);
    }
}
