/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node == null) return null;
        
        Map<Integer, Node> map = new HashMap<>();
        Queue<Node> q = new LinkedList<>();

        q.add(node);

        Node root = new Node(node.val);
        map.put(node.val, root);

        while(!q.isEmpty()) {
            Node n = q.poll();
            Node cloneNode = map.computeIfAbsent(n.val, k -> new Node(k));

            for(Node neighbor : n.neighbors) {
                if(!map.containsKey(neighbor.val)) {
                    q.add(neighbor);
                }
                
                cloneNode.neighbors.add(map.computeIfAbsent(neighbor.val, k -> new Node(k)));
            }
        }

        return root;
    }
}