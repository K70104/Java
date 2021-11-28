import java.util.ArrayList;
import java.util.List;

public class Test2 {
    public static void main(String[] args) {
        ArrayList<String> list1 = new ArrayList<>(); // 初始的大小是几？答案是0
        list1.add("bit"); // 当第一次存放数据元素的时候，顺序表被分配大小为10
        System.out.println(list1);
        ArrayList<String> list2 = new ArrayList<>(13); //初始大小是指定的13
    }

    public static void main8(String[] args) {
        ArrayList<String> list2 = new ArrayList<>();
        list2.add("a");
        list2.add("b");
        list2.add("c");
        list2.add("f");
        list2.add("g");
        List<String> sub = list2.subList(1, 3);
        System.out.println(sub); // [b, c]

        sub.set(0, "bit");
        // 把截取的[b, c] 起始位置给了sub
        System.out.println(sub); // [bit, c]
        System.out.println(list2); // [a, bit, c, f, g]
    }

    public static void main7(String[] args) {
        ArrayList<String> list2 = new ArrayList<>();
        list2.add("a");
        list2.add("b");
        list2.add("c");
        String ret = list2.get(0);
        System.out.println(ret); // a
        System.out.println(list2); // [a, b, c]

        String ret2 = list2.set(0, "p");
        System.out.println("原来的字符串是："+ret2); // 原来的字符串是：a
        System.out.println(list2); // [p, b, c]

        // 判断是否包含"p"
        System.out.println(list2.contains("p")); // true

        // 查找下标
        System.out.println(list2.indexOf("c")); // 2

        System.out.println(list2.lastIndexOf("c")); // 2

        // 清空
        list2.clear();
        System.out.println(list2); // []
    }
}

/*public class Test2 {
    public static void main(String[] args) {
        ArrayList<String> list2 = new ArrayList<>();
        list2.add("a");
        list2.add("b");
        list2.add("c");
        boolean flag = list2.remove("c");
        System.out.println(flag); // true
        System.out.println(list2); // [b]
    }
}*/
