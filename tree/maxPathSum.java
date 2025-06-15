package tree;

// [https://leetcode.com/problems/binary-tree-maximum-path-sum/description/]
// Binary Tree Maximum Path Sum

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        recPath(root);
        return maxSum;
    }

    public int recPath(TreeNode root) {
        if (root == null) return 0;

        int leftmax = Math.max(0, recPath(root.left));
        int rightmax = Math.max(0, recPath(root.right));

        int currentMaxSum = leftmax + rightmax + root.val;

        maxSum = Math.max(maxSum, currentMaxSum);

        return root.val + Math.max(rightmax, leftmax);
    }
}
