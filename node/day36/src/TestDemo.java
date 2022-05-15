import java.util.ArrayList;
import java.util.List;
import java.util.*;

public class TestDemo {
    private static boolean isLeapYeat(int y) {
        return (y % 400 == 0) || (y % 4 == 0 && y % 100 != 0);
    }

    private static final int[] DAYS = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    // 给定 y,m,d, 返回间隔天数
    private static int nDays(int y, int m, int d) {
        int n = d;
        for (int i = 0; i < m - 1; i++) {
            n += DAYS[i];
        }
        if (m > 2 && isLeapYeat(y)) {
            n++;
        }
        return n;
    }

    // 传入 y,m,d, 找到从公元前1年 12月31日开始过了多久。求它 MOD 7 的同余数
    private static int diff(int y, int m, int d) {
        return (y - 1) + (y - 1) / 4 - (y - 1) / 100 + (y - 1) / 400 + nDays(y, m, d);
    }

    // 根据 y,m,d, 求出星期几
    private static int week(int y, int m, int d) {
        int w = diff(y, m, d) % 7;
        if (w == 0) {
            w = 7;
        }
        return w;
    }

    // 根据 1 日的星期 w, 求第 n 个星期 e 是几号
    private static int m1(int w, int n, int e) {
        return 1 + (n - 1) * 7 + (7 - w + e) % 7;
    }

    // 根据 6月1日星期 w, 求 5月最后一个星期一
    private static int m2(int w) {
        int d = (w == 1 ? 7 : w - 1);
        return 32 - d;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int y = scanner.nextInt();

            System.out.printf("%d-01-01\n", y);

            int w = week(y, 1, 1);
            System.out.printf("%d-01-%02d\n", y, m1(w, 3, 1));

            w = week(y, 2, 1);
            System.out.printf("%d-02-%02d\n", y, m1(w, 3, 1));

            w = week(y, 6, 1);
            System.out.printf("%d-05-%02d\n", y, m2(w));

            System.out.printf("%d-07-04\n", y);

            w = week(y, 9, 1);
            System.out.printf("%d-09-%02d\n", y, m1(w, 1, 1));

            w = week(y, 11, 1);
            System.out.printf("%d-11-%02d\n", y,  m1(y, 4, 4));

            System.out.printf("%d-12-25\n", y);

            System.out.println();
        }
    }

    private static List<String> factorization(int a) {
        List<String> ans = new ArrayList<>();
        for (int i = 2; a > 1 && i * i <= a; i++) {
            while (a % i == 0) {
                ans.add(String.valueOf(i));
                a /= i;
            }
        }
        if (a > 1) {
            ans.add(String.valueOf(a));
        }
        return ans;
    }

    public static void main2(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int a = scanner.nextInt();
            List<String> factors = factorization(a);
            System.out.printf("%d = %s\n", a, String.join(" * ", factors));
        }
    }

    public static void main1(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        System.out.printf("%d = %s\n", 6, String.join(" * ", list)); // 6 = 1 * 2 * 3
        System.out.println(String.join(" * ", list)); // 1 * 2 * 3
        String[] array = {"a", "b", "c"};
        System.out.println(String.join(" - ", array)); // a - b - c
    }

    // 如果字符相同，两个下标同时加 1。字符不同，加长的下标，如果 m == n，同时加 1，count>1 停止
    public boolean oneEditAway(String first, String second) {
        int m = first.length();
        int n = second.length();
        if (Math.abs(m - n) > 1) {
            return false;
        }
        if (m - n >= 1) {
            return oneEditAway(second, first);
        }
        int index1 = 0;
        int index2 = 0;
        int count = 0; // 记录 m == n 的不同数
        while (index1 < m && index2 < n && count <= 1) { // // 超过一个不同 不能一次编辑
            if (first.charAt(index1) == second.charAt(index2)) {
                index1++;
                index2++;
            } else {
                if (m == n) { // m == n 两下标都加
                    index1++;
                }
                index2++;
                count++;
            }
        }
        return count <= 1;
    }
}
