import com.sun.org.apache.xpath.internal.operations.Bool;

import javax.swing.text.StyledEditorKit;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

final class A {
}

class B {
    public void B(int a) {
        System.out.println("test(): a");
    }
}

class C extends B{

}

abstract class Test {
    abstract void method();
}

public class TestDemo{
    // 隔一个放一个放最多
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int w = scanner.nextInt(); // 列
        int h = scanner.nextInt(); // 行
        int cnt = 0;
        int flg = 1;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if(flg == 1) {
                    cnt++;
                }
                flg = -flg;
            }
        }
        System.out.println(cnt);
    }

    // 放一个判断一个 不能放入最多蛋糕
    /*public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int w = 3; // 列
        int h = 3; // 行
        List<List<Integer>> list = new ArrayList<>(); // 记坐标
        int cnt = 0;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                // 判断
                Boolean flg = true;
                for (int k = 0; k < list.size(); k++) {
                    int x2 = list.get(k).get(0);
                    int y2 = list.get(k).get(1);
                    int ret = (int)Math.pow(i - x2, 2) + (int)Math.pow(j - y2, 2);
                    ret = (int)Math.sqrt(ret);
                    if (Math.abs(ret) == 2) {
                        flg = false;
                        break;
                    }
                }
                if(flg) { // 第一个不用判断直接加
                    // 可以放 加一 记录坐标
                    cnt++;
                    List<Integer> tmp = new ArrayList<>();
                    tmp.add(i);
                    tmp.add(j);
                    list.add(tmp);
                }
            }
        }
        System.out.println(cnt);
    }*/

    public static int StrToInt(String str) {
        if(str == null) {
            return 0;
        }
        int ret = 0;
        for(int i = 0; i < str.length(); i++) {
            if(ret > Integer.MAX_VALUE) {
                return 0;
            }
            char ch = str.charAt(i);
            if(i == 0 && (ch == '+' || ch == '/' || ch == '-')) {
                continue;
            } else if (Character.isDigit(ch)) {
                ret = ret * 10 + (ch - '0');
            } else {
                return 0;
            }
        }
        return ret;
    }

    public static void main3(String[] args) {
        String str = "+2147483647";
        System.out.println(StrToInt(str));
        List<List<Integer>> list = new ArrayList<>();

    }

    public static void main2(String[] args) {
        A a = new A();
        long test = 012;
        System.out.println(test);
        //double d = 0x123455678;
    }

    public static void main1(String[] args) {
        System.out.println(123);
    }
}
