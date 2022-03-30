import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.Scanner;

interface A {
    public abstract void fun();
}

interface B {}

class C {

}

/*abstract class Test1 {
    abstract void method();
}

abstract class Test2 {
    abstract void method();
}

abstract class Test3 {
    abstract void method();
}

class Test4 {
    final void method() { }
}*/

public class TestDemo extends C implements A, B{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int m = a;
        int n = b;
        int c = 0;
        while ((c = a % b) != 0) {
            a = b;
            b = c;
        }
        System.out.println(m*n/b);
    }

    public static void main7(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = Math.max(a, b);
        while (true) {
            if (c % a == 0 && c % b == 0) {
                System.out.println(c);
                break;
            }
            c++;
        }
    }

    public static void mai6(String[] args) throws IOException {
        // BufferedReader 从字符流中读取文本并且缓存
        BufferedReader bi = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bi.readLine());
    }

    public static boolean chkParenthesis(String A, int n) {
        // write code here
        if (n % 2 != 0) {
            return false;
        }
        Deque<Character> stack = new ArrayDeque<>();
        /* for (int i = 0; i < n; i++) {
            char ch = A.charAt(i); */
        for (char ch : A.toCharArray()) {
            if (ch == '(') { // 左括号入栈
                stack.offer(ch);
            } else {
                if (ch == ')' && !stack.isEmpty()) {
                    char val = stack.peek();
                    if (val == '(') { // 右括号 栈不为空 栈顶是左括号 出栈
                        stack.pop();
                    }
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main4(String[] args) {
        String s1 = "abcd";
        String s2 = s1.toLowerCase(); // 与 "abcd" 一样 返回原来的对象
        System.out.println(s1 == s2); // true
        System.out.println(s1.toLowerCase() == "abcd"); // true

        String s3 = "Admin" ;
        String s4 = s3.toLowerCase(); // 大写转小写 不一样 产生了一个新的对象
        System.out.println(s3 == "admin"); // false
    }

    public static void main3(String[] args) {
        Boolean flg = chkParenthesis("()()(((())))", 12);
        System.out.println(flg);
    }

    public static int Fib(int n) {
        int f1 = 1;
        int f2 = 1;
        int f3 = f1 + f2;
        while (n < f3) {
            f1 = f2;
            f2 = f3;
            f3 = f1 + f2;
        }
        if (n - f2 < f3 - n) {
            return n - f2;
        } else {
            return f3 - n;
        }
    }

    public static void main2(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int ret = Fib(n);
        System.out.println(ret);
    }

    @Override
    public void fun() {
        System.out.println("fun()");
    }

    public static void main1(String[] args) {
        Object object = new Object();
        System.out.println(123);
        System.out.println(Math.round(11.5));
    }
}
