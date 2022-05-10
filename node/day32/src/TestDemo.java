import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TestDemo {
    // 如果 s[1]='I'，那么令 perm[0]=0，则无论 perm[1] 为何值都满足 perm[0]<perm[1]；
    // 如果 s[0]='D'，那么令 perm[0]=n，则无论 perm[1] 为何值都满足 perm[0]>perm[1]；
    // s[1]='I', 令 perm[1] 为剩余数字中的最小数；如果 s[1]='D'，那么令 perm[1] 为剩余数字中的最大数
    public int[] diStringMatch(String s) {
        int min = 0;
        int max = s.length();
        int[] array = new int[max + 1];
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'I') {
                array[i] = min++;
            } else {
                array[i] = max--;
            }
        }
        array[s.length()] = min; // 此时 min == max
        return array;
    }

    public static void main3(String[] args) {
        int[] array = new int[100001];
        array[0] = 1;
        array[1] = 1;
        for (int i = 2; i < 100001; i++) {
            array[i] = (array[i - 1] + array[i - 2]) % 1000000;
        }
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            // %06
            System.out.printf(n < 25 ? "%d\n" : "%06d\n", array[n]);
        }
    }

    private static void AllFactors(int n, List<Integer> factors) {
        for (int i = 2; i <= n; i++) {
            if (n == 0) {
                return;
            }
//            if (n % i == 0 && isPrimeNum((i))) {
//                while (n != 0 && n % i == 0) {
//                    factors.add(i);
//                    n /= i;
//                }
//            }
        }
    }

    public static void main2(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            List<Integer> factors = new ArrayList<>();
            AllFactors(n, factors);
            System.out.print(n + " = ");
            for (int i = 0; i < factors.size() - 1; i++) {
                System.out.print(factors.get(i) + " * ");
            }
            System.out.println(factors.get(factors.size() - 1));
        }
    }

    private static int count;
    public static void main1(String[] args) {
        TestDemo test=new TestDemo(88);
        System.out.println(test.count);

        System.out.println(Math.floor(10.1)); // 10.0
        System.out.println(Math.round(10.1)); // 10
        System.out.println(Math.ceil(10.1)); // 11.0

        System.out.println("===============");
        Integer i01=159; // 自动装箱
        int i02=59;
        Integer i03=Integer.valueOf(159); // 装箱
        Integer i04=new Integer(59); // 在堆上 new 了一个新对象
        System.out.println(i01 == i03);

        System.out.println("================");
        System.out.println((int)'A'); // 65
        System.out.println((char)68); // D
        System.out.println((char) ('A' + 2)); // C
        System.out.println((char)('D' + 3)); // G
    }
    TestDemo(int a) {
        count=a;
    }
}
