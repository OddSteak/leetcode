import java.util.*;

// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}

class Solution {
    public Node cloneGraph(Node node) {
        if (node == null)
            return node;
        Node newNode, neighNode, curNode;
        Map<Integer, Node> proced = new HashMap<>();
        Queue<Node> q = new LinkedList<>();

        q.add(node);
        proced.put(node.val, new Node(node.val));

        while (!q.isEmpty()) {
            curNode = q.remove();
            newNode = proced.get(curNode.val);

            for (int i = 0; i < curNode.neighbors.size(); i++) {
                Node tnd = curNode.neighbors.get(i);
                if (!proced.containsKey(curNode.neighbors.get(i).val)) {
                    q.add(tnd);
                    neighNode = new Node(tnd.val);
                    proced.put(neighNode.val, neighNode);
                    newNode.neighbors.add(neighNode);
                } else {
                    newNode.neighbors.add(proced.get(tnd.val));
                }
            }
        }

        return proced.get(node.val);
    }
}
