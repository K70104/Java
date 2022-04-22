import java.util.*;

public class TestDemo {
    public static void main7(String[] args) {
        char c1 = 'c';
        char c2 = 'C';
        boolean ret = new String(c1 + "").equalsIgnoreCase(c2 + "");
        System.out.println(ret);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String t = "?*Bc*?"; // 通配符字符串
        String s = "abcd"; // 待匹配字符串
        System.out.println(isMatch(t, s));
    }

    private static boolean isMatch(String t, String s) {
        int lt = t.length();
        int ls = s.length();
        boolean[][] dp = new boolean[ls + 1][lt + 1];
        dp[0][0] = true;
        for (int i = 0; i <= ls; i++) {
            for (int j = 1; j <= lt; j++) {
                if (i == 0) { // 1、第一行
                    if (t.charAt(j - 1) == '*') { //
                        dp[i][j] = dp[i][j - 1];
                    }
                }  else if (t.charAt(j - 1) == '*') { // 2、*
                    if (defs2(s.charAt(i - 1))) { // 只能匹配字母 数字
                        dp[i][j] = dp[i - 1][j] || dp[i][j - 1];  // 前面 或 上面
                    }
                } else if (t.charAt(j - 1) == '?') { // 3、?
                    if (defs2(s.charAt(i - 1))) { // 只能匹配字母 数字
                        dp[i][j] = dp[i - 1][j - 1]; // 看上一个
                    }
                } else if (defs1(s.charAt(i - 1), t.charAt(j - 1))) { // 4、不区分大小写匹配
                    dp[i][j] = dp[i - 1][j - 1];  // 看上一个
                }
            }
        }
        return dp[ls][lt];
    }

    private static boolean defs1(char s, char t) {
        Character.toLowerCase(s);
        Character.toLowerCase(t);
        return s == t;
    }

    private static boolean defs2(char s) {
        if ((s >= 'A' && s <= 'z') || s >= '0' && s <= '9') {
            return true;
        }
        return false;
    }

    private static boolean isMatch00(String t, String s) {
        int lt = t.length();
        int ls = s.length();
        boolean[][] dp = new boolean[ls + 1][lt + 1];
        dp[0][0] = true;
        for (int i = 0; i <= ls; i++) {
            for (int j = 1; j <= lt; j++) {
                if (i == 0) { // 1、第一行
                    if (t.charAt(j - 1) == '*') { //
                        dp[0][j] = dp[0][j - 1];
                    }
                } else if (new String(s.charAt(i - 1) + "").equals(t.charAt(j - 1) + "")) { // 2、不区分大小写匹配
                    dp[i][j] = dp[i - 1][j - 1];  // 看上一个
                } else if (t.charAt(j - 1) == '*') { // 3、*
                    // 只能匹配字母 数字
                    if (s.charAt(i - 1) == '.' || (s.charAt(i - 1) >= 'A' && s.charAt(i - 1) <= 'z') || (s.charAt(i - 1) >= '0' && s.charAt(i - 1) <= '9')) {
                        dp[i][j] = dp[i - 1][j] || dp[i][j - 1];  // 前面 或 上面
                    }
                } else if (t.charAt(j - 1) == '?') { // 4、?
                    // 只能匹配字母 数字
                    if (s.charAt(i - 1) == '.' || (s.charAt(i - 1) >= 'A' && s.charAt(i - 1) <= 'z') || (s.charAt(i - 1) >= '0' && s.charAt(i - 1) <= '9')) {
                        dp[i][j] = dp[i - 1][j - 1]; // 看上一个
                    }
                }
            }
        }
        return dp[ls][lt];
    }

    public boolean isMatch11(String s, String p) {
        // dp[i][j] 表示 s 的前 i 个字符和 p 的前 j 个字符是否匹配
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        // 初始化
        dp[0][0] = true;
        for (int j = 1; j <= n; j++) {
            // 第一列 是空 不匹配 默认是 false 不用管
            // 第一列 如果是 * 就看前一个
            dp[0][j] = p.charAt(j - 1) == '*' && dp[0][j - 1];
        }
        // 状态转移
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?') {
                    dp[i][j] = dp[i - 1][j - 1]; // 看上一个
                } else if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1]; // 前面 或 上面
                }
            }
        }
        return dp[m][n];
    }

    public static void main6(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            map.put(str.charAt(i), map.getOrDefault(str.charAt(i), 0) + 1);
        }
        for (int i = 0; i < str.length(); i++) {
            if (map.get(str.charAt(i)) == 1) {
                System.out.println(str.charAt(i));
                return;
            }
        }
        System.out.println(-1);
    }

    public static void main5(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int n = scanner.nextInt(); // 怪物数量
            int a = scanner.nextInt(); // 初识能力值
            for (int i = 0; i < n; i++) {
                int abilityValue = scanner.nextInt();
                if (abilityValue <= a) {
                    a += abilityValue;
                } else {
                    a += func(a, abilityValue);
                }
            }
            System.out.println(a);
        }
    }

    private static int func(int a, int b) {
        int c = 0;
        while ((c = a % b) != 0) {
            a = b;
            b = c;
        }
        return b;
    }

    public static void main3(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = 2 * n - 1; // 第 n 行，有 2n-1 个数
        int[][] a = new int[n][m];
        // 初始化
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                a[i][j] = 0;
            }
        }
        // 计算到 第 n 行
        a[0][0] = 1; // 第一行
        for (int i = 1; i < n; i++) {
            a[i][0] = a[i][2 * i] = 1; // 首尾
            // for (int j = 1; j <= 2 * i - 1; j++) {
            for (int j = 1; j < 2 * i; j++) {
                if (j == 1) { // j == 1 -> 只有两个 会越界
                    a[i][j] = a[i - 1][j] + a[i - 1][j - 1];
                } else { // j == 2n-1 -> 加上 0 也没关系
                    a[i][j] = a[i - 1][j] + a[i - 1][j - 1] + a[i - 1][j - 2];
                }
            }
        }
        for (int k = 0; k < m; k++) {
            if (a[n - 1][k] % 2 == 0) { // 第 n 行，判断
                System.out.println(k + 1); // 第几个 加 1
                return;
            }
        }
        System.out.println(-1);
    }

    // 运行超时
    public static void main1(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> ret = new ArrayList<>(); // 第一行
        ret.add(1);
        list.add(ret);
        for (int i = 1; i < n; i++) { // n 行
            List<Integer> tmp = new ArrayList<>();
            tmp.add(1); // 首
            List<Integer> preRow = list.get(i - 1); // 上一行
            for (int j = 1; j <= 2 * i - 1; j++) { // 2n - 1 个
                // 左上角上数的和
                int num = 0;
                if (j - 2 >= 0 && j - 2 < preRow.size()) {
                    num += preRow.get(j - 2);
                }
                if (j - 1 >= 0 && j - 1 < preRow.size()) {
                    num += preRow.get(j - 1);
                }
                if (j >= 0 && j < preRow.size()) {
                    num += preRow.get(j);
                }
                tmp.add(num);
            }
            tmp.add(1); // 尾
            list.add(tmp);
        }
        List<Integer> ans = list.get(n - 1); // 第 n 行
        int i = 0;
        for (; i < ans.size(); i++) {
            if (ans.get(i) % 2 == 0) {
                System.out.println(i + 1); // 第几个，从 1 开始数，加 1
                break;
            }
        }
        if (i == ans.size()) {
            System.out.println(-1); // 没有偶数
        }
    }

    public static void main2(String[] args) {
        System.out.println(123);
    }
}
