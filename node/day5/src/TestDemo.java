

// day5

import java.util.HashSet;
import java.util.Scanner;

class A {
    public void A(int a) {

    }
    public void A() {
        A(10);
    }
}

public class TestDemo {
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

    public static void main(String[] args) {
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
        int n = scanner.nextInt();
        int[] array = new int[n];
        int tmp = 0;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
            tmp += array[i];
            max = Math.max(max, tmp);
            if(tmp < 0) {
                tmp = 0;
            }
        }
        System.out.println(max);
    }


    public static void main3(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] array = new int[n + 1];
        for(int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }
        int tmp1 = 0;
        int tmp2 = 0;
        int max1 = 0;
        int max2 = 0;
        for(int i = 0; i < n; i++) {
            if(array[i] >= array[i + 1]) {
                tmp1 = array[i];
                while (i < n && array[i] >= array[i + 1]) {
                    tmp1 += array[i + 1];
                    i++;
                }
                if(tmp1 > max1) {
                    max1 = tmp1;
                }
            }
            if(i < n && array[i] <= array[i + 1]) {
                tmp2 = array[i];
                while (i < n && array[i] <= array[i + 1]) {
                    tmp2 += array[i + 1];
                    i++;
                }
                if(tmp2 > max2) {
                    max2 = tmp2;
                }
            }
            i--;
        }
        System.out.println(Math.max(max1, max2));
    }

    public static void main2(String[] args) {
        StringBuilder a = new StringBuilder("A");
        StringBuilder b = new StringBuilder("B");
        operate(a, b);
        System.out.println(a + "." + b);
    }

    static void operate(StringBuilder x, StringBuilder y) {
        x.append(y);
        y = x;
    }

    public static void main1(String[] args) {
        String s;
        int a;

        //System.out.println("s = " + s);
        System.out.println(123);
    }
}
