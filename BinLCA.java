public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class BinLCA {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (root == p || root == q) return root;

        TreeNode rightRes = lowestCommonAncestor(root.right, p, q);
        TreeNode leftRes = lowestCommonAncestor(root.left, p, q);

        if (leftRes != null && rightRes != null) {
            return root;
        }

        return leftRes == null ? rightRes : leftRes;
    }
}
