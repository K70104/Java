import java.util.Stack;

public class TestDemo {
    class Solution {
        /*每周多 7 块，因此每周的钱之和的序列是一个等差数列，等差数列求和公式求所有完整周
        剩下的天数里，每天存的钱也是一个等差数列，可以用相同的公式进行求和。两者相加*/
        public int totalMoney(int n) {
            // 所有完整周
            int week = n / 7;
            int firstWeek = (1 + 7) * 7 / 2; // 每周多7
            int lastWeek = firstWeek + 7 * (week - 1);
            int weekMoney = (firstWeek + lastWeek) * week / 2;
            // 剩下不足一周
            int day = n % 7;
            int firstDay = 1 + week; // 最后一周周一
            int lastDay = firstDay + day - 1;
            int dayMoney = (firstDay + lastDay) * day / 2;

            return weekMoney + dayMoney;
        }

        public int totalMoney1(int n) {
            int week = 0;
            int day = 1;
            int ans = 0;
            for(int i = 0; i < n; i++) {
                ans += week + day;
                day++; // 每天
                if(day == 8) { // 每一周
                    day = 1;
                    week++;
                }
            }
            return ans;
        }
    }

    class MinStack {

        // private Stack<Integer> stack = new Stack<>();
        // private Stack<Integer> minStack = new Stack<>();
        private Stack<Integer> stack;
        private Stack<Integer> minStack;

        public MinStack() {
            stack = new Stack<>();
            minStack = new Stack<>();
        }

        public void push(int val) {
            stack.push(val);
            if(!minStack.empty()) { // 不为空
                int top = minStack.peek();
                if(val <= top) { // 小于等于 也要放进去
                    minStack.push(val);
                }
            } else {
                minStack.push(val);
            }
        }

        public void pop() {
            int popVal = stack.pop();
            if(!minStack.empty()) {
                int top = minStack.peek();
                if(top == popVal) {
                    minStack.pop();
                }
            }
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return minStack.peek();
        }
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(ch == '(' || ch == '{' || ch == '[') {
                // 左括号 入栈
                stack.push(ch);
            } else {
                // 右括号 匹配
                if(stack.empty()) {
                    return false; // 右括号多
                }
                char top = stack.peek(); // 栈顶元素
                if(top == '(' && ch == ')' || top == '[' && ch == ']' || top == '{' && ch == '}') {
                    stack.pop();
                } else {
                    return false; // 左右括号不匹配
                }
            }
        }
        return stack.empty(); // 不为空 左括号多
    }

    public static void main(String[] args) {
        String str = "abcde";
        System.out.println(str.replace('a', 'q')); // qbcde
        System.out.println(str); // abcde
    }

    public static void main3(String[] args) {
        MyStack stack = new MyStack();
        // 压栈
        stack.push(11);
        stack.push(33);
        stack.push(33);
        // 弹出栈顶元素，并删除
        System.out.println(stack.pop()); // 33
        // 获取栈顶元素，但不删除
        System.out.println(stack.peek()); // 22
        // 是否为空
        System.out.println(stack.isEmpty()); // false
    }

    public static void main2(String[] args) {
        Stack<Integer> stack = new Stack<>();
        // 压栈
        stack.push(11);
        stack.push(22);
        stack.push(33);
        // 弹出栈顶元素，并删除
        System.out.println(stack.pop()); // 33
        // 获取栈顶元素，但不删除
        System.out.println(stack.peek()); // 22
        // 是否为空
        System.out.println(stack.empty()); // false
        // 查找
        System.out.println(stack.search(22)); // 1
    }



    // 150. 逆波兰表达式求值
    // https://leetcode-cn.com/problems/evaluate-reverse-polish-notation/
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < tokens.length; i++) {
            String val = tokens[i];
            if(!isOperation(val)) {
                // 不是运算符
                stack.push(Integer.parseInt(val)); // 转为数字
            } else {
                // 是运算符 计算
                int num1 = stack.pop();
                int num2 = stack.pop();
                switch(val) {
                    case "+":
                      stack.push(num2 + num1);
                      break;
                    case "-":
                        stack.push(num2 - num1);
                        break;
                    case "*":
                        stack.push(num2 * num1);
                        break;
                    case "/":
                        stack.push(num2 / num1);
                        break;
                }
            }
        }
        return stack.pop();
    }

    private boolean isOperation(String x) {
        if(x.equals("+") || x.equals("-") || x.equals("*") || x.equals("/")) {
            return true;
        }
        return false;
    }

    // 剑指 Offer 31. 栈的压入、弹出序列
    // https://leetcode-cn.com/problems/zhan-de-ya-ru-dan-chu-xu-lie-lcof/
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int j = 0;
        for(int i = 0; i < pushed.length; i++) {
            stack.push(pushed[i]);
            // 循环判断
            while(!stack.empty() && j < popped.length && stack.peek() == popped[j]) {
                stack.pop();
                j++;
            }
        }
        return stack.empty();
    }

    public static void main1(String[] args) {
        System.out.println(123);
    }
}
