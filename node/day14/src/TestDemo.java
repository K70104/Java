import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.*;

public class TestDemo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            int count = 0;
            while (n != 0) {
                n = n & (n - 1);
                count++;
            }
            System.out.println(count);
        }
    }

    public static void main4(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int year = scanner.nextInt();
        int month = scanner.nextInt();
        int day = scanner.nextInt();
        int[] amount = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        // 闰年 2月变29天
        if(year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
            amount[1]++;
        }
        int ans = 0;
        for (int i = 0; i < month - 1; i++) {
            ans += amount[i];
        }
        System.out.println(ans + day);
    }

    public static void main3(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] step = new int[m + 1]; // 和石板对应
        // 初始化
        for (int i = 0; i < m + 1; i++) { // m + 1
            step[i] = Integer.MAX_VALUE;
        }
        step[n] = 0;
        for (int i = n; i < m; i++) {
            if (step[i] == Integer.MAX_VALUE) {
                continue;
            }
            // 求当前石板的约数
            List<Integer> list = div(i);
            // j -> 当前石板一次可以跳几块石板
            // i -> 当前石板的编号
            for (int j : list) {
                if (i + j <= m) { // <=
                    if (step[i + j] != Integer.MAX_VALUE) {
                        // 之间跳的步数 与 此处跳的步数 最小值
                        step[i + j] = Math.min(step[i + j], step[i] + 1);
                    } else {
                        // 没有跳过此石板
                        step[i + j] = step[i] + 1;
                    }
                }
            }
        }
        if (step[m] == Integer.MAX_VALUE) { // 不能到达
            System.out.println(-1);
        } else {
            System.out.println(step[m]);
        }
    }

    public static List<Integer> div(int num) {
        List<Integer> list = new ArrayList<>();
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                list.add(i);
                if (num / i != i) { // 两约数不同
                    list.add(num / i);
                }
            }
        }
        return list;
    }

    public static void main2(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            // 双引号引起的参数
            if (str.charAt(i) == '"') {
                do {
                    i++;
                } while (str.charAt(i) != '"');
            }
            // 碰到双引号以外的空格 count++
            if (str.charAt(i) == ' ') {
                count++;
            }
        }
        System.out.println(count + 1); // 参数比空格多一个
        int flag = 1;
        for (int i = 0; i < str.length(); i++) {
            // 碰到第一个 ""，flag 变 0，碰到第二个 ""，flag 变 1
            // flag == 0 时，一直在遍历双引号中的参数
            if (str.charAt(i) == '"') {
                flag ^= 1;
            }
            // 除了 "" 和 双引号中的空格，其他都输出
            if (str.charAt(i) != ' ' && str.charAt(i) != '"') {
                System.out.println(str.charAt(i));
            }
            // 双引号中以外的空格，换行
            if (str.charAt(i) == ' ' && flag == 1) {
                System.out.println();
            }
        }
    }


    public static int num = 0;
    public static void main1(String[] args) {
        num += 10;
    }

    public void add(Byte b) {
        b = b++;
    }

    public void test() {
        Byte a = 127;
        Byte b = 127;
        add(++a);
        System.out.println(a + " ");
        add(b);
        System.out.println(b + " ");
    }
}

