import java.math.*;
import java.util.*;

public class TestDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            BigDecimal n = scanner.nextBigDecimal();
            BigDecimal r = scanner.nextBigDecimal();
            BigDecimal len = new BigDecimal("6.28").multiply(r);
            // 身长 比 周长 长，进不去
            System.out.println(n.compareTo(len) == 1 ? "No" : "Yes");
        }
    }

    public static void main2(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            double height = scanner.nextDouble();
            double r = scanner.nextDouble();
            if (2 * 3.14 * r < height) {
                System.out.println("No");
            } else {
                System.out.println("Yes");
            }
        }
    }

    public static void main1(String[] args) {
        System.out.println(123);
    }
}
