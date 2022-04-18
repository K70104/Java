import com.sun.xml.internal.fastinfoset.tools.XML_SAX_StAX_FI;

import java.util.Scanner;

public class TestDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s1 = scanner.nextLine();
        String s2 = scanner.nextLine();
        String str = s1.length() >= s2.length() ? s1 : s2;
        String sub = s1.length() <= s2.length() ? s1 : s2;
        int maxString = 0;
        String ans = "";
        for (int i = 0; i < sub.length(); i++) {
            for (int j = 0; j < sub.length(); j++) {
                if (str.contains(sub.substring(i, j)) && j - i > maxString) {
                    maxString = j - i;
                    ans = sub.substring(i, j);
                } else {
                    break;
                }
            }
        }
        System.out.println(ans);
    }

    public static void main2(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int bottle = scanner.nextInt();
            int cnt = 0;
            if (bottle != 0) {
                while (bottle >= 2) {
                    cnt += bottle / 3;
                    bottle = bottle / 3 + bottle % 3;
                    if (bottle == 2) {
                        cnt += 1;
                        bottle = 0;
                    }
                }
                System.out.println(cnt);
            }
        }
    }

    public static void main1(String[] args) {
        System.out.println(123);
    }
}
