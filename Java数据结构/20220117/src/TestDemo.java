

public class TestDemo {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        TreeNode root = binaryTree.createTree();
        binaryTree.preOrder(root); // 前 A B D E H C F G
        System.out.println();
        binaryTree.inOrder(root); // 中 D B E H A F C G
        System.out.println();
        binaryTree.postOrder(root); // 后 D H E B F G C A
    }
}
