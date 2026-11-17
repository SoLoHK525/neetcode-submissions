class Node {
    boolean end = false;
    HashMap<Character, Node> children = new HashMap<>();
}

class PrefixTree {
    Node root;

    public PrefixTree() {
        this.root = new Node();
    }

    public void insert(String word) {
        Node n = root;

        for(char c : word.toCharArray()) {
            if(n.children.containsKey(c)) {
                n = n.children.get(c); 
            } else {
                Node child = new Node();
                n.children.put(c, child);
                n = child;
            }
        }

        n.end = true;
    }

    public boolean search(String word) {
        Node n = this.root;

        char[] arr = word.toCharArray();

        for(char c : word.toCharArray()) {
            if(n.children.containsKey(c)) {
                n = n.children.get(c);
            } else {
                return false;
            }
        }

        return n.end;
    }

    public boolean startsWith(String prefix) {
        Node n = this.root;

        char[] arr = prefix.toCharArray();

        for(int i = 0; i < arr.length; i++) {
            char c = arr[i];

            if(n.children.containsKey(c)) {
                n = n.children.get(c);
            } else {
                return false;
            }
        }

        return n != null;
    }
}
