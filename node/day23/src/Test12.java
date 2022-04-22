import java.sql.CallableStatement;
import java.util.Scanner;

public class Test12 {
    public static void main2(String[] args) {
        char t = 'A';
        char c = 'a';
        boolean flg = Character.toLowerCase(t) == Character.toLowerCase(c);
        System.out.println("t = " + t);
        System.out.println("c = " + c);
        System.out.println(flg);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String t = scanner.nextLine(); // 通配符字符串
        String s = scanner.nextLine(); // 待匹配字符串
        System.out.println(isMatch(s, t));
    }

    private static boolean isMatch(String s, String t) {
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
                    continue;
                }
                char cs = s.charAt(i - 1);
                char ct = t.charAt(j - 1);
                if (ct == '*') { // 2、*
                    if (cs == '.' || (cs >= 'A' && cs <= 'z') || (cs >= '0' && cs <= '9')) { // 只能匹配字母 数字
                        dp[i][j] = dp[i - 1][j] || dp[i][j - 1];  // 前面 或 上面
                    }
                } else if (ct == '?') { // 3、?
                    if (cs == '.' ||(cs >= 'A' && cs <= 'z') || (cs >= '0' && cs <= '9')) { // 只能匹配字母 数字
                        dp[i][j] = dp[i - 1][j - 1]; // 看上一个
                    }
                } else if (Character.toLowerCase(cs) == Character.toLowerCase(ct)) { // 4、不区分大小写匹配
                    dp[i][j] = dp[i - 1][j - 1];  // 看上一个
                }
            }
        }
        return dp[ls][lt];
    }
}
