import java.util.Stack;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class TestDemo {
    /*
    public int postIndex = 0;
    public TreeNode createTreeByPandI(int[] inorder, int[] postorder, int inbegin, int inend) {
        if(inbegin > inend) {
            // 此时没有左树 或右树
            return null;
        }

        TreeNode root = new TreeNode(postorder[postIndex]);

        // 找根在中序遍历中的位置
        int rootIndex = findIndexOfI(inorder, inbegin, inend, postorder[postIndex]);
        if(rootIndex == -1) return null;

        postIndex--; // 后序遍历 根在后 往前减

        // 分别创建 右子树 和 左子树
        root.right = createTreeByPandI(inorder, postorder, rootIndex+1, inend);
        root.left = createTreeByPandI(inorder, postorder, inbegin, rootIndex-1);

        return root;
    }

    // 在中序遍历中 在inbegin-inend范围内 找key
    public int findIndexOfI(int[] inorder, int inbegin, int inend, int key) {
        for(int i = inbegin; i <= inend; i++) {
            if(inorder[i] == key) {
                return i;
            }
        }
        return -1;
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder == null || postorder == null) return null;

        postIndex = postorder.length - 1;

        return createTreeByPandI(inorder, postorder, 0, inorder.length-1);
    }
     */

    // 通过前序与中序遍历创建二叉树
    public int preIndex = 0;
    public TreeNode createTreeByPandI(int[] preorder, int[] inorder, int inbegin, int inend) {
        if(inbegin > inend) {
            // 此时没有左树 或右树
            return null;
        }

        TreeNode root = new TreeNode(preorder[preIndex]);

        // 找更根在中序遍历中的位置
        int rootIndex = findIndexOfI(inorder, inbegin, inend, preorder[preIndex]);
        if(rootIndex == -1) return null;

        preIndex++;
        root.left = createTreeByPandI(preorder, inorder, inbegin, rootIndex-1); // 创建当前root左树
        root.right = createTreeByPandI(preorder, inorder, rootIndex+1, inend); // 右树

        return root;
    }

    // 在中序遍历中 在inbegin-inend范围内 找key
    public int findIndexOfI(int[] inorder, int inbegin, int inend, int key) {
        for(int i = inbegin; i <= inend; i++) {
            if(inorder[i] == key) {
                return i;
            }
        }
        return -1;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || inorder == null) return null;

        return createTreeByPandI(preorder, inorder, 0, inorder.length - 1);
    }

    public TreeNode prev;
    public void inorder(TreeNode pCur) {
        if(pCur == null) return;
        inorder(pCur.left);

        pCur.left = prev;
        if(prev != null) {
            prev.right = pCur;
        }
        prev = pCur;

        inorder(pCur.right);
    }

    public TreeNode Convert(TreeNode pRootOfTree) {
        if(pRootOfTree == null) return null;
        inorder(pRootOfTree);

        TreeNode head = pRootOfTree;
        while(head.left != null) {
            head = head.left;
        }
        return head;
    }

    /* 2、思路二：
    假设是孩子双亲表示法 可以转变为链表求交点 但是没有parent双亲节点
    所以用栈：
    1. 用两个栈存储路径
    2. 求栈的大小
    3. 栈中多的元素 出差值个元素
    4. 同出栈 栈顶元素相同 就是公共祖先
    */
    // root：根节点   node：指定节点   stack：存放根结点到指定节点的路径
    public boolean getPath(TreeNode root, TreeNode node, Stack stack) {
        if(root == null || node == null) return false;
        stack.push(root);

        if(root == node) return true;

        boolean flg = getPath(root.left, node, stack);
        if(flg) return true;
        flg = getPath(root.right, node, stack);
        if(flg) return true;

        stack.pop(); // 当前root不在路径下 弹出 返回false
        return false;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;
        // 获取路径
        Stack<TreeNode> stack1 = new Stack<>();
        getPath(root, p, stack1);
        Stack<TreeNode> stack2 = new Stack<>();
        getPath(root, q, stack2);

        int size1 = stack1.size();
        int size2 = stack2.size();
        // 出差值个元素
        if(size1 > size2) {
            int size = size1 - size2; // 出第一个栈的元素
            while(size != 0) {
                stack1.pop();
                size--;
            }
        }
        if(size1 < size2) {
            int size = size2 - size1; // 出第二个栈的元素
            while(size != 0) {
                stack2.pop();
                size--;
            }
        }
        // 判断栈顶元素
        while(!stack1.isEmpty() && !stack2.isEmpty()) {
            if(stack1.peek() == stack2.peek()) { // 判断地址
                return stack1.pop();
            } else {
                stack1.pop();
                stack2.pop();
            }
        }
        return null;
    }

    // LCA 问题
    // 1、思路一：
    /* 如果是二叉搜索树：中序遍历大小是有序的，左<根<右
    root.val == p || root.val == q 公共祖先是root
    p.val < root.val && q.val < root.val 说明p和q都在root的左子树中 最近公共祖先在root左树中
    p.val > root.val && q.val > root.val 说明p和q都在root的右子树中 最近公共祖先在root右树中
    p.val > root.val && q.val < root.val 分别在左子树和右子树中 最近公共祖先就是root
    */
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        if(root ==  null) return null;
        if(root == p || root == q) {
            return root;
        }
        TreeNode leftT = lowestCommonAncestor(root.left, p, q);
        TreeNode rightT = lowestCommonAncestor(root.right, p, q);

        if(leftT != null && rightT != null) {
            return root;
        } else if(leftT != null) {
            return leftT;
        } else {
            return rightT;
        }
    }

    public static void main(String[] args) {
        System.out.println(123);
    }
}
