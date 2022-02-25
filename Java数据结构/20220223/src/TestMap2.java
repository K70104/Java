import java.util.HashMap;
import java.util.Map;

public class TestMap2 {

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        System.out.println(map.size()); // 0
        System.out.println(map.isEmpty()); // true
        System.out.println(map.get("作者")); // null
        System.out.println("=======================");

        System.out.println(map.getOrDefault("作者", "佚名")); // 佚名
        System.out.println(map.containsKey("作者")); // false
        System.out.println(map.containsValue("佚名")); // false
        System.out.println("=======================");

        map.put("作者", "鲁迅");
        map.put("标题", "狂人日记");
        map.put("发表时间", "1918年");
        System.out.println(map.size()); // 3
        System.out.println(map.isEmpty()); // false
        System.out.println("=======================");

        System.out.println(map.get("作者")); // 鲁迅
        System.out.println(map.getOrDefault("作者", "佚名")); // 鲁迅
        System.out.println("=======================");

        System.out.println(map.containsKey("作者")); // true
        System.out.println(map.containsValue("佚名")); // false
        System.out.println("=======================");
        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        // 作者: 鲁迅
        // 发表时间: 1918年
        // 标题: 狂人日记
    }
}
