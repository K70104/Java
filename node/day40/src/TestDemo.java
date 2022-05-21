import java.util.*;

public class TestDemo {
    private static boolean isWin(char[][] board) {
        for (int i = 0; i < 16; i++) {
            for (int j = 0; j < 16; j++) {
                if (board[i][j] != '.') {
                    if (board[i][j] == board[i][j + 1] && board[i][j] == board[i][j + 2] && board[i][j] == board[i][j + 3] && board[i][j] == board[i][j + 4]) {
                        return true;
                    }
                    if (board[i][j] == board[i + 1][j] && board[i][j] == board[i + 2][j] && board[i][j] == board[i + 3][j] && board[i][j] == board[i + 4][j]) {
                        return true;
                    }
                    if (board[i][j] == board[i + 1][j + 1] && board[i][j] == board[i + 2][j + 2] && board[i][j] == board[i + 3][j + 3] && board[i][j] == board[i + 4][j + 4]) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static void main4(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            char[][] board = new char[20][20];
            for (int i = 0; i < 20; i++) {
                String s = scanner.next();
                for (int j = 0; j < 20; j++) {
                    // board[i][j] = scanner.next().charAt(j);
                    board[i][j] = s.charAt(j);
                }
            }
            if (isWin(board)) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            List<Character> list = new ArrayList<>();
            String s = scanner.next();
            String[] c = s.split(" ");
            for (int i = 0; i < n; i++) {
                Integer.parseInt(c[i]);
            }
        }
    }

    public static void main2(String[] args) {
        int[] nums = {2, 3, 15, 11, 21 ,7, 1};
        bubbleSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    private static void bubbleSort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 0; j < nums.length - 1 - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    int tmp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = tmp;
                }
            }
        }
    }

    public static void main1(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int k = 7;
        int left = 0;
        int right = arr.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (arr[mid] > k) {
                right = mid - 1;
            } else if (arr[mid] < k) {
                left = mid + 1;
            } else {
                System.out.println(k + " 的下标是：" + mid);
                break;
            }
        }
        System.out.println(123);
    }
}
