/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> queue = new Stack<>();
        TreeNode n = root;

        int cnt = 0;

        while(!queue.isEmpty() || n != null) {
            while(n != null) {
                queue.push(n);
                n = n.left;
            }

            n = queue.pop();

            cnt++; // 1-indexed;

            if(cnt == k) {
                return n.val;
            }

            n = n.right;
        }

        return 0;
    }
}
