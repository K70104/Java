import java.util.*;

public class TestDemo {
    private static boolean isBrother(String s, String x) {
        if (s.length() != x.length()) {
            return false;
        }
        // x 的单词次数
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < x.length(); i++) {
            map.put(x.charAt(i), map.getOrDefault(x.charAt(i), 0) + 1);
        }
        for (int i = 0; i < s.length(); i++) { // s 的每一个字符在 mapX 中有没有
            if (map.containsKey(s.charAt(i)) && map.get(s.charAt(i)) > 0) {
                map.put(s.charAt(i), map.get(s.charAt(i)) - 1);
                if (map.get(s.charAt(i)) == 0) { // 次数为 0，remove
                    map.remove(s.charAt(i));
                }
            } else { // 没有
                return false;
            }
        }
        return map.isEmpty(); // 为空，是
    }

    private static void findBrothersOfX(List<String> list, String x, int k) {
        int count = 0; // 兄弟单词的个数(包含重复)
        String[] strings = new String[list.size()];
        int j = 0;
        for (int i = 0; i < list.size(); i++) {
            String s = list.get(i);
            if (!s.equals(x) && isBrother(s, x)) { // 判断是否是星弟单词
                strings[j++] = s;
                count++;
            }
        }
        String[] ans = new String[j];
        for (int i = 0; i < j; i++) {
            ans[i] = strings[i];
        }
        Arrays.sort(ans);
        System.out.println(count);
        if (j == 0 ||  k > ans.length || k <= 0) {
            return;
        }
        System.out.println(ans[k - 1]);
    }

//    private static void findBrothersOfX(List<String> list, String x, int k) {
//        int count = 0; // 兄弟单词的个数(包含重复)
//        List<String> brothers = new ArrayList<>(); // // 保存兄弟单词
//        // 遍历 list
//        for (int i = 0; i < list.size(); i++) {
//            String s = list.get(i);
//            // 一样的单词 不是兄弟单词
//            if (!s.equals(x) && isBrother(s, x)) { // 判断是否是兄弟单词
//                brothers.add(s);
//                count++;
//            }
//        }
//        // 按字典排序
//        Collections.sort(brothers);
//        // 输出count 和 第k个兄弟单词
//        // 如果兄弟单词列表为空者或输入的数字大于列表的长度，都不进行输出
//        System.out.println(count);
//        if (brothers.size() == 0 ||  k > brothers.size()) {
//            return;
//        }
//        System.out.println(brothers.get(k - 1)); // 第 k 个，减一
//    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt(); // 包含重复 不需要特殊处理...
            List<String> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                list.add(scanner.next());
            }
            String x = scanner.next();
            int k = scanner.nextInt();
            findBrothersOfX(list, x, k);
        }
    }


    public static void main5(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("abc");
        list.add("gbc");
        list.add("dbc");
        list.add("bbc");
        String[] strings = list.toArray(new String[0]);
        Arrays.sort(strings);
        System.out.println(Arrays.toString(strings));
        System.out.println(strings[2]);
    }

    public static void main4(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String a = scanner.next();
            String b = scanner.next();
            Map<Character, Integer> map = new HashMap<>();
            for (int i = 0; i < a.length(); i++) {
                map.put(a.charAt(i), map.getOrDefault(a.charAt(i), 0) + 1);
            }
            boolean flag = true;
            for (int i = 0; i < b.length(); i++) {
                if (map.containsKey(b.charAt(i))) {
                    if (map.get(b.charAt(i)) <= 0) { // a 此种球已经为 0，要求 b 每种球数量小于等于 a
                        flag = false;
                        break;
                    }
                    map.put(b.charAt(i), map.get(b.charAt(i)) - 1);
                } else {
                    flag = false;
                    break;
                }
            }
            System.out.println(flag ? "Yes" : "No");
        }
    }

    public static void main3(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String s = scanner.nextLine(); // nextLine
            StringBuilder stringBuilder = new StringBuilder();
            int i = s.length() - 1;
            while (i >= 0) {
                if (Character.isLetter(s.charAt(i))) {
                    // 每个单词，放在 sb 中，逆置
                    int index = i;
                    StringBuilder sb = new StringBuilder();
                    while (i >= 0 && Character.isLetter(s.charAt(i))) {
                        sb.append(s.charAt(i));
                        i--;
                    }
                    stringBuilder.append(sb.reverse());
                } else {
                    // 跳过多个非字母
                    while (i >= 0 && !Character.isLetter(s.charAt(i))) {
                        i--;
                    }
                    stringBuilder.append(" ");
                }
            }
            System.out.println(stringBuilder.toString());
        }
    }

    public static void main2(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String name = scanner.next();
            boolean flag = true;
            StringBuilder stringBuilder = new StringBuilder();
            int i = 0;
            int len = name.length();
            // 拼接第一个单词
            while (i < len && name.charAt(i) != '_') {
                stringBuilder.append(name.charAt(i));
                i++;
            }
            i++; // 跳过 _
            // 不止一个单词
            while (i < len) {
                stringBuilder.append(Character.toUpperCase(name.charAt(i)));
                i++;
                while (i < len && name.charAt(i) != '_') {
                    stringBuilder.append(name.charAt(i));
                    i++;
                }
                i++; // 跳过 _
            }
            System.out.println(stringBuilder.toString());
        }
    }

    public static void main1(String[] args) {
        System.out.println(123);
    }
}
