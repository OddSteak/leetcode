import java.util.ArrayList;

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ArrayList<ListNode> al = new ArrayList<>();

        ListNode cur = head;

        while (cur != null) {
            al.add(cur);
            cur = cur.next;
        }

        int before = al.size() - n - 1;
        int after = al.size() - n + 1;

        if (before < 0)
            return head.next;

        al.get(before).next = after < al.size() ? al.get(after) : null;

        return head;
    }

    public void printll(ListNode head) {
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));

        sol.removeNthFromEnd(head, 2);
        sol.printll(head);
    }
}
