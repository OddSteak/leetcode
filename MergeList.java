import java.util.ArrayList;
class ListNode {
    int val;
    ListNode next;

    ListNode() {}

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class MergeList {
    public static ListNode
            mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode initRes, curRes;
        var resList = new ArrayList<Integer>();

        if(list1 == null && list2 == null) return null;

        do {
            if (list1 == null) {
                resList.add(list2.val);
                list2 = list2.next;
                continue;
            }
            if (list2 == null) {
                resList.add(list1.val);
                list1 = list1.next;
                continue;
            }

            if(list2.val <= list1.val) {
                resList.add(list2.val); list2 = list2.next;
            } else {
                resList.add(list1.val); list1 = list1.next;
            };

        // atleast one list should be non null
        } while(list1 != null || list2 != null);

        if(resList.size() == 1)
            return new ListNode(resList.get(0));

        curRes = new ListNode(resList.get(1));
        initRes = new ListNode(resList.get(0), curRes);


        for(int i = 2; i<resList.size(); i++) {
            curRes.next = new ListNode(resList.get(i));
            curRes = curRes.next;
        }

        return initRes;
    }

    public static void main(String[] args) {
        var list1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        var list2 = new ListNode(1, new ListNode(3, new ListNode(4)));

        var list3 = new ListNode(5, new ListNode(7, new ListNode(10)));
        var list4 = new ListNode(1, new ListNode(10));

        var list5 = new ListNode(1, new ListNode(5, new ListNode(6)));
        var list6 = new ListNode(1, new ListNode(3, new ListNode(4)));

        var merged = mergeTwoLists(list1, list2);
        var merged1 = mergeTwoLists(list3, list4);
        var merged2 = mergeTwoLists(list5, list6);

        for (int i = 0; i<6; i++) {
            System.out.print(merged.val + " ");
            merged = merged.next;
        }

        System.out.println();


        for (int i = 0; i<5; i++) {
            System.out.print(merged1.val + " ");
            merged1 = merged1.next;
        }

        System.out.println();

        for (int i = 0; i<6; i++) {
            System.out.print(merged2.val + " ");
            merged2 = merged2.next;
        }

        System.out.println();
    }
}

