

public class TestDemo {

    public static int frogJump(int n) {
        // 青蛙跳台阶问题
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

    public static int fib1(int n) {
        if(n == 1 || n == 2) {
            return 1;
        }else {
            return fib(n-1) + fib(n-2);
        }
    }

    public static int sumEverySum(int n) {
        // 写一个递归方法，输入一个非负整数，返回组成它的数字之和
        if(n < 10) {
            return n;
        }else {
            return n%10 + sumEverySum(n/10);
        }
    }

    public static void printSum(int n) {
        // 按顺序打印一个数字的每一位(例如 1234 打印出 1 2 3 4) （递归）
        if(n < 10) {
            System.out.print(n%10+" ");
        }else {
            printSum(n/10);
            System.out.print(n%10+" ");
        }
    }

    public static int sumAdd(int n) {
        // 递归求 1 + 2 + 3 + ... + 10
        if(n  == 1) {
            return 1;
        }else {
            return n + sumAdd(n-1);
        }
    }



    public static void main1(String[] args) {
        System.out.println(frogJump(5));

        System.out.println(fib(10));

        System.out.println(sumEverySum(1725));

        printSum(123);

        System.out.println(sumAdd(10));
    }


    public static void printOddEven(int n) {
        // 获取一个数二进制序列中所有的偶数位和奇数位， 分别输出二进制序列
        for (int i = 30; i >= 0; i-=2) {
            System.out.print(((n>>>i)&1)+" ");
        }
        System.out.println();
        for (int i = 31; i >= 1; i-=2) {
            System.out.print(((n>>>i)&1)+" ");
        }
    }

    public static void printNum(int n) {
        // 输出一个整数的每一位，如：123的每一位是1 ， 2 ， 3
        if( n < 10) {
            System.out.print(n%10+" ");
        }else {
            printNum(n/10);
            System.out.print(n%10+" ");
        }
    }

    public static void main2(String[] args) {
        printOddEven(15);

        printNum(123);
    }



    public static void main3(String[] args) {
        int[] array = {1, 2, 3, 2, 1};
        int sum = 0;
        for (int i = 1; i < array.length; i++) {
            sum = sum ^ array[i];
        }
        System.out.println(sum);
    }


    public static int fib(int n) {
        if(n < 10) {
            return 10;
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

    public static void main4(String[] args) {
        // 求斐波那契数列的第n项。(迭代实现)
        int ret = fib(10);
        System.out.println(ret);
    }



    public static void main5(String[] args) {
        // 调整数组顺序使得奇数位于偶数之前。调整之后，不关心大小顺序。
        int[] array = {1,2,3,4,5,6,7,8,9,10};
        int left = 0;
        int right = array.length-1;

        while(left < right) {
            while(left < right && array[left] % 2 == 0) {
                left++;
            }
            while(left < right && array[right] % 2 != 0) {
                right--;
            }
            int tmp = array[left];
            array[left] = array[right];
            array[right] = tmp;
        }

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+" ");
        }
    }

    public static int maxN(int x, int y) {
        return x > y ? x : y;
    }

    public static double maxN(double x, double y) {
        return x > y ? x : y;
    }

    public static void maxN(int x, double y, double z) {
        double tmp =  x > y ? x : y; // x y --> max
        double max = tmp > z ? tmp : z;
        double tmp2 = x < y ? x : y;
        double min = tmp2 < z ? tmp2 : z;
        double mid = (x*1.0 + y + z) - max - min;
        System.out.println(max+">"+mid+">"+min);

    }

    public static void main6(String[] args) {
        // 求最大值方法的重载
        //
        //作业内容
        //在同一个类中定义多个方法：要求不仅可以求两个整数的最大值，还可以求两个小数的最大值
        // ，以及两个小数和一个整数的大小关系

        System.out.println(maxN(10, 20));
        System.out.println(maxN(2.7, 5.8));
        maxN(3, 2.1, 3.7);
    }


    public static int retOfN(int n) {
        // 递归求 N 的阶乘
        if(n == 1) {
            return 1;
        }else {
            return n * retOfN(n-1);
        }
    }

    public static void main(String[] args) {
        int ret = retOfN(5);
        System.out.println(ret);
    }

}
