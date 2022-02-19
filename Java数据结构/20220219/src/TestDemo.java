import java.util.*;

class ListNode {
    public int val;
    public ListNode next;
}

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

public class TestDemo {


    public static void findbroken(String strExcept, String strActual) {
        Set<Character> set = new HashSet<>();
        for(int i = 0; i < strActual.length(); i++) {
            set.add(strActual.charAt(i));
        }
        // 答案字符只出现一次
        Set<Character> result = new HashSet<>();
        for(int i = 0; i < strExcept.length(); i++) {
            char ch = strExcept.charAt(i);
            if(!set.contains(ch)) { // 期望的字符没有 就是坏键盘
                if(!result.contains(ch)) {
                    result.add(ch);
                    System.out.print(Character.toUpperCase(ch)); // 大写
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String strExcept = scanner.nextLine();
        String strActual = scanner.nextLine();
        findbroken(strExcept, strActual);
    }

    public Node copyRandomList(Node head) {
        Map<Node, Node> map = new HashMap<>();
        Node cur = head;
        // 第一次遍历 存储老节点与新节点的映射关系
        while(cur != null) {
            Node node = new Node(cur.val);
            map.put(cur, node);
            cur = cur.next;
        }
        // 第二次遍历 修改新节点的next 和random
        cur = head;
        while(cur != null) {
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        // 返回新节点的head
        return map.get(head);
    }

    public ListNode removeDuplicateNodes(ListNode head) {
        if(head == null) {
            return null;
        }
        HashSet<Integer> set = new HashSet<>();
        ListNode cur = head;
        // set.add(cur.val); //
        // while(cur != null && cur.next != null) {
        //     if(set.contains(cur.next.val)) { // 用下一个查找
        //         cur.next = cur.next.next;
        //     } else {
        //         set.add(cur.next.val); //
        //         cur = cur.next;
        //     }
        // }

        // 双指针
        ListNode pre = null;
        while(cur != null) {
            if(set.contains(cur.val)) {
                pre.next  = cur.next;
            } else {
                set.add(cur.val);
                pre = cur;
            }
            cur = cur.next;
        }
        return head;
    }

    // 找出第一个重复数据
    public static int func3(int[] array) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < array[i]; i++) {
            if(set.contains(array[i])) {
                return array[i];
            } else {
                set.add(array[i]);
            }
        }
        return -1;
    }

    // 去重
    public static Set<Integer> func2(int[] array) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < array.length; i++) {
            set.add(array[i]);
        }
        return set;
    }

    // 十万个数据 统计次数
    public static Map<Integer, Integer> func1(int[] array) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            map.put(array[i], map.getOrDefault(array[i], 0) + 1);
        }
        return map;
    }

    public static void main1(String[] args) {
        int[] array = new int[1_0000];
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(1000);
        }
        Map<Integer, Integer> map = func1(array);
        System.out.println(map);
    }
}
