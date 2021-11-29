import java.util.Random;
import java.util.Scanner;

public class TestDemo {
    /**
     * 在同一个类中,分别定义求两个整数的方法 和 三个小数之和的方法。 并执行代码，求出结果
     * @param a
     * @param b
     * @return
     */

    public static int add(int a, int b) {
        return a + b;
    }

    public static double add(double a, double b, double c) {
        return a + b + c;
    }

    public static void main(String[] args) {
        int a = 10;
        int b = 20;
        int sum1 = add(a, b);
        System.out.println("a + b = "+sum1);

        double d1 = 2.7;
        double d2 = 5.3;
        double d3 = 7.1;
        double sum2 = add(d1, d2 ,d3);
        System.out.println("d1 + d2 + d3 = "+sum2);
    }

    /**
     *创建方法求两个数的最大值max2，随后再写一个求3个数的最大值的函数max3。
     求：在max3这个函数中，调用max2函数，来实现3个数的最大值计算
     * /
    public static int max2(int a, int b) {
        return a > b ? a : b;
    }
    public static int max3(int a, int b, int c) {
        int max = max2(a, b);
        max = max2(max, c);
        return max;
    }

    public static void main7(String[] args) {
        int num1 = 10;
        int num2 = 20;
        int num3 = 30;
        int maxAB = max2(num1, num2);
        System.out.println("max->num1 num2: "+maxAB);

        int maxABC = max3(num1, num2, num3);
        System.out.println("max->num1 num2 num3: "+maxABC);
    }

    public static void main6(String[] args) {
        // 求N的阶乘
        int n = 5;
        int ret = 1;
        for (int i = 1; i <= n; i++) {
            ret *= i;
        }
        System.out.println(ret);
    }

    public static void main5(String[] args) {
        // 求1！+2！+3！+4！+........+n!的和
        int n = 5;
        int ret = 1;
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            ret *= i;
            sum += ret;
        }
        System.out.println(sum);
    }

    public static void main4(String[] args) {
        // 输出n*n的乘法口诀表，n由用户输入。
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(i+"*"+j+"="+i*j+" ");
            }
            System.out.println();
        }
    }

    public static void main3(String[] args) {
        // 模拟登陆
        Scanner scanner = new Scanner(System.in);
        int count = 3;
        while(count != 0) {
            System.out.println("请输入密码：");
            String password = scanner.nextLine();
            if(password.equals("12345")) {
                System.out.println("登陆成功！");
                break;
            } else {
                count--;
                System.out.println("密码错误，还有 "+count+"次机会！");
            }
        }
    }

    public static void getBinary(int n) {

    }

    public static void main2(String[] args) {
        // 获取一个数二进制序列中所有的偶数位和奇数位， 分别输出二进制序列
        int n = 15;
        getBinary(n);
    }

    public static void main1(String[] args) {
        // 1、猜数字游戏
        Random random = new Random();
        int rand = random.nextInt(100);
        Scanner scanner = new Scanner(System.in);
        while(true) {
            System.out.println("请输入你要猜的数字：");
            int n = scanner.nextInt();
            if(n > rand) {
                System.out.println("猜大了！");
            } else if(n ==  rand) {
                System.out.println("猜对了！");
                break;
            } else {
                System.out.println("猜小了！");
            }
        }
    }

}
