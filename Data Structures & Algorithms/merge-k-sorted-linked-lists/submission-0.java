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
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode res = new ListNode(0);

        ListNode curr = res;

        while(curr != null) {
            int minVal = Integer.MAX_VALUE;
            int minIndex = -1;

            for(int i = 0; i < lists.length; i++) {
                ListNode node = lists[i];

                if(node == null) continue;

                if(node.val < minVal) {
                    minVal = node.val;
                    minIndex = i;
                }
            }

            if(minIndex == -1) break;

            curr.next = lists[minIndex];
            curr = curr.next;
            lists[minIndex] = lists[minIndex].next;
        }

        return res.next;
    }
}
