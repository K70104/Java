import java.util.Arrays;

public class TestDemo {
    /**
     * 选择排序
     * @param array 待排序序列
     */
    public static void selectSort(int[] array) {
        int minIndex = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if(array[i] > array[j]) {
                    int tmp = array[i];
                    array[i] = array[j];
                    array[j] = tmp;
                }
            }
        }
    }


    /**
     * 其实就是一个直接插入排序
     * @param array 待排序序列
     * @param gap 组数
     */
    public static void shell(int[] array,int gap) {
        for (int i = gap; i < array.length; i++) {
            int tmp = array[i];
            int j = i - gap;
            for (; j >= 0; j -= gap) {
                if(array[j] > tmp) {
                    array[j + gap] = array[j];
                } else {
                    break;
                }
            }
            array[j + gap] = tmp;
        }
    }

    public static void shellSort(int[] array) {
        int gap = array.length;
        while (gap > 1) {
            shell(array, gap);
            gap /= 2;
        }
        shell(array, 1); // 保证最后是1组
    }

    public static void main(String[] args) {
        int[] array = {3, 12, 5, 17, 2, 8};
        shellSort(array);
        System.out.println(Arrays.toString(array));
    }


    public static void bsInsertSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int v = array[i];
            int left = 0;
            int right = i;
            // [left, right)
            // 需要考虑稳定性
            while (left < right) {
                int m = (left + right) / 2;
                if (v >= array[m]) {
                    left = m + 1;
                } else {
                    right = m;
                }
            }
            // 搬移
            for (int j = i; j > left; j--) {
                array[j] = array[j - 1];
            }
            array[left] = v;
        }
    }

    /**
     * 时间复杂度：O(N^2)
     *      最好的情况是O(N): 对于直接插入排序来说，最好的情况就是数据有序的时候
     *      根据这个结论，推导出另一个结论：对于直接插入排序来说，数据越有序，越快。
     *
     * 空间复杂度：O(1)
     *
     * 稳定性：稳定的
     *   一个稳定的排序，可以实现为不稳定的排序
     *   但是一个本身就不稳定的排序，是不可以变成稳定的排序的
     * @param array
     */
    public static void insertSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int tmp = array[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if(array[j] > tmp) {
                // if(array[j] >= tmp) {  加等号 不稳定
                    array[j + 1] = array[j];
                } else {
                    // array[j + 1] = tmp;  只要j回退的时候，遇到了 比tmp小的元素就结束这次的比较
                    break;
                }
            }
            //j回退到了 小于0 的地方
            array[j + 1] = tmp;
        }
    }
    
    public static void main1(String[] args) {
        int[] array = {3, 12, 5, 17, 2, 8};
        insertSort(array);
        System.out.println(Arrays.toString(array)); // [2, 3, 5, 8, 12, 17]
        System.out.println(123);
    }
}
