import java.util.Scanner;

public class TestDemo {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        System.out.println("Hello world!".length());

        Scanner scanner = new Scanner(System.in);
        int s1 = scanner.nextInt();
        int s2 = scanner.nextInt();
        int s3 = scanner.nextInt();

        System.out.printf("score1=%d,score2=%d,score3=%d", s1, s2, s3);
    }

    public static void main1(String[] args) {
        System.out.println("     **");
        System.out.println("     **");
        System.out.println("************");
        System.out.println("************");
        System.out.println("    *  *");
        System.out.println("    *  *");

        System.out.printf("%#o %#X", 1234, 1234);

        System.out.printf("%15d", 0xABCDEF);
    }
}