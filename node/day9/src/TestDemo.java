import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.util.LinkedList;
import java.util.Scanner;

public class TestDemo {
    public static void main(String[] args) {
        String str = "SELECT dep.NAME, sum( sal.salary ) FROM salary sal\n" +
                "JOIN staff sta ON sal.staff_id = sta.staff_id\n" +
                "JOIN depart dep ON sta.depart_id = dep.depart_id \n" +
                "WHERE YEAR ( sal.MONTH ) = 2016 \n" +
                "AND MONTH ( sal.MONTH ) = 9 \n" +
                "GROUP BY dep.depart_id";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char ch = Character.toLowerCase(str.charAt(i));
            sb.append(ch);
        }
        System.out.println(sb.toString());
    }

    public static int passwordLevel(String s) {
        int score = 0;
        // 长度
        int len = s.length();
        if (len <= 4) {
            score += 5;
        } else if (len >= 5 && len <= 7) {
            score += 10;
        } else {
            score += 25;
        }
        // 统计字符个数
        int Upletter = 0; // 大写字母
        int Loletter = 0; // 小写字母
        int digit = 0; // 数字
        int symbol = 0; // 符号
        for (int i= 0; i < len; i++) {
            char ch = s.charAt(i);
            if (Character.isLowerCase(ch)) {
                Loletter++;
            } else if (Character.isUpperCase(ch)) {
                Upletter++;
            } else if (ch >= '0' && ch <= '9') {
                digit++;
            } else {
                symbol++;
            }
        }
        // 加分
        if ((Upletter + Loletter) > 0) { // 有字母
            if (Upletter == 0 || Loletter == 0) { // 都是大写或小写
                score += 10;
            } else {
                score += 20; // 大小写混合
            }
        }
        if (digit == 1) { // 一个数字
            score +=  10;
        } else if (digit > 1) { // 超过一个数字
            score += 20;
        }
        if (symbol ==  1) { // 一个符号
            score += 10;
        } else if (symbol > 1) { // 超过一个符号
            score += 25;
        }
        // 奖励
        if (Upletter != 0 && Loletter != 0 && digit != 0 && symbol != 0) {
            score += 5;
        } else if ((Upletter + Loletter) != 0 && digit != 0 && symbol != 0) {
            score += 3;
        } else if ((Upletter + Loletter) != 0 && digit != 0) {
            score += 2;
        }
        return score;
    }

    public static void main2(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        int score = passwordLevel(str);
        if (score >= 90) {
            System.out.println("VERY_SECURE");
        } else if (score >= 80) {
            System.out.println("SECURE");
        } else if (score >= 70) {
            System.out.println("VERY_STRONG");
        } else if (score >= 60) {
            System.out.println("STRONG");
        } else if (score >= 50) {
            System.out.println("AVERAGE");
        } else if (score >= 25) {
            System.out.println("WEAK");
        } else {
            System.out.println("VERY_WEAK");
        }
    }

    public boolean checkWon(int[][] board) {
        // write code here
        Boolean row = true; // 行
        for (int i = 0; i < board.length; i++) {
            row = true;
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] != 1) {
                    row = false;
                    break;
                }
            }
        }
        if (row) return true; // 列
        Boolean col = true;
        for (int i = 0; i < board.length; i++) {
            row = true;
            for (int j = 0; j < board[0].length; j++) {
                if (board[j][i] != 1) {
                    col = false;
                    break;
                }
            }
        }
        if (col) return true;
        Boolean slash1 = true; // 左对角线
        Boolean slash2 = true; // 右对角线
        int j1 = 0;
        int j2 = board.length - 1;
        for (int i = 0; i < board.length; i++) {
            if (slash1 && board[i][j1++] != 1) {
                slash1 = false;
            }
            if (slash2 && board[j2][i] != 1) {
                slash2 = false;
            }
        }
        if (slash1 || slash2) return true;
        return false;
    }

    public static void main1(String[] args) {
        System.out.println(123);
        int array[] = new int[10];
        System.out.println(array[9]);
    }
}
