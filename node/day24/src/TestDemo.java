import java.util.Arrays;
import java.util.Scanner;

public class TestDemo {
    public static void main(String[] args) {
        int[] array = {0, 1, 3, 2, 4, 5, 6, 7, 8, 9};
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                // 升序 冒泡排序：两两比较
                if (array[j] > array[j + 1]) {
                    int tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                }
            }
        }
        System.out.println(Arrays.toString(array));
    }

    // 状态F(ij):以第一个字符串第i个字符结尾和以第二个字符串第j个字符结尾的最大公共子串的长度
    public static void main3(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s1 = scanner.nextLine();
        String s2 = scanner.nextLine();
        System.out.println(getMaxLenSubstring(s1, s2));
    }

    public static int getMaxLenSubstring(String s1, String s2) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        dp[0][0] = 0;
        int maxLen = 0;
        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    if (maxLen < dp[i][j]) {
                        maxLen = dp[i][j];
                    }
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        return maxLen;
    }

    public static void main2(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s1 = scanner.nextLine();
        String s2 = scanner.nextLine();
        if (s1.length() < s2.length()) { // 题目要求以短的计算
            System.out.println(getLongSubstring(s1, s2));
        } else {
            System.out.println(getLongSubstring(s2, s1));
        }
    }

    private static String getLongSubstring(String s1, String s2) {
        int endIndex = 0;
        int max = 0;
        int[][] dp = new int[s1.length() +1][s2.length() + 1];
        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                // 如果 a 的第 i 个字符和 b 的第 j 个字符 相等
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j -1] + 1;
                    // 比 max 大，更新结果
                    if (max < dp[i][j]) {
                        max = dp[i][j];
                        endIndex = i;
                    }
                }
            }
        }
        return s1.substring(endIndex - max, endIndex);
    }

    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        // 初始化
        dp[0][0] = 0; // 空串到空串 不需要操作
        for (int j = 1; j <= word2.length(); j++) {
            dp[0][j] = dp[0][j - 1] + 1; // 前一个加一
        }
        for (int i = 1; i <= word1.length(); i++) {
            dp[i][0] = dp[i - 1][0] + 1; // 上一个加一
        }
        // 动态转移
        // 删除 更新 添加
        for (int i = 1; i <= word1.length(); i++) {
            char c1 = word1.charAt(i - 1);
            for (int j = 1; j <= word2.length(); j++) {
                char c2 = word2.charAt(j - 1);
                if (c1 == c2) { // 相等 直接左上角拿过来
                    dp[i][j] = dp[i - 1][j - 1];
                } else { // 不相等 三个操作取最小值 加一
                    dp[i][j] = minOfThree(dp[i - 1][j], dp[i][j - 1], dp[i - 1][j - 1]) + 1;
                }
            }
        }
        return dp[word1.length()][word2.length()];
    }

    private static int minOfThree(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }

    public static void main1(String[] args) {
        System.out.println(123);
    }
}
