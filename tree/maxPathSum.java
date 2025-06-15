package tree;

// [https://leetcode.com/problems/binary-tree-maximum-path-sum/description/]
// Binary Tree Maximum Path Sum

import java.util.Arrays;

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

class Pair<U, V> {
    U first;
    V second;

    Pair(U first, V second) {
        this.first = first;
        this.second = second;
    }
}

class Solution {
    public int maxPathSum(TreeNode root) {
        return recPath(root).first;
    }

    public Pair<Integer, Boolean> recPath(TreeNode root) {
        if (root == null)
            return new Pair<>(Integer.MIN_VALUE, true);

        // just root
        int node = root.val;

        // root + one subtree + one value
        int nodel = Integer.MIN_VALUE;
        int noder = Integer.MIN_VALUE;

        // both subtrees and root
        int noderl = Integer.MIN_VALUE;

        // only subtrees
        Pair<Integer, Boolean> rnode = recPath(root.right);
        Pair<Integer, Boolean> lnode = recPath(root.left);

        int lnoderoot = lnode.second && lnode.first != Integer.MIN_VALUE ? lnode.first + root.val : Integer.MIN_VALUE;
        int rnoderoot = rnode.second && rnode.first != Integer.MIN_VALUE ? rnode.first + root.val : Integer.MIN_VALUE;

        if (root.left != null) {
            if (rnode.second && rnode.first != Integer.MIN_VALUE)
                noder = rnode.first + root.val + root.left.val;
        }

        if (root.right != null) {
            if (lnode.second && lnode.first != Integer.MIN_VALUE)
                nodel = lnode.first + root.val + root.right.val;
        }

        // avoid overflow
        if ((rnode.second && rnode.first != Integer.MIN_VALUE) && (lnode.second && lnode.first != Integer.MIN_VALUE))
            noderl = rnode.first + lnode.first + root.val;

        int res = Math.max(
                Math.max(Math.max(node, noderl), Math.max(Math.max(noder, nodel), Math.max(lnode.first, rnode.first))),
                Math.max(lnoderoot, rnoderoot));

        if (Arrays.asList(node, lnoderoot, rnoderoot).contains(res))
            return new Pair<>(res, true);

        return new Pair<>(res, false);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        TreeNode root = new TreeNode(-2, new TreeNode(1), new TreeNode(3));

        System.out.println(sol.maxPathSum(root));
    }
}
