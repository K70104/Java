

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class TestDemo {
    public static void login() {
        Scanner scanner = new Scanner(System.in);
        int count = 3;
        while(count != 0) {
            System.out.println("请输入你的密码：");
            String password = scanner.nextLine();
            if(password.equals("12345")) {
                System.out.println("登录成功！");
                break;
            } else {
                count--;
                System.out.println("密码错误，你还有 "+count+"次机会！");
            }
        }
    }

    public static void main(String[] args) {
        // 模拟用户输入密码
        login();
    }

    public static int add(int a, int b) {
        return a + b;
    }
    public static double add(double a, double b) {
        return a + b;
    }
    public static int add(int a, int b, int c) {
        return a + b + c;
    }

    public static void main15(String[] args) {
        // 方法的重载 overload
        // 重载的规则：
        // 可以不是一个类（继承关系上也可以）
        // 1. 方法名相同
        // 2. 方法的参数列表不同（个数或者参数类型）
        // 3. 方法的返回值类型不影响重载
    }

    public static void swap(int a, int b) {
        // java里，拿不到栈上的地址
        // 如果要实现交换，只能把a，b放到堆上
        int tmp = a;
        a = b;
        b = tmp;
    }

    public static void main14(String[] args) {
        // 形参和实参
        int a = 10;
        int b = 20;
        System.out.println("交换前："+a+" "+b);
        swap(a, b);
        System.out.println("交换后："+a+" "+b);
    }

    public static int fac(int n) {
        int ret = 1;
        for (int i = 1; i <= n; i++) {
            ret *= i;
        }
        return ret;
    }

    /**
     * 求n的阶乘的和
     * 阅读性提高了
     * @param n
     * @return
     */
    public static int facSum(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += fac(i);
        }
        return sum;
    }

    public static void main13(String[] args) {
        // 计算1!+2!+3!+4!+5!
        System.out.println(facSum(5));
    }

    /**
     * // 求1-n的和
     * 函数名字：小驼峰
     * @param n 输入的数字
     * @return 求的和
     */
    public static int sumAdd(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        return sum;
    }

    public static void main12(String[] args) {
        // 方法：C的函数 --> 功能 可以重复使用的
        /**
         * public static 返回值 方法名称(形参列表) {
         *     函数体; // 方法体
         * }
         */
        // 求1-10的和
        int ret = sumAdd(10); // 方法的调用
        System.out.println(ret);

        // System.out.println(func());

        System.out.println(sumAdd(10)*2); // 函数的返回值支持链式调用

        // java 没有“函数声明”的概念

        // 方法的定义必须在类之中，代码书写在调用位置的上方或下方均可

        // 函数开辟的内存--栈帧
        // 每个函数在调用的时候，都会开辟栈帧，属于这个函数的内存
    }

    public static void func() {

    }

    public static void main11(String[] args) {
        // 编写程序数一下 1到 100 的所有整数中出现多少个数字9
        int count = 0;
        for(int i = 1; i <= 100; i++) {
            if(i % 10 == 9) {
                count++;
            }
            if(i / 10 == 9) {
                count++;
            }
        }
        System.out.println(count);
    }

    public static void main10(String[] args) {
        // 计算1/1-1/2+1/3-1/4+1/5 …… + 1/99 - 1/100 的值
        double sum = 0.0;
        int flag = 1;
        for (int i = 1; i <= 100; i++) {
            sum += (1.0 / i) * flag;
            flag = -flag;
        }
        System.out.println(sum); // 0.688172179310195
    }

    public static void main9(String[] args) {
        // 求两个正整数的最大公约数
        // 辗转相除法
        int a = 24;
        int b = 18;
        int c = a % b; // 24 % 18 = 6
        while(c != 0) {
            a = b;
            b = c;
            c = a % b;
        }
        System.out.println("最大公约数是"+b);
    }

    public static void main8(String[] args) {
        // 输出9*9乘法口诀表
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(i+"*"+j+"="+i*j+" ");
            }
            System.out.println();
        }
    }

    public static void main7(String[] args) {
        // 输出 1000 - 2000 之间所有的闰年
        int year = 0;
        for (year = 1000; year <= 2000; year++) {
            if(year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
                System.out.println(year+" 是闰年");
            }
        }
    }

    public static void main6(String[] args) {
        // 给定一个数字，判定一个数字是否是素数
        /** Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int i = 0;
        for (i = 2; i < num; i++) {
            if(num % i == 0) {
                System.out.println(num+"num不是素数！");
                break;
            }
        }
        if(i == num) {
            System.out.println("num是素数");
        } */

        // 优化1
        // n --> a*b  例16  1*16  2*8  4*4  其中一定有一个数字是小于等于16/2 --8
        /** Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int i = 0;
        for (i = 2; i <= num / 2; i++) { //
            if(num % i == 0) {
                System.out.println(num+"num不是素数！");
                break;
            }
        }
        if(i > num / 2) { //
            System.out.println("num是素数");
        } */

        // 优化2
        // n --> a*b  例16  1*16  2*8  4*4  其中一定有一个数字是小于等于根号n --4
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int i = 0;
        for (i = 2; i <= Math.sqrt(num); i++) { //
            if(num % i == 0) {
                System.out.println(num+"num不是素数！");
                break;
            }
        }
        if(i > Math.sqrt(num)) { //
            System.out.println("num是素数");
        }
    }

    public static void main5(String[] args) {
        // 根据输入的年龄, 来打印出当前年龄的人是少年(低于18), 青年(19-28), 中年(29-55), 老年(56以上)
        Scanner  scanner = new Scanner(System.in);
        int age = scanner.nextInt();
        if(age > 0 && age < 18) {
            System.out.println("少年");
        } else if(age >= 18 && age <= 28) {
            System.out.println("青年");
        } else if(age >= 29 && age <= 55) {
            System.out.println("中年");
        } else {
            System.out.println("老年");
        }
    }

    public static void main4(String[] args) {
        // 猜数字游戏
        Random random = new Random();
        int rand = random.nextInt(100);
        Scanner scanner = new Scanner(System.in);
        while(true) {
            System.out.print("请输入你要猜的数字：");
            int n = scanner.nextInt();
            if (n < rand) {
                System.out.println("猜小了");
            } else if (n == rand) {
                System.out.println("猜对了");
                break;
            } else {
                System.out.println("猜大了");
            }
        }
    }

    public static void main3(String[] args) {
        // 循环读取n个数字
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) { // 结束：Ctrl+d
            int n = scanner.nextInt();
            System.out.println(n);
        }
    }

    public static void main2(String[] args) {
        Scanner scanner = new Scanner(System.in); // 从键盘读
        int n = scanner.nextInt();
        System.out.println(n);

        /* double d = scanner.nextDouble();
        System.out.println(d); */

        // 放在n前面读才可以 回车
        String str1 = scanner.nextLine();
        System.out.println(str1);

        // next不能读空格
        String str2 = scanner.nextLine();

        // 关闭
        scanner.close();
    }

    public static void main1(String[] args) throws IOException {
        // 一、输入输出
        System.out.print("Enter a Char:");
        char i = (char)System.in.read(); // Alt+回车
        System.out.println("your char is :"+i);
    }
}
