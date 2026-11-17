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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head.next == null && n > 0) return null;

        int delay = 0;

        ListNode ptrR = head;
        ListNode ptrL = null, prev = null;
        while(ptrR != null) {
            ptrR = ptrR.next;
            
            if(delay == n) {
                ptrL = head;
            }

            if(ptrL != null) {
                prev = ptrL;
                ptrL = ptrL.next;
            }

            delay++;
        }

        if(prev != null) {
            prev.next = ptrL.next;
            return head;
        } else {
            return head.next;
        }
    }
}
