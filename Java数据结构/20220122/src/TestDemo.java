import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class TestDemo {


    public static void main3(String[] args) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        // 每放一个元素 都得保证当前的堆 是大堆 或者是小堆
        priorityQueue.offer(1);
        priorityQueue.offer(2);
        priorityQueue.offer(3);

        System.out.println(priorityQueue.peek()); // 1 ->默认是小堆
    }

    public static void main(String[] args) {
        int[] array = {27,15,19,18,28,34,65,49,25,37};
        TestHeap testHeap = new TestHeap();
        testHeap.createHeap(array);

        testHeap.offer(70);
        System.out.println("=============");
        System.out.println(testHeap.pop()); // 70
        System.out.println(testHeap.pop()); // 65
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode  cur = root;
        TreeNode prev = null;

        while(cur != null || !stack.empty()) {
            while(cur != null) {
                stack.push(cur);

                cur = cur.left;
            }

            TreeNode top = stack.peek();
            if(top.right == null || top.right == prev) {
                stack.pop();
                // System.out.print(top.val + " ");
                ret.add(top.val);
                prev = top;
            } else {
                cur = top.right;
            }
        }
        return ret;
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<>();

        Stack<TreeNode> stack = new Stack<>();
        TreeNode  cur = root;

        while(cur != null || !stack.empty()) {
            while(cur != null) {
                stack.push(cur);

                cur = cur.left;
            }
            TreeNode top = stack.pop();
            // System.out.print(cur.val + " ");
            ret.add(top.val);
            cur = top.right;
        }
        return ret;
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<>();

        Stack<TreeNode> stack = new Stack<>();
        TreeNode  cur = root;

        while(cur != null || !stack.empty()) {
            while(cur != null) {
                stack.push(cur);
                // System.out.print(cur.val + " ");
                ret.add(cur.val);
                cur = cur.left;
            }
            TreeNode top = stack.pop();
            cur = top.right;
        }
        return ret;
    }

    public void TreeToString(TreeNode t, StringBuilder sb) {
        if(t == null) return;
        sb.append(t.val);
        if(t.left != null) {
            sb.append("(");
            TreeToString(t.left, sb);
            sb.append(")");
        } else {
            if(t.right == null) {
                return;
            } else {
                sb.append("()"); // 左为空 右不为空
            }
        }
        if(t.right == null) {
            return;
        } else {
            sb.append("(");
            TreeToString(t.right, sb);
            sb.append(")");
        }
    }

    public String tree2str(TreeNode root) {
        if(root == null) return null;
        StringBuilder sb = new StringBuilder();
        TreeToString(root, sb);
        return sb.toString();
    }

    public static void main1(String[] args) {
        System.out.println(123);
    }
}
