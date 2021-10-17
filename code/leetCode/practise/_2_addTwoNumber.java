package leetCode.practise;

import leetCode.problems.ListNode;

public class _2_addTwoNumber {

    public ListNode solve(ListNode l1, ListNode l2) {

        ListNode resultNode = new ListNode(0);

        ListNode l3 = resultNode;

        int carry = 0;

        while (l1 != null || l2 != null) {
            int l1_val = l1 != null ? l1.val : 0;
            int l2_val = l2 != null ? l2.val : 0;

            int sum = l1_val + l2_val + carry;

            int value = sum % 10;

            l3.next = new ListNode(value);
            carry = sum / 10;

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;

            l3 = l3.next;

        }

        if (carry != 0) {
            l3.next = new ListNode(carry);
        }
        return resultNode.next;
    }

    public static void main(String[] args) {

    }
}
