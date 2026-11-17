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
    int globalMax = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        helper(root);
        return globalMax;
    }

    int helper(TreeNode n) {
        if(n == null) return 0;

        int leftMax = Math.max(0, helper(n.left));
        int rightMax = Math.max(0, helper(n.right));
        int val = n.val + Math.max(leftMax, rightMax);
        globalMax = Math.max(globalMax, leftMax + n.val + rightMax);

        return val;
    } 
}
