import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class TestDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s1 = scanner.nextLine();
        String s2 = scanner.nextLine();
        int i = 0;
        int j = 0;
        while (i < s1.length() && j < s2.length()) {
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(j);
            if (c1 != c2) { // 不相等
                if (c1 == '?') {
                    i++; // 匹配一个
                } else if (c1 == '*') {
                    i++;
                    while (j < s2.length() && c1 != c2) {
                        c1 = s1.charAt(i);
                        c2 = s2.charAt(j);
                        if (c1 == c2) {
                            i++;
                            j++;
                            break;
                        } else if (Character.isDigit(c2) || Character.isLetter(c2)) {
                            j++;
                        } else {
                            System.out.println(false);
                        }
                    }
                } else { // 不相等 不是匹配符
                    System.out.println(false);
                    return;
                }
            } else { // 相等
                i++;
                j++;
            }
        }
        System.out.println(i >= s1.length() && j >= s2.length());
    }

    public static void main3(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int count = getRabbitCnt(n);
        System.out.println(count);
    }

    private static int getRabbitCnt(int n) {
        if (n < 3) {
            return 1;
        }
        return getRabbitCnt(n - 1) + 1;
    }


    public static void main2(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> ret = new ArrayList<>();
        ret.add(1);
        list.add(ret);
        for (int i = 1; i <= n; i++) {
            List<Integer> tmp = new ArrayList<>();
            tmp.add(1);
            List<Integer> preRow = list.get(i - 1);
            for (int j = 1; j < i; j++) {
                int num = preRow.get(j - 1) + preRow.get(j);
                if (j + 1 < preRow.size()) {
                    num += preRow.get(j + 1);
                }
                tmp.add(num);
            }
            tmp.add(1);
            list.add(tmp);
        }
        List<Integer> ans = list.get(n);
        for (int i = 0; i < ans.size(); i++) {
            if (ans.get(i) % 2 == 0) {
                System.out.println(i);
                return;
            }
        }
        System.out.println(-1);
    }

    public static void main1(String[] args) {
        System.out.println(123);
    }
}
