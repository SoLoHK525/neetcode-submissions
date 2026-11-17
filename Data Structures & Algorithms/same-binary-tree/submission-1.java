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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null || q == null) return p == q;

        Stack<TreeNode[]> stack = new Stack();
        stack.push(new TreeNode[]{p, q});

        while(!stack.empty()) {
            TreeNode[] nodes = stack.pop();

            TreeNode left = nodes[0];
            TreeNode right = nodes[1];

            if((left == null && right != null) || 
            (left != null && right == null)) {
                return false;
            }

            if(left == null && right == null) {
                continue;
            }

            if(left.val != right.val) {
                return false;
            }

            stack.push(new TreeNode[]{left.left, right.left});
            stack.push(new TreeNode[]{left.right, right.right});
        }

        return true;
    }
}
