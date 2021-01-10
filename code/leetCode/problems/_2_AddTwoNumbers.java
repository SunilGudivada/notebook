package leetCode.problems;

/**
 * You are given two non-empty linked lists representing two non-negative integers. The digits are
 * stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and
 * return the sum as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * Example 1:
 *
 * Input: l1 = [2,4,3], l2 = [5,6,4] Output: [7,0,8] Explanation: 342 + 465 = 807. Example 2:
 *
 * Input: l1 = [0], l2 = [0] Output: [0] Example 3:
 *
 * Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9] Output: [8,9,9,9,0,0,0,1]
 *
 * Constraints:
 *
 * The number of nodes in each linked list is in the range [1, 100]. 
 * 0 <= Node.val <= 9 
 * It is guaranteed that the list represents a number that does not have leading zeros.
 */
public class _2_AddTwoNumbers {

  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode dummy = new ListNode(0);
    ListNode l3 = dummy;

    int carry = 0;
    while (l1 != null || l2 != null) {
      int l1_val = (l1 != null) ? l1.val : 0;
      int l2_val = (l2 != null) ? l2.val : 0;

      int sum = l1_val + l2_val + carry;
      carry = sum / 10;
      int last = sum % 10;

      l3.next = new ListNode(last);

      if (l1 != null) l1 = l1.next;
      if (l2 != null) l2 = l2.next;
      l3 = l3.next;
    }

    if (carry != 0) {
      l3.next = new ListNode(carry);
    }

    return dummy.next;
  }

}
