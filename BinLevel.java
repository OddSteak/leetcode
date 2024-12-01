import java.util.*;

// Definition for a binary tree node.
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

class TreeLvl {
    int val;
    int lvl;
    TreeNode left;
    TreeNode right;
    TreeLvl(TreeNode tr, int lvl) {
        this.val = tr.val;
        this.lvl = lvl;
        this.left = tr.left;
        this.right = tr.right;
    }
}

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> retArr = new ArrayList<>();
        Queue<TreeLvl> q = new LinkedList<>();

        if (root == null)
            return new ArrayList<>();

        TreeLvl curNode;
        List<Integer> curArr = new ArrayList<>();
        retArr.add(curArr);
        q.add(new TreeLvl(root, 0));

        while (!q.isEmpty()) {
            curNode = q.remove();

            if (retArr.size() == curNode.lvl) {
                curArr = new ArrayList<>();
                retArr.add(curArr);
            }

            curArr.add(curNode.val);

            if (curNode.left != null)
                q.add(new TreeLvl(curNode.left, curNode.lvl + 1));

            if (curNode.right != null)
                q.add(new TreeLvl(curNode.right, curNode.lvl + 1));

        }

        return retArr;
    }
}
