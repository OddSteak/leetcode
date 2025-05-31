class ChadDetectCycle {
    public boolean hasCycle(ListNode head) {
        boolean ans = false;
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                ans = true;
                return ans;
            }
        }

        return ans;
    }
}

