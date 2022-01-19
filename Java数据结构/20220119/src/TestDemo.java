import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class TestDemo {

    // 记录下标
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i]) && i - map.get(nums[i]) <= k) {
                return true;
            }
            map.put(nums[i], i);
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(123);
        BinaryTree binaryTree = new BinaryTree();
        TreeNode root = binaryTree.createTree();
        binaryTree.levelOrder(root);
    }
}
