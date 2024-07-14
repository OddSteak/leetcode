import java.util.HashSet;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

class DetectCycle {
    public boolean hasCycle(ListNode head) {
        HashSet set = new HashSet<ListNode>();
        return hasNew(head, set);
    }

    public boolean hasNew(ListNode head, HashSet set) {
        if (head == null) return false;

        if (set.contains(head)) return true;

        set.add(head);
        return hasNew(head.next, set);
    }
}
