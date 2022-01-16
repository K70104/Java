import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class MyQueue {
    // 入队的时候，统一入到第1 个栈
    // 出队的时候，统一出第2 个栈的元素，如果第二个栈为空，将第1 个栈的所有元素导入，再出栈顶元素，相当于倒了个顺序
    public Stack<Integer> stack1;
    public Stack<Integer> stack2;

    public MyQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void push(int x) {
        stack1.push(x);
    }

    public int pop() {
        if(empty()) return -1;

        if(stack2.empty()) {
            while(!stack1.empty()) {
                // int val = stack1.pop();
                // stack2.push(val);
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    public int peek() {
        if(empty()) return -1;
        if(stack2.empty()) {
            while(!stack1.empty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.peek();
    }

    public boolean empty() {
        return stack1.empty() && stack2.empty();
    }
}
