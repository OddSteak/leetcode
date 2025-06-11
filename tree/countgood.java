package tree;

// [https://leetcode.com/problems/count-good-nodes-in-binary-tree/description/]
// Count Good Nodes in Binary Tree

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
    public int goodNodes(TreeNode root) {
        return dfs(root, Integer.MIN_VALUE);
    }

    public int dfs(TreeNode root, int max) {
        if (root == null) {
            return 0;
        }

        if (root.val >= max) {
            return 1 + dfs(root.right, root.val) + dfs(root.left, root.val);
        }

        return dfs(root.right, max) + dfs(root.left, max);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        TreeNode root = new TreeNode(3, new TreeNode(1, new TreeNode(3), null), new TreeNode(4, new TreeNode(1), new TreeNode(5)));
        int o = sol.goodNodes(root);
        assert  o == 4;

        TreeNode root1 = new TreeNode(3, new TreeNode(3, new TreeNode(4), new TreeNode(2)), null);
        assert sol.goodNodes(root1) == 3;

        TreeNode root2 = new TreeNode(1);
        assert sol.goodNodes(root2) == 1;
    }
}
