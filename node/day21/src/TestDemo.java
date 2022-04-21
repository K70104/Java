import java.util.*;

public class TestDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        // t 组计算：
        while (t-- != 0) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            List<Integer> card = new ArrayList<>();
            List<Integer> list1 = new ArrayList<>();
            List<Integer> list2 = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                list1.add(scanner.nextInt());
            }
            for (int i = 0; i < n; i++) {
                list2.add(scanner.nextInt());
            }
            // k 次洗牌：
            while (k-- != 0) {
                // 洗牌放入 card
                card.clear(); //
                for (int i = n - 1; i >= 0; i--) {
                    card.add(list2.get(i)); // 先右
                    card.add(list1.get(i)); // 后左
                }
                // 更新 左 右 手的牌
                list1.clear();
                list2.clear();
                int tmp = 2 * n - 1; // 洗完牌后也要逆序
                for (int i = n - 1; i >= 0; i--) {
                    list1.add(card.get(tmp--)); // 左手前半部分 (2n-1, n)
                    list2.add(card.get(i)); // 右手后半部分 (n-1, 0)
                }
            }
            // 打印 card：
            for (int i = 2 * n - 1; i >= 0; i--) { // 倒序输出
                System.out.print(card.get(i));
                if (i != 0) { // 最后一个没有空格
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    public static void mp3(int n, String s) {
        int index = 1; // 起始页光标，大于 4 的多页记录，用于打印
        int cur = 1; // 当前歌曲序号
        // 一页或多页：
        if (n <= 4) {
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (cur == 1 && c == 'U') { // 特殊翻页：第一首 Up
                    cur = n;
                } else if(cur == n && c == 'D') { // 特殊翻页：最后一首 Down
                    cur = 1;
                } else if (c == 'U') { // 其他情况：非收尾 光标上调
                    cur--;
                } else { // 其他情况：光标下调
                    cur++;
                }
            }
        } else {
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (index == 1 && cur == 1 && c == 'U') { // 特殊翻页：光标在第一页 第一首 Up
                    index = n - 3; // 屏幕显示最后一页（即显示第7-10首歌），
                    cur = n; // 光标放到最后一首歌上
                } else if (index == n - 3 && cur == n && c == 'D') { // 特殊翻页(滚动)：光标在最后一页 最后一首 Down
                    index = 1; // 屏幕要显示第一页，
                    cur = 1; // 光标挪到第一首歌上
                } else if (index != 1 && cur == index && c == 'U') { // 一般翻页(滚动)：不是第一页，光标在当前屏幕的第一首，Up
                    index--; // 屏幕从当前歌曲的 上一首 开始显示
                    cur--; // 光标挪到上一首
                }  else if (index != n - 3 && cur == index + 3 && c == 'D') { // 一般翻页：不是最后一页，光标在当前屏幕的最后一首，Down
                    index++; // 屏幕从当前歌曲的 下一首 开始显示
                    cur++; // 光标挪到下一首
                } else if (c == 'U') { // 其他情况：不需要翻页，光标上调
                    cur--;
                } else { // 其他情况：不需要翻页，光标下调
                    cur++;
                }
            }
        }
        // 打印：
        if (n <= 4) {
            for (int i = 0; i < n; i++) {
                if (i == 0) {
                    System.out.print(index);
                } else {
                    System.out.print(" " + (index + i));
                }
            }
        } else {
            System.out.print(index + " " + (index + 1) + " " + (index + 2) + " " + (index + 3));
        }
        System.out.println();
        System.out.println(cur); // 当前歌曲序号
    }

    public static void main2(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int n = scanner.nextInt(); // 歌曲数目
            String s = scanner.next(); // (next)  操作命令 U / D
            mp3(n, s);
        }
    }

    public static void main1(String[] args) {
        System.out.println(123);
    }
}
