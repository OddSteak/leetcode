import java.util.Stack;

class MyQueue {
    private Stack<Integer> stk;
    private Stack<Integer> tmp;

    public MyQueue() {
        stk = new Stack<>();
        tmp = new Stack<>();
    }

    public void push(int x) {
        while (!stk.empty()) {
            tmp.push(stk.pop());
        }

        sq.push(x);

        while (!tmp.empty()) {
            stk.push(tmp.pop());
        }
    }

    public int pop() {
        return stk.pop();
    }

    public int peek() {
        return stk.peek();
    }

    public boolean empty() {
        return stk.empty()
    }
}

