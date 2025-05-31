class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }

    TreeNode(int x, TreeNode left, TreeNode right) {
        val = x;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return dfs(root, p, q);
    }

    public TreeNode dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q)
            return root;

        TreeNode right = dfs(root.right, p, q);
        TreeNode left = dfs(root.left, p, q);

        if (right != null && left != null)
            return root;

        return left != null ? left : right;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        TreeNode r = new TreeNode(4);
        TreeNode p = new TreeNode(5, new TreeNode(6), new TreeNode(2, new TreeNode(7), r));
        TreeNode q = new TreeNode(1, new TreeNode(0), new TreeNode(8));
        TreeNode root = new TreeNode(3, p, q);
        System.out.println(sol.lowestCommonAncestor(root, p, r).val);
    }
}
