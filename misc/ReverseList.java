// review
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class ReverseList {
    ListNode revHead;
    public ListNode reverseList(ListNode head) {
        recList(head);
        return revHead;
    }

    public ListNode recList(ListNode head) {
        if (head == null) return null;

        if (head.next != null)
            recList(head.next).next = head;
            head.next = null;

        if (revHead == null) revHead = head;
        return head;
    }


    public static void main(String[] args) {
        ListNode oldHead = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ReverseList revList = new ReverseList();
        ListNode newHead = revList.reverseList(oldHead);


        for (int i = 0; i<5; i++) {
            System.out.print(newHead.val + " ");
            newHead = newHead.next;
        }
    }
}
