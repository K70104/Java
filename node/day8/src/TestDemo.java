import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

interface A {
     public abstract void fun();
}

interface B {}

class C {

}

public class TestDemo extends C implements A, B{
    public static boolean chkParenthesis(String A, int n) {
        // write code here
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            char ch = A.charAt(i);
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
        if (stack.isEmpty()) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
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
