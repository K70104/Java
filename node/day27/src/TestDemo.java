import java.util.Scanner;

class A {
    public A(String str) {

    }
}

class Test {
    public void func() {
        A classa = new A("he");
        A classb = new A("he");
        System.out.println(classa == classb);
    }
}

abstract class IA {
    abstract public void func();
}

abstract class Shape {
    public int val;
    public void func() {
        System.out.println("测试普通方法：");
    }
    public  abstract void draw();
}

interface B {
    public final int a = 0;
}


public class TestDemo {
    public static void main(String[] args) {
        // 准备斐波那契数列
        int[] nums = new int[10001];
        nums[1] = 1; // 从 1 开始，对应
        nums[2] = 2;
        for (int i = 3; i < 10001; i++) {
            nums[i] = nums[i - 1] + nums[i - 2];
            nums[i] = nums[i] % 10000; // 如果大于4位的则只输出最后4位
        }
        // 多组测试用例
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            StringBuilder stringBuilder = new StringBuilder();
            int n = scanner.nextInt();
            for (int i = 0; i < n; i++) {
                int xi = scanner.nextInt();
                // 拼接每个 xi 的密码   格式化输出 如果这个数不足4位则用0填充
                stringBuilder.append(String.format("%04d", nums[xi]));
            }
            // 输出 n 个拼接的密码串
            System.out.println(stringBuilder.toString());
        }
    }

    public int getMost(int[][] board) {
        // write code here
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (i == 0 && j == 0) {
                    continue;
                } else if (i == 0) { // 往右走 加上前一个
                    board[i][j] += board[i][j - 1];
                } else if (j == 0) { // 往下走 加上上一个
                    board[i][j] += board[i - 1][j];
                } else { // 加右一个和下一个的最大值
                    board[i][j] += Math.max(board[i][j + 1], board[i][j + 1]);
                }
            }
        }
        // 返回最后一个
        return board[board.length - 1][board[0].length - 1];
    }

    public static void main4(String[] args) {
        int i = 0;
        int sum = (i++) + (i++) + (i++);
        System.out.println(sum);

        i = 0;
        int sum2 = (++i) + (++i) + (++i);
        System.out.println(sum2);

        i = 5;
        int s = (i++) + (++i) + (i--) + (--i);
        System.out.println(s);
    }

    public int Add(int num1,int num2) {
        int sum = 0;
        int carry = 0;
        while (num2 != 0) {
            sum = num1 ^ num2;
            carry = (num1 & num2) << 1;
            num1 = sum;
            num2 = carry;
        }
        return num1;
    }

    public static void main3(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextDouble()) {
            double a = scanner.nextDouble();
            double b = scanner.nextDouble();
            double c = scanner.nextDouble();
            if ((a > (c - b)) && (a > (b - c)) && (b > (a - c))) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
    }

    public static void main2(String[] args) {
        Test test = new Test();
        test.func();

        int a = 10;
        float d = 3.14f;
        System.out.println('A' + a + d);
    }

    private float f = 1.0f;
    int m = 12;
    public static int n = 1;
    public static void func() {
        System.out.println(123);
    }
    public static void fun2() {
        func();
    }

    public static void main1(String[] args) {
        TestDemo testDemo = new TestDemo();
        TestDemo.func();
    }
}
