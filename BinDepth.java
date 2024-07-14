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

class BinDepth {
    public int maxDepth(TreeNode root) {
        return findHeight(root);
    }

    public int findHeight(TreeNode root) {
        if (root == null) return 0;

        if (root.right == null && root.left == null) return 1;

        int heightR = findHeight(root.right);
        int heightL = findHeight(root.left);

        return 1 + (heightR > heightL ? heightR : heightL);
    }
}
