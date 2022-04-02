import java.util.Arrays;
import java.util.Scanner;

interface IA {
    void fun();
}

public class TestDemo {
    public static Boolean func(int n) {
        int i = 2;
        for (; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        if (i > Math.sqrt(n)) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int min = n;
        int[] array= new int[2];
        // 包括一半  4 --> 2 2   118 --> 59 59
        for (int i = 2; i <= n / 2; i++) {
            if (func(i) && func(n - i)) { // i 和 n - 1 是素数
                if (n - i - i < min) {
                    min = n -i - i;
                    array[0] = i;
                    array[1] = n - i;
                }
            }
        }
        System.out.println(array[0] + "\n" + array[1]);
    }

    public static int binInsert(int n, int m, int j, int i) {
        // write code here
        int[] array1 = new int[32]; // n
        int k = 31;
        while (n != 0) {
            array1[k--] = n % 2;
            n /= 2;
        }
        int[] array2 = new int[32]; // m
        k = 31;
        while (m != 0) {
            array2[k--] = m % 2;
            m /= 2;
        }
        // m 二进制序列从31开始，插入 n 的二进制 j -- i
        // 1024  -- 100 0000 0000
        // 19    --      100 11
        // 替换  -- 100 0100 1100 -- 1100
        int tmp = 31;
        for (k = 32 - j - 1; k >= 32 - i - 1; k--) { // 29 - 25
            array1[k] = array2[tmp];
            tmp--;
        }
        // 跳过高位的 0
        Boolean flg = true;
        StringBuilder sb = new StringBuilder();
        for (k = 0; k < 32; k++) {
            if (k == 0 && flg && array1[k] == 0) { // 跳过高位的 0
                flg = false;
                while (k < 32 && array1[k] == 0) {
                    k++;
                }
            }
            if (k < 32) {
                sb.append(array1[k]);
            }
        }
        // 转数字
        int ret = 0;
        for (k = 0;  k < sb.length(); k++) {
            ret = ret * 2 + sb.charAt(k)  - '0';
        }
        return ret;
    }

    public static void main4(String[] args) {
        // 1024，19，2，6
        int ret = binInsert(1024, 19, 2, 6);
        System.out.println(ret);
    }

    public static void main3(String[] args) {
        String s1 = "hello";
        String s2 = "he" + new String("llo");
        System.out.println(s1 == s2);
    }

    public static void main1(String[] args) {
        System.out.println(123);
    }
}
