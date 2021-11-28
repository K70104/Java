import java.util.*;

public class TestDemo {
    public static void main(String[] args) {

    }

    public static void main3(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("及时雨", "宋江");
        map.put("豹子头", "林冲");

        System.out.println(map.isEmpty()); // false
        System.out.println(map.size()); // 2

        String ret = map.get("及时雨");
        System.out.println(ret); // 宋江
        // 没有找到用默认值代
        System.out.println(map.getOrDefault("花和尚", "鲁智深")); // 鲁智深

        System.out.println(map.containsKey("豹子头")); // true
        System.out.println(map.containsValue("林冲")); // true

        // 不是按顺序
        System.out.println(map); // {豹子头=林冲, 及时雨=宋江}

        Set<Map.Entry<String, String>> entrySet = map.entrySet(); // 把k v组装成一个整体

        for (Map.Entry<String, String> entry : entrySet) {
            System.out.println("key: "+entry.getKey()+" value:"+entry.getValue());
        }
    }

    public static void main2(String[] args) {
        Collection<String> collection = new ArrayList<>();
        collection.add("hello");
        collection.add("world");
        System.out.println(collection); // [hello]

        collection.remove("world");
        System.out.println(collection); // [hello]

        /*Object[] objects = collection.toArray();
        System.out.println(Arrays.toString(objects)); // [hello, world]

        System.out.println(collection.size()); // 2*/
        /*System.out.println(collection); // [hello, world]
        collection.clear();
        System.out.println(collection); // []

        System.out.println(collection.isEmpty()); // true*/
    }

    public static void main1(String[] args) {
        Collection<String> collection = new ArrayList<>();
        collection.add("hello");

        // 尖括号中 不能放简单的基本类型 一定是类类型
        Collection<Integer> collection1 = new ArrayList<>();
        collection1.add(10);
    }
}
