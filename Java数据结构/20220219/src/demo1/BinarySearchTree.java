package demo1;

import java.util.function.BinaryOperator;

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node(int val) {
        this.val = val;
    }
}

public class BinarySearchTree {
    public Node root;

    /**
     * 二叉搜索树查找
     * @param key
     * @return
     */
    public Node search(int key) {
        Node cur = root;
        while(cur != null) {
            if(cur.val < key) { // cur的val比val小 在cur的右边
                cur = cur.right;
            } else if (cur.val == key) {
                return cur;
            } else {
                cur = cur.left;
            }
        }
        return null; // 没有这个数据
    }
    /*public Node search(Node root, int val) {
        if(root == null) {
            return null;
        }
        if(root.val == val) {
            return root;
        }
        if(root.val < val) { // 在右树
            search(root.right, val);
        } else { // 在左树
            search(root.left, val);
        }
        return null;
    }*/

    /**
     * 插入
     * 二叉搜索树 插入的数据 一定是在叶子节点
     * @param val
     */
    public boolean insert(int val) {
        if(root == null) {
            root = new Node(val);
            return true;
        }
        // cur parent 找val需要存储的位置
        Node cur = root;
        Node parent = null;
        while(cur != null) {
            if(cur.val < val) {
                parent = cur;
                cur = cur.right;
            } else if (cur.val == val) {
                return false; // 不能有相同的数据
            } else {
                parent = cur;
                cur = cur.left;
            }
        }
        // parent.val 和 val 比较大小，确定在插入的在左树还是右树
        Node node = new Node(val);
        if(parent.val < val) { // parent小 就在parent的右边
            parent.right = node;
        } else {
            parent.left = node;
        }
        return true;
    }

    /**
     * 删除
     * @param key
     * @return
     */
    public void remove(int key) {
        Node cur = root;
        Node parent = null;
        while(cur != null) {
            if(cur.val == key) { // 找到了
                removeNode(cur, parent); // 此处是删除
                break;
            } else if (cur.val < key) { // 在右边
                parent = cur;
                cur = cur.right;
            } else { // 在左边
                parent = cur;
                cur = cur.left;
            }
        }
    }

    public void removeNode(Node cur, Node parent) {
        if(cur.left == null) { // 一、cur左为空
            if(cur == root) { // 1.
                root = cur.right;
            } else if (cur == parent.left) { // 2.
                parent.left = cur.right;
            } else { // 3. cur == parent.right
                parent.right = cur.right;
            }
        } else if (cur.right == null) { // 二、cur右为空
            if(cur == root) { // 1.
                root = cur.left;
            } else if (cur == parent.left) { // 2.
                parent.left = cur.left;
            } else { // 3.cur == parent.right
                parent.right = cur.left;
            }
        } else { // 三、cur左不为空 右也不为空
            // cur 的左树中 找最大值
            // cur 的右树中 找最小值
            Node targetParent = cur;
            Node target = cur.right;
            while (target.left != null) {
                targetParent = target;
                target = target.left;
            }
            cur.val = target.val; // 替换 val
            // 删除
            if (target == targetParent.left) {
                targetParent.left = target.right;
            } else {
                targetParent.right = target.right;
            }
        }
    }


    public void inorder(Node root) {
        if (root == null) return;
        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);
    }

    public static void main(String[] args) {
        int[] array = {5, 13, 7, 11, 9, 3, 8};
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        for (int i = 0; i < array.length; i++) {
            binarySearchTree.insert(array[i]);
        }
        binarySearchTree.inorder(binarySearchTree.root); // 3 5 7 8 9 11 13
        System.out.println('\n' + "插入重复的数据");
        System.out.println(binarySearchTree.insert(3)); // false
        System.out.println("删除数据3");
        binarySearchTree.remove(3);
        binarySearchTree.inorder(binarySearchTree.root); // 5 7 8 9 11 13
    }
}
