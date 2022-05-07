import java.util.*;

public class TestDemo {
    public static void main7(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            int n = scanner.nextInt();
            int factorCnt = 0;
            for (int i = 2; i < n; i++) {
                if (n % i == 0) {
                    while (n != 0 && n % i == 0) {
                        n /= i;
                    }
                    factorCnt++; // 因子的个数
                }
            }
            if (n != 1) {
                factorCnt++;
            }
            System.out.println(factorCnt);
        }
    }

    public static void main6(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        while (scanner.hasNextLine()) {
            String s = scanner.nextLine();
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                if (Character.isLetter(s.charAt(i))) {
                    int index = letters.indexOf(s.charAt(i)); // 在字母串中的位置
                    index = (index - 5 + 26) % 26; // 前 5 个 字母 ABCDE 对应后面 TUVWX
                    stringBuilder.append(letters.charAt(index));
                } else { // 非字母 不需要转
                    stringBuilder.append(s.charAt(i));
                }
            }
            System.out.println(stringBuilder.toString());
        }
    }

    public static void main5(String[] args) {
        char ch = 'A';
        for (int i = 0; i < 26; i++) {
//            System.out.print("\'" + (ch++) + "\', ");
            System.out.print(ch++);
        }
    }

    public String s = "6";
    public static void main4(String[] args) {
        TestDemo testDemo = new TestDemo();
        testDemo.change(testDemo.s);
        System.out.println(testDemo.s);
    }

    private void change(String s) {
        s +=  "7";
    }

    public static void main3(String[] args) {
        Integer i1 = 59;
        int i2 = 59;
        Integer i3 = Integer.valueOf(59);
        Integer i4 = new Integer(59);
        System.out.println(i1 == i2);
        System.out.println(i1 == i3);
        System.out.println(i1 == i4);
        System.out.println("===========");
        System.out.println(i2 == i3);
        System.out.println(i2 == i4);
        System.out.println(i3 == i4);
    }

    public static void main2(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            int count = 0;
            while (n >= 3) {
                n /= 2;
                count++;
            }
            System.out.println(count);
        }
    }

    public static void main1(String[] args) {
        System.out.println(123);
        int index = -1;
        try
        {
            if (index == -1) {
                throw new Exception("no");
            }
            System.out.printf("index = %d\n", index);
        }
        catch (Exception e)
        {
            System.out.printf("没有找到\n");
        }
    }
}
