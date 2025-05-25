import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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

class Node {
    TreeNode treeNode;
    int level;

    Node(TreeNode treeNode, int level) {
        this.treeNode = treeNode;
        this.level = level;
    }
}

class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null)
            return res;

        Queue<Node> q = new LinkedList<>();
        q.add(new Node(root, 0));

        while (!q.isEmpty()) {
            Node cur = q.poll();

            if (cur.treeNode.left != null)
                q.add(new Node(cur.treeNode.left, cur.level + 1));
            if (cur.treeNode.right != null)
                q.add(new Node(cur.treeNode.right, cur.level + 1));

            // if the node is the last one at the same level
            if (q.peek() == null || q.peek().level > cur.level)
                res.add(cur.treeNode.val);
        }

        return res;
    }
}
