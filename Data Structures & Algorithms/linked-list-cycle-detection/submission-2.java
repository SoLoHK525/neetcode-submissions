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
    public boolean hasCycle(ListNode head) {
        ListNode n = new ListNode(0);

        ListNode node = head;

        while(node != null) {
            if(node.next == n) {
                return true;
            }

            ListNode nextNode = node.next;
            node.next = n;
            node = nextNode;
        }

        return false;
    }
}
