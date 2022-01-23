import java.util.*;

public class TopK {
    /**
     * 373. 查找和最小的 K 对数字
     * @param nums1
     * @param nums2
     * @param k
     * @return
     */
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        // 创建大小为 K 的大根堆
        PriorityQueue<List<Integer>> maxHeap = new PriorityQueue<>(k, new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                return (o2.get(0) + o2.get(1)) - (o1.get(0) + o1.get(1)); // 大根堆
            }
        });
        // 加入 K 组序列，然后比较堆顶元素
        for (int i = 0; i < Math.min(nums1.length, k); i++) {
            for (int j = 0; j < Math.min(nums2.length, k); j++) {
                if(maxHeap.size() < k) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums1[i]);
                    list.add(nums2[j]);
                    maxHeap.offer(list);
                } else {
                    // 堆顶元素大 poll
                    int top = maxHeap.peek().get(0) + maxHeap.peek().get(1);
                    if(top > nums1[i] + nums2[j]) {
                        maxHeap.poll();
                        List<Integer> list = new ArrayList<>();
                        list.add(nums1[i]);
                        list.add(nums2[j]);
                        maxHeap.offer(list);
                    }
                }
            }
        }
        // 存储 k 组序列
        List<List<Integer>> ret = new ArrayList<>();
        for (int i = 0; i < k && !maxHeap.isEmpty(); i++) { // 没有k组 空指针异常
            ret.add(maxHeap.poll());
        }

        return ret;
    }


    // n*logn
    public static int[] topK(int[] array, int k) {
        // 1、创建一个大小为 K 的大根堆
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1; // 大根堆
            }
        });
        // 2、遍历数组当中的元素，前K个元素放到队列当中
        for (int i = 0; i < array.length; i++) {
            if(maxHeap.size() < k) {
                maxHeap.offer(array[i]);
            } else {
                // 3、从第 k+1 个元素开始，每个元素和堆顶元素进行比较
                int top = maxHeap.peek();
                if(top > array[i]) {
                    // 3.1、先弹出
                    maxHeap.poll();
                    //3.2、后存入
                    maxHeap.offer(array[i]);
                }
            }
        }
        // 4、存储前 K 个元素，返回
        int[] ret = new int[k];
        for (int i = 0; i < k; i++) {
            ret[i] = maxHeap.poll();
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] array = {18,21,8,10,34,12};
        int[] ret = topK(array, 3);
        System.out.println(Arrays.toString(ret));
    }
}
