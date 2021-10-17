package Test;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        // 求一个整数，在内存当中存储时，二进制1的个数
        int n = 15;
        int cnt = 0;
        while(n != 0) {
            if((n & 1) == 1) {
                cnt++;
            }
            n >>= 1;
        }
        System.out.println(cnt);
    }

    public static void main10(String[] args) {
        // 求两个正整数的最大公约数
        int num1 = 10;
        int num2 = 20;
        int min = 0;
        min = num1 > num2 ? num2 : num1;
        while(true) {
            if(num1 % min == 0 && num2 % min == 0) {
                System.out.println(min);
                break;
            }
            min--;
        }
    }

    public static void main9(String[] args) {
        // 计算1/1-1/2+1/3-1/4+1/5 …… + 1/99 - 1/100 的值
        double sum = 0.0;
        int flag = 1;
        for (int i = 1; i < 99; i++) {
            sum += (1.0 / i) * flag;
            flag = -flag;
        }
        System.out.println(sum);
    }

    public static void main8(String[] args) {
        // 求出0～999之间的所有“水仙花数”并输出。(“水仙花数”是指一个三位数，
        // 其各位数字的立方和确好等于该数本 身，如；153＝1＋5＋3?，则153是一个“水仙花数“。）
        int i = 0;
        for (i = 100; i < 999; i++) {
            int tmp = i;
            // 求位数
            int cnt = 0;
            while(tmp != 0) {
                cnt++;
                tmp /= 10;
            }
            // 计算每一位次方和
            tmp = i;
            int sum = 0;
            while(tmp != 0) {
                sum += (int)Math.pow(tmp % 10, cnt);
                tmp /= 10;
            }
            // 判断
            if(sum == i) {
                System.out.println(i);
            }
        }
    }

    public static void main7(String[] args) {
        // 完成猜数字游戏 ，用户输入数字，判断该数字是大于，小于，还是等于随机生成的数字，等于的时候退出程序。
        Scanner scanner = new Scanner(System.in);
        // srand((unsigned int)time(NULL));
        // ???????????????????????????????????????????????
        // int ret = rand() % 100 + 1;
        int i = 1;
        while(i == 1) {
            System.out.println("请输入数字:>");
            int guess = scanner.nextInt();
            /*if(guess > ret) {
                System.out.println("猜大了");
            }
            else if(guess < ret) {
                System.out.println("猜小了");
            }
            else {
                System.out.println("猜对了");
            }*/
        }
    }

    public static void main6(String[] args) {
        // 打印 X 图形
        // https://www.nowcoder.com/practice/83d6afe3018e44539c51265165806ee4
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()) {
            int n = scanner.nextInt();
            int i = 0;
            for(i = 0; i< n; i++) {
                int j = 0;
                for(j=0; j<n; j++) {
                    if(j == i || j + i == n - 1) {
                        System.out.print("*");
                    }
                    else {
                        System.out.print(" ");
                    }
                }
                System.out.println();
            }
        }
    }

    public static void main5(String[] args) {
        // 根据输入的年龄, 来打印出当前年龄的人是少年(低于18), 青年(19-28), 中年(29-55), 老年(56以上)
        int age = 10;
        if(age < 18) {
            System.out.println("少年");
        }
        else if(age >= 18 && age <= 28) {
            System.out.println("青年");
        }
        else if(age >= 29 && age <= 55) {
            System.out.println("中年");
        }
        else {
            System.out.println("老年");
        }
    }

    public static void main4(String[] args) {
        // 给定一个数字，判定一个数字是否是素数
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        for (int i = 2; i < num; i++) {
            if(num % i == 0) {
                System.out.println("num不是素数");
                return;
            }
        }
        System.out.println("num是素数");
    }

    public static void main3(String[] args) {
        // 打印 1 - 100 之间所有的素数
        int i = 0;
        for (i = 1; i < 100; i++) {
            int flag = 1;
            int j = 0;
            for (j = 2; j < i; j++) {
                if(i % j == 0) {
                    flag = 0;
                    break;
                }
            }
            if(flag == 1) {
                System.out.printf("%d ", i);
            }
        }
    }

    public static void main2(String[] args) {
        // 输出 1000 - 2000 之间所有的闰年
        int year = 0;
        for (year = 1000; year <= 2000; year++) {
            if(year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
                System.out.printf("%d ", year);
            }
        }
    }

    public static void main1(String[] args) {
        // 1到 100 的所有整数中出现多少个数字9
        int i = 0;
        int count = 0;
        for(i = 1; i <= 100; i++) {
            if(i % 10 == 9) {
                count++;
            }
            if(i / 10 == 9) {
                count++;
            }
        }
        System.out.println(count);
    }
}
