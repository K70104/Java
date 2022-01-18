import sun.reflect.generics.tree.Tree;

import javax.transaction.TransactionRequiredException;
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
    /**
     * 判断一棵树是不是完全二叉树
     * @param root
     * @return
     */
    boolean isCompleteTree(TreeNode root) {
        if(root == null) return true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            // 不是空 入左右
            TreeNode cur = queue.poll(); // 弹出判断
            if(cur != null) {
                queue.offer(cur.left);
                queue.offer(cur.right);
            } else {
                break;
            }
        }
        // 判断队列 有不为空的元素 就不是完全二叉树
        while(!queue.isEmpty()) {
            if(queue.poll() != null) {
                return false;
            }
        }
        return true;
    }

    /**
     * 检测值为value的元素是否存在
     * @param root
     * @param val
     * @return
     */
    TreeNode find(TreeNode root, int val) {
        if(root == null) return null;
        // 先判断根
        if(root.val == val) return root;
        // 找左
        TreeNode ret = find(root.left, val);
        if(ret != null) {
            return ret;
        }
        // 找右
        ret = find(root.right, val);
        if(ret != null) {
            return ret;
        }
        return null;
    }

    /**
     * 时间复杂度：O(n)
     * 空间复杂度：O(log n) 当前树的高度 -> 计算右边时，左已经执行完了
     * @param root
     * @return
     */
    int getHeight(TreeNode root) {
        if(root == null) {
            return 0;
        }
        return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
        /*int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        return leftHeight > rightHeight ? leftHeight + 1: rightHeight + 1;*/
    }

    /**
     * 获取第K层节点的个数
     * @param root
     * @param k
     * @return
     */
    int getKLevelNodeCount(TreeNode root, int k) {
        if(root == null || k <= 0) {
            return 0;
        }
        if(k == 1) { // 第一层
            return 1;
        }
        return getKLevelNodeCount(root.left, k - 1) + getKLevelNodeCount(root.right, k - 1);
    }

    /**
     * 2、子问题思路：左叶子 + 右叶子
     * @param root
     * @return
     */
    int getLeafNodeCount2(TreeNode root) {
        if(root == null) {
            return 0;
        }
        // 左右都空 是叶子
        if(root.left == null && root.right == null) {
            return 1;
        }
        return getLeafNodeCount2(root.left) + getLeafNodeCount2(root.right);
    }

    /**
     *  获取叶子节点的个数 ：
     *  1、遍历思路：遍历到子叶子，计数器++
     * @param root
     * @return
     */
    int leafCount = 0;
    int getLeafNodeCount(TreeNode root) {
        if(root == null) {
            return 0;
        }
        // 左右都空 是叶子
        if(root.left == null && root.right == null) {
            leafCount++;
        }
        getLeafNodeCount(root.left);
        getLeafNodeCount(root.right);
        return leafCount;
    }

    /**
     * 2、子问题思路
     * @param root
     * @return root.left + root.right + 1
     */
    int size(TreeNode root) {
        if(root == null) {
            return 0;
        }
        return size(root.left) + size(root.right) + 1;
    }

    /**
     * 获取树中节点的个数
     * 1、遍历思路：遍历二叉树，此次root不是空，计数器++
     * @param root
     * @return
     */
    int count = 0;
    int size1(TreeNode root) {
        if(root == null) {
            return 0;
        }
        count++;
        size1(root.left);
        size1(root.right);
        return count;
    }



    public TreeNode createTree() {
        TreeNode A = new TreeNode('A');
        TreeNode B = new TreeNode('B');
        TreeNode C = new TreeNode('C');
        TreeNode D = new TreeNode('D');
        TreeNode E = new TreeNode('E');
        TreeNode F = new TreeNode('F');
        TreeNode G = new TreeNode('G');
        A.left = B;
        A.right = C;
        B.left = D;
        B.right = E;
        C.left = F;
        C.right = G;
        return A;
    }
}