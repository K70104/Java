import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeNode {
    public char val;
    public TreeNode left; // 左孩子的引用
    public TreeNode right; // 右孩子的引用
    public TreeNode(char val) {
        this.val = val;
    }
}

public class BinaryTree {

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



    class Solution {
        // 时间复杂度：O(min(m, n)) -> p,q节点的个数
        public boolean isSameTree(TreeNode p, TreeNode q) {
            // 一个为空 一个不为空
            if(p == null && q != null || q == null && p != null) {
                return false;
            }
            // 都为空
            if(p == null && q == null) {
                return true;
            }
            // 或都不为空->判断val
            if(p.val != q.val) {
                return false;
            }
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
    }

    // 时间复杂度：O(n)
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;

        return height(root) >= 0;
    }

    public int height(TreeNode root) {
        if(root == null) return 0;
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        if(leftHeight >= 0 && rightHeight >= 0 && Math.abs(leftHeight - rightHeight) <= 1) {
            return Math.max(leftHeight, rightHeight) + 1;
        } else {
            // 不平衡
            return -1;
        }
    }

    // 时间复杂度：O(n^2)
    // 判断高度差
    // 判断左右 每棵子树都要是平衡二叉树
    /* public boolean isBalanced(TreeNode root) {
        if(root == null) {
            return true;
        }
        int left = height(root.left);
        int right = height(root.right);
        // 绝对值
        return Math.abs(left - right) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    public int height(TreeNode root) {
        if(root == null) {
            return 0;
        }
        return Math.max(height(root.left), height(root.right)) + 1;
    } */

    // // 时间复杂度：O(m * n)
    // 先判断是不是相同的数
    // 再判断是不是root的左子树或右子树
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        // 判断isSubtree的 判断根是不是子树 如果没有就会空指针异常
        if(root == null || subRoot == null) {
            return false;
        }
        if(isSameTree(root, subRoot)) {
            return true;
        }
        // 判断subRoot 是不是root 的左子树或右子树
        if(isSubtree(root.left, subRoot)) {
            return true;
        }
        if(isSubtree(root.right, subRoot)) {
            return true;
        }
        return false;
    }

    // 检查两颗树是否相同
    private boolean isSameTree(TreeNode p, TreeNode q) {
        // 一个为空 一个不为空
        if(p == null && q != null || q == null && p != null) {
            return false;
        }
        // 都为空
        if(p == null && q == null) {
            return true;
        }
        // 或都不为空->判断val
        if(p.val != q.val) {
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return isSymmetricChild(root.left, root.right);
    }

    public boolean isSymmetricChild(TreeNode leftTree, TreeNode rightTree) {
        // 判断根
        if(leftTree == null && rightTree != null) return false;
        if(leftTree != null && rightTree == null) return false;
        if(leftTree == null && rightTree == null) return true;

        if(leftTree.val != rightTree.val) return false;

        // 判断根的左右
        return isSymmetricChild(leftTree.left, rightTree.right) &&
                isSymmetricChild(leftTree.right, rightTree.left);
    }

    /**
     * 层序遍历
     * @param root
     * */
    public void levelOrder1(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        if(root == null) return;
        queue.offer(root);
        // 队列不为空 弹出打印 加入不为空的左和右
        while(!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            System.out.print(cur.val + " ");
            if(cur.left != null) {
                queue.offer(cur.left);
            }
            if(cur.right != null) {
                queue.offer(cur.right);
            }
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        if(root == null) return ret;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()) {
            int size = queue.size(); // 当前层有多少节点
            List<Integer> list = new ArrayList<>();
            while (size != 0) {
                TreeNode cur = queue.poll(); // 弹出
                // list.add(cur.val); // 加入list
                if(cur.left != null) { // 左
                    queue.offer(cur.left);
                }
                if(cur.right != null) { // 右
                    queue.offer(cur.right);
                }
                size--;
            }
            ret.add(list); // 每一层
        }

        return ret;
    }
}