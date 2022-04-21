import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TestDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> ret = new ArrayList<>(); // 第一行
        ret.add(1);
        list.add(ret);
        for (int i = 1; i < n; i++) { // n 行
            List<Integer> tmp = new ArrayList<>();
            tmp.add(1); // 首
            List<Integer> preRow = list.get(i - 1); // 上一行
            for (int j = 1; j <= 2 * i - 1; j++) { // 2n - 1 个
                // 左上角上数的和
                int num = 0;
                if (j - 2 >= 0 && j - 2 < preRow.size()) {
                    num += preRow.get(j - 2);
                }
                if (j - 1 >= 0 && j - 1 < preRow.size()) {
                    num += preRow.get(j - 1);
                }
                if (j >= 0 && j < preRow.size()) {
                    num += preRow.get(j);
                }
                tmp.add(num);
            }
            tmp.add(1); // 尾
            list.add(tmp);
        }
        List<Integer> ans = list.get(n - 1); // 第 n 行
        for (int i = 0; i < ans.size(); i++) {
            if (ans.get(i) % 2 == 0) {
                System.out.println(i + 1); // 第几个，从 1 开始数，加 1
                return;
            }
        }
        System.out.println(-1); // 没有偶数
    }

    public int findMinimum(int n, int[] left, int[] right) {
        // write code here
        int leftSum = 0;
        int rightSum = 0;
        int leftMin = Integer.MAX_VALUE;
        int rightMin = Integer.MAX_VALUE;
        int zero = 0;
        for (int i = 0; i < n; i++) {
            if (left[i] * right[i] == 0) {
                zero += left[i] + right[i];
            } else {
                leftSum += left[i];
                rightSum += right[i];
                leftMin = Math.min(leftMin, left[i]);
                rightMin = Math.min(rightMin, right[i]);
            }
        }
        return Math.min(leftSum - leftMin + 1, rightSum - rightMin + 1) + 1;
    }

    public static void main1(String[] args) {
        System.out.println(123);
    }
}