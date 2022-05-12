import java.math.BigDecimal;
import java.util.Scanner;

public class TestDemo {
    public static void main(String[] args) {
        BigDecimal[] bigDecimal = new BigDecimal[90];
        BigDecimal b1 = new BigDecimal("1");
        BigDecimal b2 = new BigDecimal("2");
        BigDecimal b3 = b1.add(b2);
        for (int i = 0; i < 90; i++) {
            bigDecimal[i] = b3;
            b1 = b2;
            b2 = b3;
            b3 = b1.add(b2);
        }
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            System.out.println(bigDecimal[n - 1]);
        }
    }

    public static void main3(String[]  args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String ret = scanner.nextLine();
            int n = Integer.valueOf(ret);
            while (n-- != 0) {
                String s = scanner.nextLine();
                if (s.contains(",") || s.contains(" ")) {
                    if (n == 0) {
                        System.out.print("\"" + s + "\"");
                    } else {
                        System.out.print("\"" + s + "\"" + ", ");
                    }
                } else {
                    if (n == 0) {
                        System.out.print(s);
                    } else {
                        System.out.print(s + ", ");
                    }
                }
            }
            System.out.println();
        }
    }

    public int minDeletionSize(String[] strs) {
        // 题目要找的是列  按列访问
        int row = strs.length;
        int col= strs[0].length();
        int count = 0;
        for (int j = 0; j < col; j++) {
            for (int i = 1; i < row; i++) {
                if (strs[i - 1].charAt(j) > strs[i].charAt(j)) {
                    count++;
                    break;
                }
            }
        }
        return count;
    }

    public static void main2(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String s = scanner.next();
            String t = scanner.next();
            int count = 0;
            while (s.contains(t)) {
                s = s.replaceFirst(t, ""); // replaceFirst 替换第一个
                count++;
            }
            System.out.println(count);
        }
    }

    public static void main1(String[] args) {
        System.out.println(123);
        String s = "dfaadafdsaaaa";
        StringBuilder sb = new StringBuilder(s);
        for (int i = 0; i < 6; i++) {
            sb.replace(0, sb.length(), "a");
//            s = s.replace("a", "");
        }
        System.out.println(s);
        System.out.println(sb);
    }
}
