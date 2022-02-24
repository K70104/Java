import java.util.*;

public class TestDemo {
    /**
     * 插入排序
     * @param array
     */
    public static void insertSort(int[] array) {
        for (int i = 1; i < array.length; i++) { // 假定第一个有序 从第二个开始
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


    /**
     * @param array 待排序的序列
     * @param gap 组数
     */
    public static void sell(int[] array, int gap) {
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

    /**
     * 希尔排序
     * @param array
     */
    public static void sellSort(int[] array) {
        int gap = array.length;
        while(gap > 1) {
            sell(array, gap);
            gap /= 2;
        }
        sell(array, 1); // 保证最后是 1 组
    }


    /**
     * 选择排序
     * @param array 待排序的序列
     */
    public static void selectSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int minIndex = i; // 最小值下标
            for (int j = i + 1; j < array.length; j++) {
                if(array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            int tmp = array[i];
            array[i] = array[minIndex];
            array[minIndex] = tmp;
        }
    }

    public static void selectSort1(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if(array[j] < array[i]) {
                    int tmp = array[i];
                    array[i] = array[j];
                    array[j] = tmp;
                }
            }
        }
    }


    public static void test1(int capacity) {
        int[] array = new int[capacity];
        for (int i = 0; i < array.length; i++) {
            array[i] = i;
        }
        long start = System.currentTimeMillis(); // 开始时间
        //insertSort(array); // 2
        //sellSort(array); // 4
        quickSort(array); // 717
        long end = System.currentTimeMillis(); // 结束时间
        System.out.println(end - start);
    }

    public static void test2(int capacity) {
        int[] array = new int[capacity];
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(capacity);
        }
        long start = System.currentTimeMillis(); // 开始时间
        // insertSort(array); // 1806
        //sellSort(array); // 12
        selectSort(array); // 2362
        long end = System.currentTimeMillis(); // 结束时间
        System.out.println(end - start);
    }


    /**
     * 堆排序
     * @param array
     */
    public static void headSort(int[] array) {
        // 1、建堆 O(N)
        creatHeap(array);
        int end = array.length - 1;
        while (end > 0) {
            //  2、交换调整 O(NlogN)
            swap(array, 0, end);
            shiftDown(array, 0, end);
            end--;
        }
    }

    public static void creatHeap(int[] array) {
        for (int parent = (array.length-1-1)/2; parent >= 0; parent--) {
            shiftDown(array, parent, array.length);
        }
    }

    public static void shiftDown(int[] array, int parent, int len) {
        int child = 2 * parent + 1; // 左孩子下标
        while(child < len) {
            if(child + 1 < len && array[child] < array[child + 1]) {
                child++; // 指向最大的孩子下标
            }
            if(array[child] > array[parent]) {
                swap(array, child, parent);
                parent = child;
                child = 2 * parent + 1;
            } else {
                break;
            }
        }
    }

    private static void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }


    /**
     * 冒泡排序
     * @param array
     */
    public static void bubbleSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if(array[j] > array[j + 1]) {
                    int tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                }
            }
        }
    }

    public static void bubbleSort1(int[] array) {
        for (int i = 0; i < array.length; i++) {
            boolean flg = true; // 假设有序
            for (int j = 0; j < array.length - 1 - i; j++) {
                if(array[j] > array[j + 1]) {
                    int tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                    flg = false;
                }
            }
            if(flg) {
                break;
            }
        }
    }


    /**
     * 快速排序
     * @param array
     */
    public static void quickSort1(int[] array) {
        quick(array, 0, array.length - 1);
    }

    // 递归基准左右
    public static void quick(int[] array, int left, int right) {
        if(left >= right) {
            return;
        }

        // 2、如果区间内的数据 在排序的过程中 小于某个阈值 使用直接插入排序
        if(right - left + 1 <= 1500) {
            insertSort2(array, left, right);
            return;
        }

        // 优化
        // 1、找基准之前，我们找到中间大小的值-使用三数取中法
        int midValIndex = findMidValIndex(array, left, right);
        swap(array, midValIndex, left);

        int pivot = partition(array, left, right); // 基准
        quick(array, left, pivot - 1);
        quick(array, pivot + 1, right);
    }

    // (2.) 直接插入排序
    public static void insertSort2(int[] array, int start, int end) {
        for (int i = 1; i < end; i++) { // 假定第一个有序 从第二个开始
            int tmp = array[i];
            int j = i - 1;
            for (; j >= start; j--) {
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

    // (1.) 找三数中间值下标
    public static int findMidValIndex(int[] array, int start, int end) {
        int mid  = start + ((end - start) >>> 1);
        if(array[start] < array[end]) {
            if(array[mid] < array[start]) {
                return start;
            } else if (array[mid] > array[end]) {
                return end;
            } else {
                return mid;
            }
        } else {
            if(array[mid] > array[start]) {
                return start;
            } else if (array[mid] < array[end]) {
                return end;
            } else {
                return mid;
            }
        }
    }

    // 找基准
    public static int partition(int[] array, int start, int end) {
        int tmp = array[start];
        while(start < end) {
            while(start < end && array[end] >= tmp) {
                end--; // 从后往前找一个 < tmp 的值
            }
            array[start] = array[end];
            while(start < end && array[start] <= tmp) {
                start++; // 从前往后找一个 > tmp 的值
            }
            array[end] = array[start];
        }
        array[start] = tmp; // start 和 end 相遇的位置就是基准
        return start;
    }


    /**
     * 非递归 快速排序
     * @param array
     */
    public static void quickSort(int[] array) {
        Stack<Integer> stack = new Stack<>();
        int left = 0;
        int right = array.length - 1;
        int pivot = partition(array, left, right);
        if(pivot > left + 1) {
            // 左边有两个元素
            stack.push(left);
            stack.push(pivot - 1);
        }
        if(pivot < right - 1) {
            // 右边有两个元素
            stack.push(pivot + 1);
            stack.push(right);
        }

        while(!stack.isEmpty()) {
            right = stack.pop(); // 先右
            left = stack.pop();

            pivot = partition(array, left, right);

            if(pivot > left + 1) {
                stack.push(left);
                stack.push(pivot - 1);
            }
            if(pivot < right - 1) {
                stack.push(pivot + 1);
                stack.push(right);
            }
        }
    }


    /**
     * 有序数组合并
     * @param array1 有序
     * @param array2 有序
     * @return
     */
    public static int[] mergeArray(int[] array1, int[] array2) {
        int[] merge = new int[array1.length + array2.length];
        int i = 0;
        int s1 = 0;
        int s2 = 0;
        while (s1 < array1.length && s2 < array2.length) {
            if (array1[s1] <= array2[s2]) {
                merge[i++] = array1[s1++];
            } else {
                merge[i++] = array2[s2++];
            }
        }
        while (s1 < array1.length) {
            merge[i++] = array1[s1++];
        }
        while (s2 < array2.length) {
            merge[i++] = array2[s2++];
        }
        return merge;
    }


    /**
     * 归并排序
     * @param array
     */
    public static void mergeSort1(int[] array) {
        mergeSortInternal(array, 0, array.length - 1);
    }

    // 分解
    public static void mergeSortInternal(int[] array, int low, int high) {
        if(low >= high) { // 相遇分解完成
            return;
        }
        int mid = low + ((high - low) >>> 1);
        // 分解左右
        mergeSortInternal(array, low, mid);
        mergeSortInternal(array, mid + 1, high);
        // 合并
        merge(array, low, mid, high);
    }

    // 合并
    private static void merge(int[] array, int low, int mid, int high) {
        int[] tmp = new int[high - low + 1];
        int k = 0;
        int s1 = low;
        int e1 = mid;
        int s2 = mid + 1;
        int e2 = high;
        while (s1 <= e1 && s2 <= e2) {
            if(array[s1] <= array[s2]) { // 去等号就是不稳定
                tmp[k++] = array[s1++];
            }else {
                tmp[k++] = array[s2++];
            }
        }
        while (s1 <= e1) {
            tmp[k++] = array[s1++];
        }
        while (s2 <= e2) {
            tmp[k++] = array[s2++];
        }
        // 拷贝tmp数组的元素 放入原来的数组array当中
        for (int i = 0; i < k; i++) {
            array[i + low] = tmp[i]; // i + low 可以对应后半段位置
        }
    }


    /**
     * 非递归 归并排序
     * @param array
     */
    public static void mergeSort(int[] array) {
        int nums = 1; // 每组的数据个数 从每组1个开始

        while(nums < array.length) { // 组数直到len-1停止
            // 数组每次都要进行遍历
            for (int i = 0; i < array.length; i += nums * 2) {
                int left = i;
                int mid = left + nums - 1;
                if(mid > array.length) { // mid 可能超出范围
                    mid = array.length - 1;
                }
                int right = mid + nums;
                if(right > array.length) { // right 也有可能超出范围
                    right = array.length - 1;
                }
                // 确定下标后 合并
                merge(array, left, mid, right);
            }
            nums *= 2;
        }
    }


    /**
     * 计数排序
     * @param array
     */
    public static void countingSort(int[] array) {
        // 找数组最大值和最小值
        int maxVal = array[0];
        int minVal = array[0];
        for (int i = 1; i < array.length; i++) {
            if(array[i] > maxVal) {
                maxVal = array[i];
            }
            if(array[i] < minVal) {
                minVal = array[i];
            }
        }
        // 统计数组每个数据出现的次数
        int[] count = new int[maxVal - minVal + 1];
        for (int i = 0; i < array.length; i++) {
            // 为了空间的合理使用 这里需要index-minVal  防止923-90
            count[array[i] - minVal]++;
        }
        // 因为默认是0 所以不为0的拿出来 把数据写回数组
        int indexArray = 0;
        for (int i = 0; i < count.length; i++) {
            while(count[i] != 0) {
                // 注意 对应回去要加 minVal
                array[indexArray++] = i + minVal; // 注意 下标要向后移动
                count[i]--; // 拷贝一个 次数就少一个
            }
        }
    }

    public static void main3(String[] args) {
        int[] array1 = {1, 3, 5, 6, 11};
        int[] array2 = {3, 5, 9, 21, 32, 33};
        int[] array = mergeArray(array1, array2);
        System.out.println(Arrays.toString(array));
    }

    public static void main2(String[] args) {
        test2(100_0000);

        // test2(10_0000);
    }

    public static void main(String[] args) {
        int[] array = {3, 0, 12, 5, 0, 17, 2, 8};
        countingSort(array);
        System.out.println(Arrays.toString(array)); // [2, 3, 5, 8, 12, 17]
        System.out.println(123);
    }
}

