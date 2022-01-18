

public class TestDemo {

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        TreeNode root = binaryTree.createTree();

        System.out.println("获取树中节点的个数");
        System.out.println(binaryTree.size1(root)); // 8
        System.out.println(binaryTree.size(root)); // 8

        System.out.println(binaryTree.getLeafNodeCount(root)); // 4
        System.out.println();
        System.out.println(binaryTree.getKLevelNodeCount(root, 3)); // 4

        System.out.println(binaryTree.getHeight(root));

        try {
            TreeNode ret = binaryTree.find(root, 'E');
            System.out.println(ret.val);
        }catch (NullPointerException e) {
            e.printStackTrace();
            System.out.println("没有该节点");
        }

        System.out.println(binaryTree.isCompleteTree(root));
    }
}
