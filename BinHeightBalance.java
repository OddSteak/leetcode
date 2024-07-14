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

class BinHeightBalance {
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;

        return findHeight(root) != -1;
    }

    public int findHeight(TreeNode root) {
        if (root == null) return 0;

        if (root.right == null && root.left == null) return 1;

        int heightR = findHeight(root.right);
        int heightL = findHeight(root.left);

        if (heightL == -1 || heightR == -1) return -1;
        if (Math.abs(heightR - heightL) > 1) return -1;

        return 1 + (heightR > heightL ? heightR : heightL);
    }
}

