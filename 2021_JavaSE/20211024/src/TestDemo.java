import com.sun.media.jfxmediaimpl.HostUtils;

import java.util.Arrays;

public class TestDemo {

    public static String myToString(int[] array) {
        if(array == null) return "null";
        String str = "[";
        for (int i = 0; i < array.length; i++) {
            str += array[i];
            if(i != array.length - 1) {
                str += ",";
            }
        }
        str += "]";
        return str;
    }

    public static void main11(String[] args) {
        // 实现一个方法 toString, 把一个整型数组转换成字符串. 例如数组 {1, 2, 3} ,
        // 返回的字符串为 "[1, 2, 3]", 注意 逗号 的位置和数量
        int[] array = {1,2,3,4,5};
        String ret = myToString(array);
        System.out.println(ret);
    }

    public static int binaryArr(int[] array, int key) {
        int left = 0;
        int right = array.length - 1;
        while(left <= right) {
            int mid = (left + right) / 2;
            if(array[mid] < key) {
                left = mid + 1;
            } else if(array[mid] > key) {
                right = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static void main10(String[] args) {
        // 给定一个有序整型数组, 实现二分查找
        int[] array = {1,2,3,4,5,6,7,8,9,10};
        int key = 7;
        System.out.println(binaryArr(array, key));
    }

    public static int IsOrder(int[] array) {
        for (int i = 0; i < array.length-1; i++) {
            if(array[i] > array[i+1]) {
                return 0;
            }
        }
        return 1;
    }

    public static void main9(String[] args) {
        // 给定一个整型数组, 判定数组是否有序（递增）
        int[] array1 = {1,2,3,4,5};
        if(IsOrder(array1) == 1) {
            System.out.println("sorted");
        } else {
            System.out.println("unsorted");
        }
        int[] array2 = {1,2,3,2,5};
        if(IsOrder(array2) == 1) {
            System.out.println("sorted");
        } else {
            System.out.println("unsorted");
        }
    }

    public static void sort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if(array[j] > array[j+1]) {
                    int tmp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = tmp;
                }
            }
        }
    }

    public static void main8(String[] args) {
        // 给定一个整型数组, 实现冒泡排序(升序排序)
        int[] array = {9,8,7,6,5,4,3,2,1,0};
        sort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+" ");
        }
        System.out.println();
    }

    public static int findTheOne(int[] array) {
        int sum = array[0];
        for (int i = 1; i < array.length; i++) {
            sum ^= array[i];
        }
        return sum;
    }

    public static void main7(String[] args) {
        int[] array = {1,2,3,2,1};
        System.out.println(findTheOne(array));
    }

    /*public static int findTheOne(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int ret = array[i];
            for (int j = 0; j < array.length; j++) {
                if(i == j) continue;
                if(ret == array[j]) {
                    return i;
                }
            }
        }
    }

    public static void main(String[] args) {
        // 给定一个非空整数数组，除了某个元素只出现一次以外，
        // 其余每个元素均出现两次。找出那个只出现了一次的元素。
        int ret = int[] array = {1,2,3,2,1};
        System.out.println(array[ret]);
    }*/

    public static void main6(String[] args) {
        // 创建一个 int 类型的数组, 元素个数为 100, 并把每个元素依次设置为 1 - 100
        int[] array = new int[100];
        for (int i = 0; i < 100; i++) {
            array[i] = i + 1;
        }
        printArr(array);
    }

    public static void printArr(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+" ");
        }
        System.out.println();
    }

    public static void printArray(int[] array) {
        for (int x : array) {
            System.out.print(x+" ");
        }
        System.out.println();
    }

    public static void main5(String[] args) {
        // 实现一个方法 printArray, 以数组为参数, 循环访问数组中的每个元素, 打印每个元素的值.
        int[] array = {1,2,3,4,5,6,7,8,9,10};
        printArray(array);
    }

    public static void transform(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = 2 * array[i];
        }
    }

    public static int[] func(int[] array) {
        int[] ret = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            ret[i] = array[i] * 2;
        }
        return ret;
    }

    public static void main4(String[] args) {
        // 实现一个方法 transform, 以数组为参数, 循环将数组中的每个元素 乘以 2 ,
        // 并设置到对应的数组元素上. 例如 原数组为 {1, 2, 3}, 修改之后为 {2, 4, 6}
        int[] array = {1,2,3,4,5};
        // transform(array);
        int[] ret = func(array);
        System.out.println(Arrays.toString(ret));
    }

    public static int sumArr(int[] array) {
        int sum = 0;
        for (int x : array) {
            sum += x;
        }
        return sum;
    }

    public static void main3(String[] args) {
        // 实现一个方法 sum, 以数组为参数, 求数组所有元素之和
        int[] array = {1,2,3,4,5,6,7};
        System.out.println(sumArr(array));
    }

    public static double avg(int[] array) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        return (double)(sum / array.length);
    }

    public static void main2(String[] args) {
        // 实现一个方法 avg, 以数组为参数, 求数组中所有元素的平均值(注意方法的返回值类型).
        int[] array = {1,2,3,4,5,6};
        System.out.println(avg(array));
    }


    public static void move(char pos1, char pos2) {
        System.out.print(pos1+"->"+pos2+" ");
    }

    public static void hanio(int n, char pos1, char pos2, char pos3) {
        if(n == 1) {
            move(pos1, pos3);
        }else {
            hanio(n-1, pos1, pos3, pos2);
            move(pos1, pos3);
            hanio(n-1, pos2, pos1, pos3);
        }
    }

    public static void main1(String[] args) {
        // 递归求解汉诺塔问题
        hanio(1, 'A', 'B', 'C');
        System.out.println();
        hanio(2, 'A', 'B', 'C');
        System.out.println();
        hanio(3, 'A', 'B', 'C');
        System.out.println();
    }
}
