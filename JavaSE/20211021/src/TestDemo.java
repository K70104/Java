import java.util.Scanner;

public class TestDemo {
    // 水仙花数
    public static void findNum(int n) {
        for (int i = 1; i <= n; i++) {
            int count = 0; // 计算数字的位数
            int tmp = i;
            while(tmp != 0) {
                count++;
                tmp /= 10;
            }
            tmp = i;
            int sum = 0;
            while(tmp != 0) {
                sum += Math.pow(tmp %  10, count);
                tmp /= 10;
            }
            if(sum == i) {
                System.out.println(i);
            }
        }
    }

    public static int numOfOne(int n) {
        // 二进制位有多少1
        int count = 0;
        while (n != 0) {
            if ((n & 1) == 1) {
                count++;
            }
            n = n >>> 1; // 无符号右移
        }
        return count;
    }

    public static int numOfOne2(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n = n & (n - 1);
        }
        return count;
    }

    public static void printBinary(int n) {
        // 获取奇偶数位，分别输出
        for (int i = 30; i >= 0; i-=2) {
            System.out.print(((n >> i) & 1)+" ");
        }
        System.out.println();
        for (int i = 31; i >= 1; i-=2) {
            System.out.print(((n >> i) & 1)+" ");
        }
    }

    public static void printNum(int n) {
        // 逆序打印
        while(n != 0) {
            System.out.print(n%10+" ");
            n /= 10;
        }
    }

    public static void main1(String[] args) {
        /*Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); // 999999
        findNum(n);

        System.out.println(numOfOne(n));*/

        // printBinary(15);

        // printNum(123);

        // 有一组数据，只有一个数字是出现一次，其他是两次，请找出这个数字
        int[] array = {1, 2, 3, 2, 1};
        // int sum = 0;
        int sum = array[0];
        for (int i = 1; i < array.length; i++) {
            sum = sum ^ array[i];
        }
        System.out.println(sum);
    }

    public static void main(String[] args) {
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
    }

}
