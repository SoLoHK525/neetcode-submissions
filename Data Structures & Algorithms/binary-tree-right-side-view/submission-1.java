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
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null) return List.of();
        
        // List<Integer> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        List<Stack<Integer>> list = new ArrayList<>(); 

        queue.offer(root);

        while(!queue.isEmpty()) {
            int size = queue.size();
            Stack<Integer> stack = new Stack<>();

            for(int i = 0; i < size; i++) {
                TreeNode n = queue.poll();
                stack.push(n.val);

                if(n.left != null) queue.offer(n.left);
                if(n.right != null) queue.offer(n.right);
            }

            list.add(stack);
        }

        return list.stream()
            .map(stack -> stack.pop())
            .toList();
    }
}
