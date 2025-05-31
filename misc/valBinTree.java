import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public static boolean isValidBST(TreeNode root) {
        ArrayList<Integer> arr = new ArrayList<>();
        inOrder(root, arr);

        for (int i = 0; i < arr.size() - 1; i++) {
            if (arr.get(i) >= arr.get(i + 1)) {
                return false;
            }
        }

        return true;
    }

    public static void inOrder(TreeNode root, ArrayList<Integer> arr) {
        if (root == null) return;

        inOrder(root.left, arr);
        arr.add(root.val);
        inOrder(root.right, arr);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(0, new TreeNode(-1), null);
        System.out.println(isValidBST(root));
    }
}
