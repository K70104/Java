

public class RBTree {
    static class RBTreeNode {
        public int val;
        public RBTreeNode left;
        public RBTreeNode right;
        public RBTreeNode parent;
        public COLOR color;

        public RBTreeNode(int val) {
            this.val = val;
            this.color = COLOR.RED; // 新增节点默为红
        }
    }

    public RBTreeNode root; // 根节点

    /**
     * 插入节点
     * @param val
     * @return
     */
    public boolean insert(int val) {
        RBTreeNode node = new RBTreeNode(val);
        if (root == null) {
            root = node;
            root.color = COLOR.BLACK; // 根节点为空 插入新节点默认为红 插入第一个要改成黑色
            return true;
        }
        // 1、寻找位置 插入 node 节点
        RBTreeNode parent = null;
        RBTreeNode cur = root;
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
        // cur == null 找到了位置 判断插在左边还是右边
        if (parent.val < val) {
            parent.right = node;
        } else {
            parent.left = node;
        }
        //
        node.parent = parent;
        cur = node;

        // 红黑树：调整颜色
        while (parent != null && parent.color == COLOR.RED) {
            RBTreeNode grandFather = parent.parent; // p 为红，grandFather 一定不为空
            if (parent == grandFather.left) {
                RBTreeNode uncle = grandFather.right;
                // 情况一
                if (uncle != null && uncle.color == COLOR.RED) { // u 为红
                    parent.color = COLOR.BLACK;
                    uncle.color = COLOR.BLACK;
                    grandFather.color = COLOR.RED;
                    // 继续向上调整
                    cur = grandFather;
                    parent = cur.parent;
                } else {
                    // 情况三：uncle 不存在 / uncle 为黑
                    if (cur == parent.right) {
                        rotateLeft(parent);
                        RBTreeNode tmp = parent;
                        parent = cur;
                        cur = tmp;
                    } // 情况三变成了情况二

                    // 情况二
                    // uncle == null 或 uncle 为黑
                    rotateRight(grandFather);
                    grandFather.color = COLOR.RED;
                    parent.color = COLOR.BLACK;
                }
            } else {
                // parent == grandFather.right
                RBTreeNode uncle = grandFather.left; // 1\
                // 情况一
                if (uncle != null && uncle.color == COLOR.RED) { // u 为红
                    parent.color = COLOR.BLACK;
                    uncle.color = COLOR.BLACK;
                    grandFather.color = COLOR.RED;
                    // 继续向上调整
                    cur = grandFather;
                    parent = cur.parent;
                } else {
                    // 情况三：uncle 不存在 / uncle 为黑
                    if (cur == parent.left) { // 2\
                        rotateRight(parent); // 3\
                        RBTreeNode tmp = parent;
                        parent = cur;
                        cur = tmp;
                    } // 情况三变成了情况二

                    // 情况二
                    // uncle == null 或 uncle 为黑
                    rotateLeft(grandFather); // 4\
                    grandFather.color = COLOR.RED;
                    parent.color = COLOR.BLACK;
                }
            }
        }
        root.color = COLOR.BLACK; // 循环完 root 的颜色要置为黑色
        return true;
    }

    /**
     * 右单旋
     * @param parent
     */
    private void rotateRight(RBTreeNode parent) {
        RBTreeNode subL = parent.left;
        RBTreeNode subLR = subL.right;

        parent.left = subLR;
        if (subLR != null) { // 可能没有 subLR
            subLR.parent = parent;
        }

        subL.right = parent;
        RBTreeNode pParent = parent.parent; // 记录 parent 的父亲
        parent.parent = subL;

        if (parent == root) { // 检查 parent 是不是就是根节点
            root = subL;
            root.parent = null;
        } else { // 不是独立的子树，是其他树的左树或者右树
            if (pParent.left == parent) {
                pParent.left = subL;
            } else {
                pParent.right = subL;
            }
            subL.parent = pParent;
        }
    }

    /**
     * 左单旋
     * @param parent
     */
    private void rotateLeft(RBTreeNode parent) {
        RBTreeNode subR = parent.right;
        RBTreeNode subRL = subR.left;

        parent.right = subRL;
        if (subRL != null) { // 可能没有 subRL
            subRL.parent = parent;
        }

        subR.left = parent;
        RBTreeNode pParent = parent.parent; // 记录 parent 的父亲
        parent.parent = subR;

        if (root == parent) {
            root = subR;
            root.parent = null;
        } else {
            if (pParent.left == parent) {
                pParent.left = subR;
            } else {
                pParent.right = subR;
            }
            subR.parent = pParent;
        }
    }

    /**
     * 验证红黑树是否为二叉搜索树
     * @param root
     */
    public void inorder(RBTreeNode root) {
        if (root == null) return;
        inorder(root.left);
        System.out.println(root.val + " ");
        inorder(root.right);
    }

    /**
     * 验证是否满足红黑树性质
     * @return
     */
    public boolean isRBTree(RBTreeNode root) {
        if (root == null) { // 空树 算是红黑树
            return true;
        }
        if (root.color != COLOR.BLACK) {
            System.out.println("违反了性质：根节点必须是黑色！");
            return false;
        }

        int blackNum = 0; // 统计 root 最左路径有多少黑色节点
        RBTreeNode cur = root;
        while (cur != null) {
            if (cur.color == COLOR.BLACK) {
                blackNum++;
            }
            cur = cur.left;
        }
        // 检查有没有两个连续的红色节点 && 检查每条路径上的黑色节点个数是否一致
        return checkRedColor(root) && checkBlackNum(root, 0, blackNum);
    }


    /**
     * 检查有没有两个连续的红色节点
     * @param root
     * @return
     */
    private boolean checkRedColor(RBTreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.color == COLOR.RED) {
            RBTreeNode parent = root.parent;
            if (parent.color == COLOR.RED) {
                System.out.println("违反了性质：连续出现了两个红色节点！");
                return false;
            }
        }
        return checkRedColor(root.left) && checkRedColor(root.right);
    }

    /**
     * 检查每条路径上的黑色节点个数是否一致
     * @param root
     * @param pathBlackNum 每次递归 计算的黑色节点个数  0
     * @param blackNum 事先计算好的某路径上的黑色节点的个数  2
     * @return
     */
    private boolean checkBlackNum(RBTreeNode root, int pathBlackNum, int blackNum) {
        if (root == null) {
            return true;
        }
        if (root.left == null && root.right == null) {
            if (pathBlackNum != blackNum) {
                System.out.println("违反了性质：每条路径上的黑色节点个数不同！");
                return false;
            }
        }
        return checkBlackNum(root.left, pathBlackNum, blackNum)
                && checkBlackNum(root.right, pathBlackNum, blackNum);
    }

    public static void main(String[] args) {
        int[] array = {4, 2, 6, 1, 3, 5, 15, 7, 16, 14};
        RBTree rbTree = new RBTree();
        for (int i = 0; i < array.length; i++) {
            rbTree.insert(array[i]);
        }
        rbTree.inorder(rbTree.root);
        System.out.println("是否满足红黑树性质" + rbTree.isRBTree(rbTree.root));
    }
}
