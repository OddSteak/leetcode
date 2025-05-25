// [https://leetcode.com/problems/merge-k-sorted-lists/description/]

import java.util.PriorityQueue;

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
    public ListNode mergeKLists(ListNode[] lists) {
        return fancypq(lists);
    }

    public ListNode fancypq(ListNode[] lists) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        ListNode head = null;
        ListNode cur = null;

        for (ListNode node : lists) {
            while (node != null) {
                pq.add(node.val);
                node = node.next;
            }
        }

        while (pq.peek() != null) {
            ListNode node = new ListNode(pq.poll());

            if (head == null) {
                head = node;
                cur = node;
            } else {
                cur.next = node;
                cur = cur.next;
            }
        }

        return head;
    }

    public ListNode trad(ListNode[] lists) {
        ListNode head = null;
        ListNode cur = null;

        while (true) {
            int smallest = -1;
            int smallestVal = Integer.MAX_VALUE;

            for (int i = 0; i < lists.length; i++) {
                if (lists[i] == null)
                    continue;

                if (lists[i].val < smallestVal) {
                    smallest = i;
                    smallestVal = lists[i].val;
                }
            }

            if (smallest == -1)
                return head;

            if (head == null) {
                head = lists[smallest];
                cur = lists[smallest];
            } else {
                cur.next = lists[smallest];
                cur = cur.next;
            }

            lists[smallest] = lists[smallest].next;
        }

    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1, new ListNode(4, new ListNode(5)));
        ListNode l2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode l3 = new ListNode(2, new ListNode(6));

        ListNode[] lists = new ListNode[]{l1, l2, l3};

        Solution sol = new Solution();
        int[] res = new int[]{ 1, 1, 2, 3, 4, 4, 5, 6};
        ListNode head = sol.mergeKLists(lists);

        int i = 0;
        while (head != null) {
            assert res[i] == head.val;
            head = head.next;
            i++;
        }
    }
}
