import sun.reflect.generics.tree.Tree;

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
     * 插入节点
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
        // cur == null 找到了位置 判断插在左边还是右边
        if (parent.val < val) {
            parent.right = node;
        } else {
            parent.left = node;
        }
        //
        node.parent = parent;
        cur = node;
        // 2、修改平衡因子
        while (parent != null) {
            // 先看 cur 是 parent 的左还是右  决定平衡因子是++ 还是--
            if (cur == parent.right) {  // 如果是右树，那么右树高度增加 平衡因子++
                parent.bf++;
            } else { // 如果是左树，那么左树高度增加 平衡因子--
                parent.bf--;
            }

            // 检查当前的平衡因子 是不是绝对值 1  0  -1
            if (parent.bf == 0) {
                // 说明已经平衡了
                break;
            } else if (parent.bf == 1 || parent.bf == -1) {
                // 继续向上修改平衡因子
                cur = parent;
                parent = parent.parent;
            } else {
                // 3、不平衡 旋转 AVL 树
                if (parent.bf == 2) { // 右树高-》需要降低右树的高度
                    if (cur.bf == 1) {
                        // ——左旋
                        rotateLeft(parent);
                    } else { // cur.bf == -1
                        rotateRL(parent); // 右左双旋
                    }
                } else { // parent.bf == -2 左树高-》需要降低左树的高度
                    if (cur.bf == -1) {
                        // ——右旋
                        rotateRight(parent);
                    } else { // cur.bf == -1
                        rotateLR(parent); // 左右双旋
                    }
                }
                // 上述代码走完就平衡了
                break;
            }
        }
        return true;
    }

    /**
     * 右单旋
     * 上图在插入前，AVL树是平衡的，新节点插入到30的左子树(注意：此处不是左孩子)中，30左子树增加了一层，
     * 导致以60为根的二叉树不平衡，要让60平衡，只能将60左子树的高度减少一层，右子树增加一层，
     * 即将左子树往上提，这样60转下来，因为60比30大，只能将其放在30的右子树，
     * 而如果30有右子树，右子树根的值一定大于30，小于60，只能将其放在60的左子树，
     * 旋转完成后，更新节点的平衡因子即可。在旋转过程中，有以下几种情况需要考虑：
     * 1. 30节点的右孩子可能存在，也可能不存在
     * 2. 60可能是根节点，也可能是子树
     *   如果是根节点，旋转完成后，要更新根节点
     *   如果是子树，可能是某个节点的左子树，也可能是右子树
     * @param parent
     */
    private void rotateRight(TreeNode parent) {
        TreeNode subL = parent.left;
        TreeNode subLR = subL.right;

        parent.left = subLR;
        if (subLR != null) { // 可能没有 subLR
            subLR.parent = parent;
        }

        subL.right = parent;
        TreeNode pParent = parent.parent; // 记录 parent 的父亲
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

        // 修改平衡因子
        subL.bf = 0;
        parent.bf = 0;
    }

    /**
     * 左单旋
     * @param parent
     */
    private void rotateLeft(TreeNode parent) {
        TreeNode subR = parent.right;
        TreeNode subRL = subR.left;

        parent.right = subRL;
        if (subRL != null) { // 可能没有 subRL
            subRL.parent = parent;
        }

        subR.left = parent;
        TreeNode pParent = parent.parent; // 记录 parent 的父亲
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

        // 修改平衡因子
        subR.bf = 0;
        parent.bf = 0;
    }

    /**
     * 左右双旋
     * @param parent
     */
    private void rotateLR(TreeNode parent) {
        // 记录 判断是左还是右 修改 bf
        TreeNode subL = parent.left;;
        TreeNode subLR = subL.right;
        int bf = subLR.bf;

        // 先左单旋再右单旋
        rotateLeft(parent.left);
        rotateRight(parent);

        // 修改平衡因子
        // bf == 0 时，不需要修改
        if (bf == -1) { // subLR 在左
            subL.bf = 0;
            subLR.bf = 0;
            parent.bf = 1;
        } else if (bf == 1) { // subLR 在右
            subL.bf = -1;
            subLR.bf = 0;
            parent.bf = 0;
        }
    }

    /**
     * 右左双旋
     * @param parent
     */
    private void rotateRL(TreeNode parent) {
        // 记录 判断是左还是右 修改 bf
        TreeNode subR = parent.right;
        TreeNode subRL = subR.left;
        int bf = subRL.bf;

        // 先右单旋再左单旋
        rotateRight(parent.right);
        rotateLeft(parent);

        // 修改平衡因子 (bf == 0 不需要修改)
        if (bf == 1) {
            parent.bf = -1;
            subR.bf = 0;
            subRL.bf = 0;
        } else if (bf == -1) {
            parent.bf = 0;
            subR.bf = 1;
            subRL.bf = 0;
        }
    }

    /**
     * 验证是否为二叉搜索树
     * @param root
     */
    public void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);
    }

    /**
     * 验证是否平衡
     * @param root
     * @return
     */
    public boolean isBalance(TreeNode root) {
        if (root == null) return true;
        int leftH = height(root.left);
        int rightH = height(root.right);
        // 检查平衡因子
        if (rightH - leftH != root.bf) {
            System.out.println("当前节点 " + root.val + " 的平衡因子异常！");
            return false;
        }
        return Math.abs(leftH - rightH) <= 1
                && isBalance(root.left) && isBalance(root.right);
    }

    private int height(TreeNode root) {
        if (root == null) return 0;
        int leftH = height(root.left);
        int rightH = height(root.right);
        return leftH > rightH ? leftH + 1 : rightH + 1;
    }

    public static void main(String[] args) {
//        int[] array = {16, 3, 7, 11, 9, 26, 18, 14, 15};
//        int[] array = {4, 2, 6, 1, 3, 5, 15, 7, 16, 14};
        int[] array = {30, 20, 90, 60, 180, 40};
        AVLTree avlTree = new AVLTree();
        for (int i = 0; i < array.length; i++) {
            avlTree.insert(array[i]);
        }
        avlTree.inorder(avlTree.root);
        System.out.println("isBalance: " + avlTree.isBalance(avlTree.root));
        // 3 7 9 11 14 15 16 18 26 isBalance: true
        // 1 2 3 4 5 6 7 14 15 16 isBalance: true
    }
}
