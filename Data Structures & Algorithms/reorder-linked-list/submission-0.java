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
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null) {
            fast = fast.next;

            if(fast != null) {
                fast = fast.next;
                slow = slow.next;
            }
        }

        // now slow is at half, reverse, fast is at the end
        ListNode mid = slow;
        ListNode prev = null;
        ListNode curr = mid.next;
        mid.next = null;

        while(curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        // inter-leafing

        while(head != null && prev != null) {
            ListNode htemp = head.next;
            ListNode ptemp = prev.next;
            head.next = prev;
            prev.next = htemp;
            head = htemp;
            prev = ptemp;
        }
    }
}
