import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.concurrent.ConcurrentHashMap;

class Test {
    public void test() {
        System.out.println("test()->");
    }
}

public class TestDemo3 {
    public static void main(String[] args) {
        PriorityQueue<Integer> pri = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return 0;
            }
        });

    }

    public static void main1(String[] args) {
        new Test();// 匿名对象

        new Test() {  // 匿名内部类

            @Override
            public void test() {
                System.out.println("重写的test方法"); // 重写后：重写的test方法
            }
        }.test(); // 重写前：test()->
    }
}
