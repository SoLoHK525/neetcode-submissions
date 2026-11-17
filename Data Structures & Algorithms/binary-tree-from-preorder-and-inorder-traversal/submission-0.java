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
    int preIdx = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();

        int len = preorder.length;

        for(int i = 0; i < len; i++) {
            map.put(inorder[i], i);
        }

        return buildTree(preorder, map, 0, len - 1);
    }

    public TreeNode buildTree(int[] preorder, Map<Integer, Integer> map, int l, int r) {
        if (l > r) return null;

        int rootVal = preorder[preIdx++];
        TreeNode root = new TreeNode(rootVal);

        int indexOfRoot = map.get(rootVal);

        root.left = buildTree(preorder, map, l, indexOfRoot - 1);
        root.right = buildTree(preorder, map, indexOfRoot + 1, r);

        return root;
    }
}
