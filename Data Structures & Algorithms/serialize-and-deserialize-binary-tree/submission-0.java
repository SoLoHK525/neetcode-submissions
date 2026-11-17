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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<String> arr = new ArrayList<>();

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while(!stack.isEmpty()) {
            TreeNode n = stack.pop();

            if(n != null) {
                arr.add(String.valueOf(n.val));
                stack.add(n.right);
                stack.add(n.left);
            } else {
                arr.add("null");
            }
        }

        String res = String.join(",", arr);
        System.out.println(res);
        return res;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] arr = data.split(",");
        int[] index = new int[]{0};  // track position
        return buildTree(arr, index);
    }

    public TreeNode buildTree(String[] arr, int[] index) {
        String val = arr[index[0]];

        index[0]++;

        if(val.equals("null")) {
            return null;
        }

        TreeNode n = new TreeNode(Integer.parseInt(val));
        n.left = buildTree(arr, index);
        n.right = buildTree(arr, index);

        return n;
    }
}
