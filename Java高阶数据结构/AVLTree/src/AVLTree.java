

public class AVLTree {
    static class TreeNode {
        public int val;
        public int bf; // 平衡因子
        public TreeNode left; // 左子树的引用
        public TreeNode right; // 右子树的引用
        public TreeNode parent; // 父节点的引用

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public TreeNode root; // 根节点

    /**
     * 插入
     * @param val
     * @return
     */
    public boolean insert(int val) {
        TreeNode node = new TreeNode(val);
        if (root == null) {
            root = node;
            return true;
        }
        // 1、寻找位置 插入 node 节点
        TreeNode parent = null;
        TreeNode cur = root;
        while (cur != null) {
            if (cur.val < val) {
                parent = cur;
                cur = cur.right;
            } else if (cur.val == val) {
                return false;
            } else {
                parent = cur;
                cur = cur.left;
            }
        }
        // val == null 找到了位置 判断插在左边还是右边
        if (parent.val < val) {
            parent.right = node;
        } else {
            parent.left = node;
        }
        //
        node.parent = parent;
        cur = node;
        // 2、修改 平衡因子

        return true;
    }



    public static void main(String[] args) {
        System.out.println(123);
    }
}
