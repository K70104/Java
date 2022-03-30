import java.util.Scanner;

public class TestDemo2 {


    public static void main8(String[] args) {
        int num = 191;
        int num2 = 82;
        int num3 = 0;

        System.out.printf("%x%x%x", num, num2, num3);
    }

    public static void main7(String[] args) {
        String s1 = "fhs";
        s1.toUpperCase();
        String s2 = s1.replace('f', 'F');
        s2 = s2 + "dfa";
        System.out.println(s2);
    }

    public static void main6(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] array = new String[n];
        array[0] = scanner.nextLine();

        Boolean len = true;
        Boolean letter = true;
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextLine();
            if (i != 0 && array[i - 1].length() > array[i].length()) {
                len = false;
            }
            if (i != 0 && array[i - 1].compareTo(array[i]) > 0) {
                letter = false;
            }
        }
        if (len && letter) {
            System.out.println("both");
        } else if (len) {
            System.out.println("lengths");
        } else if (letter) {
            System.out.println("lexicographically");
        } else {
            System.out.println("none");
        }
    }

    public static void main5(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] array = new String[n];

        Boolean len1 = true;
        Boolean len2 = true;
        Boolean letter1 = true;
        Boolean letter2 = true;
        for (int i = 0; i < n; i++) {
            array[i] = scanner.next();
            if (i != 0 && len1 && array[i - 1].length() < array[i].length()) {
                len2 = false; // 不是递增
            }
            if (i != 0 && len2 && array[i - 1].length() > array[i].length()) {
                len1 = false; // 不是递减
            }
            if (i != 0 && letter2 && array[i - 1].compareTo(array[i]) < 0) {
                letter2 = false;
            }
            if (i != 0 && letter1 && array[i - 1].compareTo(array[i]) > 0) {
                letter1 = false;
            }
        }
        Boolean len = len1 || len2;
        Boolean letter = letter1 || letter2;
        if (len && letter) {
            System.out.println("both");
        } else if (len) {
            System.out.println("lengths");
        } else if (letter) {
            System.out.println("lexicographically");
        } else {
            System.out.println("none");
        }
    }

    public static void main2(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] array = new String[n];
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextLine();
        }
    }

    public static void main1(String[] args) {
        int[] array = {1,2,3,4,5};
        for (int n: array) {
            System.out.println(n);
            break;
        }
    }
}
