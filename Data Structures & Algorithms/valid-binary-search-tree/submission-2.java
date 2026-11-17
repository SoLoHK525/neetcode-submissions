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
    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> queue = new Stack<>();

        TreeNode n = root;

        Integer previousVal = null;
        while(!queue.isEmpty() || n != null) {
            while(n != null) {
                queue.push(n);
                
                n = n.left;
            }

            n = queue.pop();

            if (previousVal != null && n.val <= previousVal) return false;

            previousVal = n.val;

            n = n.right;
        }

        return true;
    }
}
