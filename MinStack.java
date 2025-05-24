class Node {
    int val;
    int min;
    Node next;

    Node(int val) {
        this.val = val;
        this.next = null;
        this.min = val;
    }
}

class MinStack {
    private Node top;

    public MinStack() {
        this.top = null;
    }

    public void push(int val) {
        Node newNode = new Node(val);
        if (top != null)
            newNode.min = Math.min(top.min, newNode.min);
        newNode.next = top;
        top = newNode;
    }

    public void pop() {
        top = top.next;
    }

    public int top() {
        return top.val;
    }

    public int getMin() {
        return top.min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
