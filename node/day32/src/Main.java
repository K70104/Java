import java.util.Scanner;

public class Main {
    private static boolean isPrimeNum(int n) {
        if (n == 1) {
            return false;
        }
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    private static boolean isLeap(int y) {
        if (y % 4 == 0 && y % 100 != 0 || y % 400 == 0) {
            return true;
        }
        return false;
    }

    private static int income(int fromYear, int fromMonth, int fromDay, int toYear, int toMonth, int toDay) {
        int income = 0;
        int[] monthDays = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        if (isLeap(fromYear)) { // 起始年 是闰年
            monthDays[1] = 29;
        }
        // 1、同一年 单独计算
        if (fromYear == toYear) {
            // fromMonth - toMonth-1
            for (int i = fromMonth; i < toMonth; i++) {
                if (isPrimeNum(i)) {
                    income += monthDays[i - 1];
                } else {
                    income += monthDays[i - 1] * 2;
                }
            }
            // 只有一个月 fromDay - toDay
            income += isPrimeNum(fromMonth) ? toDay - fromDay + 1: (toDay - fromDay + 1) * 2;
            return income;
        }

        // 计算起始年 fromMont - 12 的收益
        if (isPrimeNum(fromMonth)) { // fromMonth 可能不是从第一天开始
            income += monthDays[fromMonth - 1] - fromDay + 1;
        } else {
            income += (monthDays[fromMonth - 1] - fromDay + 1) * 2;
        }
        for (int i = fromMonth + 1; i <= 12; i++) { // fromMonth - 12
            if (isPrimeNum(i)) {
                income += monthDays[i - 1];
            } else {
                income += monthDays[i - 1] * 2;
            }
        }
        // 结束年不是闰年 改回 28
        if (!isLeap(toYear)) {
            monthDays[1] = 28;
        }
        // 计算结束年 1 - toMonth-1 的收益
        for (int i = 1; i < toMonth; i++) { // 结束年 月
            if (isPrimeNum(i)) {
                income += monthDays[i - 1];
            } else {
                income += monthDays[i - 1] * 2;
            }
        }
        // toMonth 的 toDay 收益
        income += isPrimeNum(toMonth) ? toDay : toDay * 2; // 结束年 日
        // 2、相隔一年 返回
        if (fromYear + 1 == toYear) {
            return income;
        }

        // 3、相隔多年 加中间年
        monthDays[1] = 28; // 改回 28
        // 2000 - 2002    ---> 2001-2001 需要取等于
        for (int i = fromYear + 1; i <= toYear - 1; i++) {
            if (isLeap(i)) {
                monthDays[1] = 29;
            } else {
                monthDays[1] = 28;
            }
            for (int j = 1; j <= 12; j++) {
                if (isPrimeNum(j)) {
                    income += monthDays[j - 1];
                } else {
                    income += monthDays[j - 1] * 2;
                }
            }
        }
        return income;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            // 2000 1 1 2999 12 31    579243
            int fromYear = scanner.nextInt();
            int fromMonth = scanner.nextInt();
            int fromDay = scanner.nextInt();
            int toYear = scanner.nextInt();
            int toMonth = scanner.nextInt();
            int toDay = scanner.nextInt();
            int income = income(fromYear, fromMonth, fromDay, toYear, toMonth, toDay);
            System.out.println(income);
        }
    }
}