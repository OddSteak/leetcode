package linkedlist;
// [https://leetcode.com/problems/reverse-nodes-in-k-group/description/]
// Reverse Nodes in K Group

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    boolean equals(ListNode head) {
        if (this.val != head.val) {
            return false;
        }

        if (this.next == null) {
            return head.next == this.next;
        }

        return this.next.equals(head.next);
    }
}

class Pair<U, V> {
    U first;
    V second;

    /**
     * Constructs a new <code>Pair</code> with the given values.
     *
     * @param first  the first element
     * @param second the second element
     */
    public Pair(U first, V second) {
        this.first = first;
        this.second = second;
    }
}

class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode cur = head;
        ListNode before = null;
        ListNode after = null;
        ListNode newHead = null;

        while (true) {
            Pair<ListNode, Boolean> p = kExists(cur, k);

            if (p.second) {
                after = p.first;
                newHead = reverseK(cur, after, before, k);
            } else {
                break;
            }

            // first iteration
            if (before == null) {
                head = newHead;
            }

            before = cur;
            cur = after;
        }

        return head;
    }

    // reverse k nodes and return the new head
    public ListNode reverseK(ListNode head, ListNode after, ListNode before, int k) {
        ListNode prev = null;
        ListNode cur = head;
        ListNode next = cur.next;

        head.next = after;

        for (int i = 0; i < k - 1; i++) {
            prev = cur;
            cur = next;
            next = next.next;

            cur.next = prev;
        }

        if (before != null) before.next = cur;
        return cur;
    }

    // returns the next node after the group if enough else return null
    public Pair<ListNode, Boolean> kExists(ListNode head, int k) {
        for (int i = 0; i < k; i++) {
            if (head == null)
                return new Pair<>(null, false);

            head = head.next;
        }

        return new Pair<>(head, true);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        ListNode head = new ListNode(1, new ListNode(2));
        ListNode o = new ListNode(2, new ListNode(1));

        assert sol.reverseKGroup(head, 2).equals(o);
    }
}
