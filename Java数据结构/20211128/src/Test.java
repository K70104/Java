import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;


public class Test {
    public static void main(String[] args) {
        ArrayList<String> list2 = new ArrayList<>();
        list2.add("a");
        list2.add("b");
        list2.add("c");
        String ret = list2.remove(0);
        System.out.println(ret); // a
        System.out.println(list2); // [b, c]
    }

    public static void main5(String[] args) {
        ArrayList<String> list2 = new ArrayList<>();
        list2.add("a");
        list2.add("b");
        list2.add("c");
        // add方法，默认放到数组的最后一个位置
        System.out.println(list2); // [a, b, c]

        list2.add(0, "hello");
        System.out.println(list2); // [hello, a, b, c]

        ArrayList<String> list3 = new ArrayList<>();
        list3.add("我是测试List1");
        list3.add("我是测试List2");
        list3.add("我是测试List3");
        list2.addAll(list3); // [hello, a, b, c, 我是测试List1, 我是测试List2, 我是测试List3]
        System.out.println(list2);
    }

    public static void main3(String[] args) {
        ArrayList<String> list2 = new ArrayList<>();
        // CopyOnWriteArrayList<String> list2 = new CopyOnWriteArrayList<>(); // 线程安全的
        list2.add("hello");
        list2.add("bit");
        list2.add("haha");

        ListIterator<String> it2 = list2.listIterator();
        while (it2.hasNext()) {
            String ret = it2.next();
            if(ret.equals("bit")) {
                it2.add("gaobo"); // 放到下一个
            }else {
                System.out.print(ret + " ");
            }
        }
        System.out.println("=================");
        System.out.println(list2);
        // hello haha =================
        // [hello, bit, gaobo, haha]
    }

    public static void main2(String[] args) {
        ArrayList<String> list2 = new ArrayList<>();
        list2.add("hello");
        list2.add("bit");
        list2.add("haha");

        Iterator<String> it = list2.iterator();
        while (it.hasNext()) {
            String ret = it.next();
            if(ret.equals("hello")) {
                it.remove(); // 首先需要使用next方法迭代出集合中的元素 ，然后才能调用remove方法
            }else {
                System.out.print(ret + " ");
            }
        }

        ListIterator<String> it2 = list2.listIterator();
        while (it2.hasNext()) {
            String ret = it2.next();
            if(ret.equals("hello")) {
                it2.remove(); // 首先需要使用next方法迭代出集合中的元素 ，然后才能调用remove方法
            }else {
                System.out.print(ret + " ");
            }
        }
    }

    public static void main1(String[] args) {
        ArrayList<String> list2 = new ArrayList<>();
        list2.add("hello");
        list2.add("bit");
        list2.add("haha");
        // 重写了ToString()
        System.out.println(list2);
        System.out.println("================");
        for(int i = 0; i < list2.size(); i++) {
            System.out.print(list2.get(i)+" ");
        }
        System.out.println();
        System.out.println("==================");
        for (String s : list2) {
            System.out.print(s+" ");
        }
        System.out.println();
        System.out.println("========迭代器打印==========");
        Iterator<String> it = list2.iterator();
        while (it.hasNext()) {
            System.out.print(it.next()+" ");
        }

        System.out.println();
        System.out.println("========迭代器List相关打印==========");
        ListIterator<String> it2 = list2.listIterator();
        // Iterator<String> it2 = list2.listIterator();
        while (it2.hasNext()) {
            System.out.print(it2.next()+" ");
        }
    }
}


/*public class Test {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("hello");
        list.add("bit");
        list.add("haha");
        System.out.println(list);

        // 使用另外一个ArrayList对list3进行初始化
        ArrayList<String> list3 = new ArrayList<>(list);
    }
}*/
