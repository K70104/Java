package demo1;

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
     * @param val
     * @return
     */
    public Node search(int val) {
        if(root == null) {
            return null;
        }
        Node cur = root;
        while(cur != null) {
            if(cur.val < val) { // cur的val比val小 在cur的右边
                cur = cur.right;
            } else if (cur.val == val) {
                return cur;
            } else {
                cur = cur.left;
            }
        }
        return null;
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
                cur = cur.right;
            } else if (cur.val == val) { // 不能有相同的数据
                return false;
            } else {
                cur = cur.left;
            }
            parent = cur;
        }
        // parent.val 和 val 比较大小，确定在插入的在左树还是右树
        if(parent.val < val) { // parent小 就在parent的右边
            parent.right = new Node(val);
        } else {
            parent.left = new Node(val);
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
                root = root.right;
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
            } else if (cur == parent.right) { // 3.
                parent.right = cur.left;
            }
        } else { // 三、cur左不为空 右也不为空

        }
    }








}
