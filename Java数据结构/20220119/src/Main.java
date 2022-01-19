import java.util.*;

/*class TreeNode {
    public char val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(char val) {
        this.val = val;
    }
}*/

public class Main {

    // 创建二叉树
    public static int i = 0;
    public static TreeNode createTree(String str) {
        TreeNode root = null;
        if(str.charAt(i) != '#') {
            root = new TreeNode(str.charAt(i));
            i++;
            root.left = createTree(str);
            root.right = createTree(str);
        } else {
            i++;
        }
        return root; // 跳过#后返回left或right
    }

    // 中序遍历
    public static void inorder(TreeNode root) {
        if(root == null) return;
        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNextLine()) {
            String str = in.nextLine();
            TreeNode root = createTree(str);
            inorder(root);
            System.out.println();
        }
    }
}