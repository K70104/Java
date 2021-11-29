import com.sun.xml.internal.fastinfoset.util.CharArrayArray;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 类名：大驼峰
 */
class Person {
    //字段 -> 属性 -> 成员变量
    // --> 类的内部，方法的外部

    // 成员变量：1. 普通成员变量，2. 静态成员变量
    public String name = "gaobo";
    public int age = 18;

    // 成员方法
    // 1. 成员变量：普通成员方法，静态成员方法
    public void eat() {
        System.out.println(name+" 正在吃饭");
    }

    public void sleep() {
        System.out.println(name+" 正在睡觉");
    }
}

public class TestDemo {

    public static void main(String[] args) {
        // 成员方法的访问
        Person person = new Person();
        person.eat(); // gaobo 正在吃饭
        person.sleep(); // gaobo 正在睡觉
    }

    public static void main11(String[] args) {
        Person person = new Person();
        person.name = "bit";
        person.age = 10;
        System.out.println(person.name); // bit
        System.out.println(person.age); // 10
        System.out.println("=======================");

        Person person2 = new Person();
        System.out.println(person2.name); // null
        System.out.println(person2.age); // 0
        // 每个对象都有 name age
    }

    public static void main10(String[] args) {
        // 怎样访问成员变量：普通成员变量的访问需要通过对象的引用
        // 由 类 产生 对象 的过程：实例化，用new
        // 由类Person实例化了一个对象

        Person person = new Person();
        System.out.println(person.name);
        /**
         * 局部变量没有赋初值，打印报错
         * 成员变量如果没有赋值，打印的name是null，而age是0
         *
         * 成员变量没有赋初值的默认值：
         *                         整数   byte short int long（默认值：0）
         *                         浮点数 float double（默认值：0.0）
         *          基本数据类型    字符   char（默认值：'\u0000'）
         *                         布尔   boolean（默认值：false）
         * 数据类型
         *          引用类型        String  数组 类 接口 枚举……（默认值：null）
         */
    }

    public static void main9(String[] args) {
        // 类和对象

        // 由类定义的变量：引用变量
        Person person1 = null;

        Person person2 = new Person();
    }

    public static void main8(String[] args) {
        int[][] array = {{1, 2}, {5, 6, 7}};
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j]+" ");
            }
            System.out.println();
        }
        /**
         * 1 2
         * 5 6 7
         */
        System.out.println("======================");

        // 不规则的二维数组
        int[][] array2 = new int[2][]; // 2行 null
        array2[0] = new int[3];
        array2[1] = new int[2];
        for (int i = 0; i < array2.length; i++) {
            for (int j = 0; j < array2[i].length; j++) {
                System.out.print(array2[i][j]+" ");
            }
            System.out.println();
        }
        /**
         * 0 0 0
         * 0 0
         */
    }

    public static void main7(String[] args) {
        // 二维数组
        int[][] array = {{1, 2, 3}, {5, 6, 7}};
        int[][] array2 = new int[][]{{1, 2, 3}, {5, 6, 7}};
        int[][] array3 = new int[2][3];

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(array[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println("======================");

        System.out.println(array.length); // 2
        System.out.println(array[0].length); // 3

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println("======================");

        for (int[] ret : array) {
            for (int x : ret) {
                System.out.print(x+" ");
            }
            System.out.println();
        }
        System.out.println("======================");

        System.out.println(Arrays.deepToString(array)); // [[1, 2, 3], [5, 6, 7]]
    }

    public static int[] copyArray(int[] array) {
        int[] ret = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            ret[i] = array[i];
        }
        return ret;
    }

    public static void main6(String[] args) {
        // 数组拷贝

        // 1. for 循环
        int[] array = {1,2,3,4,5,6};
        int[] copy1 = copyArray(array);
        System.out.println(Arrays.toString(copy1));

        // 2. Arrays.copyOf
        int[] copy2 = Arrays.copyOf(array, array.length);
        System.out.println(Arrays.toString(copy2)); // [1, 2, 3, 4, 5, 6]
        int[] copy3 = Arrays.copyOf(array, array.length*2);
        System.out.println(Arrays.toString(copy3)); // [1, 2, 3, 4, 5, 6, 0, 0, 0, 0, 0, 0]

        /**
         *     public static int[] copyOf(int[] original, int newLength) {
         *         int[] copy = new int[newLength];
         *         System.arraycopy(original, 0, copy, 0,
         *                          Math.min(original.length, newLength));
         *         return copy;
         *     }
         */

        // 3. Arrays.copyOfRange 拷贝局部
        int[] copy4 = Arrays.copyOfRange(array, 1, 3); // 左闭右开
        System.out.println(Arrays.toString(copy4)); // [2, 3]

        // 4. arraycopy
        int[] copy5 = new int[array.length];
        System.arraycopy(array, 0, copy5,0, array.length);
        System.out.println(Arrays.toString(copy5));

        /**
         *  C++/C 实现了
         *  速度快
         *  public static native void arraycopy(Object src,  int  srcPos,
         *                                         Object dest, int destPos,
         *                                         int length);
         */

        // 5. array.clone
        int[] copy6 = array.clone(); // 产生一个副本
        System.out.println(Arrays.toString(copy6));

        // 浅拷贝 深拷贝
        // 深拷贝：拷贝完成，访问修改不会影响原来的

        // 深拷贝或浅拷贝都是认为实现的
        // 要想实现深拷贝，就要把对象也进行拷贝
        // 需要看你拷贝的是什么，怎么拷
    }


    public static void transform(int[] array) {
        int left = 0;
        int right = array.length -1;
        while(left < right) {
            // 该循环结束, left 就指向了一个奇数
            while(left < right && array[left] % 2 == 0) {
                left++;
            }
            // 该循环结束, right 就指向了一个偶数
            while(left < right && array[right] % 2 != 0) {
                right--;
            }
            int tmp = array[left];
            array[left] = array[right];
            array[right] = tmp;
        }

        for(int i = 0; i < array.length; i++) {
            System.out.print(array[i]+" ");
        }
    }

    public static void main5(String[] args) {
        // 给定一个整型数组, 将所有的偶数放在前半部分, 将所有的奇数放在数组后半部分

        // 设定两个下标分别指向第一个元素和最后一个元素.
        //用前一个下标从左往右找到第一个奇数, 用后一个下标从右往左找到第一个偶数, 然后交换两个位置的元素.
        //依次循环即可
        int[] arr = {1, 2, 3, 4, 5, 6};
        transform(arr);
        System.out.println(Arrays.toString(arr));
    }


    public static void reverse(int[] array) {
        int left = 0;
        int right = array.length -1;
        while (left < right) {
            int tmp = array[left];
            array[left] = array[right];
            array[right] = tmp;
            left++;
            right--;
        }
    }

    public static void main4(String[] args) {
        // 给定一个数组, 将里面的元素逆序排列

        // 设定两个下标, 分别指向第一个元素和最后一个元素. 交换两个位置的元素.
        //然后让前一个下标自增, 后一个下标自减, 循环继续即可
        int[] array = {1, 2, 3, 4};
        reverse(array);
        System.out.println(Arrays.toString(array));
    }


    public static void main3(String[] args) {
        int[] array = new int[10];
        Arrays.fill(array, 99); // 填充10个99

        Arrays.fill(array, 2, 6, 1999); // 从2下标到5下标 [2,6)

        System.out.println(Arrays.toString(array));
    }


    public static void bubbleSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            boolean flag = true;
            for (int j = 0; j < array.length - 1 - i; j++) {
                if(array[j] > array[j+1]) {
                    int tmp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = tmp;
                    flag = false;
                }
            }
            if(flag == true) {
                break;
            }
        }
    }

    public static void main2(String[] args) {
        // 2. 给定一个数组, 让数组升序 (降序) 排序
        // 1 冒泡排序
        int[] array = {9, 5, 2, 7};
        // bubbleSort(array);

        // 2 Arrays.sort
        Arrays.sort(array);
        for (int x : array) {
            System.out.print(x+" ");
        }
    }


    public static boolean isSortedUp(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if(array[i] > array[i+1]) {
                return false;
            }
        }
        return true;
    }

    public static void main1(String[] args) {
        // 1. 给定一个整型数组, 判断是否该数组是有序的(升序)
        int[] array = {1,2,3,10,5,6};
        boolean flag = isSortedUp(array);
        System.out.println(flag);
        // System.out.println(isSortedUp(array));
    }
}
