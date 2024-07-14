class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}


class MiddleLink {
    public ListNode middleNode(ListNode head) {
        return findNode(head, (len(head)/2) + 1);
    }

    public int len(ListNode head) {
        if (head == null) return 0;

        return 1 + len(head.next);
    }

    public ListNode findNode(ListNode head, int idx) {
        for (int i = 0; i<idx-1; i++) {
            head = head.next;
        }

        return head;
    }
}
