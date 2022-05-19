import java.util.*;

public class TestDemo {
    public static void main(String[] args) {
        System.out.println("hello world!");
    }

    public static void main4(String[] args) {
        int border = -1;
        int[] array = new int[100000];
        array[0] = 1;
        array[1] = 2;
        for (int i = 2; i < 100000; i++) {
            array[i] = array[i - 1] + array[i - 2];
            if (border == -1 && array[i] >= 1000000) { // 超过6位数 记录
                border = i + 1;
            }
            array[i] %= 1000000; // 用 border，后取模
        }
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            if (n < border) {
                System.out.printf("%d\n", array[n - 1]);
            } else {
                System.out.printf("%06d\n", array[n - 1]);
            }
        }
    }

    private static boolean isLeap(int y) {
        return (y % 4 == 0 && y % 100 != 0 || y % 400 == 0);
    }

    // 给定一年 整年的收益
    private static int annualIncome(int year) {
        return 2 * 31
                + 28
                + 31
                + 2 * 30
                + 31
                + 2 * 30
                + 31
                + 2 * 31
                + 2 * 30
                + 2 * 31
                + 30
                + 2 * 31
                + (isLeap(year) ? 1 : 0);
    }

    private static boolean isPrime(int month) {
        return month == 2 || month == 3 || month ==  5 || month == 7 || month == 11;
    }

    // 从一年1月1日 到这一年 m,d 的收益
    private static int profitThisYear(int year, int month, int day) {
        int profit = 0;
        if (!isPrime(month)) {
            profit = day * 2;
        } else {
            profit = day;
        }

        while (--month > 0) {
            switch(month) {
                case 1: case 8: case 10: case 12:
                    profit += 62;
                    break;
                case 3: case 5: case 7:
                    profit += 31;
                    break;
                case 4: case 6: case 9:
                    profit += 60;
                    break;
                case 11:
                    profit += 30;
                    break;
                default: // 2 月
                    profit += (28 + (isLeap(year) ? 1 : 0));
                    break;
            }
        }
        return profit;
    }

    public static void main3(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int fromYear = scanner.nextInt();
            int fromMonth = scanner.nextInt();
            int fromDay = scanner.nextInt();
            int toYear = scanner.nextInt();
            int toMonth = scanner.nextInt();
            int toDay = scanner.nextInt();

            int profit = 0;
            // 起始年：整年 - 到fromDay之间 (注意减一)
            profit = annualIncome(fromYear);
            profit -= profitThisYear(fromYear, fromMonth, fromDay - 1);
            // 同一年 2000 5 17 2000 7 1
            // —> 5.17到12.31的收益 - 全年
            // = 负的一月一号到5.16的收益 + 加后面结束年
            // = 负的一月一号到5.16的收益 + 一月一号到7.1
            // = 5.17 - 7.1 的收益
            if (fromYear == toYear) {
                profit -= annualIncome(fromYear);
            }
            // 结束年
            profit += profitThisYear(toYear, toMonth, toDay);
            // 中间年
            for (int i = fromYear + 1; i < toYear; i++) {
                profit += annualIncome(i);
            }
            System.out.println(profit);
        }
    }

    public static void main2(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String m = scanner.next();
            String n = scanner.next();
            Set<Character> set = new HashSet<>();
            for (int i = 0; i < m.length(); i++) {
                set.add(m.charAt(i));
            }
            int count = 0;
            for (int i  = 0; i < n.length(); i++) {
                if (set.contains(n.charAt(i))) {
                    set.remove(n.charAt(i));
                    count++;
                }
            }
            System.out.println(count);
        }
    }

    private static void getBlack(char[][] board, int x, int y, int count) {
        if (x < board.length || y < board[0].length || board[x][y] == '#') {
            return;
        }
        count++;
        getBlack(board, x, y - 1, count);
        getBlack(board, x - 1, y, count);
        getBlack(board, x, y + 1, count);
        getBlack(board, x + 1, y, count);
    }

    public static void main1(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int m = scanner.nextInt();
            int n = scanner.nextInt();
            char[][] board = new char[m][n];
            int x = 0;
            int y = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    board[i][j] = (char) scanner.nextInt();
                    if (board[i][j] == '@') {
                        x = i;
                        y = j;
                    }
                }
            }
            int count = 0;
            getBlack(board, x, y, count);
            System.out.println(count);
        }
    }
}
