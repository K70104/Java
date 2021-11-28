

public class TestDemo {

    public static int fac(int n) {
        if(n == 1) {
            return 1;
        }
        int tmp = n * fac(n-1);
        return tmp;
    }

    public static int sumAdd(int n) {
        if(n == 1) {
            return 1;
        } else {
            return n + sumAdd(n-1);
        }
    }

    public static void printNum(int n) {
        // 顺序打印每一位
        if(n < 10) {
            System.out.print(n%10+" ");
        }else {
            printNum(n/10);
            System.out.print(n%10+" ");
        }
    }

    public static int sumEveryNum(int n) {
        // 返回每位之和 1234-->1+2+3+4
        if(n < 10) {
            return n;
        }else {
            return n % 10 + sumEveryNum(n/10);
        }
    }

    public static int fib(int n) {
        // 斐波那契数
        if(n == 1 || n == 2) {
            return 1;
        }else {
            return fib(n-1) + fib(n-2);
        }
    }

    public static int fib2(int n) {
        // 斐波那契数 - 循环/迭代
        if(n == 1 || n == 2) {
            return 1;
        }
        int f1 = 1;
        int f2 = 1;
        int f3 = 0;
        for (int i = 3; i <= n; i++) {
            f3 = f1 + f2;
            f1 = f2;
            f2 = f3;
        }
        return f3;
    }

    public static int frogJump(int n) {
        // 青蛙跳台阶
        if(n == 1 || n == 2) {
            return n;
        }else {
            return frogJump(n-1) + frogJump(n-2);
        }
    }

    public static int frogJump2(int n) {
        // 青蛙跳台阶 ->迭代
        if(n == 1 || n == 2) {
            return n;
        }
        int f1 = 1;
        int f2 = 2;
        int f3 = 0;
        for (int i = 3; i <= n; i++) {
            f3 = f1 + f2;
            f1 = f2;
            f2 = f3;
        }
        return f3;
    }

    public static void main(String[] args) {
        // 递归：方法 自己调用自己的过程
        // 1. 有一个趋向于终止的条件 2. 自己调用自己

        int sum = sumAdd(3);
        System.out.println(sum);

        printNum(123);

        System.out.println(sumEveryNum(1725));

        System.out.println(fib(10));

        System.out.println(fib2(50));

        System.out.println(frogJump(1));
        System.out.println(frogJump(2));
        System.out.println(frogJump(3));
        System.out.println(frogJump(4));

        System.out.println(frogJump2(1));
        System.out.println(frogJump2(2));
        System.out.println(frogJump2(3));
        System.out.println(frogJump2(4));
    }

}
