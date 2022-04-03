import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TestDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int count = n;
        while (n != m) {
            int i = 1;
            while (true) {
                int ret = n - i;
                if (n + ret <= m && ret != 1 && n % ret == 0) {
                    n += ret;
                    count++;
                    break;
                } else {
                    i++;
                }
            }
        }
        System.out.println(count);
    }

    public static void main3(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        int count = 0;
        List<String> list = new ArrayList<>();
        // 解析 保存入 list
        for (int i = 0; i < str.length(); i++) {
            String s = null;
            // 1、双引号引起的一个参数
            if (str.charAt(i) == '"') {
                i++; // 双引号需要去掉
                while (i < str.length() && str.charAt(i) != '"') {
                    s += str.charAt(i);
                    i++;
                }
            } else {
                // 2、普通参数
                while (i < str.length() && str.charAt(i) != ' ') {
                    s += str.charAt(i);
                    i++;
                }
            }
            // 防止空格，此次没有满足条件进入 if 获取参数，也加入了空串，count 多一个
            // 比较 len 不能与 null 比较
            if (s != null) {
                list.add(s); // 加入 list
                count++; // 参数加一
            }
        }
        // 打印 个数 和 每个参数
        System.out.println(count);
        for (String s : list) {
            System.out.println(s);
        }
    }

    public static void main2(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        int count = 0;
        List<String> list = new ArrayList<>();
        // 解析 保存入 list
        for (int i = 0; i < str.length(); i++) {
            StringBuilder stringBuilder = new StringBuilder(); // 每个参数
            // 1、双引号引起的一个参数
            if (str.charAt(i) == '"') {
                i++; // 双引号需要去掉
                while (i < str.length() && str.charAt(i) != '"') {
                    stringBuilder.append(str.charAt(i));
                    i++;
                }
            } else {
                // 2、普通参数
                while (i < str.length() && str.charAt(i) != ' ') {
                    stringBuilder.append(str.charAt(i));
                    i++;
                }
            }
            // 防止空格，此次没有满足条件进入 if 获取参数，也加入了空串，count 多一个
            // 比较 len 不能与 null 比较
            if (stringBuilder.length() != 0) {
                list.add(stringBuilder.toString()); // 加入 list
                count++; // 参数加一
            }
        }
        // 打印 个数 和 每个参数
        System.out.println(count);
        for (String s : list) {
            System.out.println(s);
        }
    }

    public static void main1(String[] args) {
        System.out.println(123);
    }
}
