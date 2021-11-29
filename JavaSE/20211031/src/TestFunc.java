

public class TestFunc {

    /**
     * 时间复杂度_空间复杂度
     * 1.算法效率
     * 算法效率分析分为两种：1.时间效率，2.空间效率。时间效率被称为时间复杂度，而空间效率被
     * 称作空间复杂度。 时间复杂度主要衡量的是一个算法的运行速度，而空间复杂度主要衡量一个算法所需要的额
     * 外空间，在计算机发展的早期，计算机的存储容量很小。所以对空间复杂度很是在乎。但是经过计算机行业的
     * 迅速发展，计算机的存储容量已经达到了很高的程度。所以我们如今已经不需要再特别关注一个算法的空间复
     * 杂度
     * /

     /**
     * 2.时间复杂度
     * 时间复杂度的定义：在计算机科学中，算法的时间复杂度是一个函数，它定量描述了该算法的运行时间。一个
     * 算法执行所耗费的时间，从理论上说，是不能算出来的，只有你把你的程序放在机器上跑起来，才能知道。但
     * 是我们需要每个算法都上机测试吗？是可以都上机测试，但是这很麻烦，所以才有了时间复杂度这个分析方
     * 式。一个算法所花费的时间与其中语句的执行次数成正比例，算法中的基本操作的执行次数，为算法的时间复
     * 杂度。
     *
     * 大O的渐进表示法 用于描述函数渐进行为的数学符号
     * 1、用常数1取代运行时间中的所有加法常数。
     * 2、在修改后的运行次数函数中，只保留最高阶项。
     * 3、如果最高阶项存在且不是1，则去除与这个项目相乘的常数。得到的结果就是大O阶。
     * 在实际中一般情况关注的是算法的最坏运行情况，所以数组中搜索数据时间复杂度为O(N)
     */

    // 请计算一下func1基本操作执行了多少次？
    void func1(int N){
        int count = 0;
        for (int i = 0; i < N ; i++) {
            for (int j = 0; j < N ; j++) {
                count++;
            }
        }
        for (int k = 0; k < 2 * N ; k++) {
            count++;
        }
        int M = 10;
        while ((M--) > 0) {
            count++;
        }
        System.out.println(count);
        // 使用大O的渐进表示法以后，Func1的时间复杂度为：O(N^2)
    }

    // 计算func2的时间复杂度？
    void func2(int N) {
        int count = 0;
        for (int k = 0; k < 2 * N ; k++) {
            count++;
        }
        int M = 10;
        while ((M--) > 0) {
            count++;
        }
        System.out.println(count);
        // O(N)
    }

    // 计算func3的时间复杂度？
    void func3(int N, int M) {
        int count = 0;
        for (int k = 0; k < M; k++) {
            count++;
        }
        for (int k = 0; k < N ; k++) {
            count++;
        }
        System.out.println(count);
        // O(M+N)
    }

    // 计算func4的时间复杂度？
    void func4(int N) {
        int count = 0;
        for (int k = 0; k < 100; k++) {
            count++;
        }
        System.out.println(count);
        // O(1)
    }

    // 计算bubbleSort的时间复杂度？
    void bubbleSort(int[] array) {
        for (int end = array.length; end > 0; end--) {
            boolean sorted = true;
            for (int i = 1; i < end; i++) {
                if (array[i - 1] > array[i]) {
                    // Swap(array, i - 1, i);
                    sorted = false;
                }
            }
            if (sorted == true) {
                break;
            }
        }
        // n*(n-1) --> O(N^2)
    }

    // 计算binarySearch的时间复杂度？
    int binarySearch(int[] array, int value) {
        int begin = 0;
        int end = array.length - 1;
        while (begin <= end) {
            int mid = begin + ((end-begin) / 2);
            if (array[mid] < value)
                begin = mid + 1;
            else if (array[mid] > value)
                end = mid - 1;
            else
                return mid;
        }
        return -1;
    }

    // 计算阶乘递归factorial的时间复杂度？
    long factorial(int N) {
        // 递归的时间复杂度 = 递归的次数 每次通过执行的次数
        //                                     1
        // O(N)
        return N < 2 ? N : factorial(N-1) * N;
    }

    // 计算斐波那契递归fibonacci的时间复杂度？
    int fibonacci(int N) {
        return N < 2 ? N : fibonacci(N-1)+fibonacci(N-2);
        //
    }


    /**
     * 3.空间复杂度
     * 空间复杂度是对一个算法在运行过程中临时占用存储空间大小的量度 。空间复杂度不是程序占用了多少bytes
     * 的空间，因为这个也没太大意义，所以空间复杂度算的是变量的个数。空间复杂度计算规则基本跟实践复杂度
     * 类似，也使用大O渐进表示法
     */

    // 计算bubbleSort1的空间复杂度？
    void bubbleSort1(int[] array) {
        for (int end = array.length; end > 0; end--) {
            boolean sorted = true; // 1
            for (int i = 1; i < end; i++) {
                if (array[i - 1] > array[i]) {
                    //Swap(array, i - 1, i);
                    sorted = false;
                }
            }
            if (sorted == true) {
                break;
            }
        }
        // 使用了常数个额外空间，所以空间复杂度为 O(1)
    }

    // 计算fibonacci的空间复杂度？
/*    int[] fibonacci(int n) {
        long[] fibArray = new long[n + 1]; // n+1 --> O(N)
        // 动态开辟了N个空间
        fibArray[0] = 0;
        fibArray[1] = 1;
        for (int i = 2; i <= n ; i++) {
            fibArray[i] = fibArray[i - 1] + fibArray [i - 2];
        }
        return fibArray;
    }*/

    // 计算阶乘递归Factorial的空间复杂度？
/*    long factorial(int N) {
        return N < 2 ? N : factorial(N-1)*N;
        // 每递归一次，开辟一块内存
        // 递归调用了N次，开辟了N个栈帧，每个栈帧使用了常数个空间。空间复杂度为 O(N)
    }*/

    public static void main(String[] args) {

    }

}
