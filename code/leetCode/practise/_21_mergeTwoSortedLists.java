package leetCode.practise;

import leetCode.problems.ListNode;

public class _21_mergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(-1), temp = res;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                res.next = new ListNode(l1.val);
                l1 = l1.next;
            } else {
                res.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            res = res.next;
        }

        while (l1 != null) {
            res.next = new ListNode(l1.val);
            l1 = l1.next;
            res = res.next;
        }
        while (l2 != null) {
            res.next = new ListNode(l2.val);
            l2 = l2.next;
            res = res.next;
        }

        return temp.next;
    }
}
