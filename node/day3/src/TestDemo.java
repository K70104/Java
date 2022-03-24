import java.util.*;

public class TestDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        int num = scanner.nextInt();
        int n = scanner.nextInt();
        while (num > 0) {
            list.add(num % n);
            num /= n;
        }
        Collections.reverse(list);
        if(list.size() < 9) {
            for (int i = 0; i < list.size(); i++) {
                System.out.print(list.get(i));
            }
        } else { // 改十六进制

        }
    }

    public static boolean isABC(int a, int b, int c, int n1, int n2, int n3, int n4) {
        if(a-b == n1 && b-c == n2 && a+b == n3 && b+c == n4) {
            return true;
        }
        return false;
    }

    public static void main3(String[] args) {
        // a-b  b-c  a+b  b+c
        Scanner scanner = new Scanner(System.in);
        int[] array = new int[4];
        for(int i = 0; i < 4; i++) {
            array[i] = scanner.nextInt();
        }
        int n1 = array[0], n2 = array[1], n3 = array[2], n4 = array[3];
        int a = (n1 + n3) / 2;
        int b = (n2 + n4) / 2;
        int c = n4 - b;
        if(isABC(a, b, c, n1, n2, n3, n4)) {
            System.out.println(a + " " + b + " " + c);
        } else if (isABC(b, c, a, n1, n2, n3, n4)) {
                System.out.println(b + " " + c + " " + a);
        } else if (isABC(c, a, b, n1, n2, n3, n4)) {
            System.out.println(c + " " + a + " " + b);
        } else {
            System.out.println("No");
        }
    }

    public static void reverse(char[] ch, int i, int j) {
        while (i < j) {
            char tmp = ch[i];
            ch[i] = ch[j];
            ch[j] = tmp;
            i++;
            j--;
        }
    }

    public static void main2(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        char[] ch = str.toCharArray();
        int len = ch.length;
        // 1、整体逆置
        reverse(ch, 0, len - 1);
        int i = 0; // 遍历
        while (i < len) {
            int j = i;
            while (j < len && ch[j] != ' ') {
                j++; // 找单词结束位置
            }
            if(j < len) {
                reverse(ch, i, j - 1);
                i = j +  1; // 下一个单词
            } else {
                reverse(ch, i, j - 1); // 一个字符
                i = j;
            }
        }
        // System.out.println(Arrays.toString(ch)); // [ , f, l, y, !,  , c, a, n, i]
        String ans = new String(ch);
        System.out.println(ans);
    }

    public static void main1(String[] args) {
        System.out.println(123);
    }
}





