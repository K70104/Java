import java.util.Arrays;

public class TestDemo {

    public static void move(char pos1, char pos2) {
        System.out.print(pos1+"->"+pos2+" ");
    }

    /**
     *
     * @param n 盘子个数
     * @param pos1 盘子所在起始位置
     * @param pos2 盘子的中转位置
     * @param pos3 盘子的结束位置
     */
    public static void hanio(int n, char pos1, char pos2, char pos3) {
        if(n == 1) {
            move(pos1, pos3); // A-C
        }else {
            hanio(n-1, pos1, pos3, pos2);
            move(pos1, pos3);
            hanio(n-1, pos2, pos1, pos3);
        }
    }

    public static void main1(String[] args) {
        // 汉诺塔
        // 1: A->C  1
        // 2: A->B  A->C  B->C  3
        // 3: A->C  A->B  C->B  A->C  B->A  B->C  A->C  7
        // 64:       2^N -1
        hanio(1, 'A', 'B', 'C');
        System.out.println();
        hanio(2, 'A', 'B', 'C');
        System.out.println();
        hanio(3, 'A', 'B', 'C');
        System.out.println();
    }


    public static void main2(String[] args) {
        // 数组：存储一组相同数据类型的数据的集合

        // 定义数组的三种方式
        int[] array = {1,2,3,4,5,6,7}; // 定义数组且初始化 []不能放任何数字
        // 注意事项：
        // 1. 定义数组时，不能写具体数字，

        int[] array2 = new int[3]; // 大小为3个元素 并没有初始化 默认是0
        // new是关键字：实例化一个对象。意味着Java当中的数组，也是一个对象


        int[] array3 = new int[]{1,2,3,4,5};
    }

    public static void main3(String[] args) {
        int[] array = {1,2,3,4,5,6,7};
        System.out.println(array.length); // 当前数组长度

        System.out.println(array[3]); // 访问下标为3的元素
        // System.out.println(array[-1]); // ArrayIndexOutOfBoundsException: -1 数组越界异常

        array[3] = 10; // 改
        System.out.println(array[3]);
    }

    public static void main4(String[] args) {
        // 打印数组的方式
        // 1、遍历数组
        int[] array = {1,2,3,4,5,6};
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+" ");
        }
        System.out.println();

        // 2、增强for循环/for each循环
        for (int x : array) { // 接收 array 的每一个元素
            System.out.print(x+" ");
        }
        System.out.println();

        // for循环 和 each循环 的区别：
        // for循环可以拿到下标，for each只能拿到元素（集合中用得多）

        // 3、借助Java的操作数组的工具类 Arrays
        // import java.util.Arrays;
        String ret = Arrays.toString(array); // 把当前数组以字符串形式输出 返回值String
        System.out.println(ret); // [1, 2, 3, 4, 5, 6]

        System.out.println(Arrays.toString(array));
    }

    public static void main5(String[] args) {
        int[] array = {1,2,3,4,5,6,7};

        int[] array2 = null; // 空引用 此引用不指向任何对象
        // System.out.println(array2.length); // 空指针异常
        // System.out.println(array2[0]); // 空指针异常
    }

    public static void printf(int[] array) {
        // 数组如何打印？
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+" ");
        }
        System.out.println();
    }

    public static void main6(String[] args) {
        int[] array = {1,2,3,4,5,6,7};
        printf(array);
    }


    public static void func1(int[] array) {
        array = new int[]{3,4,5,6,7};
    }

    public static void func2(int[] array) {
        array[0] = 900;
    }

    public static void main7(String[] args) {
        int[] array = {1,2,3,4,5,6,7};
        System.out.println(Arrays.toString(array));

        func1(array);
        func2(array);

        System.out.println(Arrays.toString(array));
    }

    public static void main8(String[] args) {
        int[] array1 = {1,2,3,4,5};
        int[] array2 = array1;
        // 代表array2这个引用 指向了array1这个引用 **指向的对象**
        // 引用 指向 引用：这句话是错的，引用只能指向对象

        // 一个引用 不能同时指向 多个对象
        int[] array = new int[]{1,2,3,4,5};
        //array = new int[10];
        //array = new int[2]{1,2};
        //array = new int[5];

        // 引用不一定在栈上：
        // 一个变量 在不在栈上，是变量的性质决定的，
        // 如果就是一个局部变量，就在栈上。示例成员变量，就不一定在栈上了
    }


    public static void swap(int[] array) {
        int tmp = array[0];
        array[0] = array[1];
        array[1] = tmp;
    }

    public static void main9(String[] args) {
        int[] array = {10, 20};
        System.out.println("交换前："+array[0]+" "+array[1]);
        swap(array);
        System.out.println("交换后："+array[0]+" "+array[1]);
    }


    /**
     * 在原来的数组上扩大二倍
     * @param array
     */
    public static void func(int[] array) {
        // 在元素组扩大
        for (int i = 0; i < array.length; i++) {
            array[i] = 2 * array[i];
        }
    }

    public static int[] transform(int[] array) {
        // 改新的数组 不影响原数组
        int[] ret = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            ret[i] = 2 * array[i];
        }
        return ret;
    }

    public static void main10(String[] args) {
        // 将数组作为方法的返回值

        // 1、写一个方法，将数组每个元素*2
        int[] array = {1,2,3,4,5};
        // func(array);
        // System.out.println(Arrays.toString(array));

        int[] ret = transform(array);
        System.out.println(ret);
    }


    public static String myToString(int[] array) {
        // [1,2,3,4,5]

        if(array == null) return "null";

        String str = "[";
        for (int i = 0; i < array.length; i++) {
            str = str + array[i];
            if(i != array.length - 1) {
                str = str + ",";
            }
        }
        str = str + "]";
        return str;
    }

    public static void main11(String[] args) {
        // 模拟实现 数组转字符串 toString
        int[] array = {1,2,3,4,5};
        // System.out.println(Arrays.toString(array));
        System.out.println(Arrays.toString(array));
    }


    public static int maxNum(int[] array) {
        if(array == null) return -1;
        if(array.length == 0) return -1;

        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if(max < array[i]) {
                max = array[i];
            }
        }
        return max;
    }

    public static void main12(String[] args) {
        // 找数组的最大值
        int[] array = {12, 22, 3 ,7 ,13};
        System.out.println(maxNum(array));
    }


    public static int findNum(int[] array, int key) {
        for (int i = 0; i < array.length; i++) {
            if(array[i] == key) {
                return i;
            }
        }
        return -1; // 下标没有负数
    }

    public static int binarySearch(int[] array, int key) {
        int left = 0;
        int right = array.length - 1;
        while(left <= right) {
            int mid = (left + right) / 2;
            if(array[mid] > key) {
                right = mid -1;
            }else if(array[mid] < key) {
                left = mid + 1;
            }else {
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        // 查找指定元素，返回下标
        int[] array = {3, 7, 13, 12, 22};
        // System.out.println(findNum(array, 7));

        // 二分查找 -有序
        System.out.println(binarySearch(array, 17));
    }

}
