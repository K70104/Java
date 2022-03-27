import java.util.Arrays;
import java.util.Scanner;

abstract class U {
}

public class TestDemo {
    public U u;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String a = scanner.nextLine();
        String b = scanner.nextLine();
        int cnt = 0;
        for (int i = 0; i <= a.length(); i++) {
            StringBuilder sb = new StringBuilder(a);
            sb.insert(i, b); // 直接插入
            // sb.reverse 会将 sb 逆置，比较的就是逆置和逆置，用 tmp 逆置
            StringBuilder tmp = new StringBuilder(sb);
            StringBuilder str = tmp.reverse();
            // 没有 equals 方法，转成字符串
            if (sb.toString().equals(str.toString())) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }


    public static boolean palindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main7(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String a = scanner.nextLine();
        String b = scanner.nextLine();
        int cnt = 0;
        for (int i = 0; i <= a.length(); i++) { // 一个一个拼 测试回文
            StringBuilder sb = new StringBuilder();
            if(i == a.length()) {
                // aa a
                // i <= len，最后一次，b 拼在 a 最后
                sb.append(a);
                sb.append(b);
            } else {
                sb.append(a, 0, i);
                sb.append(b);
                sb.append(a, i, a.length());
            }
            if(palindrome(sb.toString())) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }

    public static void main4(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        int d = scanner.nextInt();
        int A = (a + c) / 2;
        int B1 = (b + d) / 2;
        int B2 = (c - a) / 2;
        int C = (d - b) / 2;
        if (B1 != B2) {
            System.out.println("No");
        } else {
            System.out.println(A + " " + B1 + " " + C);
        }
    }

    public int MoreThanHalfNum_Solution(int [] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int result = array[0];
        int times = 1;
        for (int i = 1; i < array.length; i++) {
            if (times != 0) {
                 if (array[i] != result) {
                     times--;
                 } else {
                     times++;
                 }
            } else {
                result = array[i];
                times = 1;
            }
        }
        times = 0;
        for (int i = 0; i < array.length; i++) {
            if (result == array[i]) {
                times++;
            }
        }
        if(times > array.length / 2) {
            return times;
        }
        return 0;
    }

    public int MoreThanHalfNum_Solution1(int [] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        Arrays.sort(array);
        int len = array.length;
        int midNum = array[len / 2];
        int cnt = 0;
        for (int i = 0; i < len; i++) {
            if(array[i] == midNum) {
                cnt++;
            }
        }
        if (cnt > len / 2) {
            return midNum;
        }
        return 0;
    }

    public static void main3(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        String cur = "";
        String ret = "";
        int i = 0;
        for (; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch >= '0' && ch <= '9') {
                cur = cur + ch; // 放到 cur 上
            } else {
                if (cur.length() > ret.length()) {
                    ret = cur; // ret 放长度最大数字串
                } else {
                    cur = "";
                }
            }
        }
        // 如果结尾是数字，且是最大串，循环结束，没有更新到 ret 上，得到的结果就是最大串
        if (i == str.length() && cur.length() > ret.length()) {
            ret = cur;
        }
        System.out.println(ret);
    }

    public static void main2(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = "abcd12345ed125ss1234 5678";
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        for(int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if(!Character.isDigit(ch)) {
                if(sb1.length() > sb2.length()) {
                    sb2.delete(0, sb2.length());
                } else {
                    sb1.delete(0, sb1.length());
                }
            } else {
                if(sb1.length() == 0){
                    while(i < str.length() && Character.isDigit(str.charAt(i))) {
                        sb1.append(str.charAt(i));
                        i++;
                    }
                    //i--;
                } else {
                    while(i < str.length() && Character.isDigit(str.charAt(i))) {
                        sb2.append((str.charAt(i)));
                        i++;
                    }
                    //i--;
                }
            }
        }
        System.out.println(sb1.length() > sb2.length() ? sb1.toString() : sb2.toString());
    }

    public static void main1(String[] args) {
        System.out.println(123);
    }
}
