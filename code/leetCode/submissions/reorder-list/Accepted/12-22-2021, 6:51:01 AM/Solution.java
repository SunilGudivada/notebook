// https://leetcode.com/problems/reorder-list

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        if(head ==null || head.next == null) return;
        
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast.next !=null && fast.next.next !=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        ListNode prevMiddle = slow;
        ListNode prevCurrent = slow.next;
        
        while(prevCurrent.next != null){
            ListNode current = prevCurrent.next;
            prevCurrent.next = current.next;
            current.next = prevMiddle.next;
            prevMiddle.next = current;
        }
        
        slow = head;
        fast = prevMiddle.next;
        
        while(slow != prevMiddle){
            prevMiddle.next=fast.next;
            fast.next=slow.next;
            slow.next=fast;
            slow=fast.next;
            fast=prevMiddle.next;
        }
    }
}