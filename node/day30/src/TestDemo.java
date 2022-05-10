import java.math.BigDecimal;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.*;

public class TestDemo {

    public void oddInOddEvenInEven(int[] array) {
        int m = 0; // 偶数位
        int n = 1; // 奇数位
        while (m < array.length && n < array.length) {
            if (array[m] % 2 == 0) {
                m += 2;
                continue;
            }
            if (array[n] % 2 != 0) {
                n += 2;
                continue;
            }
            // 偶数位是奇数 奇数位是偶数 交换
            int tmp = array[m];
            array[m] = array[n];
            array[n] = tmp;
        }
    }

    public static void main2(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            BigDecimal a = scanner.nextBigDecimal();
            BigDecimal b = scanner.nextBigDecimal();
            BigDecimal c = scanner.nextBigDecimal();
            if (a.add(b).compareTo(c) > 0 && a.add(c).compareTo(b) > 0 && b.add(c).compareTo(a) > 0) {
                System.out.println("Yes");
            } else{
                System.out.println("No");
            }
        }
    }

        public boolean isValid(String code) {
            int n = code.length();
            Deque<String> tags = new ArrayDeque<String>();
            int i = 0;
            while (i < n) {
                if (code.charAt(i) == '<') {
                    if (i == n - 1) {
                        return false;
                    }
                    if (code.charAt(i + 1) == '/') { // 结束标签
                        int j = code.indexOf('>', i);
                        if (j < 0) {
                            return false;
                        }
                        String tagname = code.substring(i + 2, j);
                        if (tags.isEmpty() || !tags.peek().equals(tagname)) {
                            return false;
                        }
                        tags.pop();
                        i = j + 1;
                        if (tags.isEmpty() && i != n) {
                            return false;
                        }
                    } else if (code.charAt(i + 1) == '!') { // cdata
                        if (tags.isEmpty()) {
                            return false;
                        }
                        if (i + 9 > n) {
                            return false;
                        }
                        String cdata = code.substring(i + 2, i + 9);
                        if (!"[CDATA[".equals(cdata)) {
                            return false;
                        }
                        int j = code.indexOf("]]>", i);
                        if (j < 0) {
                            return false;
                        }
                        i = j + 3;
                    } else {
                        int j = code.indexOf('>', i);
                        if (j < 0) {
                            return false;
                        }
                        String tagname = code.substring(i + 1, j);
                        if (tagname.length() < 1 || tagname.length() > 9) {
                            return false;
                        }
                        for (int k = 0; k < tagname.length(); ++k) {
                            if (!Character.isUpperCase(tagname.charAt(k))) {
                                return false;
                            }
                        }
                        tags.push(tagname);
                        i = j + 1;
                    }
                } else {
                    if (tags.isEmpty()) {
                        return false;
                    }
                    i++;
                }
            }

            return tags.isEmpty();
        }

        // 将元素交换到对应的位置  空间复杂度：O(1)
        // 数组的下标范围是 [0, n−1]，数 i 放在数组下标为 i−1 的位置
        // i 恰好出现了一次，那么将 i 放在数组中下标为 i-1
        // i 出现了两次，那么我们希望其中的一个 i 放在数组下标中为 i-1 的位置
        public List<Integer> findDuplicates(int[] nums) {
            for (int i = 0; i < nums.length; ++i) {
                while (nums[i] != nums[nums[i] - 1]) { // 循环 直到两个元素相等或是自己
                    swap(nums, i, nums[i] - 1); // nums[i] 应该在 nums[i] − 1
                }
            }
            List<Integer> list = new ArrayList<Integer>();
            for (int i = 0; i < nums.length; ++i) {
                if (nums[i] - 1 != i) { // nums[i] 出现了两次（另一次出现在位置 num[i] − 1）
                    list.add(nums[i]);
                }
            }
            return list;
        }

        public static void swap(int[] nums, int index1, int index2) {
            int temp = nums[index1];
            nums[index1] = nums[index2];
            nums[index2] = temp;
        }

        // 使用正负号作为标记  空间复杂度：O(1)
        // 对应的下标处的元素是负数，已被访问，因此该整数被第二次访问，即出现两次
        public List<Integer> findDuplicates1(int[] nums) {
            List<Integer> ans = new ArrayList<Integer>();
            for (int i = 0; i < nums.length; ++i) {
                int x = Math.abs(nums[i]);
                if (nums[x - 1] > 0) {
                    nums[x - 1] = -nums[x - 1];
                } else {
                    ans.add(x);
                }
            }
            return ans;
        }

        public static void main1(String[] args) {
            int[] array = {4, 3, 2, 7, 8, 2, 3, 1};
            TestDemo t = new TestDemo();
            List<Integer> ret = t.findDuplicates(array);
            System.out.println(ret);
            System.out.println(123);
        }
    }
