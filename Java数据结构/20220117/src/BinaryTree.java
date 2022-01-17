import java.util.ArrayList;
import java.util.List;

// 二叉树的实现
class TreeNode {
    public char val;
    public TreeNode left; // 左孩子的引用
    public TreeNode right; // 右孩子的引用
    public TreeNode(char val) {
        this.val = val;
    }
}

public class BinaryTree {
    // 3、返回值接收
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> retlist = new ArrayList<>();
        if(root == null) {
            return retlist;
        }
        // retlist.add(root.val);

        List<Integer> leftTree = preorderTraversal(root.left);
        retlist.addAll(leftTree);

        List<Integer> rightTree = preorderTraversal(root.right);
        retlist.addAll(rightTree);

        return retlist;
    }

    // 2、一个retlist
    // List<Integer> retlist = new ArrayList<>();
    // public List<Integer> preorderTraversal2(TreeNode root) {
    //     if(root == null) {
    //         return retlist;
    //     }
    //     retlist.add(root.val);
    //     preorderTraversal(root.left);
    //     preorderTraversal(root.right);
    //     return retlist;
    // }

    // 1、pre 方法
    public List<Integer> preorderTraversal1(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        pre(root, list);
        return list;
    }

    public void pre(TreeNode root, List<Integer> list) {
        if(root != null) {
            // list.add(root.val);
            pre(root.left, list);
            pre(root.right, list);
        }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> retlist = new ArrayList<>();
        if(root == null) {
            return retlist;
        }
        List<Integer> leftTree = inorderTraversal(root.left);
        retlist.addAll(leftTree);

        // retlist.add(root.val);

        List<Integer> rightTree = inorderTraversal(root.right);
        retlist.addAll(rightTree);

        return retlist;
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> retlist = new ArrayList<>();
        if(root == null) {
            return retlist;
        }
        List<Integer> leftTree = postorderTraversal(root.left);
        retlist.addAll(leftTree);

        List<Integer> rightTree = postorderTraversal(root.right);
        retlist.addAll(rightTree);

        // retlist.add(root.val);

        return retlist;
    }

    // public TreeNode root; // 二叉树的根节点

    public TreeNode createTree() {
        TreeNode A = new TreeNode('A');
        TreeNode B = new TreeNode('B');
        TreeNode C = new TreeNode('C');
        TreeNode D = new TreeNode('D');
        TreeNode E = new TreeNode('E');
        TreeNode F = new TreeNode('F');
        TreeNode G = new TreeNode('G');
        TreeNode H = new TreeNode('H');
        A.left = B;
        A.right = C;
        B.left = D;
        B.right = E;
        C.left = F;
        C.right = G;
        E.right = H;
        return A;
    }

    // 前序遍历
    void preOrder(TreeNode root) {
        if(root == null) {
            return;
        }
        System.out.print(root.val + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    // 中序遍历
    void inOrder(TreeNode root) {
        if(root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.val + " ");
        inOrder(root.right);
    }

    // 后序遍历
    void postOrder(TreeNode root) {
        if(root == null) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.val + " ");
    }
}
