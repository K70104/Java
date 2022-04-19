import java.util.Scanner;

public class TestDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s1 = scanner.nextLine();
        String s2 = scanner.nextLine();
        String str = s1.length() >= s2.length() ? s1 : s2;
        String sub = s1.length() < s2.length() ? s1 : s2;
        int max = 0;
        for (int i = 0; i < sub.length(); i++) {
            for (int j = i; j <= sub.length(); j++) {
                if (str.contains(sub.substring(i, j)) && j - i > max) {
                    max = j - i;
                }
            }
        }
        System.out.println(max);
    }

    public static void main2(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        char[] array =  s.toCharArray();
        int l = 0;
        int r = s.length() - 1;
        while (l < r) {
            char c = array[l];
            array[l] = array[r];
            array[r] = c;
            l++;
            r--;
        }
        s = new String(array);
        System.out.println(s);
    }

    public static void main1(String[] args) {
        System.out.println(123);
    }
}
