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
    public TreeNode invertTree(TreeNode root) {
        return swap(root);
    }

    public TreeNode swap(TreeNode n) {
        if(n == null) return null;

        TreeNode temp = swap(n.left);
        n.left = swap(n.right);
        n.right = temp;

        return n;
    }
}
