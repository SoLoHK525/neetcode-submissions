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
    public int maxDepth(TreeNode root) {
        return traverse(root, 0);
    }

    public int traverse(TreeNode node, int level) {
        if(node == null) {
            return level;
        }

        level++;

        int leftDepth = level, rightDepth = level;

        if(node.left != null) {
            leftDepth = traverse(node.left, level);
        }

        if(node.right != null) {
            rightDepth = traverse(node.right, level);
        }

        return Math.max(leftDepth, rightDepth);
    }
}
