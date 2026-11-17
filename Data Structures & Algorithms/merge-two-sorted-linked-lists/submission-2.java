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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode node = dummy;

        while(list1 != null && list2 != null) {
            boolean firstIsSmaller = list1.val < list2.val;
            node.next = firstIsSmaller ? list1 : list2;
            
            node = node.next;

            if(firstIsSmaller) {
                list1 = list1.next;
            } else {
                list2 = list2.next;
            }
        }

        node.next = list1 == null ? list2 : list1;

        return dummy.next;
    }
}