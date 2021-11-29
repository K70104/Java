import java.util.Scanner;

public class TestDemo {

    public static void main(String[] args) {
        // 3、for
        // 快捷方式：fori回车
        for (;true;) {
            System.out.println("111"); // 死循环
        }

        // 4、do...while

    }

    public static void main5(String[] args) {
        // 既能被3整除，也能被5整除
        int i = 1;
        while(i <= 100) {
            if(i % 15 != 0) {
                i++;
                continue;
            }
            System.out.println(i);
            i++;
        }
    }

    public static void main4(String[] args) {
        // 求阶乘
        /** int n = 5;
        int i = 1;
        int ret = 1;
        while(i <= n) {
            ret *= i;
            i++;
        }
        System.out.println(ret); // 120 */

        // 求阶乘和
        int j = 1;
        int sum = 0;
        while(j <= 5) {
            int i = 1;
            int ret = 1;
            while (i <= j) {
                ret *= i;
                i++;
            }
            sum = sum + ret;
            j++;
        }
        System.out.println(sum);
    }

    public static void main3(String[] args) {
        // 2、switch语句
        // 不能用作switch参数的类型：long float double boolean
        // 只能是整数，字符，字符串，枚举（JDK1.5开始，引入枚举，枚举也可作为switch参数）

        // 3、循环结构
        // idea 如何调试 --> 甲壳虫/右击debug
        // debug -> 观察代码是怎么一步一步执行的
        int i = 0;
        int sum = 0;
        while(i<=5) { // 布尔表达式
            sum += i;
            i++;
        }
        System.out.println(sum);
    }

    public static void main2(String[] args) {
        // 2. 闰年
        Scanner scanner = new Scanner(System.in);
        int year = scanner.nextInt();
        // 1
        if(year % 100 == 0) {
            if(year % 400 == 0) {
                System.out.println(year+"是闰年！");
            }else {
                System.out.println(year+"不是闰年！");
            }
        }else {
            if(year % 4 == 0) {
                System.out.println(year+"是闰年！");
            }else {
                System.out.println(year+"不是闰年！");
            }
        }

        // 2
        if(year % 100 == 0 && year % 400 == 0) {
                System.out.println(year+"是闰年！");
        }else {
            if(year % 4 == 0) {
                System.out.println(year+"是闰年！");
            }else {
                System.out.println(year+"不是闰年！");
            }
        }

        // 3
        if(year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
            System.out.println(year+"是闰年");
        }else {
            System.out.println(year+"不是闰年");
        }
    }

    public static void main1(String[] args) {
        // 逻辑控制
        // 选择结构，循环结构，循序结构

        // 1、分支语句
        // if...else
        // 1. 判断一个数是不是奇数
        Scanner scanner = new Scanner(System.in); // 从键盘获取数据
        // import java.util.Scanner; --> Alt_回车
        int n = scanner.nextInt();
        if( n % 2 == 0) {
            System.out.println("偶数");
        } else {
            System.out.println("奇数");
        }

        // 输入字符串
        String str = scanner.nextLine();
        // String str = scanner.next(); // 遇到空格结束
        System.out.println(str);
        // 有整数和字符串输入，要先读取字符串
    }
}
